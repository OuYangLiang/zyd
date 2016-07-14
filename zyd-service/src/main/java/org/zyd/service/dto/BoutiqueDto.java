package org.zyd.service.dto;

import java.math.BigDecimal;
import java.util.Date;

public class BoutiqueDto extends CommodityDto implements java.io.Serializable{
	private static final long serialVersionUID = 247979495070745181L;
	
	private String cmmdtyName;
	private String cmmdtyNum;
	private String cmmdtyDesc;
	private Integer numStored;
	private Integer numSales;
	private Integer numEvaluated;
	private Integer numEnquired;
	private BigDecimal proposedPrice;
	private BigDecimal currentPrice;
	private Date shelvesTime;
	private Date unshelvesTime;
	private String defaultImageAddrs;

	public String getCmmdtyName() {
		return cmmdtyName;
	}

	public void setCmmdtyName(String cmmdtyName) {
		this.cmmdtyName = cmmdtyName;
	}

	public String getCmmdtyNum() {
		return cmmdtyNum;
	}

	public void setCmmdtyNum(String cmmdtyNum) {
		this.cmmdtyNum = cmmdtyNum;
	}

	public String getCmmdtyDesc() {
		return cmmdtyDesc;
	}

	public void setCmmdtyDesc(String cmmdtyDesc) {
		this.cmmdtyDesc = cmmdtyDesc;
	}

	public Integer getNumStored() {
		return numStored;
	}

	public void setNumStored(Integer numStored) {
		this.numStored = numStored;
	}

	public Integer getNumSales() {
		return numSales;
	}

	public void setNumSales(Integer numSales) {
		this.numSales = numSales;
	}

	public Integer getNumEvaluated() {
		return numEvaluated;
	}

	public void setNumEvaluated(Integer numEvaluated) {
		this.numEvaluated = numEvaluated;
	}
	
	public Integer getNumEnquired() {
		return numEnquired;
	}

	public void setNumEnquired(Integer numEnquired) {
		this.numEnquired = numEnquired;
	}

	public BigDecimal getProposedPrice() {
		return proposedPrice;
	}

	public void setProposedPrice(BigDecimal proposedPrice) {
		this.proposedPrice = proposedPrice;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getShelvesTime() {
		return shelvesTime;
	}

	public void setShelvesTime(Date shelvesTime) {
		this.shelvesTime = shelvesTime;
	}

	public Date getUnshelvesTime() {
		return unshelvesTime;
	}

	public void setUnshelvesTime(Date unshelvesTime) {
		this.unshelvesTime = unshelvesTime;
	}

	public String getDefaultImageAddrs() {
		return defaultImageAddrs;
	}

	public void setDefaultImageAddrs(String defaultImageAddrs) {
		this.defaultImageAddrs = defaultImageAddrs;
	}
}
