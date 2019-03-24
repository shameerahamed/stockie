package com.stockie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LAYOUT_DETAILS")
public class LayoutDetail {

	@Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "LAYOUT_DETAIL_ID")
	private Long layoutDetailId;

	@ManyToOne
	@JoinColumn(name = "LAYOUT_ID")
	private Layout layout;

	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Product product;

	@Column(name = "PAGE_NO")
	private Long pageNo;

	@Column(name = "TAB_NO")
	private Long tabNo;

	@Column(name = "COLOR_CODE")
	private String colorCode;

	public Long getLayoutDetailId() {
		return layoutDetailId;
	}

	public void setLayoutDetailId(Long layoutDetailId) {
		this.layoutDetailId = layoutDetailId;
	}

	public Layout getLayout() {
		return layout;
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getPageNo() {
		return pageNo;
	}

	public void setPageNo(Long pageNo) {
		this.pageNo = pageNo;
	}

	public Long getTabNo() {
		return tabNo;
	}

	public void setTabNo(Long tabNo) {
		this.tabNo = tabNo;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

}
