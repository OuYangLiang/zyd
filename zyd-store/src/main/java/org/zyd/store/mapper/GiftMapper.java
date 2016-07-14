package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.GiftEntity;
import org.zyd.store.term.GiftTerm;

/**
 * 
 * GiftMapper
 * 
 * @author GeJianKui
 * 
 */
public interface GiftMapper extends DBActionMapper<GiftEntity, GiftTerm>, PaginatingMapper<GiftEntity, GiftTerm> {

}
