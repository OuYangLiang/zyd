package org.zyd.service.dto;

import java.math.BigDecimal;

public class ReturnOrderItemListDto implements java.io.Serializable{
	private static final long serialVersionUID = -8126690772383965962L;
	
	private BigDecimal itemId;
    private String itemDesc;
    private Integer itemQty;
    private BigDecimal returnOrderCmmdtyId;

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

}