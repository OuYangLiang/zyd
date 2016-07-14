package org.zyd.service.dto;

import java.math.BigDecimal;

import org.zyd.common.constants.LogisticsCompCode;

public class OrderLogisticsDto implements java.io.Serializable{
	private static final long serialVersionUID = -5189111127941846376L;
	
	private BigDecimal orderId;
    private LogisticsCompCode logisticsCompanyCode;
    private String logisticsCompanyDesc;
    private String logisticsNum;

    public BigDecimal getOrderId() {
        return this.orderId;
    }

    public LogisticsCompCode getLogisticsCompanyCode() {
        return this.logisticsCompanyCode;
    }

    public String getLogisticsCompanyDesc() {
        return this.logisticsCompanyDesc;
    }

    public String getLogisticsNum() {
        return this.logisticsNum;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public void setLogisticsCompanyCode(LogisticsCompCode logisticsCompanyCode) {
        this.logisticsCompanyCode = logisticsCompanyCode;
    }

    public void setLogisticsCompanyDesc(String logisticsCompanyDesc) {
        this.logisticsCompanyDesc = logisticsCompanyDesc == null ? null : logisticsCompanyDesc.trim();
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum == null ? null : logisticsNum.trim();
    }

}