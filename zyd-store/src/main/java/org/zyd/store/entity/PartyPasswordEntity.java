package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * PartyPasswordEntity
 * 
 * @author GeJianKui
 */
public class PartyPasswordEntity extends BaseEntity {

    private BigDecimal pwdId;
    private String pwdType;
    private String pwdVal;
    private Integer pwdSalt;
    private String pwdStrongth;
    private Timestamp firstWrongCheckTime;
    private Integer wrongCheckTimes;
    private String pwdStatus;
    private BigDecimal partyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getPwdId() {
        return this.pwdId;
    }

    public String getPwdType() {
        return this.pwdType;
    }

    public String getPwdVal() {
        return this.pwdVal;
    }

    public Integer getPwdSalt() {
        return this.pwdSalt;
    }

    public String getPwdStrongth() {
        return this.pwdStrongth;
    }

    public Timestamp getFirstWrongCheckTime() {
        return this.firstWrongCheckTime;
    }

    public Integer getWrongCheckTimes() {
        return this.wrongCheckTimes;
    }

    public String getPwdStatus() {
        return this.pwdStatus;
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

    public void setPwdId(BigDecimal pwdId) {
        this.pwdId = pwdId;
    }

    public void setPwdType(String pwdType) {
        this.pwdType = pwdType == null ? null : pwdType.trim();
    }

    public void setPwdVal(String pwdVal) {
        this.pwdVal = pwdVal == null ? null : pwdVal.trim();
    }

    public void setPwdSalt(Integer pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public void setPwdStrongth(String pwdStrongth) {
        this.pwdStrongth = pwdStrongth == null ? null : pwdStrongth.trim();
    }

    public void setFirstWrongCheckTime(Timestamp firstWrongCheckTime) {
        this.firstWrongCheckTime = firstWrongCheckTime == null ? null : (Timestamp) firstWrongCheckTime.clone();
    }

    public void setWrongCheckTimes(Integer wrongCheckTimes) {
        this.wrongCheckTimes = wrongCheckTimes;
    }

    public void setPwdStatus(String pwdStatus) {
        this.pwdStatus = pwdStatus == null ? null : pwdStatus.trim();
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