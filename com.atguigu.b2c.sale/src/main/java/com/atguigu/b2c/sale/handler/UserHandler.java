package com.atguigu.b2c.sale.handler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.b2c.sale.bean.Address;
import com.atguigu.b2c.sale.bean.AjaxData;
import com.atguigu.b2c.sale.bean.ShoppingCart;
import com.atguigu.b2c.sale.bean.UserAccount;
import com.atguigu.b2c.sale.service.UserService;
import com.atguigu.b2c.sale.util.MyStringUtils;
import com.atguigu.b2c.ws.userService.AddressService;
import com.atguigu.b2c.ws.userService.WSUserService;

@Controller
public class UserHandler {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService webAddress;
	
	@Autowired
	private WSUserService webUser;
	
	@RequestMapping("goto_login")
	public String goto_login() {

		return "login";
	}
	@ResponseBody
	@RequestMapping("check_yhmch")
	public AjaxData check_yhmch(UserAccount userAccount) {
		AjaxData ajaxData = new AjaxData();
		UserAccount check = webUser.check(userAccount);
		if(check==null){
			ajaxData.setMessage("用户名可用！");
		}else{
			ajaxData.setMessage("用户名已存在！");
		}
		return ajaxData;
	}
	@RequestMapping("regist")
	public String register(UserAccount userAccount) {
		webUser.regist(userAccount);
		return "redirect:/login.do";
	}
	@RequestMapping("goto_regist")
	public String goto_register() {
		return "regist";
	}
	@RequestMapping("goto_add_aadress")
	public String goto_add_aadress(HttpSession session,ModelMap map) {
		UserAccount userAccount = (UserAccount)session.getAttribute("user");
		 List<Address> list_address = webAddress.get_address(userAccount.getId());
		map.put("list_address", list_address);
		return "add_aadress";
	}
	@ResponseBody
	@RequestMapping("save_address")
	public AjaxData save_address(Address address,HttpSession session) {
		AjaxData ajaxData = new AjaxData();
		UserAccount userAccount = (UserAccount)session.getAttribute("user");
		address.setYh_id(userAccount.getId());
		webAddress.save_address(address);
		ajaxData.setObject(address);
		return ajaxData;
	}

	@RequestMapping("login")
	public String login(UserAccount userAccount, HttpServletRequest request, HttpSession session, ModelMap map,
			HttpServletResponse response) {
		UserAccount login = webUser.login(userAccount);
	
		System.out.println(login);
		UserAccount user = userService.getUserAccount(userAccount);
		
		
		if (userAccount != null) {
			Cookie cookie = new Cookie("user", userAccount.getYh_mch());
			cookie.setMaxAge(60 * 60);
			response.addCookie(cookie);
			session.setAttribute("user", user);
			// 获取cookies中的购物车
			Cookie[] cookies = request.getCookies();
			ArrayList<ShoppingCart> db_shoppingCart = userService.get_shopping_cookies(user.getId());
			ArrayList<ShoppingCart> cookies_shoppingCart = new ArrayList<ShoppingCart>();
			session.setAttribute("str_session_cart", db_shoppingCart);
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("str_cookies_cart")) {
					// 获取cookies中的集合信息
					if(cookies[i].getValue()!=null&&cookies[i].getValue()!=""){
						cookies_shoppingCart = MyStringUtils.get_list(cookies[i].getValue(), ShoppingCart.class);
					}
					// 清除cookies
					Cookie cookie2 = new Cookie("str_cookies_cart", "");
					response.addCookie(cookie2);
				}
			}
			// 若数据库中无购物车信息
			if (db_shoppingCart == null || db_shoppingCart.size() == 0) {
				boolean b = true;

				if (cookies_shoppingCart != null || cookies_shoppingCart.size() != 0) {
					userService.save_shoppingCart_list(cookies_shoppingCart, user.getId());
					session.setAttribute("str_session_cart", cookies_shoppingCart);
				}
			} else {
				for (int i = 0; i < cookies_shoppingCart.size(); i++) {
					// 設置shoppingcart的用戶id
					cookies_shoppingCart.get(i).setYh_id(user.getId());
					boolean b = true;
					// 循环遍历集合，如sku_id相同则，更新数量，不相同则添加
					for (int j = 0; j < db_shoppingCart.size(); j++) {
						if (db_shoppingCart.get(j).getSku_id() == cookies_shoppingCart.get(i).getSku_id()) {
							//根性添加数量
							db_shoppingCart.get(j).setTjshl(db_shoppingCart.get(j).getTjshl() + cookies_shoppingCart.get(i).getTjshl());
							//更新合计
							db_shoppingCart.get(j).setHj(db_shoppingCart.get(j).getSku_jg().multiply(new BigDecimal(db_shoppingCart.get(j).getTjshl())));
							userService.update_shopping_cart(db_shoppingCart.get(j));
							b = false;
						}
					}
					if (b) {
                       //两个集合没有重复数据，添加数据库						
						userService.save_shoppingCart(cookies_shoppingCart.get(i));
						db_shoppingCart.add(cookies_shoppingCart.get(i));
					}
				}
			}
			return "redirect:/index.jsp";
		} else {
			map.put("msg", "用户名名或密码不对");
			return "login";
		}
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	
}
