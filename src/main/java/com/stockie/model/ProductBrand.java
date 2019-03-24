package com.stockie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_BRAND")
public class ProductBrand {
	@Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BRAND_ID")
	//@SequenceGenerator(name = "SEQ_BRAND_ID", sequenceName = "SEQ_BRAND_ID", allocationSize = 1)
	@Column(name="brand_id")
	private Long brandId;
	
	@Column(name="brand_name")
	private String brandName;

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
}
