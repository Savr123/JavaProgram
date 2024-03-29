package com.unislabs.helloworld;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class HelloWorld {

	public static int DEBUG = 3;

	public static void debug(int debug_level, String s) {
		if (debug_level <= DEBUG) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "postgres";

		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM test")) {
			while (rs.next()) {
				System.out.println(rs.getString("id") + " " + rs.getString("name"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			System.out.println(GenerateTrades.getTradeCenters(5));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		TradeCenter tc = new TradeCenter(TradeCenterType.CENTER, "Ромашка", "Кукуево");
		// Box box = new BoxClothes(3);
//		Floor floor = new Floor("t", true);
//		System.out.println(floor.getChargeFirst());
		// floor.getBoxes().add(box);
//		tc.getFloors().add(floor);
//		tc.getAddress();
		// System.out.println(tc);
		// System.out.println(box.getType());
		// System.out.println(new BoxElectronics(3).getType());

//		String s = "dsfsdf";
//		System.out.println(s);
//		System.out.println(s.toUpperCase());
//		System.out.println(s);
//		"dsfsdf".toUpperCase();

//		for (int i = 0; i < args.length; i++) {
//			System.out.println("args[" + i + "] = " + args[i]);
//		}
//
//		for (int j = 0; j < 4; j++) {
//			System.out.println(r(0, 5));
//		}
//		System.out.println(parse("321") * 2);
//		int bits = 1;
//		for (int n = 8 - 1; (n >>= 1) > 0; bits++) {
//		}
//		System.out.println(bits);
	}

	final public static int R = 8;

	public static int r() {
		Random r = new Random();
		return r.nextInt(1 << R);
	}

	public static int r(int max) {
		int bits = 0;
		for (int n = max - 1; n > 0; n >>= 1) {
			bits++;
		}
		debug(1, "bits = " + bits);
		int num = (bits + R - 1) / R;
		debug(1, "num = " + num);
		int res;
		do {
			res = 0;
			for (int i = 0; i < num; i++) {
				res = (res << R) + r();
			}
			debug(2, "r(max) i res = " + res);
			res >>= num * R - bits;
			debug(2, "r(max) i res >>= " + res);
		} while (res >= max);
		debug(1, "r(max) res = " + res);
		return res;
	}

	public static int r(int min, int max) {
		return r(max - min) + min;
	}

	public static int parse(String s) {
		int res = 0;
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			res = res * 10 + c[i] - '0';
		}
		return res;
	}

}
