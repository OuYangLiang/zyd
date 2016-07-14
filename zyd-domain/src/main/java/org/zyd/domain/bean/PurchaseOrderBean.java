package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.zyd.common.constants.OrderStatus;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.PurchaseOrderOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface PurchaseOrderBean extends PurchaseOrderOperation, BaseOperation, RemoveOperation {
	
	void saveRecursively() throws ZydException;
	
	List<OrderCommodityBean> getOrderCommodityBeans();
	
	void setOrderCommodityBeans(List<OrderCommodityBean> orderCommodityBeans);
	
	OrderPaymentBean getOrderPaymentBean();
	
	void setOrderPaymentBean(OrderPaymentBean orderPaymentBean);
	
	InvoiceBean getInvoiceBean();
	
	void setInvoiceBean(InvoiceBean invoiceBean);
	
	OrderContactInfoBean getOrderContactInfoBean();
	
	void setOrderContactInfoBean(OrderContactInfoBean orderContactInfoBean);
	
	OrderLogisticsBean getOrderLogisticsBean();
	
	void setOrderLogisticsBean(OrderLogisticsBean orderLogisticsBean);

    BigDecimal getOrderId();

    String getOrderNum();

    Timestamp getSubmitTime();

    OrderStatus getOrderStatus();

    BigDecimal getOrderTotalPrice();

    BigDecimal getPointConsumed();

    BigDecimal getLogisticsAmt();

    BigDecimal getOrderShouldPayment();

    BigDecimal getOrderActualPayment();

    String getRemarks();

    String getRemarks2();

    BigDecimal getPartyId();

    void setOrderId(BigDecimal orderId);

    void setOrderNum(String orderNum);

    void setSubmitTime(Timestamp submitTime);

    void setOrderStatus(OrderStatus orderStatus);

    void setOrderTotalPrice(BigDecimal orderTotalPrice);

    void setPointConsumed(BigDecimal pointConsumed);

    void setLogisticsAmt(BigDecimal logisticsAmt);
    
    void setFreeLogisticsCondition(BigDecimal freeLogisticsCondition);
    
    BigDecimal getFreeLogisticsCondition();

    boolean isFreeLogisticsAmt();

    void setFreeLogisticsAmt(boolean freeLogisticsAmt);

    void setOrderShouldPayment(BigDecimal orderShouldPayment);

    void setOrderActualPayment(BigDecimal orderActualPayment);

    void setRemarks(String remarks);

    void setRemarks2(String remarks2);

    void setPartyId(BigDecimal partyId);
    
    void setDiscount(BigDecimal discount);
    
    BigDecimal getDiscount();
}
