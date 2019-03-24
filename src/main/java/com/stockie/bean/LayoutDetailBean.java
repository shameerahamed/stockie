package com.stockie.bean;

/**
 * @author ShameerA
 * 
 */
public class LayoutDetailBean {
	private Long layoutId;

	private Long layoutDetailId;

	private LayoutBean layoutBean;

	private Long productId;

	private ProductBean productBean;

	private Long pageNo;

	private Long tabNo;

	private String colorCode;

	public Long getLayoutDetailId() {
		return layoutDetailId;
	}

	public void setLayoutDetailId(Long layoutDetailId) {
		this.layoutDetailId = layoutDetailId;
	}

	public Long getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(Long layoutId) {
		this.layoutId = layoutId;
	}

	public LayoutBean getLayoutBean() {
		return layoutBean;
	}

	public void setLayoutBean(LayoutBean layoutBean) {
		this.layoutBean = layoutBean;
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
