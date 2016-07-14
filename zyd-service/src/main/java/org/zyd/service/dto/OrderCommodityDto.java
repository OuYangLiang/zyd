package org.zyd.service.dto;

import java.math.BigDecimal;

import org.zyd.common.constants.EvaluationStatus;
import org.zyd.common.constants.OrderCommodityStatus;

public class OrderCommodityDto implements java.io.Serializable{
	private static final long serialVersionUID = -4981437203296827998L;
	
	private BigDecimal orderCmmdtyId;
    private BigDecimal orderId;
    private BigDecimal cmmdtyId;
    private String cmmdtyName;
    private BigDecimal proposedPrice;
    private BigDecimal actualPrice;
    private Integer qty;
    private String defaultImageAddrs;
    private OrderCommodityStatus commodityStatus;
    private EvaluationStatus evaluationStatus;
    private Integer timesExchanged;

    public BigDecimal getOrderCmmdtyId() {
        return this.orderCmmdtyId;
    }

    public BigDecimal getOrderId() {
        return this.orderId;
    }

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public String getCmmdtyName() {
        return this.cmmdtyName;
    }

    public BigDecimal getProposedPrice() {
        return this.proposedPrice;
    }

    public BigDecimal getActualPrice() {
        return this.actualPrice;
    }

    public Integer getQty() {
        return this.qty;
    }

    public String getDefaultImageAddrs() {
        return this.defaultImageAddrs;
    }

    public OrderCommodityStatus getCommodityStatus() {
        return this.commodityStatus;
    }

    public EvaluationStatus getEvaluationStatus() {
        return this.evaluationStatus;
    }

    public Integer getTimesExchanged() {
        return this.timesExchanged;
    }

    public void setOrderCmmdtyId(BigDecimal orderCmmdtyId) {
        this.orderCmmdtyId = orderCmmdtyId;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setCmmdtyName(String cmmdtyName) {
        this.cmmdtyName = cmmdtyName == null ? null : cmmdtyName.trim();
    }

    public void setProposedPrice(BigDecimal proposedPrice) {
        this.proposedPrice = proposedPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setDefaultImageAddrs(String defaultImageAddrs) {
        this.defaultImageAddrs = defaultImageAddrs == null ? null : defaultImageAddrs.trim();
    }

    public void setCommodityStatus(OrderCommodityStatus commodityStatus) {
        this.commodityStatus = commodityStatus;
    }

    public void setEvaluationStatus(EvaluationStatus evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

    public void setTimesExchanged(Integer timesExchanged) {
        this.timesExchanged = timesExchanged;
    }

}