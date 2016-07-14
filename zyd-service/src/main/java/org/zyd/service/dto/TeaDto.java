package org.zyd.service.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.zyd.common.constants.TeaLevel;
import org.zyd.common.constants.TeaPacking;
import org.zyd.common.constants.TeaPriceRegion;
import org.zyd.common.constants.TeaType;

public class TeaDto extends CommodityDto implements java.io.Serializable{
	private static final long serialVersionUID = -5238917719285374729L;
	
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
	private TeaType teaType;
	private String placeOfOrigin;
	private TeaLevel level;
	private TeaPacking packing;
	private TeaPriceRegion priceRegion;

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

	public TeaType getTeaType() {
		return teaType;
	}

	public void setTeaType(TeaType teaType) {
		this.teaType = teaType;
	}

	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}

	public TeaLevel getLevel() {
		return level;
	}

	public void setLevel(TeaLevel level) {
		this.level = level;
	}

	public TeaPacking getPacking() {
		return packing;
	}

	public void setPacking(TeaPacking packing) {
		this.packing = packing;
	}

	public TeaPriceRegion getPriceRegion() {
		return priceRegion;
	}

	public void setPriceRegion(TeaPriceRegion priceRegion) {
		this.priceRegion = priceRegion;
	}
}
