package com.skilldistillery.jets.entities;

public class CargoJet extends Jet{

	public CargoJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "CargoJet [" + super.toString() + "]";
	}


	
	

}
