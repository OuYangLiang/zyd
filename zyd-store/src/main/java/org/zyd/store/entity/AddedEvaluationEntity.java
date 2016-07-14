package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * AddedEvaluationEntity
 * 
 * @author GeJianKui
 */
public class AddedEvaluationEntity extends BaseEntity {

    private BigDecimal addedEvalId;
    private String addedEvalType;
    private String addedEvalContent;
    private Timestamp eventTs;
    private BigDecimal evalId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getAddedEvalId() {
        return this.addedEvalId;
    }

    public String getAddedEvalType() {
        return this.addedEvalType;
    }

    public String getAddedEvalContent() {
        return this.addedEvalContent;
    }

    public Timestamp getEventTs() {
        return this.eventTs;
    }

    public BigDecimal getEvalId() {
        return this.evalId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setAddedEvalId(BigDecimal addedEvalId) {
        this.addedEvalId = addedEvalId;
    }

    public void setAddedEvalType(String addedEvalType) {
        this.addedEvalType = addedEvalType == null ? null : addedEvalType.trim();
    }

    public void setAddedEvalContent(String addedEvalContent) {
        this.addedEvalContent = addedEvalContent == null ? null : addedEvalContent.trim();
    }

    public void setEventTs(Timestamp eventTs) {
        this.eventTs = eventTs == null ? null : (Timestamp) eventTs.clone();
    }

    public void setEvalId(BigDecimal evalId) {
        this.evalId = evalId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}