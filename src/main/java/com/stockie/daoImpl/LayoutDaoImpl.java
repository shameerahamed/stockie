package com.stockie.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stockie.dao.LayoutDao;
import com.stockie.model.Layout;

@Repository("layoutDao")
public class LayoutDaoImpl implements LayoutDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Layout getLayout(Long layoutId) {
		return (Layout) sessionFactory.getCurrentSession().get(Layout.class, layoutId);
	}
	
}
