package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.OrderGiftItemListEntity;
import org.zyd.store.term.OrderGiftItemListTerm;

/**
 * 
 * OrderGiftItemListMapper
 * 
 * @author GeJianKui
 * 
 */
public interface OrderGiftItemListMapper extends DBActionMapper<OrderGiftItemListEntity, OrderGiftItemListTerm>,
        PaginatingMapper<OrderGiftItemListEntity, OrderGiftItemListTerm> {

}
