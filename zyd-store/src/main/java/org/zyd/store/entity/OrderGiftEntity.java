package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * OrderGiftEntity
 * 
 * @author GeJianKui
 */
public class OrderGiftEntity extends BaseEntity {

    private BigDecimal orderGiftId;
    private BigDecimal orderId;
    private BigDecimal cmmdtyId;
    private String cmmdtyName;
    private BigDecimal proposedPrice;
    private Integer qty;
    private String defaultImageAddrs;
    private BigDecimal orderCmmdtyId;
    private String commodityStatus;
    private String evaluationStatus;
    private Integer timesExchanged;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getOrderGiftId() {
        return this.orderGiftId;
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

    public Integer getQty() {
        return this.qty;
    }

    public String getDefaultImageAddrs() {
        return this.defaultImageAddrs;
    }

    public BigDecimal getOrderCmmdtyId() {
        return this.orderCmmdtyId;
    }

    public String getCommodityStatus() {
        return this.commodityStatus;
    }

    public String getEvaluationStatus() {
        return this.evaluationStatus;
    }

    public Integer getTimesExchanged() {
        return this.timesExchanged;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setOrderGiftId(BigDecimal orderGiftId) {
        this.orderGiftId = orderGiftId;
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

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setDefaultImageAddrs(String defaultImageAddrs) {
        this.defaultImageAddrs = defaultImageAddrs == null ? null : defaultImageAddrs.trim();
    }

    public void setOrderCmmdtyId(BigDecimal orderCmmdtyId) {
        this.orderCmmdtyId = orderCmmdtyId;
    }

    public void setCommodityStatus(String commodityStatus) {
        this.commodityStatus = commodityStatus == null ? null : commodityStatus.trim();
    }

    public void setEvaluationStatus(String evaluationStatus) {
        this.evaluationStatus = evaluationStatus == null ? null : evaluationStatus.trim();
    }

    public void setTimesExchanged(Integer timesExchanged) {
        this.timesExchanged = timesExchanged;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}