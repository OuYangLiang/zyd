package org.zyd.store.term;

import java.math.BigDecimal;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * LevelFactorConfigTerm
 * 
 * @author GeJianKui
 */
public class LevelFactorConfigTerm extends BaseTerm {

    private String level;
    private String factor;
    private BigDecimal factorVal;

    public String getLevel() {
        return this.level;
    }

    public String getFactor() {
        return this.factor;
    }

    public BigDecimal getFactorVal() {
        return this.factorVal;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public void setFactor(String factor) {
        this.factor = factor == null ? null : factor.trim();
    }

    public void setFactorVal(BigDecimal factorVal) {
        this.factorVal = factorVal;
    }

}
