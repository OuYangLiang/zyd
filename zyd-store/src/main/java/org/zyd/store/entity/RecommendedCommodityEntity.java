package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * RecommendedCommodityEntity
 * 
 * @author GeJianKui
 */
public class RecommendedCommodityEntity extends BaseEntity {

    private BigDecimal cmmdtyId;
    private BigDecimal recommendedCmmdtyId;
    private Integer seq;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public BigDecimal getRecommendedCmmdtyId() {
        return this.recommendedCmmdtyId;
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

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setRecommendedCmmdtyId(BigDecimal recommendedCmmdtyId) {
        this.recommendedCmmdtyId = recommendedCmmdtyId;
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