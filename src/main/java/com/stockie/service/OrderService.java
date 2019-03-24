package com.stockie.service;

import java.util.List;

import com.stockie.bean.OrderBean;

public interface OrderService {

	public void addOrder(OrderBean orderBean);

	public List<OrderBean> listOrders();
	
	public OrderBean getOrder(Long orderId);
	
	public void deleteOrder(Long orderId);
}
