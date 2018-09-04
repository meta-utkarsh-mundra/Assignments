package com.metacube.training3;

public class Person {
	double weight;
	double height;
	String bloodGroup;
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public void showPerson() {
		System.out.println("Weight, height, blodGroup are " + getWeight() + " " + getHeight() + " " + getBloodGroup());
	}
}
