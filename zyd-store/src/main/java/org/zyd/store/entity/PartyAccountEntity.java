package org.zyd.store.entity;

import java.math.BigDecimal;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * PartyAccountEntity
 * 
 * @author GeJianKui
 */
public class PartyAccountEntity extends BaseEntity {

    private BigDecimal acntId;
    private String acntType;
    private String acntVal;
    private String acntStatus;
    private BigDecimal partyId;

    public BigDecimal getAcntId() {
        return this.acntId;
    }

    public String getAcntType() {
        return this.acntType;
    }

    public String getAcntVal() {
        return this.acntVal;
    }

    public String getAcntStatus() {
        return this.acntStatus;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
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

    public void setAcntStatus(String acntStatus) {
        this.acntStatus = acntStatus == null ? null : acntStatus.trim();
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

}