package com.epambootcamp.fitnessapp.body_mass_index_calculator;

public class WeightConverter {
	public float convert(float weight, WeightUnit unit){
		return weight / unit.getInKilos();
	}
}
