package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PartyLevelDetailEntity;
import org.zyd.store.term.PartyLevelDetailTerm;

/**
 * 
 * PartyLevelDetailMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PartyLevelDetailMapper extends DBActionMapper<PartyLevelDetailEntity, PartyLevelDetailTerm>,
        PaginatingMapper<PartyLevelDetailEntity, PartyLevelDetailTerm> {

}
