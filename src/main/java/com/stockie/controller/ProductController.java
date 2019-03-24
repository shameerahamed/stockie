package com.stockie.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stockie.bean.ProductBean;
import com.stockie.service.ProductService;

@Controller
public class ProductController {
private static final Logger logger = Logger.getLogger("ProductController");
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("command") ProductBean productBean, 
			BindingResult result) {
		logger.info("saveProduct");
		productService.addProduct(productBean);
		return new ModelAndView("redirect:/listProduct.sg");
	}

	@RequestMapping(value="/listProduct", method = RequestMethod.GET)
	public ModelAndView listProducts() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("products",  productService.listProducts());
		return new ModelAndView("productsList", model);
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView addProduct(@ModelAttribute("command")  ProductBean productBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("products",  productService.listProducts());
		return new ModelAndView("addProduct", model);
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@ModelAttribute("command")  ProductBean productBean,
			@RequestParam("id") Long prodId) {
		productService.deleteProduct(prodId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("product", null);
		model.put("products",  productService.listProducts());
		return new ModelAndView("addProduct", model);
	}
	
	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editProduct(@ModelAttribute("command")  ProductBean productBean,
			@RequestParam("id") Long prodId) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("product", productService.getProduct(prodId));
		model.put("products",  productService.listProducts());
		return new ModelAndView("addProduct", model);
	}
}
