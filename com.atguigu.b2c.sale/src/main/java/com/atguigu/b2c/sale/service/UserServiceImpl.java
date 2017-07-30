package com.atguigu.b2c.sale.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.b2c.sale.bean.ShoppingCart;
import com.atguigu.b2c.sale.bean.UserAccount;
import com.atguigu.b2c.sale.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public UserAccount getUserAccount(UserAccount userAccount) {
		
		return userMapper.selectUserAccount(userAccount);
	}

	public void save_shoppingCart(ShoppingCart shoppingCart) {
		
		userMapper.insert_shoppingCart(shoppingCart);
	}

	public void update_shopping_cart(ShoppingCart shoppingCart) {
		userMapper.update_shopping_cart(shoppingCart);
	}


	public ArrayList<ShoppingCart> get_shopping_cookies(Integer id) {
		
		return userMapper.select_shoppingCart_userId(id);
	}


	public void save_shoppingCart_list(ArrayList<ShoppingCart> cookies_shoppingCart, Integer userId) {
		for (ShoppingCart shoppingCart : cookies_shoppingCart) {
			shoppingCart.setYh_id(userId);
		}
		
		userMapper.insert_shoppingCart_list(cookies_shoppingCart);
	}

	

	

	 
	
}
