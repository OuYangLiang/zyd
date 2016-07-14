package org.zyd.service.dto;

import java.math.BigDecimal;

public class EvaluationLabelDto implements java.io.Serializable{
	private static final long serialVersionUID = -6263378135052129793L;
	
	private BigDecimal labelId;
    private String label;
    private Integer hitTimes;
    private BigDecimal cmmdtyId;

    public BigDecimal getLabelId() {
        return this.labelId;
    }

    public String getLabel() {
        return this.label;
    }

    public Integer getHitTimes() {
        return this.hitTimes;
    }

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public void setLabelId(BigDecimal labelId) {
        this.labelId = labelId;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public void setHitTimes(Integer hitTimes) {
        this.hitTimes = hitTimes;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

}