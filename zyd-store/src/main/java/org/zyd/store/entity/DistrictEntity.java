package org.zyd.store.entity;

import org.zyd.store.base.entity.BaseEntity;

/**
 * 
 * DistrictEntity
 * 
 * @author GeJianKui
 */
public class DistrictEntity extends BaseEntity {

    private Integer disId;
    private String disName;
    private Integer cityId;

    public Integer getDisId() {
        return this.disId;
    }

    public String getDisName() {
        return this.disName;
    }

    public Integer getCityId() {
        return this.cityId;
    }

    public void setDisId(Integer disId) {
        this.disId = disId;
    }

    public void setDisName(String disName) {
        this.disName = disName == null ? null : disName.trim();
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

}