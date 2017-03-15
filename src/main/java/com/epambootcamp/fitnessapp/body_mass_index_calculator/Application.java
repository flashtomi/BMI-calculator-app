package com.epambootcamp.fitnessapp.body_mass_index_calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//boolean success = false;
		System.out.println("Please enter your height:");
		
		/*while(!success){
			try {
				System.out.println("Enter an integer: ");
				float num = sc.nextFloat();
				if (num <= 0) throw new ArithmeticException();
				System.out.println("You entered " + num);
				success = true;
			} catch (InputMismatchException e) {
				System.err.println("You have entered invalid data");
				sc.next();
			} catch (ArithmeticException ae) {
				System.err.println("Weight can't be less than or equal to zero! Please enter a correct number.");
				continue;
			}
		}*/
		
		
		float height = sc.nextFloat();
		System.out.println("Please enter your weight:");
		float weight = sc.nextFloat();
		sc.close();
						
		BMIResult res = new BMICalc.BMICalcBuilder(height, weight)
				.setHeightUnit(HeightUnit.M)
				.setWeightUnit(WeightUnit.KG)
				.build()
				.calc();
	
		System.out.println(res.toString());
	}
}