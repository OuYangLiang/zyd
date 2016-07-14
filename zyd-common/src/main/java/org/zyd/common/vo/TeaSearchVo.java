package org.zyd.common.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TeaSearchVo {

    private String cmmdtyNum;
    private Integer numSales;
    private BigDecimal currentPrice;
    private Date shelvesTime;
    private String teaType;
    private String placeOfOrigin;
    private String level;
    private String packing;
    private String priceRegion;

    public String getCmmdtyNum() {
        return cmmdtyNum;
    }

    public void setCmmdtyNum(String cmmdtyNum) {
        this.cmmdtyNum = cmmdtyNum;
    }

    public Integer getNumSales() {
        return numSales;
    }

    public void setNumSales(Integer numSales) {
        this.numSales = numSales;
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

    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getPriceRegion() {
        return priceRegion;
    }

    public void setPriceRegion(String priceRegion) {
        this.priceRegion = priceRegion;
    }

}
