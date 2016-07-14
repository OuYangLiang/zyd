package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * PartyInfoTerm
 * 
 * @author GeJianKui
 */
public class PartyInfoTerm extends BaseTerm {

    private BigDecimal partyId;
    private String partyName;
    private String partyAlias;
    private String gender;
    private Date birthday;
    private String education;
    private String maritalStatus;
    private String industry;
    private String levelOfIncome;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public String getPartyName() {
        return this.partyName;
    }

    public String getPartyAlias() {
        return this.partyAlias;
    }

    public String getGender() {
        return this.gender;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public String getEducation() {
        return this.education;
    }

    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public String getIndustry() {
        return this.industry;
    }

    public String getLevelOfIncome() {
        return this.levelOfIncome;
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

    public void setPartyName(String partyName) {
        this.partyName = partyName == null ? null : partyName.trim();
    }

    public void setPartyAlias(String partyAlias) {
        this.partyAlias = partyAlias == null ? null : partyAlias.trim();
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday == null ? null : (Date) birthday.clone();
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public void setLevelOfIncome(String levelOfIncome) {
        this.levelOfIncome = levelOfIncome == null ? null : levelOfIncome.trim();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
