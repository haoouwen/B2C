package com.atguigu.b2c.sale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.b2c.sale.bean.ShoppingCart;
import com.atguigu.b2c.sale.mapper.ShoppingMapper;

@Service
public class ShoppingCartServiceImpl  implements ShoppingCartService{

	@Autowired
	private ShoppingMapper shoppingMapper;
	
	public void add_shoppingCart(ShoppingCart cart) {
		shoppingMapper.insert_shoppingCart(cart);
	}

	public void update_shoppingCart(ShoppingCart shoppingCart) {
		shoppingMapper.update_shoppingCart(shoppingCart);
		
	}

	public void delete_shoppingCart(Integer sku_id) {
		shoppingMapper.delete_shoppingCart(sku_id);
		
	}

}
