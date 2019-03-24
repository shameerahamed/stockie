package com.stockie.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stockie.bean.UserBean;
import com.stockie.dao.UserDao;
import com.stockie.model.User;
import com.stockie.service.UserService;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(UserBean userBean) {
		userDao.addUser(prepareModel(userBean));		
	}

	@Override
	public List<UserBean> listUsers() {
		return prepareListofBean(userDao.listUsers());
	}

	@Override
	public UserBean getUser(Long userId) {
		return prepareUserBean(userDao.getUser(userId));
	}

	@Override
	public void deleteUser(Long userId) {
		userDao.deleteUser(userId);		
	}

	@Override
	public UserBean validateUser(UserBean userBean) throws Exception {
		User user = prepareModel(userBean);
		user = userDao.validateUser(user);
		
		if (user != null) {
			userBean = prepareUserBean(user);
		}
		return userBean;
	}
	
	private User prepareModel(UserBean userBean) {
		User user = new User();
		user.setUserId(userBean.getUserId());
		user.setUsername(userBean.getUsername());
		user.setEnabled(userBean.getEnabled());
		user.setPassword(userBean.getPassword());
		userBean.setUserId(null);
		return user;
	}
	
	private List<UserBean> prepareListofBean(List<User> users){
		List<UserBean> beans = null;
		if(users != null && !users.isEmpty()){
			beans = new ArrayList<UserBean>();
			UserBean bean = null;
			for(User user : users){
				bean = new UserBean();
				bean.setUsername(user.getUsername());
				bean.setUserId(user.getUserId());
				bean.setEnabled(user.getEnabled());
				bean.setPassword(user.getPassword());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private UserBean prepareUserBean(User user){
		UserBean bean = new UserBean();
		bean.setUsername(user.getUsername());
		bean.setPassword(user.getPassword());
		bean.setEnabled(user.getEnabled());
		bean.setUserId(user.getUserId());
		return bean;
	}
}
