package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * OrderContactInfoEntity
 * 
 * @author GeJianKui
 */
public class OrderContactInfoEntity extends BaseEntity {

    private BigDecimal orderId;
    private String cntctName;
    private String cntctMobile;
    private String cntctCountry;
    private String cntctState;
    private String cntctCity;
    private String cntctTown;
    private String cntctStreet;
    private String cntctAddress;
    private String cntctPostCode;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getOrderId() {
        return this.orderId;
    }

    public String getCntctName() {
        return this.cntctName;
    }

    public String getCntctMobile() {
        return this.cntctMobile;
    }

    public String getCntctCountry() {
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

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public void setCntctName(String cntctName) {
        this.cntctName = cntctName == null ? null : cntctName.trim();
    }

    public void setCntctMobile(String cntctMobile) {
        this.cntctMobile = cntctMobile == null ? null : cntctMobile.trim();
    }

    public void setCntctCountry(String cntctCountry) {
        this.cntctCountry = cntctCountry == null ? null : cntctCountry.trim();
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

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}