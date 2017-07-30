package com.atguigu.b2c.sale.mapper;

import com.atguigu.b2c.sale.bean.ShoppingCart;

public interface ShoppingMapper {

	void insert_shoppingCart(ShoppingCart cart);

	void update_shoppingCart(ShoppingCart shoppingCart);

	void delete_shoppingCart(Integer sku_id);

}
