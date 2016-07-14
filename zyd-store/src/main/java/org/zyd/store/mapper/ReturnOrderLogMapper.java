package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ReturnOrderLogEntity;
import org.zyd.store.term.ReturnOrderLogTerm;

/**
 * 
 * ReturnOrderLogMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ReturnOrderLogMapper extends DBActionMapper<ReturnOrderLogEntity, ReturnOrderLogTerm>,
        PaginatingMapper<ReturnOrderLogEntity, ReturnOrderLogTerm> {

}
