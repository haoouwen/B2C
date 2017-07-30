package com.atguigu.b2c.sale.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.Cookie;

import com.atguigu.b2c.sale.bean.ShoppingCart;
import com.google.gson.Gson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MyStringUtils {

	public static String get_json(ArrayList<ShoppingCart> list_cart) {
		Gson gson = new Gson();
		String json = gson.toJson(list_cart);
		
		try {
			 json = URLEncoder.encode(json, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public static ArrayList<ShoppingCart> get_list(String str_cookies, Class<ShoppingCart> class1) {
		String  decode="";
		try {
			decode = URLDecoder.decode(str_cookies, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray fromObject = JSONArray.fromObject(decode);
		ArrayList<ShoppingCart> collection = (ArrayList<ShoppingCart>)JSONArray.toCollection(fromObject, class1);
		return collection;
	}

}
