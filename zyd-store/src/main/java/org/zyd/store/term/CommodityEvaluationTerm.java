package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * CommodityEvaluationTerm
 * 
 * @author GeJianKui
 */
public class CommodityEvaluationTerm extends BaseTerm {

    private BigDecimal evalId;
    private String evalLevel;
    private Integer numOfStars;
    private String evalContent;
    private Timestamp eventTs;
    private Boolean containsImage;
    private Boolean containsAddedEval;
    private Boolean forbidden;
    private BigDecimal cmmdtyId;
    private BigDecimal partyId;
    private BigDecimal orderId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getEvalId() {
        return this.evalId;
    }

    public String getEvalLevel() {
        return this.evalLevel;
    }

    public Integer getNumOfStars() {
        return this.numOfStars;
    }

    public String getEvalContent() {
        return this.evalContent;
    }

    public Timestamp getEventTs() {
        return this.eventTs;
    }

    public Boolean isContainsImage() {
        return this.containsImage;
    }

    public Boolean isContainsAddedEval() {
        return this.containsAddedEval;
    }

    public Boolean isForbidden() {
        return this.forbidden;
    }

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public BigDecimal getOrderId() {
        return this.orderId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setEvalId(BigDecimal evalId) {
        this.evalId = evalId;
    }

    public void setEvalLevel(String evalLevel) {
        this.evalLevel = evalLevel == null ? null : evalLevel.trim();
    }

    public void setNumOfStars(Integer numOfStars) {
        this.numOfStars = numOfStars;
    }

    public void setEvalContent(String evalContent) {
        this.evalContent = evalContent == null ? null : evalContent.trim();
    }

    public void setEventTs(Timestamp eventTs) {
        this.eventTs = eventTs == null ? null : (Timestamp) eventTs.clone();
    }

    public void setContainsImage(Boolean containsImage) {
        this.containsImage = containsImage;
    }

    public void setContainsAddedEval(Boolean containsAddedEval) {
        this.containsAddedEval = containsAddedEval;
    }

    public void setForbidden(Boolean forbidden) {
        this.forbidden = forbidden;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
