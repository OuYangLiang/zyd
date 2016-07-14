package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.common.constants.EvaluationStatus;
import org.zyd.common.constants.OrderCommodityStatus;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface OrderGiftBean extends BaseOperation, RemoveOperation {

    void saveRecursively() throws ZydException;
    
    List<OrderGiftItemListBean> getOrderGiftItemListBeans();

    BigDecimal getOrderGiftId();

    BigDecimal getOrderId();

    BigDecimal getCmmdtyId();

    String getCmmdtyName();

    BigDecimal getProposedPrice();

    Integer getQty();

    String getDefaultImageAddrs();

    BigDecimal getOrderCmmdtyId();

    OrderCommodityStatus getCommodityStatus();

    EvaluationStatus getEvaluationStatus();

    Integer getTimesExchanged();;

    void setOrderGiftId(BigDecimal orderGiftId);

    void setOrderId(BigDecimal orderId);

    void setCmmdtyId(BigDecimal cmmdtyId);

    void setCmmdtyName(String cmmdtyName);

    void setProposedPrice(BigDecimal proposedPrice);

    void setQty(Integer qty);

    void setDefaultImageAddrs(String defaultImageAddrs);

    void setOrderCmmdtyId(BigDecimal orderCmmdtyId);

    void setCommodityStatus(OrderCommodityStatus commodityStatus);

    void setEvaluationStatus(EvaluationStatus evaluationStatus);

    void setTimesExchanged(Integer timesExchanged);

    void setOrderGiftItemListBeans(List<OrderGiftItemListBean> orderGiftItemListBeans);

}
