package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements Cargo{

	private double loadWeight;
	
	public CargoJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		this.loadWeight = 0;
	}

	@Override
	public void fly() {
		double maxFlightTime = this.getRange() / this.getSpeed();
		System.out.printf("%s : Max flight time %.2f hours \n", toString(), maxFlightTime);	
	}

	@Override
	public String toString() {
		return "CargoJet [" + super.toString() + " , weightOfCargo=" + loadWeight + "]";
	}

	@Override
	public void loadCargo() {
		System.out.println("Now loading cargo for: " + this.toString());
		this.loadWeight += 2000;
		System.out.println(this.loadWeight + " lb of cargo loaded");
	}


	
	

}
