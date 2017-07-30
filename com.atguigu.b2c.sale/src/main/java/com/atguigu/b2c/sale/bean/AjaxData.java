package com.atguigu.b2c.sale.bean;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

public class AjaxData {

	private Boolean  success;
	private String message;
	private List<Class2Attr> list;
	private List<AttrValue> listValue;
	private ArrayList<ShoppingCart> shoppingCart_list;
	private Object object;
	private List<Product> list_product;
	private List<ObjSkuPro> list_ObjSkuPro;
	
	
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public ArrayList<ShoppingCart> getShoppingCart_list() {
		return shoppingCart_list;
	}
	public void setShoppingCart_list(ArrayList<ShoppingCart> shoppingCart_list) {
		this.shoppingCart_list = shoppingCart_list;
	}
	public List<AttrValue> getListValue() {
		return listValue;
	}
	public void setListValue(List<AttrValue> listValue) {
		this.listValue = listValue;
	}
	public List<ObjSkuPro> getList_ObjSkuPro() {
		return list_ObjSkuPro;
	}
	public void setList_ObjSkuPro(List<ObjSkuPro> list_ObjSkuPro) {
		this.list_ObjSkuPro = list_ObjSkuPro;
	}
	public List<Product> getList_product() {
		return list_product;
	}
	public void setList_product(List<Product> list_product) {
		this.list_product = list_product;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Class2Attr> getList() {
		return list;
	}
	public void setList(List<Class2Attr> list) {
		this.list = list;
	}
	
}
