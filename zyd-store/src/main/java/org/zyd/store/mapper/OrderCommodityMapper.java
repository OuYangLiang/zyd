package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.OrderCommodityEntity;
import org.zyd.store.term.OrderCommodityTerm;

/**
 * 
 * OrderCommodityMapper
 * 
 * @author GeJianKui
 * 
 */
public interface OrderCommodityMapper extends DBActionMapper<OrderCommodityEntity, OrderCommodityTerm>,
        PaginatingMapper<OrderCommodityEntity, OrderCommodityTerm> {

}
