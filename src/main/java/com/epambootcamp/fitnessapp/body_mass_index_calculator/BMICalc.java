package com.epambootcamp.fitnessapp.body_mass_index_calculator;

public class BMICalc {
	private final float height;
	private final float weight;
	private HeightUnit heightUnit;
	private WeightUnit weightUnit;
	
	public final HeightConverter heightConverter = new HeightConverter();
	public final WeightConverter weightConverter = new WeightConverter();
	
	
	private BMICalc(Builder builder){
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
	
	public HeightUnit getHeightUnit() {
		return heightUnit;
	}
	
	public WeightUnit getWeightUnit() {
		return weightUnit;
	}
	
	/** 
	 * Calculator method that convert the input values to Meter and Kilogram, then calculate the BMI and return with the category
	 * @return   with the BMI result from ENUM class
	 * @throws IllegalArgumentException   if input values are invalid
	 */
	
	public BMIResult calc() throws IllegalArgumentException {
		if (this.weight <= 0) throw new IllegalArgumentException("Illegal weight value. Weight value should be greater than 0.");
		if (this.height <= 0) throw new IllegalArgumentException("Illegal height value. Height value should be greater than 0.");
		
		final float heightInMeter = heightConverter.convert(height, heightUnit);
		final float weightInMeter = weightConverter.convert(weight, weightUnit);
		
		final float bmi = weightInMeter / (heightInMeter*heightInMeter);
		
		System.out.println("Your BMI is: " + bmi + " kg/m2");
		return BMIResult.getFromValue(bmi);		
	}
	
	public static class Builder {
		private final float height;
		private final float weight;
		
		private HeightUnit heightUnit = HeightUnit.CM;
		private WeightUnit weightUnit = WeightUnit.KG;
		
		public Builder(float height, float weight) {
			this.height = height;
			this.weight = weight;
		}
		
		public Builder setHeightUnit(HeightUnit unit) {
			this.heightUnit = unit;
			return this;			
		}
		
		public Builder setWeightUnit(WeightUnit unit) {
			this.weightUnit = unit;
			return this;
		}
		
		public BMICalc build(){
			return new BMICalc(this);
		}
	}
}
