package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.CommodityImageBean;
import org.zyd.common.constants.CommodityImageType;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.CommodityImageEntity;
import org.zyd.store.mapper.CommodityImageMapper;

public class CommodityImageBeanImpl implements CommodityImageBean {

    private CommodityImageEntity entity;

    @Autowired
    private CommodityImageMapper commodityImageMapper;

    public CommodityImageBeanImpl(CommodityImageEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getImageId() {
        if (null == entity) {
            return null;
        }
        return entity.getImageId();
    }

    @Override
    public BigDecimal getCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyId();
    }

    @Override
    public Integer getImageSeq() {
        if (null == entity) {
            return null;
        }
        return entity.getImageSeq();
    }

    @Override
    public String getImageAddrs() {
        if (null == entity) {
            return null;
        }
        return entity.getImageAddrs();
    }

    @Override
    public void setImageId(BigDecimal imageId) {
        if (null == entity) {
            entity = new CommodityImageEntity();
        }
        entity.setImageId(imageId);
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new CommodityImageEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void setImageSeq(Integer imageSeq) {
        if (null == entity) {
            entity = new CommodityImageEntity();
        }
        entity.setImageSeq(imageSeq);
    }

    @Override
    public void setImageAddrs(String imageAddrs) {
        if (null == entity) {
            entity = new CommodityImageEntity();
        }
        entity.setImageAddrs(imageAddrs);
    }

    @Override
    public void setImageType(CommodityImageType imageType) {
        if (null == entity) {
            entity = new CommodityImageEntity();
        }

        entity.setImageType(imageType.name());
    }

    @Override
    public CommodityImageType getImageType() {
        if (null == entity) {
            return null;
        }

        return CommodityImageType.valueOf(entity.getImageType());
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            commodityImageMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            commodityImageMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            commodityImageMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setImageId(null);
        }
    }

}
