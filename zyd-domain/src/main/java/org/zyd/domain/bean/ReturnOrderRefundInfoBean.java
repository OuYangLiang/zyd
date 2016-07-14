package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.RefundChannel;
import org.zyd.common.constants.RefundMethod;
import org.zyd.common.constants.RefundStatus;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface ReturnOrderRefundInfoBean extends BaseOperation, RemoveOperation {

    BigDecimal getReturnOrderId();

    Timestamp getSubmitTime();

    RefundMethod getRefundMethod();

    RefundChannel getRefundChannel();

    String getRefundAccount();

    String getRefundNum();

    BigDecimal getRefundAmt();

    Timestamp getRefundTime();

    RefundStatus getRefundStatus();

    BigDecimal getPartyId();

    void setReturnOrderId(BigDecimal returnOrderId);

    void setSubmitTime(Timestamp submitTime);

    void setRefundMethod(RefundMethod refundMethod);

    void setRefundChannel(RefundChannel refundChannel);

    void setRefundAccount(String refundAccount);

    void setRefundNum(String refundNum);

    void setRefundAmt(BigDecimal refundAmt);

    void setRefundTime(Timestamp refundTime);

    void setRefundStatus(RefundStatus refundStatus);

    void setPartyId(BigDecimal partyId);

}
