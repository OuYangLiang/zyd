package org.zyd.store.entity;

import java.sql.Timestamp;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * PropertyConfigEntity
 * 
 * @author GeJianKui
 */
public class PropertyConfigEntity extends BaseEntity {

    private String category;
    private String propName;
    private Integer seq;
    private Timestamp createTime;
    private Timestamp updateTime;

    public String getCategory() {
        return this.category;
    }

    public String getPropName() {
        return this.propName;
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

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public void setPropName(String propName) {
        this.propName = propName == null ? null : propName.trim();
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