package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ProvinceEntity;
import org.zyd.store.term.ProvinceTerm;

/**
 * 
 * ProvinceMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ProvinceMapper extends DBActionMapper<ProvinceEntity, ProvinceTerm>,
        PaginatingMapper<ProvinceEntity, ProvinceTerm> {

}
