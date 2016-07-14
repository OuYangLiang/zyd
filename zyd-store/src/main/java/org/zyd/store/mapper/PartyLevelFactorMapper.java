package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PartyLevelFactorEntity;
import org.zyd.store.term.PartyLevelFactorTerm;

/**
 * 
 * PartyLevelFactorMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PartyLevelFactorMapper extends DBActionMapper<PartyLevelFactorEntity, PartyLevelFactorTerm>,
        PaginatingMapper<PartyLevelFactorEntity, PartyLevelFactorTerm> {

}
