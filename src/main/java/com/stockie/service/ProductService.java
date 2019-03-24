package com.stockie.service;

import java.util.List;

import com.stockie.bean.ProductBean;
import com.stockie.model.Product;

/**
 * @author ShameerAhamed
 *
 */
public interface ProductService {
	public void addProduct(ProductBean productBean);

	public List<ProductBean> listProducts();
	
	public ProductBean getProduct(Long prodId);
	
	public void deleteProduct(Long prodId);
	
	public Product prepareModel(ProductBean productBean);
	
	public ProductBean prepareBean (Product product);
}
