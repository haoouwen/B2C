package com.atguigu.b2c.manager.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.b2c.manager.bean.Product;
import com.atguigu.b2c.manager.service.ShpManagerService;
import com.atguigu.b2c.manager.service.ShpManagerServiceImpl;
import com.atguigu.b2c.util.B2CUtil;

@Controller
public class ShpManagerHandler {
  
	 @Autowired
	private ShpManagerService managerService;	
	 
	@RequestMapping("goto_spu_publish/{success}")
	public ModelAndView goto_spu_publish( @PathVariable(value="success") String success,ModelAndView mv){
		mv.addObject("success",success);
		mv.setViewName("spu_publish");
		return mv;
	}
	@RequestMapping("saveProduct")
	public String saveProduct(Product product,@RequestParam("image_file")MultipartFile[] image_file){
	List<String> list=B2CUtil.getImgeName(image_file);
	managerService.saveProduct(product,list);
		
		return "redirect:/goto_spu_publish/成功.do";
	}
}
