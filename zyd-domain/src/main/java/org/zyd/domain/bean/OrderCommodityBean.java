package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.common.constants.EvaluationStatus;
import org.zyd.common.constants.OrderCommodityStatus;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface OrderCommodityBean extends BaseOperation, RemoveOperation {
	
	void saveRecursively() throws ZydException;
	
	List<OrderItemListBean> getOrderItemListBeans();
	
	void setOrderItemListBeans(List<OrderItemListBean> orderItemListBeans);
	
	List<OrderGiftBean> getOrderGiftBeans();
	
	void setOrderGiftBeans(List<OrderGiftBean> orderGiftBeans);

    BigDecimal getOrderCmmdtyId();

    BigDecimal getOrderId();

    BigDecimal getCmmdtyId();

    String getCmmdtyName();

    BigDecimal getProposedPrice();

    BigDecimal getActualPrice();

    Integer getQty();

    String getDefaultImageAddrs();

    OrderCommodityStatus getCommodityStatus();

    EvaluationStatus getEvaluationStatus();

    Integer getTimesExchanged();

    void setOrderCmmdtyId(BigDecimal orderCmmdtyId);

    void setOrderId(BigDecimal orderId);

    void setCmmdtyId(BigDecimal cmmdtyId);

    void setCmmdtyName(String cmmdtyName);

    void setProposedPrice(BigDecimal proposedPrice);

    void setActualPrice(BigDecimal actualPrice);

    void setQty(Integer qty);

    void setDefaultImageAddrs(String defaultImageAddrs);

    void setCommodityStatus(OrderCommodityStatus commodityStatus);

    void setEvaluationStatus(EvaluationStatus evaluationStatus);

    void setTimesExchanged(Integer timesExchanged);

}
