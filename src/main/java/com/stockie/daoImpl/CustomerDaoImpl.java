package com.stockie.daoImpl;

/*    */ import com.stockie.dao.CustomerDao;
/*    */ import com.stockie.model.Customer;
import java.util.List;
/*    */ import org.hibernate.Criteria;
/*    */ import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stockie.dao.CustomerDao;
import com.stockie.model.Customer;

/**
 * @author ShameerAhamed
 *
 */
@Repository ("customerDao")
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@Override
	public List<Customer> listCustomers() {
		return (List<Customer>) sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	}

	@Override
	public Customer getCustomer(Long custId) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, custId);
	}

	@Override
	public void deleteCustomer(Long custId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Customer WHERE emp_id = "+custId).executeUpdate();		
	}

}
