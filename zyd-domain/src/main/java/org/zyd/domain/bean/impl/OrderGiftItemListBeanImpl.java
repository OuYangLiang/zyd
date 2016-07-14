package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.OrderGiftItemListBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.OrderGiftItemListEntity;
import org.zyd.store.mapper.OrderGiftItemListMapper;

public class OrderGiftItemListBeanImpl implements OrderGiftItemListBean {

    private OrderGiftItemListEntity entity;

    @Autowired
    private OrderGiftItemListMapper orderGiftItemListMapper;

    public OrderGiftItemListBeanImpl(OrderGiftItemListEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getItemId() {
        if (null == entity) {
            return null;
        }
        return entity.getItemId();
    }

    @Override
    public String getItemDesc() {
        if (null == entity) {
            return null;
        }
        return entity.getItemDesc();
    }

    @Override
    public Integer getItemQty() {
        if (null == entity) {
            return null;
        }
        return entity.getItemQty();
    }

    @Override
    public BigDecimal getOrderGiftId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderGiftId();
    }

    @Override
    public void setItemId(BigDecimal itemId) {
        if (null == entity) {
            entity = new OrderGiftItemListEntity();
        }
        entity.setItemId(itemId);
    }

    @Override
    public void setItemDesc(String itemDesc) {
        if (null == entity) {
            entity = new OrderGiftItemListEntity();
        }
        entity.setItemDesc(itemDesc);
    }

    @Override
    public void setItemQty(Integer itemQty) {
        if (null == entity) {
            entity = new OrderGiftItemListEntity();
        }
        entity.setItemQty(itemQty);
    }

    @Override
    public void setOrderGiftId(BigDecimal orderGiftId) {
        if (null == entity) {
            entity = new OrderGiftItemListEntity();
        }
        entity.setOrderGiftId(orderGiftId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            orderGiftItemListMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            orderGiftItemListMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            orderGiftItemListMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setItemId(null);
        }
    }

}
