package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.domain.bean.ShoppingCartItemBean;
import org.zyd.store.entity.ShoppingCartEntity;

public class ShoppingCartItemBeanImpl implements ShoppingCartItemBean {

    private ShoppingCartEntity entity;

    public ShoppingCartItemBeanImpl(ShoppingCartEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getShoppingId() {
        if (null == entity) {
            return null;
        }
        return entity.getShoppingId();
    }

    @Override
    public void setShoppingId(BigDecimal shoppingId) {
        if (null == entity) {
            entity = new ShoppingCartEntity();
        }
        entity.setShoppingId(shoppingId);
    }

    @Override
    public BigDecimal getCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyId();
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new ShoppingCartEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public Integer getQtyToBuy() {
        if (null == entity) {
            return null;
        }
        return entity.getQtyToBuy();
    }

    @Override
    public void setQtyToBuy(Integer qtyToBuy) {
        if (null == entity) {
            entity = new ShoppingCartEntity();
        }
        entity.setQtyToBuy(qtyToBuy);
    }

    @Override
    public Timestamp getAddTime() {
        if (null == entity) {
            return null;
        }
        return entity.getAddTime();
    }

    @Override
    public void setAddTime(Timestamp addTime) {
        if (null == entity) {
            entity = new ShoppingCartEntity();
        }
        entity.setAddTime(addTime);
    }

}
