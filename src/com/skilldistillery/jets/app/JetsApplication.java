package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AirField field = new AirField();
		
		field.listFleet();
		System.out.println();
		
		field.flyAllJets();
		
		System.out.println();
		field.viewFastedJet();
		
		System.out.println();
		field.viewJetWithLongestRange();
		
	}

}
