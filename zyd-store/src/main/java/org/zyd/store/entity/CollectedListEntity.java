package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * CollectedListEntity
 * 
 * @author GeJianKui
 */
public class CollectedListEntity extends BaseEntity {

    private BigDecimal collectedId;
    private BigDecimal partyId;
    private BigDecimal cmmdtyId;
    private Timestamp collectedTime;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getCollectedId() {
        return this.collectedId;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public Timestamp getCollectedTime() {
        return this.collectedTime;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setCollectedId(BigDecimal collectedId) {
        this.collectedId = collectedId;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setCollectedTime(Timestamp collectedTime) {
        this.collectedTime = collectedTime == null ? null : (Timestamp) collectedTime.clone();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}