package org.zyd.service.dto;

import java.math.BigDecimal;

import org.zyd.common.constants.AccountStatus;
import org.zyd.common.constants.AccountType;

public class PartyAccountDto implements java.io.Serializable{
	private static final long serialVersionUID = -1079351073288513560L;
	
	private BigDecimal acntId;
    private AccountType acntType;
    private String acntVal;
    private AccountStatus acntStatus;
    private BigDecimal partyId;
    
    private String level;

    public BigDecimal getAcntId() {
        return this.acntId;
    }

    public AccountType getAcntType() {
        return this.acntType;
    }

    public String getAcntVal() {
        return this.acntVal;
    }

    public AccountStatus getAcntStatus() {
        return this.acntStatus;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public void setAcntId(BigDecimal acntId) {
        this.acntId = acntId;
    }

    public void setAcntType(AccountType acntType) {
        this.acntType = acntType;
    }

    public void setAcntVal(String acntVal) {
        this.acntVal = acntVal == null ? null : acntVal.trim();
    }

    public void setAcntStatus(AccountStatus acntStatus) {
        this.acntStatus = acntStatus;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}