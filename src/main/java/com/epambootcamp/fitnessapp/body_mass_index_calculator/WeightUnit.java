package com.epambootcamp.fitnessapp.body_mass_index_calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * ENUM class with the available weight units and conversion values to Kilogram
 */
public enum WeightUnit {
	G(1000),
	DKG(100),
	KG(1),
	POUND(2.20462262f);
	
	/**
	 * Check that the input weight unit is available
	 * @param s   input weight unit
	 * @return   true if available false if invalid
	 */
	public boolean contains(String s)
	  {
	      for(WeightUnit weightunit:values())
	           if (weightunit.name().equals(s.toUpperCase())) 
	              return true;
	      return false;
	  } 
	
	/**
	 * Print out valid weight units
	 */
	public static void printWeightUnits()
	{
		System.out.print("Valid units: ");
		for(WeightUnit weightunit:values())
			System.out.print(weightunit + " ");
		System.out.println();
	}
	
	private final float inKilo;
	
	WeightUnit(float inKilo){
		this.inKilo = inKilo;
	}
	
	public float getInKilos(){
		return inKilo;
	}
	
	/**
	 * Put valid weight values in a List
	 * @return   Array list with the weight units
	 */
	public static List<String> getValidValues() {
		List<String> validUnits = new ArrayList<String>();
		for(WeightUnit weightUnit:values()) {
			validUnits.add(weightUnit.name());
		}
		return validUnits;
	}
}
