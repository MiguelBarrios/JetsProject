package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements Cargo{

	public CargoJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		System.out.println("whoosh!!! gota get this cargo to its destination");
	}

	@Override
	public String toString() {
		return "CargoJet [" + super.toString() + "]";
	}

	@Override
	public void loadCargo() {
		// TODO Auto-generated method stub
		
	}


	
	

}
