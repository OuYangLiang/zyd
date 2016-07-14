package org.zyd.service.dto;

import java.math.BigDecimal;

import org.zyd.common.constants.ReturnOrderCmmdtyType;

public class ReturnOrderCommodityDto implements java.io.Serializable{
	private static final long serialVersionUID = -8487438054472659839L;
	
	private BigDecimal returnOrderCmmdtyId;
    private ReturnOrderCmmdtyType returnOrderCmmdtyType;
    private BigDecimal sourceOrderCmmdtyId;
    private BigDecimal cmmdtyId;
    private String cmmdtyName;
    private BigDecimal actualPrice;
    private Integer qty;
    private BigDecimal returnOrderId;

    public BigDecimal getReturnOrderCmmdtyId() {
        return this.returnOrderCmmdtyId;
    }

    public ReturnOrderCmmdtyType getReturnOrderCmmdtyType() {
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

    public void setReturnOrderCmmdtyId(BigDecimal returnOrderCmmdtyId) {
        this.returnOrderCmmdtyId = returnOrderCmmdtyId;
    }

    public void setReturnOrderCmmdtyType(ReturnOrderCmmdtyType returnOrderCmmdtyType) {
        this.returnOrderCmmdtyType = returnOrderCmmdtyType;
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

}