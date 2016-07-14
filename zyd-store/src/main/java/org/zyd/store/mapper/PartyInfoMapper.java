package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PartyInfoEntity;
import org.zyd.store.term.PartyInfoTerm;

/**
 * 
 * PartyInfoMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PartyInfoMapper extends DBActionMapper<PartyInfoEntity, PartyInfoTerm>,
        PaginatingMapper<PartyInfoEntity, PartyInfoTerm> {

}
