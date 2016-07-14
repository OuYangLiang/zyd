package org.zyd.service.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.zyd.common.constants.Education;
import org.zyd.common.constants.Gender;
import org.zyd.common.constants.LevelOfIncome;
import org.zyd.common.constants.MaritalStatus;

public class PartyInfoDto implements java.io.Serializable{
	private static final long serialVersionUID = -1723177306872480786L;
	
	private BigDecimal partyId;
    private String partyName;
    private String partyAlias;
    private Gender gender;
    private Date birthday;
    private Education education;
    private MaritalStatus maritalStatus;
//    private Industry industry;
    private LevelOfIncome levelOfIncome;

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public String getPartyName() {
        return this.partyName;
    }

    public String getPartyAlias() {
        return this.partyAlias;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public Education getEducation() {
        return this.education;
    }

    public MaritalStatus getMaritalStatus() {
        return this.maritalStatus;
    }

//    public Industry getIndustry() {
//        return this.industry;
//    }

    public LevelOfIncome getLevelOfIncome() {
        return this.levelOfIncome;
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

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday == null ? null : (Date) birthday.clone();
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    // public void setIndustry(Industry industry) {
    // this.industry = industry;
    // }

    public void setLevelOfIncome(LevelOfIncome levelOfIncome) {
        this.levelOfIncome = levelOfIncome;
    }

}