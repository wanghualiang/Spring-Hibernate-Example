package com.lenovo.leoss.service;

import com.lenovo.leoss.dao.inter.UserDAO;
import com.lenovo.leoss.model.User;
import com.lenovo.leoss.utils.ConfigProps;
import com.lenovo.leoss.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangyl27 on 2014/10/9.
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User get(Long uid) {
        return userDAO.get(uid);
    }

    public List<User> getAll(){
        return userDAO.getAll();
    }

    public void save(User user){
        userDAO.save(user);
    }

    public void update(User user){
        userDAO.update(user);
    }

    public void updateBaseInfo(User user){
        userDAO.updateBaseInfo(user);
    }

    public int activate(User user, String acode){
        if(ConfigProps.STATUS_NORMAL == user.getStatus()){
            return ErrorCode.NO_ERROR;
        }
        if(null==acode || acode.length()!=32){
            return ErrorCode.ACTIVATION_LINK_INVALID;
        }
        if(!acode.equals(user.getAcode())){
            return ErrorCode.ACTIVATION_LINK_INVALID;
        }
        long codeGeneratedAt = user.getAtime().getTime();
        Date now = new Date();
        long thisMoment = now.getTime();
        long passTime = thisMoment - codeGeneratedAt;
        if(passTime > ConfigProps.ACTIVATION_LINK_EXPIRED_TIME){
            return ErrorCode.ACTIVATION_LINK_EXPIRED;
        }
        user.setStatus(ConfigProps.STATUS_NORMAL);
        user.setAtime(now);
        userDAO.update(user);
        return ErrorCode.NO_ERROR;
    }

}
