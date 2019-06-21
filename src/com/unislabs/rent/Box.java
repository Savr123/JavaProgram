package com.unislabs.rent;

import java.io.IOException;

public abstract class Box {

	private String number;
	private double square;
	private Floor floor;
	private BoxType type;
	private double rentRate = 500;

	{
		setType(BoxType.getTypeByClass(this.getClass()));
	}

	public Box() {
		super();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public double getRentRate() {
		return rentRate;
	}

	public void setRentRate(double rentRate) {
		this.rentRate = rentRate;
	}

	public BoxType getType() {
		return type;
	}

	protected void setType(BoxType type) {
		this.type = type;
	}

	protected abstract double getRentType(double rentBase) throws IOException;

	public double getRent() throws IOException {
		return getRentType(this.rentRate * this.square) * getFloor().getCharge();
	}

	@Override
	public String toString() {
		return "Площадь " + square + "\n";
	}
}
