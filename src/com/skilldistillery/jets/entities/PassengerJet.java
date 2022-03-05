package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet{

	public PassengerJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		
	}

	@Override
	void fly() {
		System.out.println("Swoosh, ladies and gentalmen if you look to your right you will the some land");
		
	}

	@Override
	public String toString() {
		return "PassengerJet [" + super.toString() + "]";
	}

	
	
	
	
}
