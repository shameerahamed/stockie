package com.stockie.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stockie.dao.ProductDao;
import com.stockie.model.Product;

/**
 * @author ShameerAhamed
 *
 */
@Repository ("productDao")
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	@Override
	public List<Product> listProducts() {
		return (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).list();
	}

	@Override
	public Product getProduct(Long prodId) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, prodId);
	}

	@Override
	public void deleteProduct(Long prodId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Product WHERE prodId = "+prodId).executeUpdate();
	}

}
