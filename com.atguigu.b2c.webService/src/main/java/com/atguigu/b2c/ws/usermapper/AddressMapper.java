package com.atguigu.b2c.ws.usermapper;

import java.util.List;

import com.atguigu.b2c.ws.bean.Address;

public interface AddressMapper {

     public List<Address>  select_address(Integer user_id);
	public void update_address(Address address);
	public void insert_address(Address address);
	public void delete_address(Address address);
}
