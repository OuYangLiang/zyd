package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 购物订单 PurchaseOrderEntity
 * 
 * @author GeJianKui
 */
public class PurchaseOrderEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private BigDecimal orderId;
    private String orderNum;
    private Timestamp submitTime;
    private String orderStatus;
    private BigDecimal orderTotalPrice;
    private BigDecimal pointConsumed;
    private BigDecimal logisticsAmt;
    private BigDecimal freeLogisticsCondition;
    private boolean freeLogisticsAmt;
    private BigDecimal orderShouldPayment;
    private BigDecimal discount;
    private BigDecimal orderActualPayment;
    private String remarks;
    private String remarks2;
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

    public Timestamp getSubmitTime() {
        return submitTime == null ? null : (Timestamp) submitTime.clone();
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime == null ? null : (Timestamp) submitTime.clone();
        ;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public BigDecimal getPointConsumed() {
        return pointConsumed;
    }

    public void setPointConsumed(BigDecimal pointConsumed) {
        this.pointConsumed = pointConsumed;
    }

    public BigDecimal getLogisticsAmt() {
        return logisticsAmt;
    }

    public void setLogisticsAmt(BigDecimal logisticsAmt) {
        this.logisticsAmt = logisticsAmt;
    }

    public boolean isFreeLogisticsAmt() {
        return freeLogisticsAmt;
    }

    public void setFreeLogisticsAmt(boolean freeLogisticsAmt) {
        this.freeLogisticsAmt = freeLogisticsAmt;
    }

    public BigDecimal getOrderShouldPayment() {
        return orderShouldPayment;
    }

    public void setOrderShouldPayment(BigDecimal orderShouldPayment) {
        this.orderShouldPayment = orderShouldPayment;
    }

    public BigDecimal getOrderActualPayment() {
        return orderActualPayment;
    }

    public void setOrderActualPayment(BigDecimal orderActualPayment) {
        this.orderActualPayment = orderActualPayment;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks2() {
        return remarks2;
    }

    public void setRemarks2(String remarks2) {
        this.remarks2 = remarks2;
    }

    public BigDecimal getPartyId() {
        return partyId;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

	public BigDecimal getFreeLogisticsCondition() {
		return freeLogisticsCondition;
	}

	public void setFreeLogisticsCondition(BigDecimal freeLogisticsCondition) {
		this.freeLogisticsCondition = freeLogisticsCondition;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

}