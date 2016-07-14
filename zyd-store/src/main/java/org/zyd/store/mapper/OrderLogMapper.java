package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.OrderLogEntity;
import org.zyd.store.term.OrderLogTerm;

/**
 * 
 * OrderLogMapper
 * 
 * @author GeJianKui
 * 
 */
public interface OrderLogMapper extends DBActionMapper<OrderLogEntity, OrderLogTerm>,
        PaginatingMapper<OrderLogEntity, OrderLogTerm> {

}
