package com.atguigu.b2c.manager.service;

import java.util.List;

import com.atguigu.b2c.manager.bean.AjaxData;
import com.atguigu.b2c.manager.bean.Class2Attr;
import com.atguigu.b2c.manager.bean.Product;
import com.atguigu.b2c.manager.bean.Sku;

public interface SkuManagerService {

	List<Product> get_shp_mch(Product product);

	List<Class2Attr> select_attr(Integer flbh2);

	void saveSkuInfo(Sku sku, AjaxData ajaxData);

}
