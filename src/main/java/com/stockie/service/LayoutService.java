package com.stockie.service;

import com.stockie.bean.LayoutBean;

/**
 * @author ShameerA
 *
 */
public interface LayoutService {
	/**
	 * @param layoutId
	 * @return
	 */
	public LayoutBean getLayout(Long layoutId);
}
