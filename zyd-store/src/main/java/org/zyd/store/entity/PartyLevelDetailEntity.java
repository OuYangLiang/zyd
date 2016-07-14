package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * PartyLevelDetailEntity
 * 
 * @author GeJianKui
 */
public class PartyLevelDetailEntity extends BaseEntity {

    private BigDecimal detailId;
    private String scenario;
    private Timestamp eventTs;
    private String orderNum;
    private String returnOrderNum;
    private BigDecimal orderAmt;
    private String factor;
    private BigDecimal changeQty;
    private BigDecimal balanceBefore;
    private BigDecimal partyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getDetailId() {
        return this.detailId;
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

    public String getFactor() {
        return this.factor;
    }

    public BigDecimal getChangeQty() {
        return this.changeQty;
    }

    public BigDecimal getBalanceBefore() {
        return this.balanceBefore;
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

    public void setDetailId(BigDecimal detailId) {
        this.detailId = detailId;
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

    public void setFactor(String factor) {
        this.factor = factor == null ? null : factor.trim();
    }

    public void setChangeQty(BigDecimal changeQty) {
        this.changeQty = changeQty;
    }

    public void setBalanceBefore(BigDecimal balanceBefore) {
        this.balanceBefore = balanceBefore;
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