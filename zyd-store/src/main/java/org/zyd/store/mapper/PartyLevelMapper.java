package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PartyLevelEntity;
import org.zyd.store.term.PartyLevelTerm;

/**
 * 
 * PartyLevelMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PartyLevelMapper extends DBActionMapper<PartyLevelEntity, PartyLevelTerm>,
        PaginatingMapper<PartyLevelEntity, PartyLevelTerm> {

}
