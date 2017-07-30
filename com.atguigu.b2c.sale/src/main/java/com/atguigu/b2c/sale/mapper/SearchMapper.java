package com.atguigu.b2c.sale.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.b2c.sale.bean.Class2Attr;
import com.atguigu.b2c.sale.bean.ObjSkuPro;

public interface SearchMapper {

	List<ObjSkuPro> select_ObjSkuPro(Integer flbh2);

	List<Class2Attr> select_attrByClass2_id(Integer flbh2);

	List<ObjSkuPro> select_search_attr(@Param("flbh2")Integer flbh2,@Param("sql")String sql);

	ObjSkuPro select_pro_by_sku_id(Integer sku_id);

	List<ObjSkuPro> select_ObjSkuPro_by_shp_id(Integer shp_id);


}
