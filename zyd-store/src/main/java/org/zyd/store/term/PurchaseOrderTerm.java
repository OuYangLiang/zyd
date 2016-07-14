package org.zyd.store.term;

import java.math.BigDecimal;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * @author GeJianKui
 */
public class PurchaseOrderTerm extends BaseTerm {
    private BigDecimal orderId;
    private String orderNum;
    private String orderStatus;
    private BigDecimal partyId;

    public BigDecimal getOrderId() {
        return orderId;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getPartyId() {
        return partyId;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }
}
