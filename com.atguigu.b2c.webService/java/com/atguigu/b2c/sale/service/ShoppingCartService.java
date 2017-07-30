package com.atguigu.b2c.sale.service;

import com.atguigu.b2c.sale.bean.ShoppingCart;

public interface ShoppingCartService {

	void add_shoppingCart(ShoppingCart cart);

	void update_shoppingCart(ShoppingCart shoppingCart);

	void delete_shoppingCart(Integer sku_id);

}
