package com.atguigu.b2c.ws.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.b2c.ws.bean.Address;
import com.atguigu.b2c.ws.usermapper.AddressMapper;

public class WSAddressServiceImpl implements WSAddressService {

	@Autowired
	private AddressMapper addressMapper;
	public List<Address>  get_address(Integer user_id) {
		List<Address> select_address = addressMapper.select_address(user_id);
		System.out.println(select_address.size());
		return select_address;
	}

	public void update_address(Address address) {
		// TODO Auto-generated method stub
		addressMapper.update_address(address);
	}

	public void save_address(Address address) {
		// TODO Auto-generated method stub
		addressMapper.insert_address(address);
	}

	public void remove_address(Address address) {
		// TODO Auto-generated method stub
		addressMapper.delete_address(address);
	}

}
