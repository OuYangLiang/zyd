package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.CommodityEvaluationEntity;
import org.zyd.store.term.CommodityEvaluationTerm;

/**
 * 
 * CommodityEvaluationMapper
 * 
 * @author GeJianKui
 * 
 */
public interface CommodityEvaluationMapper extends DBActionMapper<CommodityEvaluationEntity, CommodityEvaluationTerm>,
        PaginatingMapper<CommodityEvaluationEntity, CommodityEvaluationTerm> {

}
