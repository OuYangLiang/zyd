package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * EvaluationImageEntity
 * 
 * @author GeJianKui
 */
public class EvaluationImageEntity extends BaseEntity {

    private BigDecimal imageId;
    private BigDecimal evalId;
    private Integer imageSeq;
    private String imageAddrs;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getImageId() {
        return this.imageId;
    }

    public BigDecimal getEvalId() {
        return this.evalId;
    }

    public Integer getImageSeq() {
        return this.imageSeq;
    }

    public String getImageAddrs() {
        return this.imageAddrs;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setImageId(BigDecimal imageId) {
        this.imageId = imageId;
    }

    public void setEvalId(BigDecimal evalId) {
        this.evalId = evalId;
    }

    public void setImageSeq(Integer imageSeq) {
        this.imageSeq = imageSeq;
    }

    public void setImageAddrs(String imageAddrs) {
        this.imageAddrs = imageAddrs == null ? null : imageAddrs.trim();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}