package com.stockie.dao;

import java.util.List;

import com.stockie.model.Order;

public interface OrderDao {
	public void addOrder(Order order);

	public List<Order> listOrders();
	
	public Order getOrder(Long orderId);
	
	public void deleteOrder(Long orderId);
}
