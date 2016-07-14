package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.OrderEventBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.OrderEventEntity;
import org.zyd.store.mapper.OrderEventMapper;

public class OrderEventBeanImpl implements OrderEventBean {

    private OrderEventEntity entity;

    @Autowired
    private OrderEventMapper orderEventMapper;

    public OrderEventBeanImpl(OrderEventEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getEventId() {
        if (null == entity) {
            return null;
        }
        return entity.getEventId();
    }

    @Override
    public Timestamp getEventTs() {
        if (null == entity) {
            return null;
        }
        return entity.getEventTs();
    }

    @Override
    public String getEventDesc() {
        if (null == entity) {
            return null;
        }
        return entity.getEventDesc();
    }

    @Override
    public BigDecimal getOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderId();
    }

    @Override
    public void setEventId(BigDecimal eventId) {
        if (null == entity) {
            entity = new OrderEventEntity();
        }
        entity.setEventId(eventId);
    }

    @Override
    public void setEventTs(Timestamp eventTs) {
        if (null == entity) {
            entity = new OrderEventEntity();
        }
        entity.setEventTs(eventTs);
    }

    @Override
    public void setEventDesc(String eventDesc) {
        if (null == entity) {
            entity = new OrderEventEntity();
        }
        entity.setEventDesc(eventDesc);
    }

    @Override
    public void setOrderId(BigDecimal orderId) {
        if (null == entity) {
            entity = new OrderEventEntity();
        }
        entity.setOrderId(orderId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            orderEventMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            orderEventMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            orderEventMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setEventId(null);
        }
    }

}
