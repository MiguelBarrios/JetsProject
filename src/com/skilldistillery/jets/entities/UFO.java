package com.skilldistillery.jets.entities;

public class UFO extends Jet implements Wepons {

	public int lazerBeamCharge;
	
	public UFO(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		lazerBeamCharge = 0;
	}

	@Override
	public void fly() {
		double maxFlightTime = this.getRange() / this.getSpeed();
		System.out.printf("%s : Max flight time %.2f hours \n", toString(), maxFlightTime);	
	}

	@Override
	public String toString() {
		return "UFO [" + super.toString() + ", lazerCharge=" + this.lazerBeamCharge + "]";
	}

	@Override
	public void reloadWepons() {
		System.out.println("Recharging lazers for: " + this.toString());
		this.lazerBeamCharge = 100;
		System.out.println("Charging complete");
		
	}

	@Override
	public void fireWepons() {
		if(this.lazerBeamCharge > 5) {
			System.out.println("Zap Zap!!");
			this.lazerBeamCharge -= 5;
		}
		else {
			System.out.println("Click, click");
		}
		
	}	

}
