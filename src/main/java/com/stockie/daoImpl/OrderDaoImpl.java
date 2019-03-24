package com.stockie.daoImpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stockie.dao.OrderDao;
import com.stockie.model.Order;

@Repository ("orderDao")
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addOrder(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);		
	}

	@Override
	public List<Order> listOrders() {
		Query q = sessionFactory.getCurrentSession().createQuery("from Order");
		
		return (List<Order>) q.list();		
	}

	@Override
	public Order getOrder(Long orderId) {
		return (Order) sessionFactory.getCurrentSession().get(Order.class, orderId);
	}

	@Override
	public void deleteOrder(Long OrderId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Order WHERE orderId = "+OrderId).executeUpdate();
	}

}
