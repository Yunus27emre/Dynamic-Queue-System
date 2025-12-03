package _23010310067_Yunus_Taskesen;

import java.io.BufferedReader;
import java.io.FileReader;

public class error_look {

	public int Err() {
		String line;
		int i=0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Kuyruk.txt"));
			while ((line = reader.readLine()) != null) {
				if(line.isEmpty()) continue;
				i++;
			}
			reader.close();
			return i;

		} catch (Exception e) {
			System.out.println("Dosya hatası: " + e.getMessage());
			System.out.println("Program Kapatılıyor.");
			System.exit(0);
			
		}
		return i;

	}

	public void capacity_check(int capacity) {

		if (capacity % 2 != 0) {
			System.out.println("Kapasite çift sayı olmalıdır.Girilen: " + capacity);

			System.out.println("Program sonlandırılıyor.");
			System.exit(0);
		}
	}

	public void type_control(String[] tip, String degisken) {
		boolean matched = false;
		String detected_type;

		if (degisken.startsWith("'") && degisken.endsWith("'") && degisken.toCharArray().length == 3) {
			detected_type = "char";
		} else if (degisken.matches("^-?\\d+$")) {
			detected_type = "int";
		} else if (degisken.matches("^-?\\d*\\.\\d+$")) {
			detected_type = "double";
		} else {
			detected_type = "String";
		}

		switch (detected_type) {
		case "String":

		case "int":

		case "double":

		case "char":
			for (String t : tip) {
				if (t.equals(detected_type)) {
					matched = true;
					break;
				}
			}
			break;
		default:
			matched = false;
		}

		if (!matched) {
			System.out.println("Hata: '" + degisken + "' tipi desteklenmiyor veya yanlış yazıldı.");
			System.out.println("Programdan çıkılıyor.");
			System.exit(0);
		}
	}

	public void type_array_control(String[] tip) {
		if (tip.length == 0) {
			System.out.println("Tip türü belirtilmemiş.");
			System.out.println("Programdan çıkılıyor.");
			System.exit(0);
		}
		for (int i = 0; i < tip.length; i++) {
			switch (tip[i]) {
			case "String":

			case "int":

			case "double":

			case "char":
				break;
			default:
				System.out.println("Yanlış tip türü girildi.Girilen veri: " + tip[i]);
				System.out.println("Programdan çıkılıyor.");
				System.exit(0);
				break;
			}
		}

	}
}
