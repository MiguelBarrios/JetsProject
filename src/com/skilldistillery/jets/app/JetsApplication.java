package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {
	
	private AirField airfield;
	
	private Scanner scanner;
	
	public JetsApplication() {
		airfield = new AirField();
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		
		app.run();
	}
	
	public void run() {
		// A String var is used to casting and associated exceptions
		String userInput = "";
		
		do {
			displayMenu();
			userInput = scanner.nextLine();
			System.out.println();
			
			switch(userInput) {
				case "1": airfield.listFleet();
					break;
				case "2": airfield.flyAllJets();
					break;
				case "3": airfield.viewFastedJet();
					break;
				case "4": airfield.viewFastedJet();
					break;
				case "5": airfield.loadAllCargoJets();
					break;
				case "6": airfield.reloadAllMilitaryJets();
					break;
				case "7":
					break;
				case "8":
					break;
				case "9":
					break;
				default:
					System.out.println("Ivalid option, please try again");
					break;
			}
			System.out.println();
			
			
		}while(!userInput.equalsIgnoreCase("9"));
		
		displayMenu();
		
		scanner.close();
	}
	
	public void displayMenu() {
		System.out.println("Menu");
		System.out.println("1)List fleet\n"
				+ "2)Fly all jets\n"
				+ "3)View fastest jet\n"
				+ "4)View jet with longest range\n"
				+ "5)Load all Cargo Jets\n"
				+ "6)Reload jets with wepons!\n"
				+ "7)Add a jet to Fleet\n"
				+ "8)Remove a jet from Fleet\n"
				+ "9)Quit");
		System.out.print("Select option: ");
	}

}
