package com.atguigu.b2c.ws.userService;

import javax.jws.WebService;

import com.atguigu.b2c.ws.bean.UserAccount;

@WebService
public interface WSUserService {

	public UserAccount check(UserAccount user);
	public UserAccount login(UserAccount user);
	public void regist(UserAccount user);
	public void update(UserAccount user);
	public void remove(UserAccount user);
	
	
}
