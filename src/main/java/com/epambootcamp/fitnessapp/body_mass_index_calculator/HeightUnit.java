package com.epambootcamp.fitnessapp.body_mass_index_calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * ENUM class with the available height units and conversion values to Meter
 */
public enum HeightUnit {
	MM(1000),
	CM(100),
	M(1),
	INCH(39.3700787f),
	FEET(3.2808399f);

	/**
	 * Check that the input height unit is available
	 * @param s   input height unit
	 * @return   true if available false if invalid
	 */	
	public boolean contains(String s) {
		for (HeightUnit heightunit : values())
			if (heightunit.name().equals(s.toUpperCase()))
				return true;
		return false;
	}

	/**
	 * Print out valid height units
	 */
	public static void printHeightUnits()
	{
		System.out.print("Valid units: ");
		for(HeightUnit heightunit:values())
			System.out.print(heightunit + " ");
		System.out.println();
	}

	private final float inMeter;

	HeightUnit(float inMeter) {
		this.inMeter = inMeter;
	}

	public float getInMeters() {
		return inMeter;
	}
	
	/**
	 * Put valid height values in a List
	 * @return   Array list with the height units
	 */
	public static List<String> getValidValues() {
		List<String> validUnits = new ArrayList<String>();
		for(HeightUnit heightUnit:values()) {
			validUnits.add(heightUnit.name());
		}
		return validUnits;
	}
}
