package org.zyd.service.dto;

import java.math.BigDecimal;

public class PartyPointDto implements java.io.Serializable{
	private static final long serialVersionUID = 8814124056146551375L;
	
	private BigDecimal partyId;
    private BigDecimal totalAmt;
    private BigDecimal usedAmt;
    private BigDecimal balanceAmt;

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

}