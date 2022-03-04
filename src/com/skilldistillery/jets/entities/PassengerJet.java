package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet{

	public PassengerJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		
	}

	@Override
	void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "PassengerJet [" + super.toString() + "]";
	}

	
	
	
	
}
