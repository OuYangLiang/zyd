package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * PartyPointTerm
 * 
 * @author GeJianKui
 */
public class PartyPointTerm extends BaseTerm {

    private BigDecimal partyId;
    private BigDecimal totalAmt;
    private BigDecimal usedAmt;
    private BigDecimal balanceAmt;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public BigDecimal getTotalAmt() {
        return this.totalAmt;
    }

    public BigDecimal getUsedAmt() {
        return this.usedAmt;
    }

    public BigDecimal getBalanceAmt() {
        return this.balanceAmt;
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

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    public void setUsedAmt(BigDecimal usedAmt) {
        this.usedAmt = usedAmt;
    }

    public void setBalanceAmt(BigDecimal balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
