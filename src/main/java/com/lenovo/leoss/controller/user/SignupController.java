package com.lenovo.leoss.controller.user;

import com.lenovo.leoss.model.User;
import com.lenovo.leoss.service.MailService;
import com.lenovo.leoss.service.UserService;
import com.lenovo.leoss.utils.ConfigProps;
import com.octo.captcha.service.image.ImageCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by zhangyl27 on 2014/10/11.
 */
@Controller
@RequestMapping("/user/signup")
public class SignupController {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageCaptchaService captchaService;

    @Autowired
    private MailService mailService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showSignupPage(){
        ModelAndView mv = new ModelAndView("/user/signup");
        mv.addObject("user", new User());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView signUp(HttpServletRequest request,
                               @Valid @ModelAttribute User user,
                               BindingResult userValiResult,
                               @RequestParam("captchaText") String captchaText) throws UnsupportedEncodingException {
        ModelAndView mv = new ModelAndView();
        String sessionId = request.getRequestedSessionId();
        boolean isCaptchaCorrect = captchaService.validateResponseForID(sessionId, captchaText);
        boolean invalid = false;
        if(!isCaptchaCorrect) {
            invalid = true;
            mv.addObject("captchaInvalid", true);
        }
        if(userValiResult.hasErrors()) {
            invalid = true;
        }
        if(invalid){
            mv.setViewName("/user/signup");
            return mv;
        }

        String userEmail = user.getEmail();
        //send activation mail
        /*
        String from = "tester@lenovo.com";
        String to = user.getEmail();
        String subject = "Test Mail";
        String templateFilePath = "templates/sign-up-activation-mail.vm";
        String activationLink = "";
        Map tplParamModel = new HashMap();
        tplParamModel.put("user", user);
        tplParamModel.put("activationLink", activationLink);
        mailService.sendMail(from, to, subject, templateFilePath, tplParamModel);
        */
        Date now = new Date();
        user.setCtime(now);

        String codeSrc = userEmail + now.getTime();
        String acode = DigestUtils.md5DigestAsHex(codeSrc.getBytes("utf-8"));
        user.setAcode(acode);
        user.setAtime(now);
        user.setStatus(ConfigProps.STATUS_INACTIVATION);
        userService.save(user);

        mv.addObject("message", "sign up successfully");
        mv.setViewName("redirect:/users");
        return mv;
    }

}
