package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * ReturnOrderCommodityEntity
 * 
 * @author GeJianKui
 */
public class ReturnOrderCommodityEntity extends BaseEntity {

    private BigDecimal returnOrderCmmdtyId;
    private String returnOrderCmmdtyType;
    private BigDecimal sourceOrderCmmdtyId;
    private BigDecimal cmmdtyId;
    private String cmmdtyName;
    private BigDecimal actualPrice;
    private Integer qty;
    private BigDecimal returnOrderId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getReturnOrderCmmdtyId() {
        return this.returnOrderCmmdtyId;
    }

    public String getReturnOrderCmmdtyType() {
        return this.returnOrderCmmdtyType;
    }

    public BigDecimal getSourceOrderCmmdtyId() {
        return this.sourceOrderCmmdtyId;
    }

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public String getCmmdtyName() {
        return this.cmmdtyName;
    }

    public BigDecimal getActualPrice() {
        return this.actualPrice;
    }

    public Integer getQty() {
        return this.qty;
    }

    public BigDecimal getReturnOrderId() {
        return this.returnOrderId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setReturnOrderCmmdtyId(BigDecimal returnOrderCmmdtyId) {
        this.returnOrderCmmdtyId = returnOrderCmmdtyId;
    }

    public void setReturnOrderCmmdtyType(String returnOrderCmmdtyType) {
        this.returnOrderCmmdtyType = returnOrderCmmdtyType == null ? null : returnOrderCmmdtyType.trim();
    }

    public void setSourceOrderCmmdtyId(BigDecimal sourceOrderCmmdtyId) {
        this.sourceOrderCmmdtyId = sourceOrderCmmdtyId;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setCmmdtyName(String cmmdtyName) {
        this.cmmdtyName = cmmdtyName == null ? null : cmmdtyName.trim();
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setReturnOrderId(BigDecimal returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}