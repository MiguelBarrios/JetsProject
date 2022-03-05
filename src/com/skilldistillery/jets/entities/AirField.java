package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirField {
	private List<Jet> jets;
	
	public AirField() {
		this.jets = loadJetData("jets.txt");
	}
	
	public void listFleet() {
		System.out.println("Fleet info: number of jets " + jets.size());
		for(Jet jet : jets) {
			System.out.println(jet);
		}
	}
	
	public void flyAllJets() {
		for(Jet jet : this.jets) {
			jet.fly();
		}
	}
	
	public void viewFastedJet() {
		double fastestSpeed = 0;
		Jet fastestJet = null;
		for(Jet jet : this.jets) {
			if(jet.getSpeed() > fastestSpeed) {
				fastestSpeed = jet.getSpeed();
				fastestJet = jet;
			}
		}
		
		if(fastestJet == null) {
			System.out.println("There can't be a fastest jet if there are no jets");
		}
		else {
			System.out.println("Fastest Jet");
			System.out.println(fastestJet);
		}
	}
	
	public void viewJetWithLongestRange() {
		int longestRange = 0;
		Jet longestRangeJet = null;
		for(Jet jet : this.jets) {
			if(jet.getSpeed() > longestRange) {
				longestRange = jet.getRange();
				longestRangeJet = jet;
			}
		}
		
		if(longestRangeJet == null) {
			System.out.println("There can't be a fastest jet if there are no jets");
		}
		else {
			System.out.println("Jet with the longest Range");
			System.out.println(longestRangeJet);
		}
	}
	
	// read in list of jets from file
	private List<Jet> loadJetData(String filename){
		
		List<Jet> jets = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line;
			while((line = br.readLine()) != null) {
				String[] data = line.split(",");
				String type = data[0];
				String model = data[1];
				double speed = Double.parseDouble(data[2]);
				int range = Integer.parseInt(data[3]);
				double price = Double.parseDouble(data[4]);
				Jet jet = createJet(type, model, speed, range, price);
				if(jet != null) {
					jets.add(jet);
				}
				
			}
		}catch(IOException e) {
			System.err.println("Error reading data");
		}
		
		return jets;
		
	}
	
	private Jet createJet(String type, String model, double speed, int range, double price) {
		
		Jet jet = null;
		if(type.equals("Passenger Jet")) {
			jet = new PassengerJet(model, speed, range, price);
		}
		else if(type.equals("Cargo Plane")) {
			jet = new CargoJet(model, speed, range, price);
		}
		else if(type.equals("Fighter Jet")) {
			jet = new FighterJet(model, speed, range, price);
		}
		else if(type.equals("UFO")) {
			jet = new UFO(model, speed, range, price);
		}
		else {
			System.err.println("Error: invalid data");
		}
		
		return jet;
	}

}
