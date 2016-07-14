package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.OrderItemListEntity;
import org.zyd.store.term.OrderItemListTerm;

/**
 * 
 * OrderItemListMapper
 * 
 * @author GeJianKui
 * 
 */
public interface OrderItemListMapper extends DBActionMapper<OrderItemListEntity, OrderItemListTerm>,
        PaginatingMapper<OrderItemListEntity, OrderItemListTerm> {

}
