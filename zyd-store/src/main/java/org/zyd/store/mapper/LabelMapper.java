package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.LabelEntity;
import org.zyd.store.term.LabelTerm;

/**
 * 
 * LabelMapper
 * 
 * @author GeJianKui
 * 
 */
public interface LabelMapper extends DBActionMapper<LabelEntity, LabelTerm>, PaginatingMapper<LabelEntity, LabelTerm> {

}
