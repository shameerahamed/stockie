package com.stockie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {
	@Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROD_ID")
	//@SequenceGenerator(name = "SEQ_PROD_ID", sequenceName = "SEQ_PROD_ID", allocationSize = 1)
	@Column(name = "PROD_ID")
	private Long prodId;
	
	@Column(name = "Prod_Name")
	private String prodName;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "BRAND_NAME")
	private String brandName;
	
	@Column(name="quantity_sold")
	private Long quantitySold;
	
	@Column(name="total_quantity")
	private Long totalQuantity;	
	
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Long getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(Long quantitySold) {
		this.quantitySold = quantitySold;
	}
	public Long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
}
