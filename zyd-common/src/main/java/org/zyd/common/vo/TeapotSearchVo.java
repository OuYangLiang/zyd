package org.zyd.common.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TeapotSearchVo implements java.io.Serializable{
    private static final long serialVersionUID = 8097056387310914027L;
    
    private String category;
    private Integer numSales;
    private Integer numEvaluated;
    private BigDecimal currentPrice;
    private Date shelvesTime;
    private String type;
    private String shape;
    private String material;
    private Integer size;
    private String level;
    private String priceRegion;

    public String getCategory() {
        return this.category;
    }

    public Integer getNumSales() {
        return this.numSales;
    }

    public Integer getNumEvaluated() {
        return this.numEvaluated;
    }

    public BigDecimal getCurrentPrice() {
        return this.currentPrice;
    }

    public Date getShelvesTime() {
        return this.shelvesTime;
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

    public String getPriceRegion() {
        return this.priceRegion;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNumSales(Integer numSales) {
        this.numSales = numSales;
    }

    public void setNumEvaluated(Integer numEvaluated) {
        this.numEvaluated = numEvaluated;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setShelvesTime(Date shelvesTime) {
        this.shelvesTime = shelvesTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setPriceRegion(String priceRegion) {
        this.priceRegion = priceRegion;
    }

}
