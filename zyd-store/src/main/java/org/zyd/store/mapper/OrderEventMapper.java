package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.OrderEventEntity;
import org.zyd.store.term.OrderEventTerm;

/**
 * 
 * OrderEventMapper
 * 
 * @author GeJianKui
 * 
 */
public interface OrderEventMapper extends DBActionMapper<OrderEventEntity, OrderEventTerm>,
        PaginatingMapper<OrderEventEntity, OrderEventTerm> {

}
