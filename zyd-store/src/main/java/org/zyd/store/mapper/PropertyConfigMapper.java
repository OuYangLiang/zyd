package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PropertyConfigEntity;
import org.zyd.store.term.PropertyConfigTerm;

/**
 * 
 * PropertyConfigMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PropertyConfigMapper extends DBActionMapper<PropertyConfigEntity, PropertyConfigTerm>,
        PaginatingMapper<PropertyConfigEntity, PropertyConfigTerm> {

}
