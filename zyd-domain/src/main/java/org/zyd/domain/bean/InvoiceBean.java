package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.common.constants.InvoiceType;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface InvoiceBean extends BaseOperation, RemoveOperation {

    BigDecimal getInvoiceId();

    InvoiceType getInvoiceType();

    String getInvoiceTitle();

    BigDecimal getOrderId();

    void setInvoiceId(BigDecimal invoiceId);

    void setInvoiceType(InvoiceType invoiceType);

    void setInvoiceTitle(String invoiceTitle);

    void setOrderId(BigDecimal orderId);

}
