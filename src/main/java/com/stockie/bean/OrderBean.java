package com.stockie.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderBean {
	private Long orderId;

	private CustomerBean customerBean;

	private Long customerId;

	private List<CustomerBean> customers;

	private String orderDate;

	private Float discount;

	private Float subTotal;

	private List<OrderItemBean> orderItems = new ArrayList(5);

	private String status;
	private Long tax;

	private Float netAmount;
	private Float oldBalance;

	public Float getOldBalance() {
		return this.oldBalance;
	}

	public void setOldBalance(Float oldBalance) {
		this.oldBalance = oldBalance;
	}

	public Float getNetAmount() {
		return this.netAmount;
	}

	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public CustomerBean getCustomerBean() {
		return customerBean;
	}

	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}

	public List<CustomerBean> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerBean> customers) {
		this.customers = customers;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public List<OrderItemBean> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemBean> orderItems) {
		this.orderItems = orderItems;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Float subTotal) {
		this.subTotal = subTotal;
	}

	public Long getTax() {
		return tax;
	}

	public void setTax(Long tax) {
		this.tax = tax;
	}

}
