package com.epambootcamp.fitnessapp.body_mass_index_calculator;

public enum WeightUnit {
	G(1000),
	DKG(100),
	KG(1),
	POUND(2.20462262f);
	
	private final float inKilo;
	
	WeightUnit(float inKilo){
		this.inKilo = inKilo;
	}
	
	public float getInKilos(){
		return inKilo;
	}
}
