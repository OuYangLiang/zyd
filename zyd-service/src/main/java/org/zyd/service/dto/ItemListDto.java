package org.zyd.service.dto;

import java.math.BigDecimal;

public class ItemListDto implements java.io.Serializable{
	private static final long serialVersionUID = -7104884453698416816L;
	
	private BigDecimal itemId;
	private String itemDesc;
	private Integer itemQty;
	private BigDecimal cmmdtyId;

	public BigDecimal getItemId() {
		return itemId;
	}

	public void setItemId(BigDecimal itemId) {
		this.itemId = itemId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Integer getItemQty() {
		return itemQty;
	}

	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}

	public BigDecimal getCmmdtyId() {
		return cmmdtyId;
	}

	public void setCmmdtyId(BigDecimal cmmdtyId) {
		this.cmmdtyId = cmmdtyId;
	}

}
