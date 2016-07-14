package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PointEventEntity;
import org.zyd.store.term.PointEventTerm;

/**
 * 
 * PointEventMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PointEventMapper extends DBActionMapper<PointEventEntity, PointEventTerm>,
        PaginatingMapper<PointEventEntity, PointEventTerm> {

}
