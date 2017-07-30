package com.atguigu.b2c.manager.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.b2c.manager.bean.Class2Attr;
import com.atguigu.b2c.manager.bean.Product;
import com.atguigu.b2c.manager.bean.Sku;

public interface SkuManagerMapper {

	List<Product> get_shp_mch(Product product);

	List<Class2Attr> getAttrByClass2Id(@Param("flbh2")Integer flbh2);

	void insertSku(Sku sku);

	void insertSkuAttr(HashMap<String, Object> hashMap);

	
	
}
