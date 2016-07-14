package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PartyPasswordEntity;
import org.zyd.store.term.PartyPasswordTerm;

/**
 * 
 * PartyPasswordMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PartyPasswordMapper extends DBActionMapper<PartyPasswordEntity, PartyPasswordTerm>,
        PaginatingMapper<PartyPasswordEntity, PartyPasswordTerm> {

}
