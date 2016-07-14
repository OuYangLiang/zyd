package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface ReturnOrderItemListBean extends BaseOperation, RemoveOperation {

    BigDecimal getItemId();

    String getItemDesc();

    Integer getItemQty();

    BigDecimal getReturnOrderCmmdtyId();

    void setItemId(BigDecimal itemId);

    void setItemDesc(String itemDesc);

    void setItemQty(Integer itemQty);

    void setReturnOrderCmmdtyId(BigDecimal returnOrderCmmdtyId);

}
