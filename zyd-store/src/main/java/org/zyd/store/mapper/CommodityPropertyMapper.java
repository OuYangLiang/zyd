package org.zyd.store.mapper;

import java.util.List;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.CommodityPropertyEntity;
import org.zyd.store.term.CommodityPropertyTerm;

/**
 * 
 * CommodityPropertyMapper
 * 
 * @author GeJianKui
 * 
 */
public interface CommodityPropertyMapper extends DBActionMapper<CommodityPropertyEntity, CommodityPropertyTerm>,
        PaginatingMapper<CommodityPropertyEntity, CommodityPropertyTerm> {

    List<CommodityPropertyEntity> selectWithSort(CommodityPropertyTerm param);

    int cleanCommodityProperties(CommodityPropertyEntity param);

}
