package com.lenovo.leoss.controller.user;

import com.lenovo.leoss.exception.ResourceNotFoundException;
import com.lenovo.leoss.model.User;
import com.lenovo.leoss.service.UserService;
import com.lenovo.leoss.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhangyl27 on 2014/10/16.
 */
@Controller
@RequestMapping("/user/{uid}/activate/{acode}")
public class ActivateController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView activate(@PathVariable("uid") Long uid,
                           @PathVariable("acode") String acode){
        if(null==uid || uid<1){
            throw new ResourceNotFoundException();
        }
        User user = userService.get(uid);
        if(null == user){
            throw new ResourceNotFoundException();
        }
        int errorCode = userService.activate(user, acode);
        boolean actSuccess = (errorCode==ErrorCode.NO_ERROR);
        if(!actSuccess){
            return getErrorView(errorCode);
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/");
        return mv;
    }

    private ModelAndView getErrorView(int... errorCodes){
        ModelAndView mv = new ModelAndView();
        mv.addObject("code", errorCodes);
        mv.setViewName("redirect:/error");
        return mv;
    }

}
