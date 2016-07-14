package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * InvoiceEntity
 * 
 * @author GeJianKui
 */
public class InvoiceEntity extends BaseEntity {

    private BigDecimal invoiceId;
    private String invoiceType;
    private String invoiceTitle;
    private BigDecimal orderId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getInvoiceId() {
        return this.invoiceId;
    }

    public String getInvoiceType() {
        return this.invoiceType;
    }

    public String getInvoiceTitle() {
        return this.invoiceTitle;
    }

    public BigDecimal getOrderId() {
        return this.orderId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setInvoiceId(BigDecimal invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType == null ? null : invoiceType.trim();
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}