package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> jets;
	
	public AirField() {
		this("jets.txt");
	}
	
	public AirField(String filename) {
		this.jets = loadJetData(filename);
	}
	
	public Jet[] getJets() {
		
		Jet[] res = new Jet[this.jets.size()];
		for(int i = 0; i < res.length; ++i) {
			res[i] = createCopy(jets.get(i));
		}
		
		return res;
	}
	
	public void listFleet() {
		for(Jet jet : jets) {
			System.out.println(jet);
		}
	}
	
	public void flyAllJets() {
		System.out.println("Flying all jets");
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
			System.out.println("Fastest Jet\n" + fastestJet);
		}
	}
	
	public void viewJetWithLongestRange() {
		int longestRange = 0;
		Jet longestRangeJet = null;
		for(Jet jet : this.jets) {
			if(jet.getRange() > longestRange) {
				longestRange = jet.getRange();
				longestRangeJet = jet;
			}
		}
		
		if(longestRangeJet == null) {
			System.out.println("There are currently no jets in the airfield");
		}
		else {
			System.out.println("Jet with the longest Range: " + longestRangeJet);
		}
	}
	
	public void loadAllCargoJets() {
		System.out.println("Loading all cargo jets");
		for(Jet jet : jets) {
			if(jet instanceof CargoJet) {
				((CargoJet) jet).loadCargo();
			}
		}
	}
	
	public void reloadAllMilitaryJets() {
		System.out.println("Reloading all Jets with wepons");
		for(Jet jet : jets) {
			if(jet instanceof Wepons) {
				((Wepons) jet).reloadWepons();
			}
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
	
	public void addJetToFleet(String type, String model, double speed, int range, double price) {
		Jet jet = createJet(type ,model , speed, range, price);
		jets.add(jet);
	}
	
	public Jet createJet(String type, String model, double speed, int range, double price) {
		
		Jet jet = null;
		if(type.equals("JetImpl")) {
			jet = new JetImpl(model, speed, range, price);
		}
		else if(type.equals("CargoJet")) {
			jet = new CargoJet(model, speed, range, price);
		}
		else if(type.equals("FighterJet")) {
			jet = new FighterJet(model, speed, range, price);
		}
		else if(type.equals("UFO")) {
			jet = new UFO(model, speed, range, price);
		}
		else {
			System.err.println("Error: invalid data. Type " + type + " " + "model: " + model);
		}
		
		return jet;
	}
	
	public boolean removeJetById(int id) {
		for(int i = 0; i < jets.size(); ++i) {
			if(jets.get(i).getId() == id) {
				jets.remove(i);
				return true; 
			}
		}
		return false;
	}
	
	public Jet createCopy(Jet jet) {
		String[] classPath = jet.getClass().getName().split("\\.");
		String jetType = classPath[classPath.length - 1];
		Jet copyOfJet = createJet(jetType, jet.getModel(), jet.getSpeed(), jet.getRange(), jet.getPrice());
		copyOfJet.setId(jet.getId());
		Jet.lastIssuedId = Jet.lastIssuedId - 1;
		return copyOfJet;
	}

}
