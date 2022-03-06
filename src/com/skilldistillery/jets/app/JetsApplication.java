package com.skilldistillery.jets.app;

import java.io.IOException;
import java.util.Scanner;
import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {

	private final String[] typesOfJets = new String[] { "Cargo Jet", "Fighter Jet", "Passenger Jet", "UFO" };
	
	private AirField airfield;

	private Scanner scanner;

	public static void main(String[] args) throws InterruptedException, IOException {

		JetsApplication app = new JetsApplication();
		app.run();
		
		System.out.println("Goodbye");
	}
	
	public JetsApplication() {
		airfield = new AirField();
		scanner = new Scanner(System.in);
	}

	public void run() {

		String userInput = "";

		do {
			displayMenu();
			userInput = scanner.nextLine();
			System.out.println();

			switch (userInput) {
			case "1":
				System.out.println("--- Jets in Fleet ---");
				airfield.listFleet();
				break;
			case "2":
				airfield.flyAllJets();
				break;
			case "3":
				airfield.viewFastedJet();
				break;
			case "4":
				airfield.viewJetWithLongestRange();
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
				removeJet();
				break;
			case "9":
				scanner.close();
				return;
			default:
				System.out.print("Ivalid option: ");
				break;
			}
			System.out.print("\nPress ENTER to continue ");
			scanner.nextLine();

		} while (!userInput.equals("9"));

		scanner.close();
	}

	public void displayMenu() {
		System.out.println("\n--- Main Menu ---");
		System.out.print("1)List fleet\n" + "2)Fly all jets\n" + "3)View fastest jet\n"
				+ "4)View jet with longest range\n" + "5)Load all Cargo Jets\n" + "6)Reload jets with wepons!\n"
				+ "7)Add a jet to Fleet\n" + "8)Remove a jet from Fleet\n" + "9)Quit\n\nSelect option: ");
	}

	public void removeJet() {
		Jet[] jets = airfield.getJets();
		System.out.println("--- Select Jet to remove ---");
		for(int i = 0; i < jets.length; ++i) {
			System.out.printf("%d) %s\n", i + 1, jets[i].toString());
		}
		String selection = getSelectionFromUser();
		
		Jet jetToRemove = jets[Integer.parseInt(selection) - 1];
		System.out.println("Jet to remove");
		System.out.println(jetToRemove);
		boolean removed = airfield.removeJetById(jetToRemove.getId());
		
		String message = (removed) ? "Jet succesfully removed": "Jet was unable to be removed";
		System.out.println(message);
	}
	
	public void addNewJet() {
		System.out.println("## Adding Jet to fleet ##");
		for (int i = 0; i < typesOfJets.length; ++i) {
			System.out.printf("%d)%s\n", i + 1, typesOfJets[i]);
		}

		String selection = getSelectionFromUser();

		String type = null;
		switch (selection) {
			case "1":
				type = "CargoJet";
				break;
			case "2":
				type = "FighterJet";
				break;
			case "3":
				type = "PassengerJet";
				break;
			case "4":
				type = "UFO";
				break;
		}

		if (type != null) {
			System.out.println("Enter jet info in the following format: model,speed,range,price");
			String data = scanner.nextLine().trim();
			String[] jetInfo = data.split(",");
			String model = jetInfo[0];
			double speed = Double.parseDouble(jetInfo[1]);
			int range = Integer.parseInt(jetInfo[2]);
			double price = Double.parseDouble(jetInfo[3]);
			airfield.addJetToFleet(type, model, speed, range, price);
		} else {
			System.out.println("Invalid option");
		}

	}
	
	public String getSelectionFromUser() {
		System.out.print("Selection: ");
		return scanner.nextLine();
	}
	
	

}
