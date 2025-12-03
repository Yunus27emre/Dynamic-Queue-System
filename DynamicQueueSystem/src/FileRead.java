package _23010310067_Yunus_Taskesen;

import java.io.BufferedReader;
import java.io.IOException;

public class FileRead {

	String[] type;
	int capacity;
	String[] temp;

	public void readFile(BufferedReader reader, int cap) throws IOException {
		error_look capacity_c = new error_look();
		String line;
		int i = 0;

		temp = new String[cap];
		while ((line = reader.readLine()) != null) {
			if (line.isEmpty())
				continue;
			if (i == 0) {
				try {
					this.capacity = Integer.parseInt(line);
					capacity_c.capacity_check(this.capacity);
				} catch (NumberFormatException e) {
					System.out.println("Hata: Kapasite değeri sayısal olmalıdır!Girilen veri " + line);
					System.exit(0);
				}

			} else if (i == 1) {
				this.type = line.split(" ");
				capacity_c.type_array_control(type);
			} else {
				this.temp[i - 2] = line;
			}
			i++;
		}

	}

}
