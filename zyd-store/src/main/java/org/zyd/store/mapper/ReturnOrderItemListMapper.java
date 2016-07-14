package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ReturnOrderItemListEntity;
import org.zyd.store.term.ReturnOrderItemListTerm;

/**
 * 
 * ReturnOrderItemListMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ReturnOrderItemListMapper extends DBActionMapper<ReturnOrderItemListEntity, ReturnOrderItemListTerm>,
        PaginatingMapper<ReturnOrderItemListEntity, ReturnOrderItemListTerm> {

}
