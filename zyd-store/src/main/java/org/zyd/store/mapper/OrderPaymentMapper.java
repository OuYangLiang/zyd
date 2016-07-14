package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.OrderPaymentEntity;
import org.zyd.store.term.OrderPaymentTerm;

/**
 * 
 * OrderPaymentMapper
 * 
 * @author GeJianKui
 * 
 */
public interface OrderPaymentMapper extends DBActionMapper<OrderPaymentEntity, OrderPaymentTerm>,
        PaginatingMapper<OrderPaymentEntity, OrderPaymentTerm> {

}
