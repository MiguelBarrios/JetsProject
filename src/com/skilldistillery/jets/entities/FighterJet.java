package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements Wepons {
	
	public int ammoCount;

	public FighterJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		ammoCount = 0;
	}

	@Override
	public void fly() {
		double maxFlightTime = this.getRange() / this.getSpeed();
		System.out.printf("%s : Max flight time %.2f hours \n", toString(), maxFlightTime);		
	}

	@Override
	public String toString() {
		return "FighterJet [" + super.toString() + ", AmmountOfAmmo=" + this.ammoCount + "]";
	}

	@Override
	public void reloadWepons() {
		System.out.println("Reloading jet: " + this.toString());
		this.ammoCount = 2000;
		System.out.println("Jet reloaded");
	}

	@Override
	public void fireWepons() {
		if(this.ammoCount > 5) {
			System.out.println("bang, bang, bang, bang, bang!!!");
			this.ammoCount -= 5;
		}
		else {
			System.out.println("Click, click");
		}
		
		
		
	}
}
