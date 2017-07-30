package com.atguigu.b2c.sale.handler;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.b2c.sale.bean.AjaxData;
import com.atguigu.b2c.sale.bean.AttrValue;
import com.atguigu.b2c.sale.bean.Class2Attr;
import com.atguigu.b2c.sale.bean.ObjSkuPro;
import com.atguigu.b2c.sale.bean.ShoppingCart;
import com.atguigu.b2c.sale.bean.UserAccount;
import com.atguigu.b2c.sale.service.SearchService;
import com.atguigu.b2c.sale.util.MyStringUtils;

@Controller
public class SearchHandler {
    @Autowired
  	private SearchService searchService;
    
    
    @RequestMapping("show_pro_info")
    public String  show_pro_info(Integer sku_id,ModelMap modelMap){
    	ObjSkuPro skuPro = searchService.show_pro_info(sku_id);
    	List<ObjSkuPro> list = searchService.get_ObjSkuPro_by_shp_id(skuPro.getShp_id());
    	modelMap.put("skuPro", skuPro);
    	modelMap.put("list", list);
    	return "show_pro_info";
    }
    
    
    @RequestMapping("goto_search")
    public String  goto_search(ModelMap map,String flmch2,Integer flbh2){
    	List<ObjSkuPro> list = searchService.get_ObjSkuPro(flbh2);
    	map.put("list", list);
    	
    	List<Class2Attr> listAttr=searchService.get_attrByClass2_id(flbh2);
    	map.put("listAttr", listAttr);
    	map.put("flmch2", flmch2);
    	map.put("flbh2", flbh2);
    	return "search";
    }
    @ResponseBody
    @RequestMapping("get_search_attr")
    public AjaxData get_search_attr(Integer flbh2,AjaxData ajax,String orderBy){
    	AjaxData ajaxData = new  AjaxData();
    	Map<String,Object> map = new HashMap<String,Object>();
    	List<ObjSkuPro> listAttr =null;
    	try{
    		map.put("orderBy", orderBy);
    		if(flbh2==null&&ajax==null){
    			listAttr= searchService.get_search_attr(map);
    		}else{
    			map.put("flbh2", flbh2);
    			List<AttrValue> list2 = ajax.getListValue();
    			map.put("list2", list2);
    			 listAttr = searchService.get_search_attr(map);
    		}
    		ajaxData.setSuccess(true);
    		ajaxData.setList_ObjSkuPro(listAttr);
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    		ajaxData.setSuccess(false);
		}
    	return ajaxData;
    }
    
    
}
