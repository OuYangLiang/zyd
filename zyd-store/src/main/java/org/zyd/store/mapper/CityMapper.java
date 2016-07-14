package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.CityEntity;
import org.zyd.store.term.CityTerm;

/**
 * 
 * CityMapper
 * 
 * @author GeJianKui
 * 
 */
public interface CityMapper extends DBActionMapper<CityEntity, CityTerm>, PaginatingMapper<CityEntity, CityTerm> {

}
