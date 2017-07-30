package com.atguigu.b2c.manager.bean;

import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

public class AjaxData {

	private Boolean  success;
	private String message;
	private List<Class2Attr> list;
	private List<Product> list_product;
	
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
