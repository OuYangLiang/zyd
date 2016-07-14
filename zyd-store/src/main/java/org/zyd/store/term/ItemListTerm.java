package org.zyd.store.term;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * ItemListTerm
 * 
 * @author GeJianKui
 */
public class ItemListTerm extends BaseTerm {

    private BigDecimal itemId;
    private String itemDesc;
    private Integer itemQty;
    private BigDecimal cmmdtyId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public BigDecimal getItemId() {
        return this.itemId;
    }

    public String getItemDesc() {
        return this.itemDesc;
    }

    public Integer getItemQty() {
        return this.itemQty;
    }

    public BigDecimal getCmmdtyId() {
        return this.cmmdtyId;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setItemId(BigDecimal itemId) {
        this.itemId = itemId;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    public void setCmmdtyId(BigDecimal cmmdtyId) {
        this.cmmdtyId = cmmdtyId;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime == null ? null : (Timestamp) createTime.clone();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime == null ? null : (Timestamp) updateTime.clone();
    }

}
