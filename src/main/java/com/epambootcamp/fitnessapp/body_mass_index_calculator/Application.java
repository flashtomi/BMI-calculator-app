/**
 * The Application wait for height and weight with measurement unit and giving back the BMI value and category.
 * @author Tamas Szabo
 * @version 1.1
 */

package com.epambootcamp.fitnessapp.body_mass_index_calculator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		final float height = readNonZeroAndValidValue(sc, "Height");
		
		sc.nextLine();

		System.out.println("Please enter height unit: ");
		HeightUnit.printHeightUnits();
		String heightUnit = readUnit(sc, HeightUnit.getValidValues());
		
		final float weight = readNonZeroAndValidValue(sc, "Weight");

		sc.nextLine();
		
		System.out.println("Please enter Weight unit: ");
		WeightUnit.printWeightUnits();
		String weightUnit = readUnit(sc, WeightUnit.getValidValues());
		
		sc.close();


		BMIResult result = new BMICalc.Builder(height, weight)
				.setHeightUnit(HeightUnit.valueOf(heightUnit.toUpperCase()))
				.setWeightUnit(WeightUnit.valueOf(weightUnit.toUpperCase()))
				.build()
				.calc();

		System.out.println(result.toString());

	}
	
	/**
	 * Read float value from keyboard and return with it.
	 * @param scanner contain the value
	 * @param attribute 
	 * @return with valid float value
	 * @exception ArithmeticException if value <= than 0
	 * @exception InputMismatchException if value is invalid
	 */
	public static float readNonZeroAndValidValue(Scanner scanner, String attribute) {
		float attributeValue;
		while (true) {
			try {
				System.out.println("Please enter your " + attribute + ": ");
				attributeValue = scanner.nextFloat();
				if (attributeValue <= 0) {
					throw new ArithmeticException();
				}
				return attributeValue;
			} catch (InputMismatchException e) {
				System.err.println("You have entered invalid data. Please try again.");
				scanner.next();
			} catch (ArithmeticException ae) {
				System.err.println(attribute + " can't be less than or equal to zero! Please enter a correct number.");
			}
		}
	}
	
	/**
	 * Read the measurement unit from the keyboard
	 * @param scanner contain the scanned unit
	 * @param validUnits list of the valid units in the ENUM class
	 * @return valid measurement unit
	 */
	public static String readUnit(Scanner scanner, List<String> validUnits) {
		String unitString;
		do {
			unitString = scanner.nextLine();
			if (validUnits.contains(unitString.toUpperCase())) {
				break;
			} else {
				System.err.println("Please enter a valid unit:");
			}
		} while (true);
		
		return unitString;
	}
}