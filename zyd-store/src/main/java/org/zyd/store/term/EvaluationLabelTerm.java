package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * EvaluationLabelTerm
 * 
 * @author GeJianKui
 */
public class EvaluationLabelTerm extends BaseTerm {

    private BigDecimal labelId;
    private String label;
    private Integer hitTimes;
    private BigDecimal cmmdtyId;
    private Timestamp createTime;
    private Timestamp updateTime;

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

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
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

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
