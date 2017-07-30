package com.atguigu.b2c.sale.service;

import java.util.ArrayList;

import com.atguigu.b2c.sale.bean.ShoppingCart;
import com.atguigu.b2c.sale.bean.UserAccount;

public interface UserService {

	UserAccount getUserAccount(UserAccount userAccount);

	ArrayList<ShoppingCart> get_shopping_cookies(Integer id);

	void save_shoppingCart(ShoppingCart shoppingCart);

	void update_shopping_cart(ShoppingCart shoppingCart);

	void save_shoppingCart_list(ArrayList<ShoppingCart> cookies_shoppingCart, Integer id);

	

}
