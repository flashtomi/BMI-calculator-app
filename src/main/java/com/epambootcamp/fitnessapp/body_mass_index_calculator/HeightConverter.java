package com.epambootcamp.fitnessapp.body_mass_index_calculator;

public class HeightConverter {
	public float convert(float height, HeightUnit unit){
		return height / unit.getInMeters();
	}
}
