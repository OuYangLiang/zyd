package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.ShoppingCartBean;
import org.zyd.domain.bean.ShoppingCartItemBean;
import org.zyd.store.entity.ShoppingCartEntity;
import org.zyd.store.mapper.ShoppingCartMapper;

public class ShoppingCartBeanImpl implements ShoppingCartBean {

    private List<ShoppingCartItemBean> items;
    private BigDecimal partyId;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public void addCommodity(BigDecimal cmmdtyId, int qty) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        Timestamp now = new Timestamp(new Date().getTime());
        ShoppingCartEntity entity = new ShoppingCartEntity();
        entity.setAddTime(now);
        entity.setCmmdtyId(cmmdtyId);
        entity.setQtyToBuy(qty);
        entity.setPartyId(this.getPartyId());
        entity.setCreateTime(now);
        entity.setUpdateTime(now);
        shoppingCartMapper.insert(entity);
    }

    @Override
    public void changeCommodityQty(BigDecimal cmmdtyId, int qty) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        Timestamp now = new Timestamp(new Date().getTime());
        ShoppingCartEntity entity = new ShoppingCartEntity();
        entity.setCmmdtyId(cmmdtyId);
        entity.setQtyToBuy(qty);
        entity.setPartyId(this.getPartyId());
        entity.setUpdateTime(now);
        shoppingCartMapper.updateByUserCmmdty(entity);
    }

    @Override
    public void removeCommodity(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        ShoppingCartEntity entity = new ShoppingCartEntity();
        entity.setCmmdtyId(cmmdtyId);
        entity.setPartyId(this.getPartyId());
        shoppingCartMapper.deleteByUserCmmdty(entity);
    }

    @Override
    public BigDecimal getPartyId() {
        return this.partyId;
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

    @Override
    public List<ShoppingCartItemBean> getItems() {
        return this.items;
    }

    @Override
    public void setItems(List<ShoppingCartItemBean> items) {
        this.items = items;
    }

    /*@Override
    public void save() throws ZydException {

        try {
            if (!CollectionUtils.isEmpty(items)) {
                for (ShoppingCartItemBean item : items) {
                    ShoppingCartEntity entity = new ShoppingCartEntity();
                    entity.setAddTime(item.getAddTime());
                    entity.setCmmdtyId(item.getCmmdtyId());
                    entity.setQtyToBuy(item.getQtyToBuy());
                    entity.setShoppingId(item.getShoppingId());
                    entity.setPartyId(this.getPartyId());

                    Timestamp now = new Timestamp(new Date().getTime());
                    entity.setUpdateTime(now);
                    if (null == entity.getShoppingId()) {
                        entity.setCreateTime(now);

                        shoppingCartMapper.insert(entity);
                    } else {
                        shoppingCartMapper.updateBySelective(entity);
                    }
                }
            }
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

    }*/

    /*@Override
    public void remove() throws ZydException {
        try {
            if (!CollectionUtils.isEmpty(items)) {
                for (ShoppingCartItemBean item : items) {
                    ShoppingCartEntity entity = new ShoppingCartEntity();
                    entity.setShoppingId(item.getShoppingId());
                    shoppingCartMapper.delete(entity);

                    item.setShoppingId(null);
                }
            }
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }*/
}
