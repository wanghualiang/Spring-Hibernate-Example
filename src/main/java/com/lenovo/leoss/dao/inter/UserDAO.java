package com.lenovo.leoss.dao.inter;

import com.lenovo.leoss.model.User;

import java.util.List;

/**
 * Created by zhangyl27 on 2014/10/9.
 */
public interface UserDAO {

    public User get(Long uid);
    public List<User> getAll();
    public Long save(User user);
    public void update(User user);
    public void updateBaseInfo(User user);

}
