package com.stockie.service;

import java.util.List;

import com.stockie.bean.CustomerBean;
import com.stockie.model.Customer;

public interface CustomerService {
	public void addCustomer(CustomerBean customerBean);

	public List<CustomerBean> listCustomers();
	
	public CustomerBean getCustomer(Long custId);
	
	public void deleteCustomer(Long custId);
	
	public CustomerBean prepareBean(Customer customer);
	
	public Customer prepareModel(CustomerBean customerBean);
}
