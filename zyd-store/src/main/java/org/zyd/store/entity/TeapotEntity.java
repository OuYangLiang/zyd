package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * TeapotEntity
 * 
 * @author GeJianKui
 */
public class TeapotEntity extends BaseEntity {

    private BigDecimal cmmdtyId;
    private String category;
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
    private String type;
    private String shape;
    private String material;
    private Integer size;
    private String level;
    private String producer;
    private String salesMode;
    private String priceRegion;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCmmdtyName() {
        return this.cmmdtyName;
    }

    public String getCmmdtyNum() {
        return this.cmmdtyNum;
    }

    public String getCmmdtyDesc() {
        return this.cmmdtyDesc;
    }

    public Integer getNumStored() {
        return this.numStored;
    }

    public Integer getNumSales() {
        return this.numSales;
    }

    public Integer getNumEvaluated() {
        return this.numEvaluated;
    }

    public BigDecimal getProposedPrice() {
        return this.proposedPrice;
    }

    public BigDecimal getCurrentPrice() {
        return this.currentPrice;
    }

    public Date getShelvesTime() {
        return this.shelvesTime;
    }

    public Date getUnshelvesTime() {
        return this.unshelvesTime;
    }

    public String getDefaultImageAddrs() {
        return this.defaultImageAddrs;
    }

    public String getType() {
        return this.type;
    }

    public String getShape() {
        return this.shape;
    }

    public String getMaterial() {
        return this.material;
    }

    public Integer getSize() {
        return this.size;
    }

    public String getLevel() {
        return this.level;
    }

    public String getProducer() {
        return this.producer;
    }

    public String getSalesMode() {
        return this.salesMode;
    }

    public String getPriceRegion() {
        return this.priceRegion;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public void setCmmdtyName(String cmmdtyName) {
        this.cmmdtyName = cmmdtyName == null ? null : cmmdtyName.trim();
    }

    public void setCmmdtyNum(String cmmdtyNum) {
        this.cmmdtyNum = cmmdtyNum == null ? null : cmmdtyNum.trim();
    }

    public void setCmmdtyDesc(String cmmdtyDesc) {
        this.cmmdtyDesc = cmmdtyDesc == null ? null : cmmdtyDesc.trim();
    }

    public void setNumStored(Integer numStored) {
        this.numStored = numStored;
    }

    public void setNumSales(Integer numSales) {
        this.numSales = numSales;
    }

    public void setNumEvaluated(Integer numEvaluated) {
        this.numEvaluated = numEvaluated;
    }

    public void setProposedPrice(BigDecimal proposedPrice) {
        this.proposedPrice = proposedPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setShelvesTime(Date shelvesTime) {
        this.shelvesTime = shelvesTime == null ? null : (Date) shelvesTime.clone();
    }

    public void setUnshelvesTime(Date unshelvesTime) {
        this.unshelvesTime = unshelvesTime == null ? null : (Date) unshelvesTime.clone();
    }

    public void setDefaultImageAddrs(String defaultImageAddrs) {
        this.defaultImageAddrs = defaultImageAddrs == null ? null : defaultImageAddrs.trim();
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public void setShape(String shape) {
        this.shape = shape == null ? null : shape.trim();
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public void setProducer(String producer) {
        this.producer = producer == null ? null : producer.trim();
    }

    public void setSalesMode(String salesMode) {
        this.salesMode = salesMode == null ? null : salesMode.trim();
    }

    public void setPriceRegion(String priceRegion) {
        this.priceRegion = priceRegion == null ? null : priceRegion.trim();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

	public Integer getNumEnquired() {
		return numEnquired;
	}

	public void setNumEnquired(Integer numEnquired) {
		this.numEnquired = numEnquired;
	}

}