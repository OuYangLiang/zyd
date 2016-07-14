package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.OrderGiftEntity;
import org.zyd.store.term.OrderGiftTerm;

/**
 * 
 * OrderGiftMapper
 * 
 * @author GeJianKui
 * 
 */
public interface OrderGiftMapper extends DBActionMapper<OrderGiftEntity, OrderGiftTerm>,
        PaginatingMapper<OrderGiftEntity, OrderGiftTerm> {

}
