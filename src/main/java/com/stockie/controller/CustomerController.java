package com.stockie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.stockie.bean.CustomerBean;
import com.stockie.service.CustomerService;
import com.stockie.util.DateUtil;

@Controller
public class CustomerController {
	private static final Logger logger = Logger.getLogger("CustomerController");
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute("command") CustomerBean customerBean, 
			BindingResult result) {
		logger.info("saveCustomer");
		customerService.addCustomer(customerBean);
		return new ModelAndView("redirect:/listCustomer.sg");
	}

	@RequestMapping(value="/listCustomer", method = RequestMethod.GET)
	public ModelAndView listCustomers() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customers",  customerService.listCustomers());
		return new ModelAndView("customersList", model);
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView addCustomer(@ModelAttribute("command")  CustomerBean customerBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customers",  customerService.listCustomers());
		customerBean.setRegDate(DateUtil.getCurrentDate());
		return new ModelAndView("addCustomer", model);
	}
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@ModelAttribute("command")  CustomerBean customerBean,
			@RequestParam("id") Long custId) {
		customerService.deleteCustomer(custId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customer", null);
		model.put("customers",  customerService.listCustomers());
		return new ModelAndView("addCustomer", model);
	}
	
	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editCustomer(@ModelAttribute("command")  CustomerBean customerBean,
			@RequestParam("id") Long custId) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("customer", customerService.getCustomer(custId));
		model.put("customers",  customerService.listCustomers());
		return new ModelAndView("addCustomer", model);
	}
	
	@RequestMapping(value="/getAllCustomers", method = RequestMethod.GET)
	public @ResponseBody List<CustomerBean> getAllProduct() {
		List<CustomerBean> customers = customerService.listCustomers();
		return customers;
	}
	
	@RequestMapping(value="/getCustomer", method = RequestMethod.GET)
	public @ResponseBody CustomerBean getCustomer(@RequestParam(value = "prodId") Long custId) {
		logger.info("custId :: " + custId);
		CustomerBean CustomerBean = customerService.getCustomer(custId);
		return CustomerBean;
	}
}
