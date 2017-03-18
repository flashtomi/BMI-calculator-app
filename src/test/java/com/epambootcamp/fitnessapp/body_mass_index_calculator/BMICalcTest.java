package com.epambootcamp.fitnessapp.body_mass_index_calculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BMICalcTest {
	
	@Test
	public void testSetHeightUnit() {
		BMICalc result = new BMICalc.Builder(1,1).setHeightUnit(HeightUnit.CM).build();
		assertThat(result.getHeightUnit(), is(HeightUnit.CM));
	}
	
	@Test
	public void testResultShouldBeSevereThinnes() {
		BMIResult result = new BMICalc.Builder(180, 50).build().calc();
		assertThat(result, is(BMIResult.SEVERE_THINNESS));
	}
	
	@Test
	public void testResultShouldBeModerateThinnes() {
		BMIResult result = new BMICalc.Builder(180, 55).build().calc();
		assertThat(result, is(BMIResult.MODERATE_THINNESS));
	}
	
	@Test
	public void testResultShouldBeMildThinnes() {
		BMIResult result = new BMICalc.Builder(180, 56).build().calc();
		assertThat(result, is(BMIResult.MILD_THINNESS));
	}
	
	@Test
	public void testResultShouldBeNormal() {
		BMIResult result = new BMICalc.Builder(180, 80).build().calc();
		assertThat(result, is(BMIResult.NORMAL));
	}
	
	@Test
	public void testResultShouldBeOverweight() {
		BMIResult result = new BMICalc.Builder(180, 90).build().calc();
		assertThat(result, is(BMIResult.OVERWEIGHT));
	}
	
	@Test
	public void testResultShouldBeObeseClassI() {
		BMIResult result = new BMICalc.Builder(180, 100).build().calc();
		assertThat(result, is(BMIResult.OBESE_CLASS_I));
	}
	
	@Test
	public void testResultShouldBeObeseClassII() {
		BMIResult result = new BMICalc.Builder(180, 120).build().calc();
		assertThat(result, is(BMIResult.OBESE_CLASS_II));
	}
	
	@Test
	public void testResultShouldBeObeseClassIII() {
		BMIResult result = new BMICalc.Builder(180, 140).build().calc();
		assertThat(result, is(BMIResult.OBESE_CLASS_III));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenZeroWeightProvided_ShouldThrowInvalid() {
		new BMICalc.Builder(180, 0).build().calc();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenZeroHeightProvided_ShouldThrowInvalid() {
		new BMICalc.Builder(0,80).build().calc();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenNegativeWeightProvided_ShouldThrowInvalid() {
		new BMICalc.Builder(180, -50).build().calc();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenNegativeHeightProvided_ShouldThrowInvalid() {
		new BMICalc.Builder(-50, 80).build().calc();
	}
	
}
