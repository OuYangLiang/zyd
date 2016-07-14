package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.PaymentChannel;
import org.zyd.common.constants.PaymentMethod;
import org.zyd.common.constants.PaymentStatus;

public class OrderPaymentDto implements java.io.Serializable{
	private static final long serialVersionUID = -1927335648392625904L;
	
	private BigDecimal orderId;
    private PaymentMethod paymentMethod;
    private PaymentChannel paymentChannel;
    private String paymentAccount;
    private String paymentNum;
    private BigDecimal paymentAmt;
    private Timestamp paymentTime;
    private PaymentStatus paymentStatus;

    public BigDecimal getOrderId() {
        return this.orderId;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public PaymentChannel getPaymentChannel() {
        return this.paymentChannel;
    }

    public String getPaymentAccount() {
        return this.paymentAccount;
    }

    public String getPaymentNum() {
        return this.paymentNum;
    }

    public BigDecimal getPaymentAmt() {
        return this.paymentAmt;
    }

    public Timestamp getPaymentTime() {
        return this.paymentTime;
    }

    public PaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentChannel(PaymentChannel paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount == null ? null : paymentAccount.trim();
    }

    public void setPaymentNum(String paymentNum) {
        this.paymentNum = paymentNum == null ? null : paymentNum.trim();
    }

    public void setPaymentAmt(BigDecimal paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime == null ? null : (Timestamp) paymentTime.clone();
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}