package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ReturnOrderLogisticsEntity;
import org.zyd.store.term.ReturnOrderLogisticsTerm;

/**
 * 
 * ReturnOrderLogisticsMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ReturnOrderLogisticsMapper extends
        DBActionMapper<ReturnOrderLogisticsEntity, ReturnOrderLogisticsTerm>,
        PaginatingMapper<ReturnOrderLogisticsEntity, ReturnOrderLogisticsTerm> {

}
