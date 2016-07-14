package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.LevelRightsRelEntity;
import org.zyd.store.term.LevelRightsRelTerm;

/**
 * 
 * LevelRightsRelMapper
 * 
 * @author GeJianKui
 * 
 */
public interface LevelRightsRelMapper extends DBActionMapper<LevelRightsRelEntity, LevelRightsRelTerm>,
        PaginatingMapper<LevelRightsRelEntity, LevelRightsRelTerm> {

}
