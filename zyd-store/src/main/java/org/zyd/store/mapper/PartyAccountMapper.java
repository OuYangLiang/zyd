package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PartyAccountEntity;
import org.zyd.store.term.PartyAccountTerm;

/**
 * 
 * PartyAccountMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PartyAccountMapper extends DBActionMapper<PartyAccountEntity, PartyAccountTerm>,
        PaginatingMapper<PartyAccountEntity, PartyAccountTerm> {

}
