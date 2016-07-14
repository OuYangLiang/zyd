package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.RecommendedListEntity;
import org.zyd.store.term.RecommendedListTerm;

/**
 * 
 * RecommendedListMapper
 * 
 * @author GeJianKui
 * 
 */
public interface RecommendedListMapper extends DBActionMapper<RecommendedListEntity, RecommendedListTerm>,
        PaginatingMapper<RecommendedListEntity, RecommendedListTerm> {

}
