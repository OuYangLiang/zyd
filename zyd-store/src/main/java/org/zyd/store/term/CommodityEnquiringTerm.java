package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * CommodityEnquiringTerm
 * 
 * @author GeJianKui
 */
public class CommodityEnquiringTerm extends BaseTerm {

    private BigDecimal enquiringId;
    private String enquiringContent;
    private Timestamp eventTs;
    private BigDecimal cmmdtyId;
    private BigDecimal partyId;
    private String answerer;
    private String answer;
    private Timestamp answerTs;
    private Timestamp createTime;
    private Timestamp updateTime;

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

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
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

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
