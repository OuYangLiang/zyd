package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.ShoppingCartEntity;
import org.zyd.store.term.ShoppingCartTerm;

/**
 * 
 * ShoppingCartMapper
 * 
 * @author GeJianKui
 * 
 */
public interface ShoppingCartMapper extends DBActionMapper<ShoppingCartEntity, ShoppingCartTerm>,
        PaginatingMapper<ShoppingCartEntity, ShoppingCartTerm> {

    int cleanShoppingCart(ShoppingCartEntity param);

    int updateByUserCmmdty(ShoppingCartEntity param);
    
    int deleteByUserCmmdty(ShoppingCartEntity param);

}
