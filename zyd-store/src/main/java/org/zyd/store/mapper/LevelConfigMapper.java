package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.LevelConfigEntity;
import org.zyd.store.term.LevelConfigTerm;

/**
 * 
 * LevelConfigMapper
 * 
 * @author GeJianKui
 * 
 */
public interface LevelConfigMapper extends DBActionMapper<LevelConfigEntity, LevelConfigTerm>,
        PaginatingMapper<LevelConfigEntity, LevelConfigTerm> {

}
