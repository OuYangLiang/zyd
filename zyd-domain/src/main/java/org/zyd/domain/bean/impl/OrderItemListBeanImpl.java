package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.OrderItemListBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.OrderItemListEntity;
import org.zyd.store.mapper.OrderItemListMapper;

public class OrderItemListBeanImpl implements OrderItemListBean {

    private OrderItemListEntity entity;

    @Autowired
    private OrderItemListMapper orderItemListMapper;

    public OrderItemListBeanImpl(OrderItemListEntity entity) {
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
    public BigDecimal getOrderCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderCmmdtyId();
    }

    @Override
    public void setItemId(BigDecimal itemId) {
        if (null == entity) {
            entity = new OrderItemListEntity();
        }
        entity.setItemId(itemId);
    }

    @Override
    public void setItemDesc(String itemDesc) {
        if (null == entity) {
            entity = new OrderItemListEntity();
        }
        entity.setItemDesc(itemDesc);
    }

    @Override
    public void setItemQty(Integer itemQty) {
        if (null == entity) {
            entity = new OrderItemListEntity();
        }
        entity.setItemQty(itemQty);
    }

    @Override
    public void setOrderCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new OrderItemListEntity();
        }
        entity.setOrderCmmdtyId(cmmdtyId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            orderItemListMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            orderItemListMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            orderItemListMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setItemId(null);
        }
    }
}
