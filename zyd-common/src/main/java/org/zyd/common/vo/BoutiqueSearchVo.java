package org.zyd.common.vo;

import java.math.BigDecimal;
import java.util.Date;

public class BoutiqueSearchVo {

    private String category;
    private String cmmdtyNum;
    private Integer numSales;
    private BigDecimal currentPrice;
    private Date shelvesTime;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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

}
