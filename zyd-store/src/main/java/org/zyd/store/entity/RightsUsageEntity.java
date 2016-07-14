package org.zyd.store.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * RightsUsageEntity
 * 
 * @author GeJianKui
 */
public class RightsUsageEntity extends BaseEntity {

    private BigDecimal eventId;
    private String level;
    private String rights;
    private String eventTs;
    private BigDecimal partyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getEventId() {
        return this.eventId;
    }

    public String getLevel() {
        return this.level;
    }

    public String getRights() {
        return this.rights;
    }

    public String getEventTs() {
        return this.eventTs;
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

    public void setEventId(BigDecimal eventId) {
        this.eventId = eventId;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public void setRights(String rights) {
        this.rights = rights == null ? null : rights.trim();
    }

    public void setEventTs(String eventTs) {
        this.eventTs = eventTs == null ? null : eventTs.trim();
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