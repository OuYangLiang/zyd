package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * OrderLogisticsEntity
 * 
 * @author GeJianKui
 */
public class OrderLogisticsEntity extends BaseEntity {

    private BigDecimal orderId;
    private String logisticsCompanyCode;
    private String logisticsCompanyDesc;
    private String logisticsNum;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getOrderId() {
        return this.orderId;
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

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
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

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}