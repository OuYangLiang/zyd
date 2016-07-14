package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PartyIdentifyEntity;
import org.zyd.store.term.PartyIdentifyTerm;

/**
 * 
 * PartyIdentifyMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PartyIdentifyMapper extends DBActionMapper<PartyIdentifyEntity, PartyIdentifyTerm>,
        PaginatingMapper<PartyIdentifyEntity, PartyIdentifyTerm> {

}
