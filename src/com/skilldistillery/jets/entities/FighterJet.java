package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements Wepons {

	public FighterJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		System.out.println("Zooom!!!! CONTACT FRONT!! CONTACT FRONT!! prepare for combat");
		
	}

	@Override
	public String toString() {
		return "FighterJet [" + super.toString() + "]";
	}

	@Override
	public void reloadWepons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fireWepons() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
