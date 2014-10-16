package com.lenovo.leoss.dao.impl;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lenovo.leoss.dao.inter.KeyDAO;
import com.lenovo.leoss.model.Key;

/**
 * @author zhaoxin
 */
public class DBKeyDAO extends HibernateDaoSupport implements KeyDAO {
	
    @Override
    @SuppressWarnings("unchecked")
    public List<Key> listByUserId(Long userId) {
        Key key = new Key();
        key.setUserId(userId);
        return (List<Key>)(getHibernateTemplate().findByExample(key)); 
    }

    @Override
    public Key getById(Long keyId) {
    	return (Key)getHibernateTemplate().load(Key.class, keyId);
    }
    
    @Override
    public Long save(Key key) {
        getHibernateTemplate().save(key);
        return key.getId();
    }
    
    @Override
    public Long delete(Key key) {
    	Transaction tx = getSession().beginTransaction();
        tx.begin();
        getHibernateTemplate().delete(key);
        tx.commit();
        return key.getId();
    }
    
    @Override
    public Long update(Key key) {
    	Transaction tx = getSession().beginTransaction();
        tx.begin();
        getHibernateTemplate().update(key);
        tx.commit();
        return key.getId();
    }

}
