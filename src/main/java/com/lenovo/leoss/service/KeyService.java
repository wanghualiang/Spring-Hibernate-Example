package com.lenovo.leoss.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenovo.leoss.dao.inter.KeyDAO;
import com.lenovo.leoss.model.Key;
/**
 * @author zhaoxin
 */
@Service
public class KeyService {
	
	@Autowired
	private KeyDAO keyDAO;
	
	public List<Key> listByUserId(long userId) {
	    return keyDAO.listByUserId(userId);	
	}
	
	/**
	 * Key should created by storage service.
	 * @param userId
	 * @return
	 */
	public Key createKey(long userId){
	    Key key = new Key();	
	    key.setUserId(userId);
	    key.setAccessKey("access-key-created"+new Date().toString());
  	    key.setSecretKey("secret-key-created1");
  	    key.setStatus(1);
  	    key.setCtime(new Date());
	    return key;
	}
	
	public Key setStatus(Long keyId, Integer status) {
	    Key key = keyDAO.getById(keyId);  	
	    key.setStatus(status);
	    keyDAO.update(key);
	    return key;
	}
	
	public Key getById(Long keyId) {
		return keyDAO.getById(keyId);
	}

    public Long save(Key key) {
        return keyDAO.save(key);	
    }

    public Long delete(Key key) {
        return keyDAO.delete(key);	
    }

    public Long update(Key key) {
        return keyDAO.update(key);	
    }
}
