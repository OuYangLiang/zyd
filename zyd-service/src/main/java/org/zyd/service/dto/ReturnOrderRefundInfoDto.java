package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.RefundChannel;
import org.zyd.common.constants.RefundMethod;
import org.zyd.common.constants.RefundStatus;

public class ReturnOrderRefundInfoDto implements java.io.Serializable{
	private static final long serialVersionUID = -3196744496507768434L;
	
	private BigDecimal returnOrderId;
    private Timestamp submitTime;
    private RefundMethod refundMethod;
    private RefundChannel refundChannel;
    private String refundAccount;
    private String refundNum;
    private BigDecimal refundAmt;
    private Timestamp refundTime;
    private RefundStatus refundStatus;
    private BigDecimal partyId;

    public BigDecimal getReturnOrderId() {
        return this.returnOrderId;
    }

    public Timestamp getSubmitTime() {
        return this.submitTime;
    }

    public RefundMethod getRefundMethod() {
        return this.refundMethod;
    }

    public RefundChannel getRefundChannel() {
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

    public RefundStatus getRefundStatus() {
        return this.refundStatus;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public void setReturnOrderId(BigDecimal returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime == null ? null : (Timestamp) submitTime.clone();
    }

    public void setRefundMethod(RefundMethod refundMethod) {
        this.refundMethod = refundMethod;
    }

    public void setRefundChannel(RefundChannel refundChannel) {
        this.refundChannel = refundChannel;
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

    public void setRefundStatus(RefundStatus refundStatus) {
        this.refundStatus = refundStatus;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

}