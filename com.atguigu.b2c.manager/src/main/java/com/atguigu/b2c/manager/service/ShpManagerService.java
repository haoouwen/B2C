package com.atguigu.b2c.manager.service;

import java.util.List;

import com.atguigu.b2c.manager.bean.Product;

public interface ShpManagerService {

	void saveProduct(Product product, List<String> list);

	
}
