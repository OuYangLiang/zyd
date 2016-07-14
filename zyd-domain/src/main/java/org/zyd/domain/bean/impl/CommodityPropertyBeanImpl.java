package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.CommodityPropertyBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.CommodityPropertyEntity;
import org.zyd.store.mapper.CommodityPropertyMapper;

public class CommodityPropertyBeanImpl implements CommodityPropertyBean {

    private CommodityPropertyEntity entity;

    @Autowired
    private CommodityPropertyMapper commodityPropertyMapper;

    public CommodityPropertyBeanImpl(CommodityPropertyEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getPropertyId() {
        if (null == entity) {
            return null;
        }
        return entity.getPropertyId();
    }

    @Override
    public BigDecimal getCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyId();
    }

    @Override
    public String getPropName() {
        if (null == entity) {
            return null;
        }
        return entity.getPropName();
    }

    @Override
    public String getPropVal() {
        if (null == entity) {
            return null;
        }
        return entity.getPropVal();
    }

    @Override
    public Integer getSeq() {
        if (null == entity) {
            return null;
        }
        return entity.getSeq();
    }

    @Override
    public void setPropertyId(BigDecimal propertyId) {
        if (null == entity) {
            entity = new CommodityPropertyEntity();
        }
        entity.setPropertyId(propertyId);
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new CommodityPropertyEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void setPropName(String propName) {
        if (null == entity) {
            entity = new CommodityPropertyEntity();
        }
        entity.setPropName(propName);
    }

    @Override
    public void setPropVal(String propVal) {
        if (null == entity) {
            entity = new CommodityPropertyEntity();
        }
        entity.setPropVal(propVal);
    }

    @Override
    public void setSeq(Integer seq) {
        if (null == entity) {
            entity = new CommodityPropertyEntity();
        }
        entity.setSeq(seq);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            commodityPropertyMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            commodityPropertyMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            commodityPropertyMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setPropertyId(null);
        }
    }

}
