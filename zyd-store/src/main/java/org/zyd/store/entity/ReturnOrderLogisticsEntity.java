package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * ReturnOrderLogisticsEntity
 * 
 * @author GeJianKui
 */
public class ReturnOrderLogisticsEntity extends BaseEntity {

    private BigDecimal logisticsId;
    private String logisticsType;
    private String logisticsCompanyCode;
    private String logisticsCompanyDesc;
    private String logisticsNum;
    private BigDecimal logisticsAmt;
    private boolean freeLogisticsAmt;
    private BigDecimal returnOrderId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getLogisticsId() {
        return this.logisticsId;
    }

    public String getLogisticsType() {
        return this.logisticsType;
    }

    public String getLogisticsCompanyCode() {
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

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setLogisticsId(BigDecimal logisticsId) {
        this.logisticsId = logisticsId;
    }

    public void setLogisticsType(String logisticsType) {
        this.logisticsType = logisticsType == null ? null : logisticsType.trim();
    }

    public void setLogisticsCompanyCode(String logisticsCompanyCode) {
        this.logisticsCompanyCode = logisticsCompanyCode == null ? null : logisticsCompanyCode.trim();
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

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}