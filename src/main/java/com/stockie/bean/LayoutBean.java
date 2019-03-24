package com.stockie.bean;

import java.util.List;

public class LayoutBean {
	private Long layoutId;

	private String layoutName;

	private Long totalTabs;

	private Long totalPages;

	private List<LayoutDetailBean> layoutDetailBeans;

	public Long getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(Long layoutId) {
		this.layoutId = layoutId;
	}

	public String getLayoutName() {
		return layoutName;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}

	public Long getTotalTabs() {
		return totalTabs;
	}

	public void setTotalTabs(Long totalTabs) {
		this.totalTabs = totalTabs;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public List<LayoutDetailBean> getLayoutDetailBeans() {
		return layoutDetailBeans;
	}

	public void setLayoutDetailBeans(List<LayoutDetailBean> layoutDetailBeans) {
		this.layoutDetailBeans = layoutDetailBeans;
	}

}
