package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.LevelFactorConfigEntity;
import org.zyd.store.term.LevelFactorConfigTerm;

/**
 * 
 * LevelFactorConfigMapper
 * 
 * @author GeJianKui
 * 
 */
public interface LevelFactorConfigMapper extends DBActionMapper<LevelFactorConfigEntity, LevelFactorConfigTerm>,
        PaginatingMapper<LevelFactorConfigEntity, LevelFactorConfigTerm> {

}
