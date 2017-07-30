package com.atguigu.b2c.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.b2c.manager.bean.AjaxData;
import com.atguigu.b2c.manager.bean.AttrValue;
import com.atguigu.b2c.manager.bean.Class2Attr;
import com.atguigu.b2c.manager.mapper.AttrManagerMapper;

@Service                                       
public  class AttrManagerServiceImpl implements AttrManagerService{

	 @Autowired
	 private AttrManagerMapper attrManagerMapper ;
	
	public List<Class2Attr> show_attr(Integer class2_id) {
		return attrManagerMapper.getAttrByClass2Id(class2_id);
	}

	public void add_attr(String flmch2, Integer flbh2, AjaxData ajaxData) {
		List<Class2Attr> list = ajaxData.getList();
		
		for (Class2Attr class2Attr : list) {
			class2Attr.setFlbh2(flbh2);
			attrManagerMapper.save_attr(class2Attr);
			Integer shxm_id = class2Attr.getId();
			List<AttrValue> list2 = class2Attr.getList();
			for (AttrValue attrValue : list2) {
				attrValue.setShxm_id(shxm_id);
				attrManagerMapper.save_atte_value(attrValue);
			}
			
			
		}
		
		
		
		
		
	}

	

}
