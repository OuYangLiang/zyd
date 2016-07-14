package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ShoppingCartItemDto implements java.io.Serializable{
	private static final long serialVersionUID = 168380173146272894L;
	
	private BigDecimal shoppingId;
	private BigDecimal cmmdtyId;
	private Integer qtyToBuy;
	private Timestamp addTime;

	private CommodityDto cmmdty;
	
	public BigDecimal getShoppingId() {
		return shoppingId;
	}

	public void setShoppingId(BigDecimal shoppingId) {
		this.shoppingId = shoppingId;
	}

	public BigDecimal getCmmdtyId() {
		return cmmdtyId;
	}

	public void setCmmdtyId(BigDecimal cmmdtyId) {
		this.cmmdtyId = cmmdtyId;
	}

	public Integer getQtyToBuy() {
		return qtyToBuy;
	}

	public void setQtyToBuy(Integer qtyToBuy) {
		this.qtyToBuy = qtyToBuy;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

    public CommodityDto getCmmdty() {
        return cmmdty;
    }

    public void setCmmdty(CommodityDto cmmdty) {
        this.cmmdty = cmmdty;
    }

}
