package org.zyd.service.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.zyd.common.constants.SalesMode;
import org.zyd.common.constants.TeapotLevel;
import org.zyd.common.constants.TeapotMaterial;
import org.zyd.common.constants.TeapotPriceRegion;
import org.zyd.common.constants.TeapotShape;
import org.zyd.common.constants.TeapotType;

public class TeapotDto extends CommodityDto implements java.io.Serializable{
	private static final long serialVersionUID = 8534380269365225031L;
	
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
	private TeapotType type;
	private TeapotShape shape;
	private TeapotMaterial material;
	private Integer size;
	private TeapotLevel level;
	private String producer;
	private SalesMode salesMode;
	private TeapotPriceRegion priceRegion;

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

	public TeapotType getType() {
		return type;
	}

	public void setType(TeapotType type) {
		this.type = type;
	}

	public TeapotShape getShape() {
		return shape;
	}

	public void setShape(TeapotShape shape) {
		this.shape = shape;
	}

	public TeapotMaterial getMaterial() {
		return material;
	}

	public void setMaterial(TeapotMaterial material) {
		this.material = material;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public TeapotLevel getLevel() {
		return level;
	}

	public void setLevel(TeapotLevel level) {
		this.level = level;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public SalesMode getSalesMode() {
		return salesMode;
	}

	public void setSalesMode(SalesMode salesMode) {
		this.salesMode = salesMode;
	}

	public TeapotPriceRegion getPriceRegion() {
		return priceRegion;
	}

	public void setPriceRegion(TeapotPriceRegion priceRegion) {
		this.priceRegion = priceRegion;
	}

}
