package com.stockie.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "SEQ_ORD_ID")
	// @SequenceGenerator(name = "SEQ_ORD_ID", sequenceName = "SEQ_ORD_ID",
	// allocationSize = 1)
	@Column(name = "order_id")
	private Long orderId;

	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	@Column(name = "order_date")
	private String orderDate;

	@Column(name = "discount")
	private Float discount;

	@Column(name = "sub_total")
	private Float subTotal;

	@Column(name = "status")
	private String status;
	@Column(name = "tax")
	private Long tax;
	@Column(name = "net_amount")
	private Float netAmount;
	@Column(name = "old_balance")
	private Float oldBalance;
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	@ForeignKey(name = "FK_ORDER")
	private List<OrderItem> orderItems;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public Float getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(Float subTotal) {
		this.subTotal = subTotal;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTax() {
		return tax;
	}

	public void setTax(Long tax) {
		this.tax = tax;
	}

	public Float getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}

	public Float getOldBalance() {
		return oldBalance;
	}

	public void setOldBalance(Float oldBalance) {
		this.oldBalance = oldBalance;
	}

}
