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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "LAYOUT")
public class Layout {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "LAYOUT_ID")
	private Long layoutId;

	@Column(name = "LAYOUT_NAME")
	private String layoutName;

	@Column(name = "TOTAL_TABS")
	private Long totalTabs;

	@Column(name = "TOTAL_PAGES")
	private Long totalPages;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "LAYOUT_ID")
	@ForeignKey(name = "FK_LAYOUT")
	private List<LayoutDetail> layoutDetails;

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

	public List<LayoutDetail> getLayoutDetails() {
		return layoutDetails;
	}

	public void setLayoutDetails(List<LayoutDetail> layoutDetails) {
		this.layoutDetails = layoutDetails;
	}

}
