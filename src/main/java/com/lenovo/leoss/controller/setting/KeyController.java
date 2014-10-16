package com.lenovo.leoss.controller.setting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lenovo.leoss.model.ApiResult;
import com.lenovo.leoss.model.Key;
import com.lenovo.leoss.service.KeyService;

/**
 * @author zhaoxin
 */
@Controller
@RequestMapping("/api/key")
public class KeyController {
	
	@Autowired
	private KeyService keyService;  

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Key> listKeysByUser(){
    	//userId should read from session.
    	long userId = 11;
        return keyService.listByUserId(userId);
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody ApiResult createKey(){	
    	//userId should read from session.
        long userId = 11;

        try {
            Key key = keyService.createKey(userId);
            keyService.save(key);
            return new ApiResult("ok", "");
        } catch (Exception e){
            return new ApiResult("error", e.getMessage());     	
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody ApiResult deleteKey(@RequestParam("key_id") Long keyId){
        try {
            Key key = keyService.getById(keyId);
    	    keyService.delete(key);
    	    return new ApiResult("ok", "");
        } catch (Exception e) {
        	return new ApiResult("error", e.getMessage());
        }
    }
    
    @RequestMapping(value = "/status/set", method = RequestMethod.POST)
    public @ResponseBody ApiResult setKeyStatus(@RequestParam("key_id") Long keyId, @RequestParam("status") Integer status){
    	try {
    		keyService.setStatus(keyId, status);
    		return new ApiResult("ok", "");
    	} catch (Exception e) {
            return new ApiResult("error", e.getMessage());	
    	}
    }
    
    
}
