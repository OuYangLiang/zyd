package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.zyd.common.constants.ReturnOrderStatus;
import org.zyd.common.constants.ReturnOrderType;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;
import org.zyd.domain.bean.operation.ReturnOrderOperation;

public interface ReturnOrderBean extends ReturnOrderOperation, BaseOperation, RemoveOperation {

    void saveRecursively() throws ZydException;

    List<ReturnOrderCommodityBean> getReturnOrderCommodityBeans();

    void setReturnOrderCommodityBeans(List<ReturnOrderCommodityBean> returnOrderCommodityBeans);

    ReturnOrderRefundInfoBean getReturnOrderRefundInfoBean();

    void setReturnOrderRefundInfoBean(ReturnOrderRefundInfoBean returnOrderRefundInfoBean);

    ReturnOrderContactInfoBean getReturnOrderContactInfoBean();

    void setReturnOrderContactInfoBean(ReturnOrderContactInfoBean returnOrderContactInfoBean);

    List<ReturnOrderEventBean> getReturnOrderEventBeans();

    void setReturnOrderEventBeans(List<ReturnOrderEventBean> returnOrderEventBeans);

    List<ReturnOrderLogisticsBean> getReturnOrderLogisticsBeans();

    void setReturnOrderLogisticsBeans(List<ReturnOrderLogisticsBean> returnOrderLogisticsBeans);

    BigDecimal getReturnOrderId();

    String getReturnOrderNum();

    ReturnOrderType getReturnOrderType();

    Timestamp getSubmitTime();

    ReturnOrderStatus getReturnOrderStatus();

    String getReturnReason();

    String getReturnReasonDesc();

    BigDecimal getShouldRefundAmt();

    BigDecimal getActualRefundAmt();

    String getRemarks();

    BigDecimal getOrderId();

    BigDecimal getPartyId();

    void setReturnOrderId(BigDecimal returnOrderId);

    void setReturnOrderNum(String returnOrderNum);

    void setReturnOrderType(ReturnOrderType returnOrderType);

    void setSubmitTime(Timestamp submitTime);

    void setReturnOrderStatus(ReturnOrderStatus returnOrderStatus);

    void setReturnReason(String returnReason);

    void setReturnReasonDesc(String returnReasonDesc);

    void setShouldRefundAmt(BigDecimal shouldRefundAmt);

    void setActualRefundAmt(BigDecimal actualRefundAmt);

    void setRemarks(String remarks);

    void setOrderId(BigDecimal orderId);

    void setPartyId(BigDecimal partyId);

}
