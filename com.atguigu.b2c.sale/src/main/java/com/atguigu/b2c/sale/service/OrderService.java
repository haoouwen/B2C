package com.atguigu.b2c.sale.service;

import java.util.List;

import com.atguigu.b2c.sale.bean.Address;
import com.atguigu.b2c.sale.bean.Object_Orders;
import com.atguigu.b2c.sale.bean.UserAccount;

public interface OrderService {


	void save_order(List<Object_Orders> list_order, Address address, UserAccount userAccount)throws Exception ;

}
