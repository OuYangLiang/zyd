package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ReturnOrderEventEntity;
import org.zyd.store.term.ReturnOrderEventTerm;

/**
 * 
 * ReturnOrderEventMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ReturnOrderEventMapper extends DBActionMapper<ReturnOrderEventEntity, ReturnOrderEventTerm>,
        PaginatingMapper<ReturnOrderEventEntity, ReturnOrderEventTerm> {

}
