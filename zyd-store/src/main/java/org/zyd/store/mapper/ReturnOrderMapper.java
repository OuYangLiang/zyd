package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ReturnOrderEntity;
import org.zyd.store.term.ReturnOrderTerm;

/**
 * 
 * ReturnOrderMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ReturnOrderMapper extends DBActionMapper<ReturnOrderEntity, ReturnOrderTerm>,
        PaginatingMapper<ReturnOrderEntity, ReturnOrderTerm> {

}
