package com.atguigu.b2c.sale.handler;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.b2c.sale.bean.AjaxData;
import com.atguigu.b2c.sale.bean.ShoppingCart;
import com.atguigu.b2c.sale.bean.UserAccount;
import com.atguigu.b2c.sale.service.ShoppingCartService;
import com.atguigu.b2c.sale.util.MyStringUtils;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import net.sf.json.util.NewBeanInstanceStrategy;

@Controller
public class ShoppingCartHandler {

	@Autowired
	private ShoppingCartService shoppingCartService;

	
	 @RequestMapping("delete_cart")
	 @ResponseBody
	 public AjaxData delete_shoppingCart(HttpSession session,@CookieValue(value="str_cookies_cart",required=false)String str_cookies_cart,Integer sku_id){
		 AjaxData  ajaxData = new AjaxData();
		 Object attribute = session.getAttribute("user");
		 ArrayList<ShoppingCart> get_list =null;
		   try {
			if(attribute==null){
				   get_list = MyStringUtils.get_list(str_cookies_cart, ShoppingCart.class);
				   for (int i = 0; i < get_list.size(); i++) {
					   if(get_list.get(i).getSku_id()==sku_id){
						   get_list.remove(i);
						}
				}
			   }else{
				   get_list = (ArrayList<ShoppingCart>)session.getAttribute("str_session_cart");
				   for (int i = 0; i < get_list.size(); i++) {
					   if(get_list.get(i).getSku_id()==sku_id){
						   get_list.remove(i);
						   shoppingCartService.delete_shoppingCart(sku_id);
						}
				}
			   }
			ajaxData.setSuccess(true);
			
		} catch (Exception e) {
			ajaxData.setSuccess(false);
			e.printStackTrace();
		}
		 return ajaxData;
	 }
	
	//更新购物车
	 /**
	 * @return
	 */
	@ResponseBody
	 @RequestMapping("update_shopping_cart")
	 public AjaxData update_shopping_cart(HttpServletResponse response,@CookieValue(value="str_cookies_cart",required=false)String str_cookies_cart,Integer sku_id,Integer tjshl,String shfxz,HttpSession session,ModelMap map){
		  AjaxData ajaxData = new AjaxData();
		 Object user = session.getAttribute("user");
		 ArrayList<ShoppingCart> get_list =null;
		 //将boolean的选中状态改为Integer类型
		 
		 if(user==null){
					//将cookies字符创转化为List
			 get_list = MyStringUtils.get_list(str_cookies_cart, ShoppingCart.class);
			 //遍历集合更改购物车状态
			 for (ShoppingCart shoppingCart : get_list) {
				if(shoppingCart.getSku_id()==sku_id){
					shoppingCart.setTjshl(tjshl);
					if(shfxz.equals("-1")){}
					else{
						if (tjshl.equals(true)) {
							shoppingCart.setShfxz("1");
						}else{
							shoppingCart.setShfxz("0");
						}
					}
					
				shoppingCart.setHj(shoppingCart.getSku_jg().multiply(new BigDecimal(tjshl+"")));
				}
			}
			 Cookie cookie = new Cookie("str_cookies_cart", MyStringUtils.get_json(get_list));
			 cookie.setMaxAge(60*60*24*7);
			 response.addCookie(cookie);
		 }else{
			 get_list = (ArrayList<ShoppingCart>)session.getAttribute("str_session_cart");
			 for (ShoppingCart shoppingCart : get_list) {
					if(shoppingCart.getSku_id()==sku_id){
						shoppingCart.setTjshl(tjshl);
						if(shfxz.equals("-1")){}
						else{
							if (tjshl.equals(true)) {
								shoppingCart.setShfxz("1");
							}else{
								shoppingCart.setShfxz("0");
							}
						}	
						shoppingCart.setHj(shoppingCart.getSku_jg().multiply(new BigDecimal(tjshl+"")));
						shoppingCartService.update_shoppingCart(shoppingCart);
				}
		 }
			 }
		 BigDecimal num = new BigDecimal("0");
			
			for (ShoppingCart shoppingCart : get_list) {
				num.add(shoppingCart.getHj());
			}
		 ajaxData.setShoppingCart_list(get_list);
		 String message = get_list.size()+" "+num;
		 ajaxData.setMessage(message);
		 return ajaxData;
	 }
	
