package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.TeaEntity;
import org.zyd.store.term.TeaTerm;

/**
 * 
 * TeaMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PendingTeaMapper extends DBActionMapper<TeaEntity, TeaTerm>, PaginatingMapper<TeaEntity, TeaTerm> {

}
