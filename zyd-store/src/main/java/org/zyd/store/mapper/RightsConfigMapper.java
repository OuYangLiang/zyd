package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.RightsConfigEntity;
import org.zyd.store.term.RightsConfigTerm;

/**
 * 
 * RightsConfigMapper
 * 
 * @author GeJianKui
 * 
 */
public interface RightsConfigMapper extends DBActionMapper<RightsConfigEntity, RightsConfigTerm>,
        PaginatingMapper<RightsConfigEntity, RightsConfigTerm> {

}
