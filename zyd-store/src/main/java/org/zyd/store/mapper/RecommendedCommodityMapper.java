package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.RecommendedCommodityEntity;
import org.zyd.store.term.RecommendedCommodityTerm;

/**
 * 
 * RecommendedCommodityMapper
 * 
 * @author GeJianKui
 * 
 */
public interface RecommendedCommodityMapper extends
        DBActionMapper<RecommendedCommodityEntity, RecommendedCommodityTerm>,
        PaginatingMapper<RecommendedCommodityEntity, RecommendedCommodityTerm> {

    int deleteByRecommendedCmmdtyId(RecommendedCommodityEntity entity);

}
