package com.atguigu.b2c.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.b2c.manager.bean.AttrValue;
import com.atguigu.b2c.manager.bean.Class2Attr;

public interface AttrManagerMapper {

	List<Class2Attr> getAttrByClass2Id(@Param("class2_id")Integer class2_id);

	void save_attr(Class2Attr class2Attr);

	void save_atte_value( AttrValue attrValue);

}
