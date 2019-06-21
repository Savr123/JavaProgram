package com.unislabs.rent;

import java.util.ArrayList;
import java.util.Collection;

public class TradeCenter {
	private TradeCenterType type;
	private String name;
	private String address;
	private Collection<Floor> floors = new ArrayList<Floor>();

	public TradeCenter() {
		super();
	}

	public TradeCenter(TradeCenterType type, String name, String address) {
		super();
		this.type = type;
		this.name = name;
		this.address = address;
	}

	public double getCharge() {
		return type.getCharge();
	}

	public TradeCenterType getType() {
		return type;
	}

	public void setType(TradeCenterType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Описание метода
	 * 
	 * @return адрес
	 */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<Floor> getFloors() {
		return floors;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("Торговый центр\n").append(type).append(", name=").append(name)
				.append(", address=").append(address).append("\n");
		for (Floor floor : floors) {
			res.append(floor);
		}
		return res.append("\n").toString();
	}
}
