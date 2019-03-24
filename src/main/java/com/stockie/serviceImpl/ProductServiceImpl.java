package com.stockie.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stockie.bean.ProductBean;
import com.stockie.dao.ProductDao;
import com.stockie.model.Product;
import com.stockie.service.ProductService;

@Service ("productService")
@Transactional(propagation = Propagation.SUPPORTS)
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;

	@Override
	public void addProduct(ProductBean productBean) {
		productDao.addProduct(prepareModel(productBean));
	}

	@Override
	public List<ProductBean> listProducts() {
		return prepareListofBean(productDao.listProducts());
	}

	@Override
	public ProductBean getProduct(Long prodId) {
		return prepareBean(productDao.getProduct(prodId));
	}

	@Override
	public void deleteProduct(Long prodId) {
		productDao.deleteProduct(prodId);
	}
	
	public Product prepareModel(ProductBean productBean) {
		Product product = new Product();
		product.setProdId(productBean.getProdId());
		product.setProdName(productBean.getProdName());
		product.setBrandName(productBean.getBrandName());
		product.setPrice(productBean.getPrice());
		product.setQuantity(productBean.getQuantity());
		product.setQuantitySold(productBean.getQuantitySold());
		product.setTotalQuantity(productBean.getTotalQuantity());
		
		return product;
	}
	
	private List<ProductBean> prepareListofBean(List<Product> products){
		List<ProductBean> beans = null;
		if(products != null && !products.isEmpty()){
			beans = new ArrayList<ProductBean>();
			ProductBean bean = null;
			for(Product product : products){
				bean = new ProductBean();
				bean.setProdId(product.getProdId());
				bean.setProdName(product.getProdName());
				bean.setBrandName(product.getBrandName());
				bean.setPrice(product.getPrice());
				bean.setQuantity(product.getQuantity());
				bean.setQuantitySold(product.getQuantitySold());
				bean.setTotalQuantity(product.getTotalQuantity());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	public ProductBean prepareBean(Product product){
		ProductBean bean = new ProductBean();
		bean.setProdId(product.getProdId());
		bean.setProdName(product.getProdName());
		bean.setBrandName(product.getBrandName());
		bean.setPrice(product.getPrice());
		bean.setQuantity(product.getQuantity());
		bean.setQuantitySold(product.getQuantitySold());
		bean.setTotalQuantity(product.getTotalQuantity());
		return bean;
	}

}
