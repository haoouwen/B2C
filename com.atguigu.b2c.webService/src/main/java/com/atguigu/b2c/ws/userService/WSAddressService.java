package com.atguigu.b2c.ws.userService;

import java.util.List;

import javax.jws.WebService;

import com.atguigu.b2c.ws.bean.Address;

@WebService
public interface WSAddressService {

	public List<Address>  get_address(Integer user_id);
	public void update_address(Address address);
	public void save_address(Address address);
	public void remove_address(Address address);
	
	
}
