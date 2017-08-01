package com.atguigu.b2c.sale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.b2c.sale.bean.Address;
import com.atguigu.b2c.sale.bean.Object_Orders;
import com.atguigu.b2c.sale.bean.Order_Info;
import com.atguigu.b2c.sale.bean.UserAccount;
import com.atguigu.b2c.sale.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderMapper orderMapper;

	

	public void save_order(List<Object_Orders> list_order, Address address, UserAccount userAccount) throws Exception {
        for (Object_Orders object_Orders : list_order) {
			
			orderMapper.insert_order(object_Orders);
			List<Order_Info> list_info = object_Orders.getList_info();
			for (Order_Info order_Info : list_info) {
				
				order_Info.setDd_id(object_Orders.getId());
				
				orderMapper.insert_order_info(order_Info);
				
				orderMapper.remove_shoppingCart_by_yhId(order_Info.getGwch_id());
				
				int kc =orderMapper.query_kc(order_Info.getGwch_id());
				if(kc<order_Info.getSku_shl()){
					throw new Exception();
				}else{
					orderMapper.update_sku_kc(order_Info.getSku_shl(),order_Info.getGwch_id());
				}
				
				
			}
			
		}
	}
	
}
