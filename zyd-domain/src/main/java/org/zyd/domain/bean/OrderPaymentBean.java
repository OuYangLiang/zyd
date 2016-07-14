package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.PaymentChannel;
import org.zyd.common.constants.PaymentMethod;
import org.zyd.common.constants.PaymentStatus;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface OrderPaymentBean extends BaseOperation, RemoveOperation {

    BigDecimal getOrderId();

    PaymentMethod getPaymentMethod();

    PaymentChannel getPaymentChannel();

    String getPaymentAccount();

    String getPaymentNum();

    BigDecimal getPaymentAmt();

    Timestamp getPaymentTime();

    PaymentStatus getPaymentStatus();

    void setOrderId(BigDecimal orderId);

    void setPaymentMethod(PaymentMethod paymentMethod);

    void setPaymentChannel(PaymentChannel paymentChannel);

    void setPaymentAccount(String paymentAccount);

    void setPaymentNum(String paymentNum);

    void setPaymentAmt(BigDecimal paymentAmt);

    void setPaymentTime(Timestamp paymentTime);

    void setPaymentStatus(PaymentStatus paymentStatus);

}
