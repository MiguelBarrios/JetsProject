package com.skilldistillery.jets.entities;

public class JetImpl extends Jet{

	public JetImpl(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		
	}

	@Override
	public void fly() {
		double maxFlightTime = this.getRange() / this.getSpeed();
		System.out.printf("%s : Max flight time %.2f hours \n", toString(), maxFlightTime);	
	}

	@Override
	public String toString() {
		return "JetImpl [" + super.toString() + "]";
	}

	
	
	
	
}
