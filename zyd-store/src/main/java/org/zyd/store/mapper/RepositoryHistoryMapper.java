package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.RepositoryHistoryEntity;
import org.zyd.store.term.RepositoryHistoryTerm;

/**
 * 
 * RepositoryHistoryMapper
 * 
 * @author GeJianKui
 * 
 */
public interface RepositoryHistoryMapper extends DBActionMapper<RepositoryHistoryEntity, RepositoryHistoryTerm>,
        PaginatingMapper<RepositoryHistoryEntity, RepositoryHistoryTerm> {

}
