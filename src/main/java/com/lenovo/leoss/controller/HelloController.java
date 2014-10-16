package com.lenovo.leoss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Hello controller
 */
@Controller
public class HelloController {
	
	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	public String welcomePage(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("message", "This is admin page!");
		return "admin";
	}
	
	@RequestMapping(value = "/setting/key", method = RequestMethod.GET)
	public String adminPage() {
		return "setting/key";
	}
}