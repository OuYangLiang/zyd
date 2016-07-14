package org.zyd.service.dto;

import java.math.BigDecimal;

public class CommodityPropertyDto implements java.io.Serializable{
	private static final long serialVersionUID = -4318680603607116174L;
	
	private BigDecimal propertyId;
	private BigDecimal cmmdtyId;
	private String propName;
	private String propVal;
	private Integer seq;

	public BigDecimal getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(BigDecimal propertyId) {
		this.propertyId = propertyId;
	}

	public BigDecimal getCmmdtyId() {
		return cmmdtyId;
	}

	public void setCmmdtyId(BigDecimal cmmdtyId) {
		this.cmmdtyId = cmmdtyId;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropVal() {
		return propVal;
	}

	public void setPropVal(String propVal) {
		this.propVal = propVal;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

}
