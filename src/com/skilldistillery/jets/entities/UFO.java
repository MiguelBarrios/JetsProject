package com.skilldistillery.jets.entities;

public class UFO extends Jet implements AlienTech {

	public UFO(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	void fly() {
		System.out.println("Zig Zag, Zig, Zag, scanning for humans to abduct");
		
	}

	@Override
	public String toString() {
		return "UFO [" + super.toString() + "]";
	}

	@Override
	public void enableTractorBeam() {
		// TODO Auto-generated method stub
		
	}
	
	

}
