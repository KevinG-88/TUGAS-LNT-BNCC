package bncc;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class tugas {
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	int menu = 0,gaji = 0,temgaj = 0,update = 0,choose=0;
	String name = "", kode= "",gender="",jabatan="",temna = "",temko = "",temgen = "",temja = "";
	boolean looper = true;
	ArrayList<String> namar = new ArrayList<>();
	ArrayList<Integer> gajar = new ArrayList<>();
	ArrayList<String> kodar = new ArrayList<>();
	ArrayList<String> jabar = new ArrayList<>();
	ArrayList<String> genar = new ArrayList<>();
	ArrayList<String> managerar = new ArrayList<>();
	ArrayList<String> supervisorar = new ArrayList<>();
	ArrayList<String> adminar = new ArrayList<>();
	public tugas() {
		do {
			System.out.println("=Cookie Walk Shop=");
			System.out.println("=======Menu=======");
			System.out.println("1. Input data karyawan,");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.println("5. Exit");
			do {
				System.out.println("Choose : ");
				try {
					menu = sc.nextInt();
				} catch (Exception e) {
					menu = 69;
				}
				sc.nextLine();
			} while (!(menu >= 1 && menu <= 5));
			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				view();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				looper = false;
				break;
			}
		} while (looper == true);
	}

	public void add() {
		do {
			System.out.println("input nama Karyawan [ Nama minimal 3 huruf ]: ");
			try {
				name = sc.nextLine();
			} catch (Exception e) {
				sc.nextInt();
				name = "a";
			}
		} while (!(name.length() >= 3 ));
		do {
			System.out.println("Input Jenis Kelamin [ Laki laki | Perempuan ] (case sensitive): ");
			try {
				gender = sc.nextLine();
			} catch (Exception e) {
				sc.nextInt();
			}
		} while (!(gender.equals("Laki laki") || gender.equals("Perempuan")));
		do {
			System.out.println("Input Jabatan [ Manager | Supervisor | Admin ] (case sensitive): ");
			try {
				jabatan = sc.nextLine();
			} catch (Exception e) {
				sc.nextInt();
			}
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor")|| jabatan.equals("Admin")));
		kode = ""+(char) ('A' + rand.nextInt(26))+(char) ('A' + rand.nextInt(26))+"-"+ rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		System.out.println("Berhasil menambahkan karyawan dengan ID: "+kode);
		if (jabatan.equals("Manager")) {
			gaji = 8000000;
			managerar.add(jabatan);
		}
		else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
			supervisorar.add(jabatan);
		}
		else if (jabatan.equals("Admin")) {
			gaji = 4000000;
			adminar.add(jabatan);
		}
		namar.add(name);
		genar.add(gender);
		jabar.add(jabatan);
		kodar.add(kode);
		gajar.add(gaji);
		if (managerar.size() >= 3 && jabatan.equals("Manager")) {
			String output = "Bonus sebesar 10% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < kodar.size(); i++) {
				if (jabar.get(i).equals("Manager")) {
					output = output + kodar.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		
		if (supervisorar.size() >= 3 && jabatan.equals("Supervisor")) {
			String output = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < kodar.size(); i++) {
				if (jabar.get(i).equals("Supervisor")) {
					output = output + kodar.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		
		if (adminar.size() >= 3 && jabatan.equals("Admin")) {
			String output = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < kodar.size(); i++) {
				if (jabar.get(i).equals("Admin")) {
					output = output + kodar.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		if (managerar.size() % 3 == 0) {
			for (int i = 0; i < managerar.size(); i++) {
				gajar.set(i, (gajar.get(i) + (gaji * 10 / 100)));
			}
		}
		
		if (supervisorar.size() % 3 == 0) {
			for (int i = 0; i < supervisorar.size(); i++) {
				gajar.set(i, (int) (gajar.get(i) + (gaji * 7.5 / 100)));
			}
		}
		
		if (adminar.size() % 3 == 0) {
			for (int i = 0; i < adminar.size(); i++) {
				gajar.set(i, (gajar.get(i) + (gaji * 5 / 100)));
			}
		}
	}
	
	public void view() {
		if (namar.size() == 0) {
			System.out.println("======NO DATA=====");
			System.out.println("==enter to proceed==");
			sc.nextLine();
		}
		for (int i = 0; i < namar.size() - 1; i++) {
			for (int j = i + 1; j < namar.size(); j++) {
				if (namar.get(i).compareToIgnoreCase(namar.get(j)) > 0) {
						temna = namar.get(i);
						namar.set(i,namar.get(j));
						namar.set(j,temna);
						
						temgaj = gajar.get(i);
						gajar.set(i,gajar.get(j));
						gajar.set(j,temgaj);
						
						temko = kodar.get(i);
						kodar.set(i,kodar.get(j));
						kodar.set(j,temko);
						
						temgen = genar.get(i);
						genar.set(i,genar.get(j));
						genar.set(j,temgen);
						
						temja = jabar.get(i);
						jabar.set(i,jabar.get(j));
						jabar.set(j,temja);
					
				}
			}
		}
		for (int i = 0; i < namar.size(); i++) {
			System.out.println("===========================");
			System.out.println("No.: "+(i +1));
			System.out.println("Kode: "+ kodar.get(i));
			System.out.println("Nama Karyawan: "+namar.get(i));
			System.out.println("Gender: "+genar.get(i));
			System.out.println("Jabatan: "+jabar.get(i));
			System.out.println("Gaji: "+gajar.get(i));
		}
	}
	
	public void update() {
		if (namar.size() == 0) {
			System.out.println("======NO DATA=====");
			System.out.println("==enter to proceed==");
			sc.nextLine();
		}
		else {
			
		for (int i = 0; i < namar.size() - 1; i++) {
			for (int j = i + 1; j < namar.size(); j++) {
				if (namar.get(i).compareToIgnoreCase(namar.get(j)) > 0) {
						temna = namar.get(i);
						namar.set(i,namar.get(j));
						namar.set(j,temna);
						
						temgaj = gajar.get(i);
						gajar.set(i,gajar.get(j));
						gajar.set(j,temgaj);
						
						temko = kodar.get(i);
						kodar.set(i,kodar.get(j));
						kodar.set(j,temko);
						
						temgen = genar.get(i);
						genar.set(i,genar.get(j));
						genar.set(j,temgen);
						
						temja = jabar.get(i);
						jabar.set(i,jabar.get(j));
						jabar.set(j,temja);
					
				}
			}
		}
		for (int i = 0; i < namar.size(); i++) {
			System.out.println("===========================");
			System.out.println("No.: "+(i +1));
			System.out.println("Kode: "+ kodar.get(i));
			System.out.println("Nama Karyawan: "+namar.get(i));
			System.out.println("Gender: "+genar.get(i));
			System.out.println("Jabatan: "+jabar.get(i));
			System.out.println("Gaji: "+gajar.get(i));
		}
		do {
			try {
				System.out.println("Pilih kode karyawan yang ingin diupdate [1-"+ namar.size() +"]:");
				update = sc.nextInt();
			} catch (Exception e) {
				sc.nextLine();
			}sc.nextLine();
		} while (!(update >= 1 && update <= namar.size()));
	}
		do {
			System.out.println("input nama Karyawan [ Nama minimal 3 huruf ]: ");
			try {
				name = sc.nextLine();
			} catch (Exception e) {
				sc.nextInt();
				name = "a";
			}
		} while (!(name.length() >= 3 ));
		do {
			System.out.println("Input Jenis Kelamin [ Laki laki | Perempuan ] (case sensitive): ");
			try {
				gender = sc.nextLine();
			} catch (Exception e) {
				sc.nextInt();
			}
		} while (!(gender.equals("Laki laki") || gender.equals("Perempuan")));
		do {
			System.out.println("Input Jabatan [ Manager | Supervisor | Admin ] (case sensitive): ");
			try {
				jabatan = sc.nextLine();
			} catch (Exception e) {
				sc.nextInt();
			}
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor")|| jabatan.equals("Admin")));
		kode = ""+(char) ('A' + rand.nextInt(26))+(char) ('A' + rand.nextInt(26))+"-"+ rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		System.out.println("Berhasil menambahkan karyawan dengan ID: "+kode);
		if (jabatan.equals("Manager")) {
			gaji = 8000000;
			managerar.add(jabatan);
		}
		else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
			supervisorar.add(jabatan);
		}
		else if (jabatan.equals("Admin")) {
			gaji = 4000000;
			adminar.add(jabatan);
		}
		if (jabar.get(update-1).equals("Manager")) {
			managerar.remove(managerar.size()-1);
		}
		if (jabar.get(update-1).equals("Supervisor")) {
			supervisorar.remove(supervisorar.size()-1);
		}
		if (jabar.get(update-1).equals("Admin")) {
			adminar.remove(adminar.size()-1);
		}
		namar.set((update-1),name);
		genar.set((update-1),gender);
		jabar.set((update-1),jabatan);
		kodar.set((update-1),kode);
		gajar.set((update-1),gaji);
		if (managerar.size() >= 3 && jabatan.equals("Manager")) {
			String output = "Bonus sebesar 10% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < kodar.size(); i++) {
				if (jabar.get(i).equals("Manager")) {
					output = output + kodar.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		
		if (supervisorar.size() >= 3 && jabatan.equals("Supervisor")) {
			String output = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < kodar.size(); i++) {
				if (jabar.get(i).equals("Supervisor")) {
					output = output + kodar.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		
		if (adminar.size() >= 3 && jabatan.equals("Admin")) {
			String output = "Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id ";
			for (int i = 0; i < kodar.size(); i++) {
				if (jabar.get(i).equals("Admin")) {
					output = output + kodar.get(i) + " ";
				}
			}
			System.out.println(output);
		}
		if (managerar.size() % 3 == 0) {
			for (int i = 0; i < managerar.size(); i++) {
				gajar.set(i, (gajar.get(i) + (gaji * 10 / 100)));
			}
		}
		
		if (supervisorar.size() % 3 == 0) {
			for (int i = 0; i < supervisorar.size(); i++) {
				gajar.set(i, (int) (gajar.get(i) + (gaji * 7.5 / 100)));
			}
		}
		
		if (adminar.size() % 3 == 0) {
			for (int i = 0; i < adminar.size(); i++) {
				gajar.set(i, (gajar.get(i) + (gaji * 5 / 100)));
			}
		}
	}
	
	public void delete()  {
		if (namar.size() == 0) {
			System.out.println("======NO DATA=====");
			System.out.println("==enter to proceed==");
			sc.nextLine();
		}
		else {	
		for (int i = 0; i < namar.size() - 1; i++) {
			for (int j = i + 1; j < namar.size(); j++) {
				if (namar.get(i).compareToIgnoreCase(namar.get(j)) > 0) {
						temna = namar.get(i);
						namar.set(i,namar.get(j));
						namar.set(j,temna);
						
						temgaj = gajar.get(i);
						gajar.set(i,gajar.get(j));
						gajar.set(j,temgaj);
						
						temko = kodar.get(i);
						kodar.set(i,kodar.get(j));
						kodar.set(j,temko);
						
						temgen = genar.get(i);
						genar.set(i,genar.get(j));
						genar.set(j,temgen);
						
						temja = jabar.get(i);
						jabar.set(i,jabar.get(j));
						jabar.set(j,temja);
					
				}
			}
		}
		for (int i = 0; i < namar.size(); i++) {
			System.out.println("===========================");
			System.out.println("No.: "+(i +1));
			System.out.println("Kode: "+ kodar.get(i));
			System.out.println("Nama Karyawan: "+namar.get(i));
			System.out.println("Gender: "+genar.get(i));
			System.out.println("Jabatan: "+jabar.get(i));
			System.out.println("Gaji: "+gajar.get(i));
		}
		if (namar.size() > 0) {
			do {System.out.println("Pilih Karyawan untuk di delete");
				try {
				choose = sc.nextInt();
			} catch (Exception e) {
				choose = 6969;	
			}
				sc.nextLine();
			}
			while(!(choose <= namar.size()));
			if (jabar.get(choose-1).equals("Manager")) {
				managerar.remove(managerar.size()-1);
			}
			if (jabar.get(choose-1).equals("Supervisor")) {
				supervisorar.remove(supervisorar.size()-1);
			}
			if (jabar.get(choose-1).equals("Admin")) {
				adminar.remove(adminar.size()-1);
			}
			namar.remove(choose-1);
			jabar.remove(choose-1);
			kodar.remove(choose-1);
			genar.remove(choose-1);
			gajar.remove(choose-1);
			}
		}
	}
	public static void main(String[] args) {
		new tugas();

	}

}
