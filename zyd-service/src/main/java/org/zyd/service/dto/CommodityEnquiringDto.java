package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CommodityEnquiringDto implements java.io.Serializable {
    private static final long serialVersionUID = -7412178810922232835L;

    private BigDecimal enquiringId;
    private String enquiringContent;
    private Timestamp eventTs;
    private BigDecimal cmmdtyId;
    private BigDecimal partyId;
    private String answerer;
    private String answer;
    private Timestamp answerTs;
    private String acntVal;

    public BigDecimal getEnquiringId() {
        return this.enquiringId;
    }

    public String getEnquiringContent() {
        return this.enquiringContent;
    }

    public Timestamp getEventTs() {
        return this.eventTs;
    }

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public String getAnswerer() {
        return this.answerer;
    }

    public String getAnswer() {
        return this.answer;
    }

    public Timestamp getAnswerTs() {
        return this.answerTs;
    }

    public void setEnquiringId(BigDecimal enquiringId) {
        this.enquiringId = enquiringId;
    }

    public void setEnquiringContent(String enquiringContent) {
        this.enquiringContent = enquiringContent == null ? null : enquiringContent.trim();
    }

    public void setEventTs(Timestamp eventTs) {
        this.eventTs = eventTs == null ? null : (Timestamp) eventTs.clone();
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

    public void setAnswerer(String answerer) {
        this.answerer = answerer == null ? null : answerer.trim();
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public void setAnswerTs(Timestamp answerTs) {
        this.answerTs = answerTs == null ? null : (Timestamp) answerTs.clone();
    }

    public String getAcntVal() {
        return acntVal;
    }

    public void setAcntVal(String acntVal) {
        this.acntVal = acntVal == null ? null : acntVal.trim();
    }

}