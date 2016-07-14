package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * ShoppingCartEntity
 * 
 * @author GeJianKui
 */
public class ShoppingCartEntity extends BaseEntity {

    private BigDecimal shoppingId;
    private BigDecimal partyId;
    private BigDecimal cmmdtyId;
    private Integer qtyToBuy;
    private Timestamp addTime;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getShoppingId() {
        return this.shoppingId;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public Integer getQtyToBuy() {
        return this.qtyToBuy;
    }

    public Timestamp getAddTime() {
        return this.addTime;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setShoppingId(BigDecimal shoppingId) {
        this.shoppingId = shoppingId;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setQtyToBuy(Integer qtyToBuy) {
        this.qtyToBuy = qtyToBuy;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime == null ? null : (Timestamp) addTime.clone();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}