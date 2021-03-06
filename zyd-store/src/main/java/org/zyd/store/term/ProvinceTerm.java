package org.zyd.store.term;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * ProvinceTerm
 * 
 * @author GeJianKui
 */
public class ProvinceTerm extends BaseTerm {

    private Integer proId;
    private String proName;
    private Integer sort;
    private String proRemark;

    public Integer getProId() {
        return this.proId;
    }

    public String getProName() {
        return this.proName;
    }

    public Integer getSort() {
        return this.sort;
    }

    public String getProRemark() {
        return this.proRemark;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public void setProRemark(String proRemark) {
        this.proRemark = proRemark == null ? null : proRemark.trim();
    }

}
