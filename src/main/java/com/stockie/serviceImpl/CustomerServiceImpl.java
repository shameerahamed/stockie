package com.stockie.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stockie.bean.CustomerBean;
import com.stockie.dao.CustomerDao;
import com.stockie.model.Customer;
import com.stockie.service.CustomerService;

@Service("customerService")
@Transactional(propagation = Propagation.SUPPORTS)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public void addCustomer(CustomerBean customerBean) {
		customerDao.addCustomer(prepareModel(customerBean));
	}

	public Customer prepareModel(CustomerBean customerBean) {
		Customer customer = new Customer();		
		customer.setCustName(customerBean.getCustName());
		customer.setAddress(customerBean.getAddress());
		customer.setEmail(customerBean.getEmail());
		customer.setPhoneNo(customerBean.getPhoneNo());
		customer.setRegDate(customerBean.getRegDate());
		customer.setCustId(customerBean.getCustId());
		customerBean.setCustId(null);
		return customer;
	}

	@Override
	public List<CustomerBean> listCustomers() {
		return prepareListofBean(customerDao.listCustomers());
	}

	private List<CustomerBean> prepareListofBean(List<Customer> customers) {
		List<CustomerBean> beans = null;
		if(customers != null && !customers.isEmpty()){
			beans = new ArrayList<CustomerBean>();
			for(Customer customer : customers){
				beans.add(prepareBean(customer));
			}
		}
		return beans;
	}

	@Override
	public CustomerBean getCustomer(Long custId) {
		Customer customer = customerDao.getCustomer(custId);
		return prepareBean(customer);
	}

	public CustomerBean prepareBean(Customer customer) {
		CustomerBean customerBean = new CustomerBean();
		customerBean.setCustId(customer.getCustId());
		customerBean.setCustName(customer.getCustName());
		customerBean.setAddress(customer.getAddress());
		customerBean.setEmail(customer.getEmail());
		customerBean.setPhoneNo(customer.getPhoneNo());
		customerBean.setRegDate(customer.getRegDate());
		return customerBean;
	}

	@Override
	public void deleteCustomer(Long custId) {
		customerDao.deleteCustomer(custId);
	}

}
