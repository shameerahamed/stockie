package com.stockie.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stockie.bean.CustomerBean;
import com.stockie.bean.LayoutBean;
import com.stockie.bean.OrderBean;
import com.stockie.bean.OrderItemBean;
import com.stockie.bean.ProductBean;
import com.stockie.service.CustomerService;
import com.stockie.service.LayoutService;
import com.stockie.service.OrderService;
import com.stockie.service.ProductService;
import com.stockie.util.DateUtil;

@Controller
public class OrderController {
private static final Logger logger = Logger.getLogger("OrderController");
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private LayoutService layoutService;

	@RequestMapping(value="/listOrder", method = RequestMethod.GET)
	public ModelAndView listOrders() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("orders",  orderService.listOrders());
		return new ModelAndView("ordersList", model);
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public ModelAndView addOrder(@ModelAttribute("command")  OrderBean orderBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("orders",  orderService.listOrders());
		
		OrderBean orderBean2 = new OrderBean();
		if (orderBean2.getOrderItems() != null) {
			orderBean2.getOrderItems().addAll(Collections.nCopies(5, new OrderItemBean()));
		}
		
		List<CustomerBean> customers = customerService.listCustomers();		
		model.put("customers", customers);
		
		productMap(model);
		model.put("order", orderBean2);
		
		return new ModelAndView("addOrder", model);
	}
	
	@RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
	public ModelAndView deleteOrder(@ModelAttribute("command")  OrderBean orderBean,
			@RequestParam("id") Long prodId) {
		orderService.deleteOrder(prodId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("order", null);
		model.put("orders",  orderService.listOrders());
		return new ModelAndView("addOrder", model);
	}
	
	@RequestMapping(value = "/viewOrder", method = RequestMethod.GET)
	public ModelAndView viewOrder(@RequestParam("id") Long orderId) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("order", orderService.getOrder(orderId));
		model.put("orders",  orderService.listOrders());
		
		return new ModelAndView("viewOrder", model);
	}
	
	@RequestMapping(value = "/printOrder", method = RequestMethod.GET)
	public ModelAndView printOrder(@RequestParam("id") Long orderId) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("order", orderService.getOrder(orderId));
		model.put("orders",  orderService.listOrders());
		model.put("screen", "print");
		
		return new ModelAndView("printOrder", model);
	}
	
/*	@RequestMapping(value = "/editOrder", method = RequestMethod.GET)
	public ModelAndView editOrder(@ModelAttribute("command")  OrderBean orderBean,
			@RequestParam("id") Long orderId) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("order", orderService.getOrder(orderId));
		model.put("orders",  orderService.listOrders());
		
		OrderBean orderBean2 = new OrderBean();
		if (orderBean2.getOrderItems() != null) {
			orderBean2.getOrderItems().addAll(Collections.nCopies(5, new OrderItemBean()));
		}
		
		List<CustomerBean> customers = customerService.listCustomers();		
		model.put("customers", customers);
		
		productMap(model);
		
		return new ModelAndView("addOrder", model);
	}*/
	
	public void productMap(Map<String, Object> model) {
		List<ProductBean> products = productService.listProducts();
		//Map<Long, String> productMap = new LinkedHashMap<Long, String>();
		
		/*for (ProductBean productBean : products) {
			productMap.put(productBean.getProdId(), productBean.getProdName());
		}*/
		
		model.put("products", products);		
	}
	
	@RequestMapping(value="/getAllProduct", method = RequestMethod.GET)
	public @ResponseBody List<ProductBean> getAllProduct() {
		List<ProductBean> products = productService.listProducts();
		return products;
	}
	
	@RequestMapping(value="/getProduct", method = RequestMethod.GET)
	public @ResponseBody ProductBean getProduct(@RequestParam(value = "prodId") Long prodId) {
		//String result = "";
		logger.info("prodId :: " + prodId);
		ProductBean productBean = productService.getProduct(prodId);
		//result = productBean;		
		return productBean;
	}
	

	@RequestMapping(value = "/sellOrder", method = RequestMethod.GET)
	public ModelAndView sellOrder() {
		Map<String, Object> model = new HashMap<String, Object>();		
		LayoutBean layoutBean = layoutService.getLayout(Long.valueOf(2));
		
		productMap(model);
		model.put("layout", layoutBean);
		//model.put("orders",  orderService.listOrders());
		
		return new ModelAndView("sellOrder", model);
	}
 
	@RequestMapping(value={"/saveOrder"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	@ResponseBody
	public String sync(@RequestBody OrderBean orderBean) { orderBean.setOrderDate(DateUtil.getCurrentDate());
		this.orderService.addOrder(orderBean);
		logger.info("OrderId" + orderBean.getOrderId());
		return orderBean.getOrderId().toString();
	}
}
