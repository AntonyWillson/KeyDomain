package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Artifacts;
import model.Golden;
import model.Purple;

public class Main {
	Scanner s = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<Artifacts> arList = new ArrayList<Artifacts>();
	public Main() {
		while (true) {
			System.out.println("Key Domain");
			System.out.println("=============================");
			System.out.println("1. Insert artifacts");
			System.out.println("2. View obtainable artifacts");
			System.out.println("3. Grind for artifact");
			System.out.println("4. Exit");
			int choose;
			do {
				System.out.print(">> ");
				try {
					choose = s.nextInt();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					choose = 0;
				}s.nextLine();
			} while (choose < 1 || choose > 4);
			
			switch (choose) {
			case 1:
				menu1();
				break;
			case 2:
				menu2();
				break;
			case 3:
				menu3();
				break;
			case 4:
				System.exit(0);
				break;

			
			}
		}
	}
	
	void menu1() {
		int choose;
		System.out.println("Which artifacts you want to add");
		System.out.println("1. Purple Artifact");
		System.out.println("2. Golen Aritfact");
		
		do {
			System.out.print(">> ");
			try {
				choose = s.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				choose = 0;
			}s.nextLine();
		} while (choose < 1 || choose > 2);
		
		String name;
		do {
			System.out.print("Input name : ");
			name = s.nextLine();
		} while (name.length() < 3 || name.length() > 15);
		
		String type;
		do {
			System.out.print("Input type : ");
			type = s.nextLine();
		} while (!type.equals("Flower") && !type.equals("Plume") && !type.equals("Sands") && !type.equals("Circlet") && !type.equals("Goblet"));
		
		int attack = 0;
		if (type.equals("Flower") || type.equals("Plume")) {
			do {
				System.out.print("Input base attack : ");
				try {
					attack = s.nextInt();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					attack = 0;
				}s.nextLine();
			} while (attack < 90 || attack > 100);
			
		}else if (type.equals("Sands") || type.equals("Circlet") || type.equals("Goblet")) {
			do {
				System.out.print("Input base attacl : ");
				try {
					attack = s.nextInt();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					attack = 0;
				}s.nextLine();
			} while (attack < 101 || attack > 110);
		}
		
		if (choose == 1) {
			String bonus;
			do {
				System.out.print("Input Bonus status : ");
				bonus = s.nextLine();
			} while (!bonus.equals("Pyro") && !bonus.equals("Cryo") && !bonus.equals("Anemo") && !bonus.equals("Hydro") && !bonus.equals("Electro"));
			
			int damage = attack * 100;
			Artifacts p = new Purple(name, type, attack,damage, bonus);
			arList.add(p);
			
		}else if (choose == 2) {
			double multi;
			do {
				System.out.print("Input multiplier : ");
				try {
					multi = s.nextDouble();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					multi = 0;
				}s.nextLine();
			} while (multi < 1.5 || multi > 2);
			
			int damage =  (int) (attack * multi * 100);
			Artifacts g = new Golden(name, type, attack,damage, multi);
			arList.add(g);
		}
		System.out.println("Succesfully inserted!");
	}
	
	void menu2(){
		if (arList.isEmpty()) {
			System.out.println("KOsong");
		}else {
			System.out.println("============================================================================");
			System.out.printf("|%-20s|%-10s|%-10s|%-20s|%-10s|\n","Name","Type","Base Atk","Bonus Stat","Muliplier");
			System.out.println("============================================================================");
			for (int i = 0; i < arList.size(); i++) {
				Artifacts a = arList.get(i);
				if (a instanceof Purple) {
					System.out.printf("|%-20s|%-10s|%-10s|%-20s|%-10s|\n", a.getName(), a.getType(), a.getAttack(),((Purple)a).bonus, " - ");
				}else if (a instanceof Golden) {
					System.out.printf("|%-20s|%-10s|%-10s|%-20s|%-10s|\n", a.getName(), a.getType(), a.getAttack()," - ", ((Golden)a).multi);
				}
			}
			System.out.println("============================================================================");
			System.out.println("Press enter to continue...");s.nextLine();
		}
	}
	
	void menu3() {
		if (arList.isEmpty()) {
			System.out.println("Kosong");
		}else {
			String character;
			do {
				System.out.print("Input character : ");
				character = s.nextLine();
				
				if (!character.equalsIgnoreCase("Diluc") && !character.equalsIgnoreCase("Xiao") && !character.equalsIgnoreCase("Keqing")) {
					System.out.println("Character Invalid");
				}
			} while (!character.equalsIgnoreCase("Diluc") && !character.equalsIgnoreCase("Xiao") && !character.equalsIgnoreCase("Keqing"));
			
			System.out.println(character + " came back and got you a new artifact!");
			Artifacts a = arList.get(rand.nextInt(arList.size()));
			System.out.println("Name : "+a.getName());
			System.out.println("Type : "+a.getType());
			System.out.println("Base Atk : "+a.getAttack());
			if (a instanceof Purple) {
				System.out.println("Damage : "+a.getDamage());
				System.out.println("Bonus Stat : "+((Purple)a).bonus);
				
			}else if (a instanceof Golden) {
				System.out.println("Damage : "+((Golden)a).multi * a.getAttack());
			}
			System.out.println(" ");
			System.out.println("Press Enter to continue...");s.nextLine();
			
			arList.remove(a);
		}
	}

	public static void main(String[] args) {
		new Main();

	}

}
