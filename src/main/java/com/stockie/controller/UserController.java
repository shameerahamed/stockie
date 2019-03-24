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

import com.stockie.bean.UserBean;
import com.stockie.service.UserService;

@Controller
public class UserController {
	
	private static final Logger logger = Logger.getLogger("UserController");
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("command") UserBean userBean, 
			BindingResult result) {
		logger.info("saveUser");
		userService.addUser(userBean);
		return new ModelAndView("redirect:/addUser.sg");
	}

	@RequestMapping(value="/listUser", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users",  userService.listUsers());
		return new ModelAndView("usersList", model);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute("command")  UserBean userBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users",  userService.listUsers());
		return new ModelAndView("addUser", model);
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(@ModelAttribute("command")  UserBean userBean,
			@RequestParam("id") Long userId) {		
		userService.deleteUser(userId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", null);
		model.put("users",  userService.listUsers());
		return new ModelAndView("addUser", model);
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(@ModelAttribute("command")  UserBean userBean,
			@RequestParam("id") Long userId) {
		Map<String, Object> model = new HashMap<String, Object>();
		//Long userId = Long.getLong(request.getParameter("id"));
		logger.info("UserId Data ::" + userId);
		model.put("user", userService.getUser(userId));
		model.put("users",  userService.listUsers());
		return new ModelAndView("addUser", model);
	}
	
}
