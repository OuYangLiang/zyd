package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.ReturnOrderEventBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.ReturnOrderEventEntity;
import org.zyd.store.mapper.ReturnOrderEventMapper;

public class ReturnOrderEventBeanImpl implements ReturnOrderEventBean {

    private ReturnOrderEventEntity entity;

    @Autowired
    private ReturnOrderEventMapper returnOrderEventMapper;

    public ReturnOrderEventBeanImpl(ReturnOrderEventEntity entity) {
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
    public BigDecimal getReturnOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getReturnOrderId();
    }

    @Override
    public void setEventId(BigDecimal eventId) {
        if (null == entity) {
            entity = new ReturnOrderEventEntity();
        }
        entity.setEventId(eventId);
    }

    @Override
    public void setEventTs(Timestamp eventTs) {
        if (null == entity) {
            entity = new ReturnOrderEventEntity();
        }
        entity.setEventTs(eventTs);
    }

    @Override
    public void setEventDesc(String eventDesc) {
        if (null == entity) {
            entity = new ReturnOrderEventEntity();
        }
        entity.setEventDesc(eventDesc);
    }

    @Override
    public void setReturnOrderId(BigDecimal returnOrderId) {
        if (null == entity) {
            entity = new ReturnOrderEventEntity();
        }
        entity.setReturnOrderId(returnOrderId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            returnOrderEventMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            returnOrderEventMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            returnOrderEventMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setEventId(null);
        }
    }

}
