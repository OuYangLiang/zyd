package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * RepositoryHistoryTerm
 * 
 * @author GeJianKui
 */
public class RepositoryHistoryTerm extends BaseTerm {

    private BigDecimal hisId;
    private String chgType;
    private Timestamp eventTs;
    private Integer numStoredBefore;
    private Integer chgQty;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private String operator;
    private BigDecimal cmmdtyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getHisId() {
        return this.hisId;
    }

    public String getChgType() {
        return this.chgType;
    }

    public Timestamp getEventTs() {
        return this.eventTs;
    }

    public Integer getNumStoredBefore() {
        return this.numStoredBefore;
    }

    public Integer getChgQty() {
        return this.chgQty;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public String getOperator() {
        return this.operator;
    }

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setHisId(BigDecimal hisId) {
        this.hisId = hisId;
    }

    public void setChgType(String chgType) {
        this.chgType = chgType == null ? null : chgType.trim();
    }

    public void setEventTs(Timestamp eventTs) {
        this.eventTs = eventTs == null ? null : (Timestamp) eventTs.clone();
    }

    public void setNumStoredBefore(Integer numStoredBefore) {
        this.numStoredBefore = numStoredBefore;
    }

    public void setChgQty(Integer chgQty) {
        this.chgQty = chgQty;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
