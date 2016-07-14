package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.RightsUsageEntity;
import org.zyd.store.term.RightsUsageTerm;

/**
 * 
 * RightsUsageMapper
 * 
 * @author GeJianKui
 * 
 */
public interface RightsUsageMapper extends DBActionMapper<RightsUsageEntity, RightsUsageTerm>,
        PaginatingMapper<RightsUsageEntity, RightsUsageTerm> {

}
