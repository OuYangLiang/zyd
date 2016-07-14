package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.PasswordStatus;
import org.zyd.common.constants.PasswordStrongth;
import org.zyd.common.constants.PasswordType;

public class PartyPasswordDto implements java.io.Serializable{
	private static final long serialVersionUID = -8513827708424210380L;
	
	private BigDecimal pwdId;
    private PasswordType pwdType;
    private String pwdVal;
    private Integer pwdSalt;
    private PasswordStrongth pwdStrongth;
    private Timestamp firstWrongCheckTime;
    private Integer wrongCheckTimes;
    private PasswordStatus pwdStatus;
    private BigDecimal partyId;

    public BigDecimal getPwdId() {
        return this.pwdId;
    }

    public PasswordType getPwdType() {
        return this.pwdType;
    }

    public String getPwdVal() {
        return this.pwdVal;
    }

    public Integer getPwdSalt() {
        return this.pwdSalt;
    }

    public PasswordStrongth getPwdStrongth() {
        return this.pwdStrongth;
    }

    public Timestamp getFirstWrongCheckTime() {
        return this.firstWrongCheckTime;
    }

    public Integer getWrongCheckTimes() {
        return this.wrongCheckTimes;
    }

    public PasswordStatus getPwdStatus() {
        return this.pwdStatus;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public void setPwdId(BigDecimal pwdId) {
        this.pwdId = pwdId;
    }

    public void setPwdType(PasswordType pwdType) {
        this.pwdType = pwdType;
    }

    public void setPwdVal(String pwdVal) {
        this.pwdVal = pwdVal == null ? null : pwdVal.trim();
    }

    public void setPwdSalt(Integer pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public void setPwdStrongth(PasswordStrongth pwdStrongth) {
        this.pwdStrongth = pwdStrongth;
    }

    public void setFirstWrongCheckTime(Timestamp firstWrongCheckTime) {
        this.firstWrongCheckTime = firstWrongCheckTime == null ? null : (Timestamp) firstWrongCheckTime.clone();
    }

    public void setWrongCheckTimes(Integer wrongCheckTimes) {
        this.wrongCheckTimes = wrongCheckTimes;
    }

    public void setPwdStatus(PasswordStatus pwdStatus) {
        this.pwdStatus = pwdStatus;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

}