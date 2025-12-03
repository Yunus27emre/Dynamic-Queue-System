package _23010310067_Yunus_Taskesen;

import java.io.*;

public class _23010310067_Yunus_Taskesen {

	public static void main(String[] args) throws IOException {

		error_look look = new error_look();

		int cap = look.Err();
		BufferedReader reader = new BufferedReader(new FileReader("Kuyruk.txt"));
		FileRead fileRead = new FileRead();
		fileRead.readFile(reader, cap);
		System.out.println("Kuyruk.txt dosyası okundu.");
		Queue_make queue = new Queue_make(fileRead.type, fileRead.capacity, fileRead.temp);
		queue.Queue_Task();

	}

}
