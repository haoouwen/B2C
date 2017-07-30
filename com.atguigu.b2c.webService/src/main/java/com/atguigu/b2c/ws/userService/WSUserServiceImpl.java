package com.atguigu.b2c.ws.userService;

import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.b2c.ws.bean.UserAccount;
import com.atguigu.b2c.ws.usermapper.UserMapper;

public class WSUserServiceImpl implements WSUserService {

	 @Autowired
	private  UserMapper userMapper;
	
	public UserAccount check(UserAccount user) {
		return userMapper.select_user(user);
	}

	public UserAccount login(UserAccount user) {
		return userMapper.login(user);
	}

	public void regist(UserAccount user) {
		userMapper.insert_user(user);
	}

	public void update(UserAccount user) {
		userMapper.update_user(user);
	}

	public void remove(UserAccount user) {
		userMapper.delete_user(user);
	}

}
