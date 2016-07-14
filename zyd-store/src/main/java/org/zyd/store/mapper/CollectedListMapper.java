package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.CollectedListEntity;
import org.zyd.store.term.CollectedListTerm;

/**
 * 
 * CollectedListMapper
 * 
 * @author GeJianKui
 * 
 */
public interface CollectedListMapper extends DBActionMapper<CollectedListEntity, CollectedListTerm>,
        PaginatingMapper<CollectedListEntity, CollectedListTerm> {

    int deleteByPartyIdAndCmmdtyId(CollectedListEntity entity);
    
}
