package org.zyd.store.entity;

import java.math.BigDecimal;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * EvaluationLabelRelEntity
 * 
 * @author GeJianKui
 */
public class EvaluationLabelRelEntity extends BaseEntity {

    private BigDecimal evalId;
    private BigDecimal labelId;

    public BigDecimal getEvalId() {
        return this.evalId;
    }

    public BigDecimal getLabelId() {
        return this.labelId;
    }

    public void setEvalId(BigDecimal evalId) {
        this.evalId = evalId;
    }

    public void setLabelId(BigDecimal labelId) {
        this.labelId = labelId;
    }

}