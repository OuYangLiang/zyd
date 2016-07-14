package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * PartyLevelFactorEntity
 * 
 * @author GeJianKui
 */
public class PartyLevelFactorEntity extends BaseEntity {

    private BigDecimal factorId;
    private String factor;
    private BigDecimal factorVal;
    private BigDecimal partyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getFactorId() {
        return this.factorId;
    }

    public String getFactor() {
        return this.factor;
    }

    public BigDecimal getFactorVal() {
        return this.factorVal;
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

    public void setFactorId(BigDecimal factorId) {
        this.factorId = factorId;
    }

    public void setFactor(String factor) {
        this.factor = factor == null ? null : factor.trim();
    }

    public void setFactorVal(BigDecimal factorVal) {
        this.factorVal = factorVal;
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