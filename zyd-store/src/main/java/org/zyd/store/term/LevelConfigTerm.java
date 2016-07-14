package org.zyd.store.term;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * LevelConfigTerm
 * 
 * @author GeJianKui
 */
public class LevelConfigTerm extends BaseTerm {

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
