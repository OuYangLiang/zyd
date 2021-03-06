package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * ReturnOrderItemListEntity
 * 
 * @author GeJianKui
 */
public class ReturnOrderItemListEntity extends BaseEntity {

    private BigDecimal itemId;
    private String itemDesc;
    private Integer itemQty;
    private BigDecimal returnOrderCmmdtyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getItemId() {
        return this.itemId;
    }

    public String getItemDesc() {
        return this.itemDesc;
    }

    public Integer getItemQty() {
        return this.itemQty;
    }

    public BigDecimal getReturnOrderCmmdtyId() {
        return this.returnOrderCmmdtyId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setItemId(BigDecimal itemId) {
        this.itemId = itemId;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    public void setReturnOrderCmmdtyId(BigDecimal returnOrderCmmdtyId) {
        this.returnOrderCmmdtyId = returnOrderCmmdtyId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}