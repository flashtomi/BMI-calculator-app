package com.epambootcamp.fitnessapp.body_mass_index_calculator;

public enum HeightUnit {
	MM(1000),
	CM(100),
	M(1),
	INCH(39.3700787f),
	FEET(3.2808399f);
	
	private final float inMeter;
	
	HeightUnit(float inMeter){
		this.inMeter = inMeter;
	}
	
	public float getInMeters(){
		return inMeter;
	}
}
