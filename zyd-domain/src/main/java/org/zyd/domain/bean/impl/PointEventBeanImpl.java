package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.PointEventBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.Scenario;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.PointEventEntity;
import org.zyd.store.mapper.PointEventMapper;

public class PointEventBeanImpl implements PointEventBean {

    private PointEventEntity entity;

    @Autowired
    private PointEventMapper pointEventMapper;

    public PointEventBeanImpl(PointEventEntity entity) {
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
    public Scenario getScenario() {
        if (null == entity) {
            return null;
        }
        return Scenario.valueOf(entity.getScenario());
    }

    @Override
    public Timestamp getEventTs() {
        if (null == entity) {
            return null;
        }
        return entity.getEventTs();
    }

    @Override
    public String getOrderNum() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderNum();
    }

    @Override
    public String getReturnOrderNum() {
        if (null == entity) {
            return null;
        }
        return entity.getReturnOrderNum();
    }

    @Override
    public BigDecimal getOrderAmt() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderAmt();
    }

    @Override
    public BigDecimal getChangeQty() {
        if (null == entity) {
            return null;
        }
        return entity.getChangeQty();
    }

    @Override
    public BigDecimal getPointBalanceBefore() {
        if (null == entity) {
            return null;
        }
        return entity.getPointBalanceBefore();
    }

    @Override
    public BigDecimal getPartyId() {
        if (null == entity) {
            return null;
        }
        return entity.getPartyId();
    }

    @Override
    public void setEventId(BigDecimal eventId) {
        if (null == entity) {
            entity = new PointEventEntity();
        }
        entity.setEventId(eventId);
    }

    @Override
    public void setScenario(Scenario scenario) {
        if (null == entity) {
            entity = new PointEventEntity();
        }
        entity.setScenario(scenario.name());
    }

    @Override
    public void setEventTs(Timestamp eventTs) {
        if (null == entity) {
            entity = new PointEventEntity();
        }
        entity.setEventTs(eventTs);
    }

    @Override
    public void setOrderNum(String orderNum) {
        if (null == entity) {
            entity = new PointEventEntity();
        }
        entity.setOrderNum(orderNum);
    }

    @Override
    public void setReturnOrderNum(String returnOrderNum) {
        if (null == entity) {
            entity = new PointEventEntity();
        }
        entity.setReturnOrderNum(returnOrderNum);
    }

    @Override
    public void setOrderAmt(BigDecimal orderAmt) {
        if (null == entity) {
            entity = new PointEventEntity();
        }
        entity.setOrderAmt(orderAmt);
    }

    @Override
    public void setChangeQty(BigDecimal changeQty) {
        if (null == entity) {
            entity = new PointEventEntity();
        }
        entity.setChangeQty(changeQty);
    }

    @Override
    public void setPointBalanceBefore(BigDecimal pointBalanceBefore) {
        if (null == entity) {
            entity = new PointEventEntity();
        }
        entity.setPointBalanceBefore(pointBalanceBefore);
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new PointEventEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            pointEventMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            pointEventMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            pointEventMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setEventId(null);
        }
    }

}
