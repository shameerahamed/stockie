package com.stockie.dao;

import java.util.List;

import com.stockie.model.Customer;

public interface CustomerDao {
	public void addCustomer(Customer customer);

	public List<Customer> listCustomers();
	
	public Customer getCustomer(Long custId);
	
	public void deleteCustomer(Long custId);
}
