package com.atguigu.b2c.ws.util;

public class MyKeyShitch {

	private static ThreadLocal<String> key = new ThreadLocal<String>();

	public static String getKey() {
		return key.get();
	}

	public static void setKey(String key_in) {
		key.set(key_in);
	}
	
	
}
