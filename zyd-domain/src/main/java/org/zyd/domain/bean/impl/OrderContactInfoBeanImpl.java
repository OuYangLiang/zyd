package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.OrderContactInfoBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.OrderContactInfoEntity;
import org.zyd.store.mapper.OrderContactInfoMapper;

public class OrderContactInfoBeanImpl implements OrderContactInfoBean {

    private OrderContactInfoEntity entity;

    @Autowired
    private OrderContactInfoMapper orderContactInfoMapper;

    public OrderContactInfoBeanImpl(OrderContactInfoEntity entity) {
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
    public String getCntctName() {
        if (null == entity) {
            return null;
        }
        return entity.getCntctName();
    }

    @Override
    public String getCntctMobile() {
        if (null == entity) {
            return null;
        }
        return entity.getCntctMobile();
    }

    @Override
    public String getCntctCountry() {
        if (null == entity) {
            return null;
        }
        return entity.getCntctCountry();
    }

    @Override
    public String getCntctState() {
        if (null == entity) {
            return null;
        }
        return entity.getCntctState();
    }

    @Override
    public String getCntctCity() {
        if (null == entity) {
            return null;
        }
        return entity.getCntctCity();
    }

    @Override
    public String getCntctTown() {
        if (null == entity) {
            return null;
        }
        return entity.getCntctTown();
    }

    @Override
    public String getCntctStreet() {
        if (null == entity) {
            return null;
        }
        return entity.getCntctStreet();
    }

    @Override
    public String getCntctAddress() {
        if (null == entity) {
            return null;
        }
        return entity.getCntctAddress();
    }

    @Override
    public String getCntctPostCode() {
        if (null == entity) {
            return null;
        }
        return entity.getCntctPostCode();
    }

    @Override
    public void setOrderId(BigDecimal orderId) {
        if (null == entity) {
            entity = new OrderContactInfoEntity();
        }
        entity.setOrderId(orderId);
    }

    @Override
    public void setCntctName(String cntctName) {
        if (null == entity) {
            entity = new OrderContactInfoEntity();
        }
        entity.setCntctName(cntctName);
    }

    @Override
    public void setCntctMobile(String cntctMobile) {
        if (null == entity) {
            entity = new OrderContactInfoEntity();
        }
        entity.setCntctMobile(cntctMobile);
    }

    @Override
    public void setCntctCountry(String cntctCountry) {
        if (null == entity) {
            entity = new OrderContactInfoEntity();
        }
        entity.setCntctCountry(cntctCountry);
    }

    @Override
    public void setCntctState(String cntctState) {
        if (null == entity) {
            entity = new OrderContactInfoEntity();
        }
        entity.setCntctState(cntctState);
    }

    @Override
    public void setCntctCity(String cntctCity) {
        if (null == entity) {
            entity = new OrderContactInfoEntity();
        }
        entity.setCntctCity(cntctCity);
    }

    @Override
    public void setCntctTown(String cntctTown) {
        if (null == entity) {
            entity = new OrderContactInfoEntity();
        }
        entity.setCntctTown(cntctTown);
    }

    @Override
    public void setCntctStreet(String cntctStreet) {
        if (null == entity) {
            entity = new OrderContactInfoEntity();
        }
        entity.setCntctStreet(cntctStreet);
    }

    @Override
    public void setCntctAddress(String cntctAddress) {
        if (null == entity) {
            entity = new OrderContactInfoEntity();
        }
        entity.setCntctAddress(cntctAddress);
    }

    @Override
    public void setCntctPostCode(String cntctPostCode) {
        if (null == entity) {
            entity = new OrderContactInfoEntity();
        }
        entity.setCntctPostCode(cntctPostCode);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            orderContactInfoMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            orderContactInfoMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            orderContactInfoMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setOrderId(null);
        }
    }

}
