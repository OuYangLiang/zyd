package org.zyd.service.dto;

import java.math.BigDecimal;

import org.zyd.common.constants.Country;

public class ReturnOrderContactInfoDto implements java.io.Serializable{
	private static final long serialVersionUID = 2428149858290179211L;
	
	private BigDecimal returnOrderId;
    private String cntctName;
    private String cntctMobile;
    private Country cntctCountry;
    private String cntctState;
    private String cntctCity;
    private String cntctTown;
    private String cntctStreet;
    private String cntctAddress;
    private String cntctPostCode;

    public BigDecimal getReturnOrderId() {
        return this.returnOrderId;
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

    public void setReturnOrderId(BigDecimal returnOrderId) {
        this.returnOrderId = returnOrderId;
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

}