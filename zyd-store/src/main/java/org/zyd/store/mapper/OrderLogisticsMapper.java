package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.OrderLogisticsEntity;
import org.zyd.store.term.OrderLogisticsTerm;

/**
 * 
 * OrderLogisticsMapper
 * 
 * @author GeJianKui
 * 
 */
public interface OrderLogisticsMapper extends DBActionMapper<OrderLogisticsEntity, OrderLogisticsTerm>,
        PaginatingMapper<OrderLogisticsEntity, OrderLogisticsTerm> {

}
