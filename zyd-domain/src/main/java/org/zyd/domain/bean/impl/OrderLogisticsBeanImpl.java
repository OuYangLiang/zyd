package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.OrderLogisticsBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.LogisticsCompCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.OrderLogisticsEntity;
import org.zyd.store.mapper.OrderLogisticsMapper;

public class OrderLogisticsBeanImpl implements OrderLogisticsBean {

    private OrderLogisticsEntity entity;

    @Autowired
    private OrderLogisticsMapper orderLogisticsMapper;

    public OrderLogisticsBeanImpl(OrderLogisticsEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderId();
    }

    @Override
    public LogisticsCompCode getLogisticsCompanyCode() {
        if (null == entity) {
            return null;
        }
        return LogisticsCompCode.valueOf(entity.getLogisticsCompanyCode());
    }

    @Override
    public String getLogisticsCompanyDesc() {
        if (null == entity) {
            return null;
        }
        return entity.getLogisticsCompanyDesc();
    }

    @Override
    public String getLogisticsNum() {
        if (null == entity) {
            return null;
        }
        return entity.getLogisticsNum();
    }

    @Override
    public void setOrderId(BigDecimal orderId) {
        if (null == entity) {
            entity = new OrderLogisticsEntity();
        }
        entity.setOrderId(orderId);
    }

    @Override
    public void setLogisticsCompanyCode(LogisticsCompCode logisticsCompanyCode) {
        if (null == entity) {
            entity = new OrderLogisticsEntity();
        }
        entity.setLogisticsCompanyCode(logisticsCompanyCode.name());
    }

    @Override
    public void setLogisticsCompanyDesc(String logisticsCompanyDesc) {
        if (null == entity) {
            entity = new OrderLogisticsEntity();
        }
        entity.setLogisticsCompanyDesc(logisticsCompanyDesc);
    }

    @Override
    public void setLogisticsNum(String logisticsNum) {
        if (null == entity) {
            entity = new OrderLogisticsEntity();
        }
        entity.setLogisticsNum(logisticsNum);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            orderLogisticsMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            orderLogisticsMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            orderLogisticsMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setOrderId(null);
        }
    }

}
