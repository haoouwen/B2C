package com.atguigu.b2c.manager.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.b2c.manager.bean.AjaxData;
import com.atguigu.b2c.manager.bean.Class2Attr;
import com.atguigu.b2c.manager.bean.Product;
import com.atguigu.b2c.manager.bean.Sku;
import com.atguigu.b2c.manager.service.SkuManagerService;


@Controller
public class SkuManagerHandler {
  
	 @Autowired
	 private SkuManagerService skumanagerService;	
	
	 
	 @RequestMapping("goto_sku_publish")
	 public String goto_attr_publish(){
		 
		 return "sku_publish";
	 }
	 
	
	@ResponseBody
	@RequestMapping("get_shp_mch")
	public AjaxData get_shp_mch(Product product){
	   AjaxData ajaxData = new AjaxData();
	   try{
		   List<Product> list_product = skumanagerService.get_shp_mch(product);
		   ajaxData.setList_product(list_product);
		   System.out.println(list_product.size());
		   ajaxData.setSuccess(true);
	   }catch(Exception e){
		   ajaxData.setSuccess(false);
		   e.printStackTrace();
	   }finally{
		   return ajaxData;
	   }
	}
	@ResponseBody
	@RequestMapping("select_attr")
	public AjaxData show_attr(Integer flbh2,String flmch2){
		
	   AjaxData ajaxData = new AjaxData();
	   try{
		   List<Class2Attr> list = skumanagerService.select_attr(flbh2);
		   ajaxData.setList(list);
		   ajaxData.setSuccess(true);
	   }catch(Exception e){
		   ajaxData.setSuccess(false);
		   e.printStackTrace();
	   }finally{
		   return ajaxData;
	   }
	}
	@RequestMapping("saveSkuInfo")
	public String saveSkuInfo(Sku sku,AjaxData ajaxData){
		System.out.println(sku.getShp_id());
		skumanagerService.saveSkuInfo(sku,ajaxData);
		return "redirect:/goto_sku_publish.do";
	}
}
