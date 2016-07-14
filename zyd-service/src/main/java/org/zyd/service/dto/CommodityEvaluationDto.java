package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.EvaluationLevel;

public class CommodityEvaluationDto implements java.io.Serializable{
	private static final long serialVersionUID = -7505180912162616025L;
	
	private BigDecimal evalId;
    private EvaluationLevel evalLevel;
    private Integer numOfStars;
    private String evalContent;
    private Timestamp eventTs;
    private Boolean containsImage;
    private Boolean containsAddedEval;
    private Boolean forbidden;
    private BigDecimal cmmdtyId;
    private BigDecimal partyId;
    private BigDecimal orderId;

    public BigDecimal getEvalId() {
        return this.evalId;
    }

    public EvaluationLevel getEvalLevel() {
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

    public Boolean getContainsImage() {
        return this.containsImage;
    }

    public Boolean getContainsAddedEval() {
        return this.containsAddedEval;
    }

    public Boolean getForbidden() {
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

    public void setEvalId(BigDecimal evalId) {
        this.evalId = evalId;
    }

    public void setEvalLevel(EvaluationLevel evalLevel) {
        this.evalLevel = evalLevel;
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

}