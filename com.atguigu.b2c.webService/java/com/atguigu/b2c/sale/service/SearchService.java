package com.atguigu.b2c.sale.service;

import java.util.List;
import java.util.Map;

import com.atguigu.b2c.sale.bean.Class2Attr;
import com.atguigu.b2c.sale.bean.ObjSkuPro;

public interface SearchService {

	List<ObjSkuPro> get_ObjSkuPro(Integer flbh2);

	List<Class2Attr> get_attrByClass2_id(Integer flbh2);

	List<ObjSkuPro> get_search_attr(Map<String, Object> map);

	ObjSkuPro show_pro_info(Integer sku_id);

	List<ObjSkuPro> get_ObjSkuPro_by_shp_id(Integer shp_id);

}
