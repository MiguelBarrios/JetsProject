package com.skilldistillery.jets.entities;

public abstract class Jet {
	
	protected static int lastIssuedId = 0;
	
	private String model;
	
	private double speed;
	
	private int range;
	
	private double price;
	
	private int id;
	
	abstract void fly();
	
	public Jet(String model, double speed, int range, double price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.id = lastIssuedId + 1;
		lastIssuedId = lastIssuedId + 1;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "model=" + model + ", id=" + id + ", speed=" + speed + ", range=" + range + ", price=" + price;
	}
	
	
	
}
