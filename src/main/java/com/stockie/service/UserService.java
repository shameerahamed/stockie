package com.stockie.service;

import java.util.List;

import com.stockie.bean.UserBean;

public interface UserService {
	public void addUser(UserBean userBean);

	public List<UserBean> listUsers();
	
	public UserBean getUser(Long userId);
	
	public void deleteUser(Long userId);
	
	public UserBean validateUser(UserBean userBean) throws Exception;
}
