package com.skilldistillery.jets.app;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {

	private AirField airfield;

	private Scanner scanner;

	public JetsApplication() {
		airfield = new AirField();
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) throws InterruptedException, IOException {
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

			switch (userInput) {
			case "1":
				airfield.listFleet();
				break;
			case "2":
				airfield.flyAllJets();
				break;
			case "3":
				airfield.viewFastedJet();
				break;
			case "4":
				airfield.viewFastedJet();
				break;
			case "5":
				airfield.loadAllCargoJets();
				break;
			case "6":
				airfield.reloadAllMilitaryJets();
				break;
			case "7":
				addNewJet();
				break;
			case "8":
				break;
			case "9":
				break;
			default:
				System.out.println("Ivalid option, please try again");
				break;
			}
			System.out.println("\nPress enter to continue");
			scanner.nextLine();
			

		} while (!userInput.equalsIgnoreCase("9"));

		displayMenu();

		scanner.close();
	}

	public void displayMenu() {
		System.out.println("Menu");
		System.out.println("1)List fleet\n" + "2)Fly all jets\n" + "3)View fastest jet\n"
				+ "4)View jet with longest range\n" + "5)Load all Cargo Jets\n" + "6)Reload jets with wepons!\n"
				+ "7)Add a jet to Fleet\n" + "8)Remove a jet from Fleet\n" + "9)Quit");
		System.out.print("Select option: ");
	}

	public void addNewJet() {
		System.out.println("## Adding Jet to fleet ##");
		String[] typesOfJets = new String[] { "Cargo Jet", "Fighter Jet", "Passenger Jet", "UFO" };
		menuPrint("Select type of jet", typesOfJets);
		System.out.println("selection: ");
		String selection = scanner.nextLine();
		System.out.println(selection);
		System.out.println("Enter jet information in the following format");
		System.out.println("model,speed,range,price");
		String data = scanner.nextLine();
		String[] jetInfo = data.split(",");
		String model = jetInfo[0];
		double speed = Double.parseDouble(jetInfo[1]);
		int range = Integer.parseInt(jetInfo[2]);
		double price = Double.parseDouble(jetInfo[3]);
		
		
		String type = null;
		switch (selection) {
			case "1": type = "Cargo Plane";
				break;
			case "2": type = "Fighter Jet";
				break;
			case "3": type = "Passenger Jet"; 
				break;
			case "4": type = "UFO";
				break;
		}
		
		if(type != null) {
			airfield.addJetToFleet(type, model, speed, range, price);
		} else {
			System.out.println("IO error");
		}
		

	}

	public void menuPrint(String banner, String[] items) {
		System.out.println(banner);
		for (int i = 0; i < items.length; ++i) {
			System.out.printf("%d)%s\n", i + 1, items[i]);
		}
	}

}
