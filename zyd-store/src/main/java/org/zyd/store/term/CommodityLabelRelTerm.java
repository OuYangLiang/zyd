package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * CommodityLabelRelTerm
 * 
 * @author GeJianKui
 */
public class CommodityLabelRelTerm extends BaseTerm {

    private BigDecimal cmmdtyId;
    private BigDecimal labelId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public BigDecimal getLabelId() {
        return this.labelId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setLabelId(BigDecimal labelId) {
        this.labelId = labelId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
