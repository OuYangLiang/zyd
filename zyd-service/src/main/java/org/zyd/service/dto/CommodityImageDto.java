package org.zyd.service.dto;

import java.math.BigDecimal;

import org.zyd.common.constants.CommodityImageType;


public class CommodityImageDto implements java.io.Serializable{
	private static final long serialVersionUID = -3291646059727553216L;
	
	private BigDecimal imageId;
    private BigDecimal cmmdtyId;
    private Integer imageSeq;
    private String imageAddrs;
    private CommodityImageType imageType;

    public BigDecimal getImageId() {
        return this.imageId;
    }

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public Integer getImageSeq() {
        return this.imageSeq;
    }

    public String getImageAddrs() {
        return this.imageAddrs;
    }

    public void setImageId(BigDecimal imageId) {
        this.imageId = imageId;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setImageSeq(Integer imageSeq) {
        this.imageSeq = imageSeq;
    }

    public void setImageAddrs(String imageAddrs) {
        this.imageAddrs = imageAddrs == null ? null : imageAddrs.trim();
    }

	public CommodityImageType getImageType() {
		return imageType;
	}

	public void setImageType(CommodityImageType imageType) {
		this.imageType = imageType;
	}

}