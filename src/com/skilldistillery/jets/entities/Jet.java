package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String Type;
	private String model;
	private double speed;
	private double range;
	private double price;
	
	public abstract void fly();
	
	public abstract void takeOff();
	
	public abstract void land();
	
	public abstract void communicateWithControlTower();
	
	public abstract void fuelingTank();

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
