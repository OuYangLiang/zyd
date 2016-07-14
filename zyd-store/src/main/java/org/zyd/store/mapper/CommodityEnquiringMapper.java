package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.CommodityEnquiringEntity;
import org.zyd.store.term.CommodityEnquiringTerm;

/**
 * 
 * CommodityEnquiringMapper
 * 
 * @author GeJianKui
 * 
 */
public interface CommodityEnquiringMapper extends DBActionMapper<CommodityEnquiringEntity, CommodityEnquiringTerm>,
        PaginatingMapper<CommodityEnquiringEntity, CommodityEnquiringTerm> {

}
