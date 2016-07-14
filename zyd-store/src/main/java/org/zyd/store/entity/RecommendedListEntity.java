package org.zyd.store.entity;

import java.math.BigDecimal;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * RecommendedListEntity
 * 
 * @author GeJianKui
 */
public class RecommendedListEntity extends BaseEntity {

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