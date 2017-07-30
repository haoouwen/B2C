package com.atguigu.b2c.sale.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.atguigu.b2c.sale.bean.ShoppingCart;
import com.atguigu.b2c.sale.bean.UserAccount;

public interface UserMapper {

	UserAccount selectUserAccount(UserAccount userAccount);

	void insert_shoppingCart_list(@Param("cookies_shoppingCart")ArrayList<ShoppingCart> cookies_shoppingCart);

	ArrayList<ShoppingCart> select_shoppingCart_userId(Integer id);

	void update_shopping_cart(ShoppingCart shoppingCart);

	void insert_shoppingCart(ShoppingCart shoppingCart);


}
