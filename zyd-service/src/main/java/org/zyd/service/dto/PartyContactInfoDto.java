package org.zyd.service.dto;

import java.math.BigDecimal;

import org.zyd.common.constants.ContactType;
import org.zyd.common.constants.Country;

public class PartyContactInfoDto implements java.io.Serializable{
	private static final long serialVersionUID = 2677216713414121875L;
	
	private BigDecimal cntctId;
    private ContactType cntctType;
    private Integer cntctSeq;
    private String cntctName;
    private String cntctMobile;
    private Country cntctCountry;
    private String cntctState;
    private String cntctCity;
    private String cntctTownCode;
    private String cntctTown;
    private String cntctStreet;
    private String cntctAddress;
    private String cntctPostCode;
    private boolean preferFlag;
    private BigDecimal partyId;

    public BigDecimal getCntctId() {
        return this.cntctId;
    }

    public ContactType getCntctType() {
        return this.cntctType;
    }

    public Integer getCntctSeq() {
        return this.cntctSeq;
    }

    public String getCntctName() {
        return this.cntctName;
    }

    public String getCntctMobile() {
        return this.cntctMobile;
    }

    public Country getCntctCountry() {
        return this.cntctCountry;
    }

    public String getCntctState() {
        return this.cntctState;
    }

    public String getCntctCity() {
        return this.cntctCity;
    }

    public String getCntctTown() {
        return this.cntctTown;
    }

    public String getCntctStreet() {
        return this.cntctStreet;
    }

    public String getCntctAddress() {
        return this.cntctAddress;
    }

    public String getCntctPostCode() {
        return this.cntctPostCode;
    }

    public boolean isPreferFlag() {
        return this.preferFlag;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public void setCntctId(BigDecimal cntctId) {
        this.cntctId = cntctId;
    }

    public void setCntctType(ContactType cntctType) {
        this.cntctType = cntctType;
    }

    public void setCntctSeq(Integer cntctSeq) {
        this.cntctSeq = cntctSeq;
    }

    public void setCntctName(String cntctName) {
        this.cntctName = cntctName == null ? null : cntctName.trim();
    }

    public void setCntctMobile(String cntctMobile) {
        this.cntctMobile = cntctMobile == null ? null : cntctMobile.trim();
    }

    public void setCntctCountry(Country cntctCountry) {
        this.cntctCountry = cntctCountry;
    }

    public void setCntctState(String cntctState) {
        this.cntctState = cntctState == null ? null : cntctState.trim();
    }

    public void setCntctCity(String cntctCity) {
        this.cntctCity = cntctCity == null ? null : cntctCity.trim();
    }

    public void setCntctTown(String cntctTown) {
        this.cntctTown = cntctTown == null ? null : cntctTown.trim();
    }

    public void setCntctStreet(String cntctStreet) {
        this.cntctStreet = cntctStreet == null ? null : cntctStreet.trim();
    }

    public void setCntctAddress(String cntctAddress) {
        this.cntctAddress = cntctAddress == null ? null : cntctAddress.trim();
    }

    public void setCntctPostCode(String cntctPostCode) {
        this.cntctPostCode = cntctPostCode == null ? null : cntctPostCode.trim();
    }

    public void setPreferFlag(boolean preferFlag) {
        this.preferFlag = preferFlag;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

	public String getCntctTownCode() {
		return cntctTownCode;
	}

	public void setCntctTownCode(String cntctTownCode) {
		this.cntctTownCode = cntctTownCode == null ? null : cntctTownCode.trim();
	}

}