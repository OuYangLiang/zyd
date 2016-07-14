package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PurchaseOrderEntity;
import org.zyd.store.term.PurchaseOrderTerm;

/**
 * 购物订单 PurchaseOrderMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PurchaseOrderMapper extends DBActionMapper<PurchaseOrderEntity, PurchaseOrderTerm>,
        PaginatingMapper<PurchaseOrderEntity, PurchaseOrderTerm> {

}
