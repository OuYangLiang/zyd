package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ItemListEntity;
import org.zyd.store.term.ItemListTerm;

/**
 * 
 * ItemListMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ItemListMapper extends DBActionMapper<ItemListEntity, ItemListTerm>,
        PaginatingMapper<ItemListEntity, ItemListTerm> {

}
