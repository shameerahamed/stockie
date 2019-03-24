package com.stockie.dao;

import java.util.List;

import com.stockie.model.User;

/**
 * @author ShameerAhamed
 *
 */
public interface UserDao {
	public void addUser(User user);

	public List<User> listUsers();

	public User getUser(Long userId);

	public void deleteUser(Long userId);

	public User validateUser(User user);
}
