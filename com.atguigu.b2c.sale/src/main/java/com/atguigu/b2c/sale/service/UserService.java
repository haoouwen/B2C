package com.atguigu.b2c.sale.service;

import java.util.ArrayList;

import com.atguigu.b2c.sale.bean.ShoppingCart;
import com.atguigu.b2c.sale.bean.UserAccount;

public interface UserService {

    public UserAccount getUserAccount(UserAccount userAccount) ; 
	public void save_shoppingCart(ShoppingCart shoppingCart) ;
	public void update_shopping_cart(ShoppingCart shoppingCart) ;


	public ArrayList<ShoppingCart> get_shopping_cookies(Integer id) ;


	public void save_shoppingCart_list(ArrayList<ShoppingCart> cookies_shoppingCart, Integer userId);
	
}
