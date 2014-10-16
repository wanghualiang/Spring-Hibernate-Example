package com.lenovo.leoss.dao.inter;

import java.util.List;

import com.lenovo.leoss.model.Key;

/**
 * @author zhaoxin
 */
public interface KeyDAO {
	
	public List<Key> listByUserId(Long userId);
    public Key getById(Long keyId);
    public Long save(Key key);
    public Long delete(Key key);
    public Long update(Key key);

}
