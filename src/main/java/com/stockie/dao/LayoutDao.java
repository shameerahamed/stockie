package com.stockie.dao;

import com.stockie.model.Layout;

/**
 * @author ShameerA
 *
 */
public interface LayoutDao {
	/**
	 * @param layoutId
	 * @return
	 */
	public Layout getLayout(Long layoutId);
}
