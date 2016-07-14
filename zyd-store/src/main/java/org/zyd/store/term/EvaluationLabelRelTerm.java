package org.zyd.store.term;

import java.math.BigDecimal;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * EvaluationLabelRelTerm
 * 
 * @author GeJianKui
 */
public class EvaluationLabelRelTerm extends BaseTerm {

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
