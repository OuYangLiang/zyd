package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ThirdPartyAccountEntity;
import org.zyd.store.term.ThirdPartyAccountTerm;

/**
 * 
 * ThirdPartyAccountMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ThirdPartyAccountMapper extends DBActionMapper<ThirdPartyAccountEntity, ThirdPartyAccountTerm>,
        PaginatingMapper<ThirdPartyAccountEntity, ThirdPartyAccountTerm> {

}
