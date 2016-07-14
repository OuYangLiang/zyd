package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.GiftContainingEntity;
import org.zyd.store.term.GiftContainingTerm;

/**
 * 
 * GiftContainingMapper
 * 
 * @author GeJianKui
 * 
 */
public interface GiftContainingMapper extends DBActionMapper<GiftContainingEntity, GiftContainingTerm>,
        PaginatingMapper<GiftContainingEntity, GiftContainingTerm> {

    int deleteByGiftId(GiftContainingEntity entity);

}
