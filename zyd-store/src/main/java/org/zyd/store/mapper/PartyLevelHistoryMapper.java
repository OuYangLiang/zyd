package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PartyLevelHistoryEntity;
import org.zyd.store.term.PartyLevelHistoryTerm;

/**
 * 
 * PartyLevelHistoryMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PartyLevelHistoryMapper extends DBActionMapper<PartyLevelHistoryEntity, PartyLevelHistoryTerm>,
        PaginatingMapper<PartyLevelHistoryEntity, PartyLevelHistoryTerm> {

}
