package com.stockie.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stockie.bean.UserBean;
import com.stockie.service.UserService;

/**
 * @author ShameerAhamed
 *
 */
@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger("HomeController");
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("redirect:/login.sg");
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView Home() {
		return new ModelAndView("home");
	}
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }
 
	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("login");
 
	  return model;
 
	}
 
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
 
	  ModelAndView model = new ModelAndView();
 
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addObject("username", userDetail.getUsername());
	  }
 
	  model.setViewName("403");
	  return model;
 
	}
	
	
	/*@RequestMapping (value="/login", method = RequestMethod.GET)
	public ModelAndView userLogin(@ModelAttribute("command") UserBean userBean) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("view", "login");
		mv.addObject("user", userBean);
		return mv;
	}
	
	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute("command") UserBean userBean, 
			BindingResult result) throws Exception {
		UserBean uBean = userService.validateUser(userBean);
		ModelAndView mv = new ModelAndView();
		
		if (uBean != null && uBean.getUserId() != null && uBean.getUserId() != 0) {
			logger.info("Access Validated");	
			mv = new ModelAndView("redirect:/home.sg");
			//mv.addObject("errMsg", "Access Validated !!");
		}
		else {
			logger.info("Access Denied");	
			mv = new ModelAndView("redirect:/login.sg");
			mv.addObject("errMsg", "Access Denied !!");
		}
		
		return mv;
	}
	
	@RequestMapping (value = "/logout", method = RequestMethod.POST)
	public ModelAndView logoutUser() {
		ModelAndView mv = new ModelAndView("redirect:/login.sg");
		//request.getSession().invalidate();
		return mv;
	}*/
}
