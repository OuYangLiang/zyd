package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.CommodityLabelRelEntity;
import org.zyd.store.term.CommodityLabelRelTerm;

/**
 * 
 * CommodityLabelRelMapper
 * 
 * @author GeJianKui
 * 
 */
public interface CommodityLabelRelMapper extends DBActionMapper<CommodityLabelRelEntity, CommodityLabelRelTerm>,
        PaginatingMapper<CommodityLabelRelEntity, CommodityLabelRelTerm> {

    int deleteByCmmdtyIdAndLabelId(CommodityLabelRelEntity entity);
    
    int deleteByLabelId(CommodityLabelRelEntity entity);

}
