package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * GiftContainingTerm
 * 
 * @author GeJianKui
 */
public class GiftContainingTerm extends BaseTerm {

    private BigDecimal relId;
    private BigDecimal giftId;
    private BigDecimal cmmdtyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getRelId() {
        return this.relId;
    }

    public BigDecimal getGiftId() {
        return this.giftId;
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

    public void setRelId(BigDecimal relId) {
        this.relId = relId;
    }

    public void setGiftId(BigDecimal giftId) {
        this.giftId = giftId;
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
