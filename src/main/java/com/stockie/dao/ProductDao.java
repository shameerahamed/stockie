package com.stockie.dao;

import java.util.List;

import com.stockie.model.Product;

/**
 * @author ShameerAhamed
 *
 */
public interface ProductDao {
	public void addProduct(Product product);

	public List<Product> listProducts();
	
	public Product getProduct(Long prodId);
	
	public void deleteProduct(Long prodId);
}
