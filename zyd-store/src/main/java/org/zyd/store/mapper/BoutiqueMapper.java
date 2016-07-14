package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.BoutiqueEntity;
import org.zyd.store.term.BoutiqueTerm;

/**
 * 
 * BoutiqueMapper
 * 
 * @author GeJianKui
 * 
 */
public interface BoutiqueMapper extends DBActionMapper<BoutiqueEntity, BoutiqueTerm>,
        PaginatingMapper<BoutiqueEntity, BoutiqueTerm> {

}
