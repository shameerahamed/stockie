package com.stockie.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stockie.dao.UserDao;
import com.stockie.model.User;

/**
 * @author ShameerAhamed
 *
 */
@Repository ("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);		
	}

	@Override
	public List<User> listUsers() {
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User getUser(Long userId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}

	@Override
	public void deleteUser(Long userId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE userId = "+userId).executeUpdate();
	}

	@Override
	public User validateUser(User user) {
		Query q = sessionFactory.getCurrentSession().createQuery("from User where username = :username and password = :password");
		q.setString("username", user.getUsername());
		q.setString("password", user.getPassword());
		
		return (User)q.uniqueResult();
	}

}
