package org.zyd.store.entity;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * LevelConfigEntity
 * 
 * @author GeJianKui
 */
public class LevelConfigEntity extends BaseEntity {

    private String level;
    private String levelBefore;
    private String levelAfter;

    public String getLevel() {
        return this.level;
    }

    public String getLevelBefore() {
        return this.levelBefore;
    }

    public String getLevelAfter() {
        return this.levelAfter;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public void setLevelBefore(String levelBefore) {
        this.levelBefore = levelBefore == null ? null : levelBefore.trim();
    }

    public void setLevelAfter(String levelAfter) {
        this.levelAfter = levelAfter == null ? null : levelAfter.trim();
    }

}