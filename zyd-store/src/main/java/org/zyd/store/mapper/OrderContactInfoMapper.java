package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.OrderContactInfoEntity;
import org.zyd.store.term.OrderContactInfoTerm;

/**
 * 
 * OrderContactInfoMapper
 * 
 * @author GeJianKui
 * 
 */
public interface OrderContactInfoMapper extends DBActionMapper<OrderContactInfoEntity, OrderContactInfoTerm>,
        PaginatingMapper<OrderContactInfoEntity, OrderContactInfoTerm> {

}
