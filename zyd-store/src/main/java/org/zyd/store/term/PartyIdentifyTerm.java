package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * PartyIdentifyTerm
 * 
 * @author GeJianKui
 */
public class PartyIdentifyTerm extends BaseTerm {

    private BigDecimal partyId;
    private String recommendCode;
    private Timestamp registerDate;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public String getRecommendCode() {
        return this.recommendCode;
    }

    public Timestamp getRegisterDate() {
        return this.registerDate;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode == null ? null : recommendCode.trim();
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate == null ? null : (Timestamp) registerDate.clone();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
