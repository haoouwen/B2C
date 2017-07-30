package com.atguigu.b2c.manager.service;

import java.util.List;
import java.util.Map;

import com.atguigu.b2c.manager.bean.AjaxData;
import com.atguigu.b2c.manager.bean.Class2Attr;

public interface AttrManagerService {

	List<Class2Attr> show_attr(Integer class2_id);

	void add_attr(String flmch2, Integer flbh2, AjaxData ajaxData);


	
	
}
