package com.stockie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
/*    */ @Table(name="ORDER_ITEMS")
public class OrderItem {
	@Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ORD_ITEM_ID")
	//@SequenceGenerator(name = "SEQ_ORD_ITEM_ID", sequenceName = "SEQ_ORD_ITEM_ID", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Product product;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "amount")
	private Float amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

}
