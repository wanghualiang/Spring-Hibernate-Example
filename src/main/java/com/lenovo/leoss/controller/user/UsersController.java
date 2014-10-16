package com.lenovo.leoss.controller.user;

import com.lenovo.leoss.model.User;
import com.lenovo.leoss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zhangyl27 on 2014/10/11.
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showUsers(){
        ModelAndView mv = new ModelAndView("users");
        List<User> users = userService.getAll();
        mv.addObject("users", users);
        return mv;
    }

}
