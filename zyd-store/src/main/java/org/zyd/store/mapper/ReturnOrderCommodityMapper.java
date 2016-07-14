package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ReturnOrderCommodityEntity;
import org.zyd.store.term.ReturnOrderCommodityTerm;

/**
 * 
 * ReturnOrderCommodityMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ReturnOrderCommodityMapper extends
        DBActionMapper<ReturnOrderCommodityEntity, ReturnOrderCommodityTerm>,
        PaginatingMapper<ReturnOrderCommodityEntity, ReturnOrderCommodityTerm> {

}
