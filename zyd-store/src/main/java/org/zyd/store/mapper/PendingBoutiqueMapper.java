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
public interface PendingBoutiqueMapper extends DBActionMapper<BoutiqueEntity, BoutiqueTerm>,
        PaginatingMapper<BoutiqueEntity, BoutiqueTerm> {

}
