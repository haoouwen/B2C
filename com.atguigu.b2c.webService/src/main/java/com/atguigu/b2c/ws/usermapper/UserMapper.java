package com.atguigu.b2c.ws.usermapper;

import com.atguigu.b2c.ws.bean.UserAccount;

public interface UserMapper {

	public UserAccount select_user(UserAccount user);
	public UserAccount login(UserAccount user);
	public void insert_user(UserAccount user);
	public void update_user(UserAccount user);
	public void delete_user(UserAccount user);
}
