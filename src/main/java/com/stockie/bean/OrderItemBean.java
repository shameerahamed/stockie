package com.stockie.bean;

public class OrderItemBean {
	private Long id;

	private OrderBean orderBean;

	private Long productId;

	private ProductBean productBean;

	private String unitCost;

	private Float amount;

	private Long quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderBean getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
