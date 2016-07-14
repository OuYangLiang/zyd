package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * GiftTerm
 * 
 * @author GeJianKui
 */
public class GiftTerm extends BaseTerm {

    private BigDecimal giftId;
    private Integer seq;
    private BigDecimal cmmdtyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getGiftId() {
        return this.giftId;
    }

    public Integer getSeq() {
        return this.seq;
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

    public void setGiftId(BigDecimal giftId) {
        this.giftId = giftId;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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
