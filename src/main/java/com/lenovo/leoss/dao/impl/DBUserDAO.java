package com.lenovo.leoss.dao.impl;

import com.lenovo.leoss.dao.inter.UserDAO;
import com.lenovo.leoss.model.User;
import com.lenovo.leoss.utils.HSqls;
import org.hibernate.ObjectNotFoundException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhangyl27 on 2014/10/9.
 */
public class DBUserDAO extends HibernateDaoSupport implements UserDAO {

    @Override
    public User get(Long uid) {
        User user = (User) getHibernateTemplate().load(User.class, uid);
        try{
            String email = user.getEmail();
        }catch (ObjectNotFoundException e){
            return null;
        }
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return (List<User>)(getHibernateTemplate().loadAll(User.class));
    }

    @Override
    public Long save(User user) {
        getHibernateTemplate().save(user);
        return user.getId();
    }

    @Transactional
    @Override
    public void update(User user) {
        getHibernateTemplate().update(user);
    }

    @Override
    public void updateBaseInfo(User user) {
        Object[] params = new Object[]{
                user.getContactName(),
                user.getPhone(),
                user.getCompanyType(),
                user.getCompanyName(),
                user.getCompanySite(),
                user.getId()};
        getHibernateTemplate().bulkUpdate(HSqls.USER_BASE_INFO_UPDATE, params);
    }
}
