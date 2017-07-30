package com.atguigu.b2c.ws.userService;

import java.util.ArrayList;

import javax.jws.WebService;

import com.atguigu.b2c.sale.bean.ShoppingCart;
import com.atguigu.b2c.sale.bean.UserAccount;


@WebService
public interface WSUserService {

	public UserAccount check(UserAccount user);
	public UserAccount login(UserAccount user);
	public void regist(UserAccount user);
	public void update(UserAccount user);
	public void remove(UserAccount user);
	UserAccount getUserAccount(UserAccount userAccount);

	ArrayList<ShoppingCart> get_shopping_cookies(Integer id);

	void save_shoppingCart(ShoppingCart shoppingCart);

	void update_shopping_cart(ShoppingCart shoppingCart);

	void save_shoppingCart_list(ArrayList<ShoppingCart> cookies_shoppingCart, Integer id);

	
	
}
