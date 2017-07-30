package com.atguigu.b2c.manager.mapper;

import java.util.Map;

import com.atguigu.b2c.manager.bean.Product;

public interface ShpManagerMapper {
	
	void insertProduct(Product product);

	void insertProductImge(Map<Object, Object> map);

}
