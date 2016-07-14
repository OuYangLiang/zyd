package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * OrderLogEntity
 * 
 * @author GeJianKui
 */
public class OrderLogEntity extends BaseEntity {

    private BigDecimal logId;
    private String orderStatusBefore;
    private String orderStatusAfter;
    private String operatorType;
    private String logDesc;
    private Timestamp eventTs;
    private String operator;
    private BigDecimal orderId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getLogId() {
        return this.logId;
    }

    public String getOrderStatusBefore() {
        return this.orderStatusBefore;
    }

    public String getOrderStatusAfter() {
        return this.orderStatusAfter;
    }

    public String getOperatorType() {
        return this.operatorType;
    }

    public String getLogDesc() {
        return this.logDesc;
    }

    public Timestamp getEventTs() {
        return this.eventTs;
    }

    public String getOperator() {
        return this.operator;
    }

    public BigDecimal getOrderId() {
        return this.orderId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setLogId(BigDecimal logId) {
        this.logId = logId;
    }

    public void setOrderStatusBefore(String orderStatusBefore) {
        this.orderStatusBefore = orderStatusBefore == null ? null : orderStatusBefore.trim();
    }

    public void setOrderStatusAfter(String orderStatusAfter) {
        this.orderStatusAfter = orderStatusAfter == null ? null : orderStatusAfter.trim();
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType == null ? null : operatorType.trim();
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc == null ? null : logDesc.trim();
    }

    public void setEventTs(Timestamp eventTs) {
        this.eventTs = eventTs == null ? null : (Timestamp) eventTs.clone();
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}