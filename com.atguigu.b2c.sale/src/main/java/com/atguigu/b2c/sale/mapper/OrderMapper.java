package com.atguigu.b2c.sale.mapper;

import org.apache.ibatis.annotations.Param;

import com.atguigu.b2c.sale.bean.Object_Orders;
import com.atguigu.b2c.sale.bean.Order_Info;

public interface OrderMapper {

	void insert_order(Object_Orders object_Orders);

	

	int query_kc(Integer gwch_id);

	void insert_order_info(Order_Info order_Info);



	void update_sku_kc(@Param("sku_shl")Integer sku_shl,@Param("gwch_id") Integer gwch_id);



	void remove_shoppingCart_by_yhId(Integer gwch_id);

}
