package org.zyd.store.mapper;

import java.util.List;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.CommodityImageEntity;
import org.zyd.store.term.CommodityImageTerm;

/**
 * 
 * CommodityImageMapper
 * 
 * @author GeJianKui
 * 
 */
public interface CommodityImageMapper extends DBActionMapper<CommodityImageEntity, CommodityImageTerm>,
        PaginatingMapper<CommodityImageEntity, CommodityImageTerm> {

    List<CommodityImageEntity> selectWithSort(CommodityImageTerm param);

    int cleanImageByType(CommodityImageEntity param);

}
