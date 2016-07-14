package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * LabelTerm
 * 
 * @author GeJianKui
 */
public class LabelTerm extends BaseTerm {

    private BigDecimal labelId;
    private String labelStyle;
    private String labelVal;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getLabelId() {
        return this.labelId;
    }

    public String getLabelStyle() {
        return this.labelStyle;
    }

    public String getLabelVal() {
        return this.labelVal;
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

    public void setLabelStyle(String labelStyle) {
        this.labelStyle = labelStyle == null ? null : labelStyle.trim();
    }

    public void setLabelVal(String labelVal) {
        this.labelVal = labelVal == null ? null : labelVal.trim();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
