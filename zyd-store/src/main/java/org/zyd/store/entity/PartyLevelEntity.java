package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * PartyLevelEntity
 * 
 * @author GeJianKui
 */
public class PartyLevelEntity extends BaseEntity {

    private BigDecimal partyId;
    private String level;
    private String levelChgType;
    private Timestamp levelChgTs;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public String getLevel() {
        return this.level;
    }

    public String getLevelChgType() {
        return this.levelChgType;
    }

    public Timestamp getLevelChgTs() {
        return this.levelChgTs;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public void setLevelChgType(String levelChgType) {
        this.levelChgType = levelChgType == null ? null : levelChgType.trim();
    }

    public void setLevelChgTs(Timestamp levelChgTs) {
        this.levelChgTs = levelChgTs == null ? null : (Timestamp) levelChgTs.clone();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}