package com.epambootcamp.fitnessapp.body_mass_index_calculator;

public class BMICalc{
	private final float height;
	private final float weight;
	private HeightUnit heightUnit;
	private WeightUnit weightUnit;
	
	public final HeightConverter heightConverter = new HeightConverter();
	public final WeightConverter weightConverter = new WeightConverter();
	
	
	private BMICalc(BMICalcBuilder builder){
		this.weight = builder.weight;
		this.height = builder.height;
		this.heightUnit = builder.heightUnit;
		this.weightUnit = builder.weightUnit;
	}
	
	public float getHeight(){
		return height;
	}
	
	public float getWeight(){
		return weight;
	}
	
	public BMIResult calc(){
		final float heightInMeter = heightConverter.convert(height, heightUnit);
		final float weightInMeter = weightConverter.convert(weight, weightUnit);
		
		final float bmi = weightInMeter / (heightInMeter*heightInMeter);
		
		System.out.println("Your BMI is:" + bmi + "kg/m2");
		return BMIResult.getFromValue(bmi);		
	}
	
	public static class BMICalcBuilder{
		private float height;
		private float weight;	
		private HeightUnit heightUnit;
		private WeightUnit weightUnit;;
		
		public BMICalcBuilder(float height, float weight){
			this.height = height;
			this.weight = weight;
		}
		
		public BMICalcBuilder setHeightUnit(HeightUnit unit){
			this.heightUnit = unit;
			return this;			
		}
		
		public BMICalcBuilder setWeightUnit(WeightUnit unit){
			this.weightUnit = unit;
			return this;
		}
		
		public BMICalc build(){
			return new BMICalc(this);
		}
	}
}
