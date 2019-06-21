package com.unislabs.helloworld;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import com.unislabs.rent.Box;
import com.unislabs.rent.BoxType;
import com.unislabs.rent.Floor;
import com.unislabs.rent.TradeCenter;
import com.unislabs.rent.TradeCenterType;

public class GenerateTrades {

	public static int r(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}

	public static TradeCenter getTradeCenter(String name, String address)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		TradeCenter tc = null;
		TradeCenterType type = TradeCenterType.getTypeById(r(1, TradeCenterType.values().length + 1));
		tc = new TradeCenter(type, name, address);
		tc.getFloors().addAll(getFloors(r(1, 10), tc));
		return tc;
	}

	public static Collection<TradeCenter> getTradeCenters(int n) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Collection<TradeCenter> TCenters = new ArrayList<TradeCenter>(n);
		for (int i = 0; i < n; i++) {
			TCenters.add(getTradeCenter("ТЦ " + i, "Длинное шоссе, дом " + i));
		}
		return TCenters;
	}

	static public Floor getFloor(String number, boolean isFirst, TradeCenter tradeCenter)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		Floor floor = new Floor(number, isFirst, tradeCenter);
		floor.getBoxes().addAll(getBoxes(r(5, 20), floor));
		return floor;
	}

	static public Collection<Floor> getFloors(int n, TradeCenter tradeCenter)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		Collection<Floor> floors = new ArrayList<Floor>(n);
		for (int i = 0; i < n; i++) {
			floors.add(getFloor("Этаж номер " + i, i < 1, tradeCenter));
		}
		return floors;
	}

	static public Box getBox(String number, Floor floor) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		BoxType type = BoxType.getTypeById(r(1, BoxType.values().length) + 1);
		Box box = type.getBox().getDeclaredConstructor().newInstance();
		box.setNumber(number);
		box.setSquare(r(100, 150) / 10d);
		box.setFloor(floor);
		switch (type) {
		case CLOTHES:
			box.getClass().getMethod("setCountFittingRooms", int.class).invoke(box, r(1, 5));
			break;
		case ELECTRONICS:
			box.getClass().getMethod("setCountSocets", int.class).invoke(box, r(1, 5));
			break;
		case FOOD:
			box.getClass().getMethod("setCountRef", int.class).invoke(box, r(0, 10));
			box.getClass().getMethod("setCountScale", int.class).invoke(box, r(0, 5));
			break;
		default:
		}
		return box;
	}

	static public Collection<Box> getBoxes(int n, Floor floor) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Collection<Box> boxes = new ArrayList<Box>(n);
		for (int i = 0; i < n; i++) {
			boxes.add(getBox("Бокс номер " + i, floor));
		}
		return boxes;
	}

}
