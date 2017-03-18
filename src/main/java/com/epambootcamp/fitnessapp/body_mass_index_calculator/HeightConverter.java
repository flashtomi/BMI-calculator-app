package com.epambootcamp.fitnessapp.body_mass_index_calculator;

public class HeightConverter {
	/**
	 * Converter method to convert input height value to Meter 
	 * @param height   height value from readNonZeroAndValidValue method
	 * @param unit   input height unit from readUnit method
	 * @return   Height in Meter
	 */
	public float convert(float height, HeightUnit unit){
		return height / unit.getInMeters();
	}
}
