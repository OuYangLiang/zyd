package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * PartyAccountTerm
 * 
 * @author GeJianKui
 */
public class PartyAccountTerm extends BaseTerm {

    private BigDecimal acntId;
    private String acntType;
    private String acntVal;
    private String acntStatus;
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

    public String getAcntStatus() {
        return this.acntStatus;
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

    public void setAcntStatus(String acntStatus) {
        this.acntStatus = acntStatus == null ? null : acntStatus.trim();
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
