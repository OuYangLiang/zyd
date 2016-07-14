package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * CommodityEntity
 * 
 * @author GeJianKui
 */
public class CommodityEntity extends BaseEntity {

    private BigDecimal cmmdtyId;
    private String category;
    private String introducer;
    private String auditor;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public String getCategory() {
        return this.category;
    }

    public String getIntroducer() {
        return this.introducer;
    }

    public String getAuditor() {
        return this.auditor;
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

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public void setIntroducer(String introducer) {
        this.introducer = introducer == null ? null : introducer.trim();
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}