package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * ReturnOrderEntity
 * 
 * @author GeJianKui
 */
public class ReturnOrderEntity extends BaseEntity {

    private BigDecimal returnOrderId;
    private String returnOrderNum;
    private String returnOrderType;
    private Timestamp submitTime;
    private String returnOrderStatus;
    private String returnReason;
    private String returnReasonDesc;
    private BigDecimal shouldRefundAmt;
    private BigDecimal actualRefundAmt;
    private String remarks;
    private BigDecimal orderId;
    private BigDecimal partyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getReturnOrderId() {
        return this.returnOrderId;
    }

    public String getReturnOrderNum() {
        return this.returnOrderNum;
    }

    public String getReturnOrderType() {
        return this.returnOrderType;
    }

    public Timestamp getSubmitTime() {
        return this.submitTime;
    }

    public String getReturnOrderStatus() {
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

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setReturnOrderId(BigDecimal returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public void setReturnOrderNum(String returnOrderNum) {
        this.returnOrderNum = returnOrderNum == null ? null : returnOrderNum.trim();
    }

    public void setReturnOrderType(String returnOrderType) {
        this.returnOrderType = returnOrderType == null ? null : returnOrderType.trim();
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime == null ? null : (Timestamp) submitTime.clone();
    }

    public void setReturnOrderStatus(String returnOrderStatus) {
        this.returnOrderStatus = returnOrderStatus == null ? null : returnOrderStatus.trim();
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

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}