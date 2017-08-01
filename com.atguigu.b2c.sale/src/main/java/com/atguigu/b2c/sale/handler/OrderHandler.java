package com.atguigu.b2c.sale.handler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.atguigu.b2c.sale.bean.Address;
import com.atguigu.b2c.sale.bean.Object_Orders;
import com.atguigu.b2c.sale.bean.Order_Info;
import com.atguigu.b2c.sale.bean.ShoppingCart;
import com.atguigu.b2c.sale.bean.UserAccount;
import com.atguigu.b2c.sale.service.OrderService;
import com.atguigu.b2c.ws.userService.AddressService;
import com.sun.javafx.sg.prism.NGShape.Mode;

@Controller
@SessionAttributes("list_order")
public class OrderHandler {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AddressService addressService;
	
	
	@RequestMapping("goto_pay")
	public String goto_pay(BigDecimal zje,HttpSession session,ModelMap map){
		
		Object attribute = session.getAttribute("user");
		if(attribute==null){
			
			return  "redirect:/login_for_pay.do";
		}else{
			
			ArrayList<ShoppingCart> arrayList = new ArrayList<ShoppingCart>();
			ArrayList<Object_Orders> list_order = new ArrayList<Object_Orders>();
			
			
			HashSet<String> hashSet = new HashSet<String>();
			UserAccount user =(UserAccount)attribute;
			ArrayList<ShoppingCart> list_cart = (ArrayList<ShoppingCart>)session.getAttribute("str_session_cart");
			
			for (int i = 0; i < list_cart.size(); i++) {
				if (list_cart.get(i).getShfxz().equals("1")) {
					hashSet.add(list_cart.get(i).getKcdz());
					arrayList.add(list_cart.get(i));
				}
			}
			Iterator<String> iterator = hashSet.iterator();
			BigDecimal sum = new BigDecimal("0");
			while(iterator.hasNext()){
				String next = iterator.next();
				ArrayList<Order_Info> order_info_list = new ArrayList<Order_Info>();
				Object_Orders object_Order = new Object_Orders();
				object_Order.setJdh(1);
				object_Order.setYh_id(user.getId());
				BigDecimal bigDecimal = new BigDecimal("0");
				
				for (int i = 0; i < arrayList.size(); i++) {
					Order_Info order_Info = new Order_Info();
					if(next.equals(arrayList.get(i).getKcdz())){
						bigDecimal=bigDecimal.add(new BigDecimal(arrayList.get(i).getHj()+""));
						object_Order.setZje(arrayList.get(i).getHj());
						
						order_Info.setGwch_id(arrayList.get(i).getId());
						order_Info.setShp_tp(arrayList.get(i).getShp_tp());
						order_Info.setSku_id(arrayList.get(i).getSku_id());
						order_Info.setSku_jg(arrayList.get(i).getSku_jg());
						order_Info.setSku_kcdz(arrayList.get(i).getKcdz());
						order_Info.setSku_mch(arrayList.get(i).getSku_mch());
						order_Info.setSku_shl(arrayList.get(i).getTjshl());
					}
					order_info_list.add(order_Info);
				}
				object_Order.setZje(bigDecimal);
				
				sum=sum.add(bigDecimal);
				object_Order.setList_info(order_info_list);
				list_order.add(object_Order);
			}
			map.addAttribute("list_order", list_order);
			map.put("sum", sum);
			return "redirect:/order_pay.do?zje="+zje+"";
		}
	}
	
	@RequestMapping("order_pay")
	public String order_pay(@ModelAttribute("list_order") List<Object_Orders> list_order,ModelMap  map,HttpSession session,
		                    BigDecimal zje){
		UserAccount userAccount=(UserAccount)session.getAttribute("user");
		List<Address> get_address = addressService.get_address(userAccount.getId());
		map.put("get_address", get_address);
		map.put("zje", zje);
		map.put("list_order", list_order);
		return "sale_order";
	}
	@RequestMapping("to_pay")
	public String to_pay(@ModelAttribute("list_order") List<Object_Orders> list_order,ModelMap  map,HttpSession session,
		                    BigDecimal sum,Address address) throws Exception{
		UserAccount userAccount=(UserAccount)session.getAttribute("user");
		
		orderService.save_order(list_order,address,userAccount);
		List<ShoppingCart> list_car = (List<ShoppingCart>) session.getAttribute("list_car_session");
		List<ShoppingCart> list_car_del = new ArrayList<ShoppingCart>();
		for (int i = 0; i < list_car.size(); i++) {
			if (list_car.get(i).getShfxz().equals("1")) {
				list_car_del.add(list_car.get(i));
			}
		}
		list_car.removeAll(list_car_del);
		
		
		return "sale_order";
		
		
	}
	
	
	
}
