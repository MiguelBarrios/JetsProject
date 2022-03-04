package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AirField {
	private List<Jet> jets;
	
	public AirField() {
		loadJetData("jets.txt");
	}
	

	
	// read in list of jets from file
	private List<Jet> loadJetData(String filename){
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line;
			while((line = br.readLine()) != null) {
				Jet jet = createJet(line);
				System.out.println(jet);
				
			}
		}catch(IOException e) {
			System.out.println("IO Exception");
		}
		
		
		return jets;
		
	}
	
	private Jet createJet(String line) {
		String[] data = line.split(",");
		String type = data[0];
		String model = data[1];
		double speed = Double.parseDouble(data[2]);
		int range = Integer.parseInt(data[3]);
		double price = Double.parseDouble(data[4]);
		
		if(type.equals("Passenger Jet")) {
			return new PassengerJet(model, speed, range, price);
			
		}
		else if(type.equals("Cargo Plane")) {
			return new CargoJet(model, speed, range, price);
		}
		else if(type.equals("Fighter Jet")) {
			return new FighterJet(model, speed, range, price);
		}
		else if(type.equals("UFO")) {
			return new UFO(model, speed, range, price);
		}
		else {
			System.err.println("Invalid jet");
			System.err.println(Arrays.toString(data));
		}
		return null;
	}
}
