package org.zyd.service.dto;

import java.math.BigDecimal;

public class OrderGiftItemListDto implements java.io.Serializable{
	private static final long serialVersionUID = -4907327969927921663L;
	
	private BigDecimal itemId;
    private String itemDesc;
    private Integer itemQty;
    private BigDecimal orderGiftId;

    public BigDecimal getItemId() {
        return this.itemId;
    }

    public String getItemDesc() {
        return this.itemDesc;
    }

    public Integer getItemQty() {
        return this.itemQty;
    }

    public BigDecimal getOrderGiftId() {
        return this.orderGiftId;
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

    public void setOrderGiftId(BigDecimal orderGiftId) {
        this.orderGiftId = orderGiftId;
    }

}