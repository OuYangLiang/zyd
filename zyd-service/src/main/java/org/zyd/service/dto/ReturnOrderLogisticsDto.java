package org.zyd.service.dto;

import java.math.BigDecimal;

import org.zyd.common.constants.LogisticsCompCode;
import org.zyd.common.constants.ReturnOrderLogisticsType;

public class ReturnOrderLogisticsDto implements java.io.Serializable{
	private static final long serialVersionUID = -7162356108419326695L;
	
	private BigDecimal logisticsId;
    private ReturnOrderLogisticsType logisticsType;
    private LogisticsCompCode logisticsCompanyCode;
    private String logisticsCompanyDesc;
    private String logisticsNum;
    private BigDecimal logisticsAmt;
    private boolean freeLogisticsAmt;
    private BigDecimal returnOrderId;

    public BigDecimal getLogisticsId() {
        return this.logisticsId;
    }

    public ReturnOrderLogisticsType getLogisticsType() {
        return this.logisticsType;
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

    public BigDecimal getLogisticsAmt() {
        return this.logisticsAmt;
    }

    public boolean isFreeLogisticsAmt() {
        return this.freeLogisticsAmt;
    }

    public BigDecimal getReturnOrderId() {
        return this.returnOrderId;
    }

    public void setLogisticsId(BigDecimal logisticsId) {
        this.logisticsId = logisticsId;
    }

    public void setLogisticsType(ReturnOrderLogisticsType logisticsType) {
        this.logisticsType = logisticsType;
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

    public void setLogisticsAmt(BigDecimal logisticsAmt) {
        this.logisticsAmt = logisticsAmt;
    }

    public void setFreeLogisticsAmt(boolean freeLogisticsAmt) {
        this.freeLogisticsAmt = freeLogisticsAmt;
    }

    public void setReturnOrderId(BigDecimal returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

}