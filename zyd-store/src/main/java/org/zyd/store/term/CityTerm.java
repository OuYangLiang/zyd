package org.zyd.store.term;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * CityTerm
 * 
 * @author GeJianKui
 */
public class CityTerm extends BaseTerm {

    private Integer cityId;
    private String cityName;
    private Integer proId;
    private Integer sort;

    public Integer getCityId() {
        return this.cityId;
    }

    public String getCityName() {
        return this.cityName;
    }

    public Integer getProId() {
        return this.proId;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}
