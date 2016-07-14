package org.zyd.store.mapper;

import java.util.List;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.TeapotEntity;
import org.zyd.store.term.TeapotTerm;

/**
 * 
 * TeapotMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PendingTeapotMapper extends DBActionMapper<TeapotEntity, TeapotTerm>,
        PaginatingMapper<TeapotEntity, TeapotTerm> {
    void insertBatch(List<TeapotEntity> list);
}
