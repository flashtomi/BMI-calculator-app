package com.epambootcamp.fitnessapp.body_mass_index_calculator;

/**
 * ENUM class with the BMI categories and limit values
 */

public enum BMIResult {
	SEVERE_THINNESS,
	MODERATE_THINNESS,
	MILD_THINNESS,
	NORMAL,
	OVERWEIGHT,
	OBESE_CLASS_I,
	OBESE_CLASS_II,
	OBESE_CLASS_III;

	public static BMIResult getFromValue(float bmiValue) {
		if (bmiValue < 16) {
			return BMIResult.SEVERE_THINNESS;
		} else if (16 < bmiValue && bmiValue < 17) {
			return BMIResult.MODERATE_THINNESS;
		} else if (17 < bmiValue && bmiValue < 18.5f) {
			return BMIResult.MILD_THINNESS;
		} else if (18.5f < bmiValue && bmiValue < 25) {
			return BMIResult.NORMAL;
		} else if (25 < bmiValue && bmiValue < 30) {
			return BMIResult.OVERWEIGHT;
		} else if (30 < bmiValue && bmiValue < 35) {
			return BMIResult.OBESE_CLASS_I;
		} else if (35 < bmiValue && bmiValue < 40) {
			return BMIResult.OBESE_CLASS_II;
		} else if (40 < bmiValue) {
			return BMIResult.OBESE_CLASS_III;
		}else {
			return null;
		}
	}
}
