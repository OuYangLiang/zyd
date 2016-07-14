package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.CommodityEntity;
import org.zyd.store.term.CommodityTerm;

/**
 * 
 * CommodityMapper
 * 
 * @author GeJianKui
 * 
 */
public interface CommodityMapper extends DBActionMapper<CommodityEntity, CommodityTerm>,
        PaginatingMapper<CommodityEntity, CommodityTerm> {

}
