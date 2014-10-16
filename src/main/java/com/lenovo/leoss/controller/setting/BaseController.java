package com.lenovo.leoss.controller.setting;

import com.lenovo.leoss.exception.ResourceNotFoundException;
import com.lenovo.leoss.model.User;
import com.lenovo.leoss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by zhangyl27 on 2014/10/15.
 */
@Controller
@RequestMapping("/setting/base")
public class BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showBaseInfo(@RequestParam("uid") Long uid){
        if(null==uid || uid<0) {
            throw new ResourceNotFoundException();
        }
        User user = userService.get(uid);
        if(null==user) {
            throw new ResourceNotFoundException();
        }
        ModelAndView mv = new ModelAndView("/setting/base");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editBaseInfo(@Valid @ModelAttribute User user,
                                     BindingResult userValiResult){
        ModelAndView mv = new ModelAndView();
        if(userValiResult.hasErrors()){
            mv.setViewName("/setting/base");
            return mv;
        }
        userService.updateBaseInfo(user);
        mv.setViewName("redirect:/users");
        return mv;
    }

}
