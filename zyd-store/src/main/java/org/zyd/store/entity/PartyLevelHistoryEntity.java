package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * PartyLevelHistoryEntity
 * 
 * @author GeJianKui
 */
public class PartyLevelHistoryEntity extends BaseEntity {

    private BigDecimal hisId;
    private String levelChgType;
    private Timestamp levelChgTs;
    private String levelBefore;
    private String levelAfter;
    private BigDecimal partyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getHisId() {
        return this.hisId;
    }

    public String getLevelChgType() {
        return this.levelChgType;
    }

    public Timestamp getLevelChgTs() {
        return this.levelChgTs;
    }

    public String getLevelBefore() {
        return this.levelBefore;
    }

    public String getLevelAfter() {
        return this.levelAfter;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setHisId(BigDecimal hisId) {
        this.hisId = hisId;
    }

    public void setLevelChgType(String levelChgType) {
        this.levelChgType = levelChgType == null ? null : levelChgType.trim();
    }

    public void setLevelChgTs(Timestamp levelChgTs) {
        this.levelChgTs = levelChgTs == null ? null : (Timestamp) levelChgTs.clone();
    }

    public void setLevelBefore(String levelBefore) {
        this.levelBefore = levelBefore == null ? null : levelBefore.trim();
    }

    public void setLevelAfter(String levelAfter) {
        this.levelAfter = levelAfter == null ? null : levelAfter.trim();
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}