package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.AddedEvalType;

public class AddedEvaluationDto implements java.io.Serializable{
	private static final long serialVersionUID = 9215555669458148145L;
	
	private BigDecimal addedEvalId;
    private AddedEvalType addedEvalType;
    private String addedEvalContent;
    private Timestamp eventTs;
    private BigDecimal evalId;

    public BigDecimal getAddedEvalId() {
        return this.addedEvalId;
    }

    public AddedEvalType getAddedEvalType() {
        return this.addedEvalType;
    }

    public String getAddedEvalContent() {
        return this.addedEvalContent;
    }

    public Timestamp getEventTs() {
        return this.eventTs;
    }

    public BigDecimal getEvalId() {
        return this.evalId;
    }

    public void setAddedEvalId(BigDecimal addedEvalId) {
        this.addedEvalId = addedEvalId;
    }

    public void setAddedEvalType(AddedEvalType addedEvalType) {
        this.addedEvalType = addedEvalType;
    }

    public void setAddedEvalContent(String addedEvalContent) {
        this.addedEvalContent = addedEvalContent == null ? null : addedEvalContent.trim();
    }

    public void setEventTs(Timestamp eventTs) {
        this.eventTs = eventTs == null ? null : (Timestamp) eventTs.clone();
    }

    public void setEvalId(BigDecimal evalId) {
        this.evalId = evalId;
    }

}