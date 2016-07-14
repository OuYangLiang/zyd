package org.zyd.service.dto;

import java.math.BigDecimal;

public class OrderItemListDto implements java.io.Serializable{
	private static final long serialVersionUID = 1086267115449586698L;
	
	private BigDecimal itemId;
    private String itemDesc;
    private Integer itemQty;
    private BigDecimal orderCmmdtyId;

    public BigDecimal getItemId() {
        return this.itemId;
    }

    public String getItemDesc() {
        return this.itemDesc;
    }

    public Integer getItemQty() {
        return this.itemQty;
    }

    public BigDecimal getOrderCmmdtyId() {
        return this.orderCmmdtyId;
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

    public void setOrderCmmdtyId(BigDecimal orderCmmdtyId) {
        this.orderCmmdtyId = orderCmmdtyId;
    }

}