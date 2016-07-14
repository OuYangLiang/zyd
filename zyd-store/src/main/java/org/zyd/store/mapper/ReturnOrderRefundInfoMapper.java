package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ReturnOrderRefundInfoEntity;
import org.zyd.store.term.ReturnOrderRefundInfoTerm;

/**
 * 
 * ReturnOrderRefundInfoMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ReturnOrderRefundInfoMapper extends
        DBActionMapper<ReturnOrderRefundInfoEntity, ReturnOrderRefundInfoTerm>,
        PaginatingMapper<ReturnOrderRefundInfoEntity, ReturnOrderRefundInfoTerm> {

}
