package com.atguigu.b2c.manager.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.b2c.manager.bean.AjaxData;
import com.atguigu.b2c.manager.bean.Class2Attr;
import com.atguigu.b2c.manager.service.AttrManagerService;


@Controller
public class AttrManagerHandler {
  
	 @Autowired
	 private AttrManagerService attrmanagerService;	
	 
	 @RequestMapping("goto_attr_publish")
	 public String goto_attr_publish(){
		 
		 return "attr_publish";
	 }
	 
	 //restFull风格
	@RequestMapping("attr_add")
	public ModelAndView do_add_attr(String flmch2,Integer flbh2,AjaxData ajaxData,ModelAndView mv){
		
		System.out.println(flbh2+flmch2);
		attrmanagerService.add_attr(flmch2,flbh2,ajaxData);
		mv.addObject("redirect:/add_attr/flbh2/flmch2.do");
		mv.addObject("message", "添加成功");
		return mv;
	}
	@RequestMapping("add_attr/{flbh2}/{flmch2}")
	public String add_attr(@PathVariable(value="flbh2")Integer flbh2,@PathVariable(value="flmch2")String  flmch2){
		
		return "add_attr2";
	}
	
	@ResponseBody
	@RequestMapping("show_attr")
	public AjaxData show_attr(Integer class2_id,String flmch2){
	   AjaxData ajaxData = new AjaxData();
	   try{
		   List<Class2Attr> list = attrmanagerService.show_attr(class2_id);
		   ajaxData.setList(list);
		   ajaxData.setSuccess(true);
	   }catch(Exception e){
		   ajaxData.setSuccess(false);
		   e.printStackTrace();
	   }finally{
		   return ajaxData;
	   }
	}
}
