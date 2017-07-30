package com.atguigu.b2c.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.b2c.manager.bean.Product;
import com.atguigu.b2c.manager.mapper.ShpManagerMapper;


@Service
public class ShpManagerServiceImpl implements ShpManagerService{

	@Autowired
	private ShpManagerMapper managerMapper;

	public void saveProduct(Product product, List<String> list) {
		product.setShp_tp(list.get(0));
		managerMapper.insertProduct(product);
	   Integer id = product.getId();
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("id", id);
		map.put("list", list);
		managerMapper.insertProductImge(map);
	}
}
