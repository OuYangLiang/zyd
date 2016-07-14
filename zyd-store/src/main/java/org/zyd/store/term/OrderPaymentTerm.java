package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * OrderPaymentTerm
 * 
 * @author GeJianKui
 */
public class OrderPaymentTerm extends BaseTerm {

    private BigDecimal orderId;
    private String paymentMethod;
    private String paymentChannel;
    private String paymentAccount;
    private String paymentNum;
    private BigDecimal paymentAmt;
    private Timestamp paymentTime;
    private String paymentStatus;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getOrderId() {
        return this.orderId;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getPaymentChannel() {
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

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel == null ? null : paymentChannel.trim();
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

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus == null ? null : paymentStatus.trim();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
