package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * OrderEventEntity
 * 
 * @author GeJianKui
 */
public class OrderEventEntity extends BaseEntity {

    private BigDecimal eventId;
    private Timestamp eventTs;
    private String eventDesc;
    private BigDecimal orderId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getEventId() {
        return this.eventId;
    }

    public Timestamp getEventTs() {
        return this.eventTs;
    }

    public String getEventDesc() {
        return this.eventDesc;
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

    public void setEventId(BigDecimal eventId) {
        this.eventId = eventId;
    }

    public void setEventTs(Timestamp eventTs) {
        this.eventTs = eventTs == null ? null : (Timestamp) eventTs.clone();
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc == null ? null : eventDesc.trim();
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