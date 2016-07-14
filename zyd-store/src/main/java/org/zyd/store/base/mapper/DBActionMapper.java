package org.zyd.store.base.mapper;

import java.util.List;

import org.zyd.store.base.entity.BaseEntity;
import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * Mapper层，统一数据库操作方法
 * 
 * @author GeJianKui
 */
public interface DBActionMapper<T extends BaseEntity, Q extends BaseTerm> {

	List<T> select(Q param);
	
    int delete(T param);

    int insert(T param);

    int updateBySelective(T param);
}
