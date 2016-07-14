package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface OrderItemListBean extends BaseOperation, RemoveOperation {

    BigDecimal getItemId();

    String getItemDesc();

    Integer getItemQty();

    BigDecimal getOrderCmmdtyId();

    void setItemId(BigDecimal itemId);

    void setItemDesc(String itemDesc);

    void setItemQty(Integer itemQty);

    void setOrderCmmdtyId(BigDecimal orderCmmdtyId);

}