	@RequestMapping("show_mini_shopingCart")
	public String show_mini_shopingCart(@CookieValue(value="str_cookies_cart",required=false)String str_cookies_cart,HttpSession session,ModelMap map){
		Object user = session.getAttribute("user");
		ArrayList<ShoppingCart> get_list =null;
		if(user==null){
			//将cookies字符创转化为List
			if(str_cookies_cart!=null&&str_cookies_cart!=""){
				
				get_list = MyStringUtils.get_list(str_cookies_cart, ShoppingCart.class);
			}
		}else{
			get_list = (ArrayList<ShoppingCart>)session.getAttribute("str_session_cart");
		}
		BigDecimal num = new BigDecimal("0");
		
		for (ShoppingCart shoppingCart : get_list) {
			num =num.add(shoppingCart.getHj());
		}
		
		map.put("get_list", get_list);
		map.put("num", num);
		map.put("count", get_list.size());
		return "mini_cart_inner";
	}
	 @ResponseBody
	 @RequestMapping("ajax_select_shopingCart")
	 public AjaxData ajax_select_shopingCart(@CookieValue(value="str_cookies_cart",required=false)String str_cookies_cart,HttpSession session,ModelMap map){
		  AjaxData ajaxData = new AjaxData();
		 Object user = session.getAttribute("user");
		 ArrayList<ShoppingCart> get_list =null;
		 if(user==null){
					//将cookies字符创转化为List
			 get_list = MyStringUtils.get_list(str_cookies_cart, ShoppingCart.class);
		 }else{
			 get_list = (ArrayList<ShoppingCart>)session.getAttribute("str_session_cart");
		 }
		 ajaxData.setShoppingCart_list(get_list);
		 map.put("get_list", get_list);
		 return ajaxData;
	 }
	@RequestMapping("goto_shopping")
	public String goto_shopping() {
		return "search";
	}

	@RequestMapping("add_shopping_cart")
	public String add_shopping_cart(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ShoppingCart cart) {
		Object attribute = session.getAttribute("user");

		ArrayList<ShoppingCart> list_cart = new ArrayList<ShoppingCart>();
		// 未登录
		if (attribute == null) {
			Cookie[] cookies = request.getCookies();
			// 若cookies不为空，循环遍历数组，
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("str_cookies_cart")) {
					String str_cookies = cookies[i].getValue();
					list_cart = MyStringUtils.get_list(str_cookies, ShoppingCart.class);
				}
			}
			if (list_cart.size() != 0) {
				boolean b = true;
				for (int i = 0; i < list_cart.size(); i++) {
					if (list_cart.get(i).getSku_id() == cart.getSku_id()) {
						b = false;
						list_cart.get(i).setTjshl(list_cart.get(i).getTjshl() + 1);
						list_cart.get(i).setHj(list_cart.get(i).getSku_jg().multiply(new BigDecimal(list_cart.get(i).getTjshl())));
					}
				}
				if (b) {
					list_cart.add(cart);
				}
			} else {
				list_cart.add(cart);
			}

			String str_cookies_cart = MyStringUtils.get_json(list_cart);
			Cookie cookie = new Cookie("str_cookies_cart", str_cookies_cart);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);
			// 已登录
		} else {
			UserAccount user = (UserAccount) attribute;
			list_cart = (ArrayList<ShoppingCart>) session.getAttribute("str_session_cart");
			if (list_cart == null || list_cart.size() == 0) {
				cart.setYh_id(user.getId());
				shoppingCartService.add_shoppingCart(cart);
				list_cart.add(cart);
				session.setAttribute("str_session_cart", list_cart);
			} else {
				boolean b = true;
				for (ShoppingCart shoppingCart : list_cart) {
					if (shoppingCart.getSku_id() == cart.getSku_id()) {
						shoppingCart.setTjshl(shoppingCart.getTjshl() + 1);
						shoppingCart.setHj(shoppingCart.getSku_jg().multiply(new BigDecimal(shoppingCart.getTjshl())) );
						shoppingCartService.update_shoppingCart(shoppingCart);
						b = false;
					}
				}
				if (b) {
					cart.setYh_id(user.getId());
					shoppingCartService.add_shoppingCart(cart);
					list_cart.add(cart);
				}
			}
		}
		return "redirect:/add_cookies_success.do";
	}

	@RequestMapping("add_cookies_success")
	public String add_cookies_success(){
		
		return "add_cookies_success";
	}
	
	
}
