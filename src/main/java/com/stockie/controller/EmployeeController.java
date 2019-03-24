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

import com.stockie.bean.EmployeeBean;
import com.stockie.service.EmployeeService;

/**
 * @author Shameer Ahamed
 *
 */
@Controller
public class EmployeeController {
	
	private static final Logger logger = Logger.getLogger("EmployeeController");
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean employeeBean, 
			BindingResult result) {
		logger.info("saveEmployee");
		employeeService.addEmployee(employeeBean);
		return new ModelAndView("redirect:/addEmployee.sg");
	}

	@RequestMapping(value="/listEmployee", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  employeeService.listEmployees());
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  employeeService.listEmployees());
		return new ModelAndView("addEmployee", model);
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			@RequestParam("id") Long empId) {
		employeeService.deleteEmployee(empId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees",  employeeService.listEmployees());
		return new ModelAndView("addEmployee", model);
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  EmployeeBean employeeBean,
			@RequestParam("id") Long empId) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", employeeService.getEmployee(empId));
		model.put("employees",  employeeService.listEmployees());
		return new ModelAndView("addEmployee", model);
	}
}
