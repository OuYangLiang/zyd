package org.zyd.store.term;

import java.math.BigDecimal;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * RecommendedListTerm
 * 
 * @author GeJianKui
 */
public class RecommendedListTerm extends BaseTerm {

    private BigDecimal presenteeId;
    private BigDecimal partyId;

    public BigDecimal getPresenteeId() {
        return this.presenteeId;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public void setPresenteeId(BigDecimal presenteeId) {
        this.presenteeId = presenteeId;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

}
