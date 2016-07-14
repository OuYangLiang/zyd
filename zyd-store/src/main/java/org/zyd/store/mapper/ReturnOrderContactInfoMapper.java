package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ReturnOrderContactInfoEntity;
import org.zyd.store.term.ReturnOrderContactInfoTerm;

/**
 * 
 * ReturnOrderContactInfoMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ReturnOrderContactInfoMapper extends
        DBActionMapper<ReturnOrderContactInfoEntity, ReturnOrderContactInfoTerm>,
        PaginatingMapper<ReturnOrderContactInfoEntity, ReturnOrderContactInfoTerm> {

}
