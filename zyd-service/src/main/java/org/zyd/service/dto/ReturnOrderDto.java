package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.ReturnOrderStatus;
import org.zyd.common.constants.ReturnOrderType;

public class ReturnOrderDto implements java.io.Serializable{
	private static final long serialVersionUID = 5640726054977554772L;
	
	private BigDecimal returnOrderId;
    private String returnOrderNum;
    private ReturnOrderType returnOrderType;
    private Timestamp submitTime;
    private ReturnOrderStatus returnOrderStatus;
    private String returnReason;
    private String returnReasonDesc;
    private BigDecimal shouldRefundAmt;
    private BigDecimal actualRefundAmt;
    private String remarks;
    private BigDecimal orderId;
    private BigDecimal partyId;

    public BigDecimal getReturnOrderId() {
        return this.returnOrderId;
    }

    public String getReturnOrderNum() {
        return this.returnOrderNum;
    }

    public ReturnOrderType getReturnOrderType() {
        return this.returnOrderType;
    }

    public Timestamp getSubmitTime() {
        return this.submitTime;
    }

    public ReturnOrderStatus getReturnOrderStatus() {
        return this.returnOrderStatus;
    }

    public String getReturnReason() {
        return this.returnReason;
    }

    public String getReturnReasonDesc() {
        return this.returnReasonDesc;
    }

    public BigDecimal getShouldRefundAmt() {
        return this.shouldRefundAmt;
    }

    public BigDecimal getActualRefundAmt() {
        return this.actualRefundAmt;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public BigDecimal getOrderId() {
        return this.orderId;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public void setReturnOrderId(BigDecimal returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public void setReturnOrderNum(String returnOrderNum) {
        this.returnOrderNum = returnOrderNum == null ? null : returnOrderNum.trim();
    }

    public void setReturnOrderType(ReturnOrderType returnOrderType) {
        this.returnOrderType = returnOrderType;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime == null ? null : (Timestamp) submitTime.clone();
    }

    public void setReturnOrderStatus(ReturnOrderStatus returnOrderStatus) {
        this.returnOrderStatus = returnOrderStatus;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason == null ? null : returnReason.trim();
    }

    public void setReturnReasonDesc(String returnReasonDesc) {
        this.returnReasonDesc = returnReasonDesc == null ? null : returnReasonDesc.trim();
    }

    public void setShouldRefundAmt(BigDecimal shouldRefundAmt) {
        this.shouldRefundAmt = shouldRefundAmt;
    }

    public void setActualRefundAmt(BigDecimal actualRefundAmt) {
        this.actualRefundAmt = actualRefundAmt;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

}