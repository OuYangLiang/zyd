package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * PointEventEntity
 * 
 * @author GeJianKui
 */
public class PointEventEntity extends BaseEntity {

    private BigDecimal eventId;
    private String scenario;
    private Timestamp eventTs;
    private String orderNum;
    private String returnOrderNum;
    private BigDecimal orderAmt;
    private BigDecimal changeQty;
    private BigDecimal pointBalanceBefore;
    private BigDecimal partyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getEventId() {
        return this.eventId;
    }

    public String getScenario() {
        return this.scenario;
    }

    public Timestamp getEventTs() {
        return this.eventTs;
    }

    public String getOrderNum() {
        return this.orderNum;
    }

    public String getReturnOrderNum() {
        return this.returnOrderNum;
    }

    public BigDecimal getOrderAmt() {
        return this.orderAmt;
    }

    public BigDecimal getChangeQty() {
        return this.changeQty;
    }

    public BigDecimal getPointBalanceBefore() {
        return this.pointBalanceBefore;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
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

    public void setScenario(String scenario) {
        this.scenario = scenario == null ? null : scenario.trim();
    }

    public void setEventTs(Timestamp eventTs) {
        this.eventTs = eventTs == null ? null : (Timestamp) eventTs.clone();
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public void setReturnOrderNum(String returnOrderNum) {
        this.returnOrderNum = returnOrderNum == null ? null : returnOrderNum.trim();
    }

    public void setOrderAmt(BigDecimal orderAmt) {
        this.orderAmt = orderAmt;
    }

    public void setChangeQty(BigDecimal changeQty) {
        this.changeQty = changeQty;
    }

    public void setPointBalanceBefore(BigDecimal pointBalanceBefore) {
        this.pointBalanceBefore = pointBalanceBefore;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}