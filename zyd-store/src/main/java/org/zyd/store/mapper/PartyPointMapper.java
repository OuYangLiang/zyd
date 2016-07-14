package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PartyPointEntity;
import org.zyd.store.term.PartyPointTerm;

/**
 * 
 * PartyPointMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PartyPointMapper extends DBActionMapper<PartyPointEntity, PartyPointTerm>,
        PaginatingMapper<PartyPointEntity, PartyPointTerm> {

}
