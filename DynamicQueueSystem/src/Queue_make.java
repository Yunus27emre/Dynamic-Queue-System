package _23010310067_Yunus_Taskesen;

public class Queue_make {
	private String[] Type;
	private int Capacity;
	private String[] Task;
	private Object[] queue;
	private int front;
	private int rear;
	private int size;

	public Queue_make(String[] Ty, int c, String[] T) {
		this.Type = Ty;
		this.Capacity = c;
		this.Task = T;
		this.queue = new Object[Capacity];
		front = 0;
		rear = -1;
		size = 0;

	}

	public void Queue_Task() {
		String[] temp = new String[5];
		for (int i = 0; i < Task.length; i++) {
			if (Task[i] == null)
				break;
			temp = Task[i].split(" ");

			if (temp[0].equals("ekle")) {
				Enqueue(temp[1]);
			} else if (temp[0].equals("çıkar")) {
				Dequeue();
			} else if (temp[0].equals("peek")) {
				Peek();

			} else {
				System.out.println("Bilinmeyen komut: " + temp[0]);
				System.out.println("Sistemden çıkılıyor.");
				System.exit(0);
			}

		}

	}

	public void Resize() {
		Object[] queue_temp;

		if (Capacity == size) {
			int oldCapacity = Capacity;
			Capacity = Math.max(2, Capacity * 2);
			queue_temp = new Object[Capacity];

			for (int i = 0; i < size; i++) {
				queue_temp[i] = queue[(front + i) % oldCapacity];
			}

			front = 0;
			rear = size - 1;
			queue = queue_temp;
		}

		if (size < Capacity / 2 && Capacity > 2) {
			int oldCapacity = Capacity;
			Capacity = Math.max(2, Capacity / 2);
			if (Capacity % 2 != 0)
				Capacity++;
			queue_temp = new Object[Capacity];

			for (int i = 0; i < size; i++) {
				queue_temp[i] = queue[(front + i) % oldCapacity];
			}
			front = 0;
			rear = size - 1;
			queue = queue_temp;
		}
	}

	public void Enqueue(String value) {
		error_look temp = new error_look();
		temp.type_control(Type, value);
		if (size == Capacity)
			Resize();
		rear = (rear + 1) % Capacity;
		queue[rear] = value;
		size++;
		wait_command();
		System.out.println(queue[rear] + " kuyruğa eklendi.");
		print_queue();

	}

	public void Dequeue() {
		if (isEmpty()) {
			System.out.print("Kuyruk boş.");
			return;
		}
		wait_command();
		System.out.println(queue[front] + " kuyruktan çıktı.");
		queue[front] = null;
		front = (front + 1) % Capacity;
		size--;
		Resize();
		print_queue();

	}

	public void Peek() {
		if (isEmpty()) {
			System.out.println("Kuyruk boş.");
		} else {
			wait_command();
			System.out.println("Peek sonucu: " + queue[front]);
			print_queue();
		}
	}

	public int Size() {
		return size;
	}

	public boolean isEmpty() {

		return size == 0;
	}

	public boolean isFull() {

		return size == Capacity;
	}

	public void print_queue() {
		wait_command();
		System.out.print("Kapasite:" + Capacity + " ");
		System.out.print("Eleman Sayısı:" + size + " ");
		System.out.print("Başı ");

		for (int i = 0; i < size; i++) {

			System.out.print(queue[(front + i) % Capacity]);

			if (i != size - 1)
				System.out.print(", ");
		}

		System.out.print(" Sonu");
		System.out.println();
		
	}

	public void wait_command() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.print("Error: "+e.getMessage());
		}
	}

}
