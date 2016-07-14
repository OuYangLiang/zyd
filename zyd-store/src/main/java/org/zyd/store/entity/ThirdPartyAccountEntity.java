package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * ThirdPartyAccountEntity
 * 
 * @author GeJianKui
 */
public class ThirdPartyAccountEntity extends BaseEntity {

    private BigDecimal acntId;
    private String acntType;
    private String acntVal;
    private BigDecimal partyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getAcntId() {
        return this.acntId;
    }

    public String getAcntType() {
        return this.acntType;
    }

    public String getAcntVal() {
        return this.acntVal;
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

    public void setAcntId(BigDecimal acntId) {
        this.acntId = acntId;
    }

    public void setAcntType(String acntType) {
        this.acntType = acntType == null ? null : acntType.trim();
    }

    public void setAcntVal(String acntVal) {
        this.acntVal = acntVal == null ? null : acntVal.trim();
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