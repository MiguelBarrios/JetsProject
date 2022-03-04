package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	
	private double speed;
	
	private int range;
	
	private double price;
	
	public Jet(String model, double speed, int range, double price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	abstract void fly();

	@Override
	public String toString() {
		return "model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price;
	}
	
	
	
}
