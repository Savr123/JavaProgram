package com.unislabs.rent;

import java.io.IOException;

public class BoxClothes extends Box {

	private int countFittingRooms;

	public BoxClothes() {
		super();
	}

	public BoxClothes(String number, int countFittingRooms, double square, Floor floor) {
		super();
		setNumber(number);
		this.countFittingRooms = countFittingRooms;
		setSquare(square);
		setFloor(floor);
	}

	public int getCountFittingRooms() {
		return this.countFittingRooms;
	}

	public void setCountFittingRooms(int countFittingRooms) {
		this.countFittingRooms = countFittingRooms;
	}

	@Override
	protected double getRentType(double rentBase) throws IOException {
		return rentBase + this.countFittingRooms * Prop.getPropDouble(Prop.BOX_CLOTHES_ROOMS_PRICE);
	}

	@Override
	public String toString() {
		String rentRate = "";
		try {
			rentRate = String.valueOf(getRentType(super.getRentRate()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rentRate = "\nОшибка расчёта стоимости: " + e.getMessage() + "\n";
		}
		StringBuilder res = new StringBuilder("Одежда: ").append(getNumber()).append(", примерочных: ")
				.append(countFittingRooms).append("\n стоимость аренды: ").append(rentRate);
		return res.append("\n").toString();
	}
}
