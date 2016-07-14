package org.zyd.store.entity;

import java.math.BigDecimal;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * LevelRightsRelEntity
 * 
 * @author GeJianKui
 */
public class LevelRightsRelEntity extends BaseEntity {

    private String level;
    private String rights;
    private BigDecimal levelRightsRate;
    private Integer limitTimes;
    private BigDecimal limitVal;

    public String getLevel() {
        return this.level;
    }

    public String getRights() {
        return this.rights;
    }

    public BigDecimal getLevelRightsRate() {
        return this.levelRightsRate;
    }

    public Integer getLimitTimes() {
        return this.limitTimes;
    }

    public BigDecimal getLimitVal() {
        return this.limitVal;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public void setRights(String rights) {
        this.rights = rights == null ? null : rights.trim();
    }

    public void setLevelRightsRate(BigDecimal levelRightsRate) {
        this.levelRightsRate = levelRightsRate;
    }

    public void setLimitTimes(Integer limitTimes) {
        this.limitTimes = limitTimes;
    }

    public void setLimitVal(BigDecimal limitVal) {
        this.limitVal = limitVal;
    }

}