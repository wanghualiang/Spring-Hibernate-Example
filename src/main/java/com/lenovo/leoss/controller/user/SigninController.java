package com.lenovo.leoss.controller.user;

import com.lenovo.leoss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhaoxin
 */
@Controller
@RequestMapping("/user/signin")
public class SigninController {
	
	@Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showSignInPage(
    		@RequestParam(value = "error", required = false) String error,
    		@RequestParam(value = "signout", required = false) String signout,
    		ModelMap model) {

    	if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
 
		if (signout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}

        return "user/signin";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String doSignIn(ModelMap model) {
        return "user/signin";
    }

}
