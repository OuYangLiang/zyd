package org.zyd.service.dto;

import java.math.BigDecimal;

public class InvoiceDto implements java.io.Serializable{
	private static final long serialVersionUID = 615840993541562199L;
	
	private BigDecimal invoiceId;
    private String invoiceType;
    private String invoiceTitle;
    private BigDecimal orderId;

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

}