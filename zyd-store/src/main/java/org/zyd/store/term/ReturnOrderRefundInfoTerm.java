package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * ReturnOrderRefundInfoTerm
 * 
 * @author GeJianKui
 */
public class ReturnOrderRefundInfoTerm extends BaseTerm {

    private BigDecimal returnOrderId;
    private Timestamp submitTime;
    private String refundMethod;
    private String refundChannel;
    private String refundAccount;
    private String refundNum;
    private BigDecimal refundAmt;
    private Timestamp refundTime;
    private String refundStatus;
    private BigDecimal partyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getReturnOrderId() {
        return this.returnOrderId;
    }

    public Timestamp getSubmitTime() {
        return this.submitTime;
    }

    public String getRefundMethod() {
        return this.refundMethod;
    }

    public String getRefundChannel() {
        return this.refundChannel;
    }

    public String getRefundAccount() {
        return this.refundAccount;
    }

    public String getRefundNum() {
        return this.refundNum;
    }

    public BigDecimal getRefundAmt() {
        return this.refundAmt;
    }

    public Timestamp getRefundTime() {
        return this.refundTime;
    }

    public String getRefundStatus() {
        return this.refundStatus;
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

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime == null ? null : (Timestamp) submitTime.clone();
    }

    public void setRefundMethod(String refundMethod) {
        this.refundMethod = refundMethod == null ? null : refundMethod.trim();
    }

    public void setRefundChannel(String refundChannel) {
        this.refundChannel = refundChannel == null ? null : refundChannel.trim();
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount == null ? null : refundAccount.trim();
    }

    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum == null ? null : refundNum.trim();
    }

    public void setRefundAmt(BigDecimal refundAmt) {
        this.refundAmt = refundAmt;
    }

    public void setRefundTime(Timestamp refundTime) {
        this.refundTime = refundTime == null ? null : (Timestamp) refundTime.clone();
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus == null ? null : refundStatus.trim();
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
