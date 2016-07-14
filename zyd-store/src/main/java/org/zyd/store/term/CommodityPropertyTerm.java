package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * CommodityPropertyTerm
 * 
 * @author GeJianKui
 */
public class CommodityPropertyTerm extends BaseTerm {

    private BigDecimal propertyId;
    private BigDecimal cmmdtyId;
    private String propName;
    private String propVal;
    private Integer seq;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getPropertyId() {
        return this.propertyId;
    }

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public String getPropName() {
        return this.propName;
    }

    public String getPropVal() {
        return this.propVal;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setPropertyId(BigDecimal propertyId) {
        this.propertyId = propertyId;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setPropName(String propName) {
        this.propName = propName == null ? null : propName.trim();
    }

    public void setPropVal(String propVal) {
        this.propVal = propVal == null ? null : propVal.trim();
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
