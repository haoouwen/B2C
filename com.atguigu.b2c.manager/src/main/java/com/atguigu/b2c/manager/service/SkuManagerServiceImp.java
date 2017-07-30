package com.atguigu.b2c.manager.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.b2c.manager.bean.AjaxData;
import com.atguigu.b2c.manager.bean.Class2Attr;
import com.atguigu.b2c.manager.bean.Product;
import com.atguigu.b2c.manager.bean.Sku;
import com.atguigu.b2c.manager.mapper.SkuManagerMapper;

@Service
public class SkuManagerServiceImp<V> implements SkuManagerService{

	@Autowired
	private SkuManagerMapper skuManagerMapper;

	public List<Product> get_shp_mch(Product product) {
		
		return skuManagerMapper.get_shp_mch(product);
	}

	public List<Class2Attr> select_attr(Integer flbh2) {
		
		return skuManagerMapper.getAttrByClass2Id(flbh2);
	}

	public void saveSkuInfo(Sku sku, AjaxData ajaxData) {
		skuManagerMapper.insertSku(sku);
		List<Class2Attr> list = ajaxData.getList();
		for (Class2Attr class2Attr : list) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("sku_id", sku.getId());
			hashMap.put("shp_id", sku.getShp_id());
			hashMap.put("shxm_id", class2Attr.getId());
			hashMap.put("shxzh_id", class2Attr.getList().get(0).getId());
			
			skuManagerMapper.insertSkuAttr(hashMap);
		}
		
	}
	
}
