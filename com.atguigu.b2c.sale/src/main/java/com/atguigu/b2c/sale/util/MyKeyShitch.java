package com.atguigu.b2c.sale.util;

public class MyKeyShitch {

	private static ThreadLocal<String> key = new ThreadLocal<String>();

	public static ThreadLocal<String> getKey() {
		return key;
	}

	public static void setKey(ThreadLocal<String> key) {
		key = key;
	}
	
	
}
