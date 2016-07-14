package org.zyd.store.term;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * DistrictTerm
 * 
 * @author GeJianKui
 */
public class DistrictTerm extends BaseTerm {

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
