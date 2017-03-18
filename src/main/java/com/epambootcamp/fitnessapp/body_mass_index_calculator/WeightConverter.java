package com.epambootcamp.fitnessapp.body_mass_index_calculator;

public class WeightConverter {
	/**
	 * Converter method to convert input weight value to Kilogram
	 * @param weight   weight value from readNonZeroAndValidValue method
	 * @param unit   input weight unit from readUnit method
	 * @return   Weight in Kilogram
	 */
	public float convert(float weight, WeightUnit unit){
		return weight / unit.getInKilos();
	}
}
