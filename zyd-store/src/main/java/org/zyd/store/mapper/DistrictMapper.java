package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.DistrictEntity;
import org.zyd.store.term.DistrictTerm;

/**
 * 
 * DistrictMapper
 * 
 * @author GeJianKui
 * 
 */
public interface DistrictMapper extends DBActionMapper<DistrictEntity, DistrictTerm>,
        PaginatingMapper<DistrictEntity, DistrictTerm> {

}
