package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.ThirdPartyAccountBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.ThirdPartyAcntType;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.ThirdPartyAccountEntity;
import org.zyd.store.mapper.ThirdPartyAccountMapper;

public class ThirdPartyAccountBeanImpl implements ThirdPartyAccountBean {

    private ThirdPartyAccountEntity entity;

    @Autowired
    private ThirdPartyAccountMapper thirdPartyAccountMapper;

    @Override
    public BigDecimal getAcntId() {
        if (null == entity) {
            return null;
        }
        return entity.getAcntId();
    }

    @Override
    public ThirdPartyAcntType getAcntType() {
        if (null == entity) {
            return null;
        }
        return ThirdPartyAcntType.valueOf(entity.getAcntType());
    }

    @Override
    public String getAcntVal() {
        if (null == entity) {
            return null;
        }
        return entity.getAcntVal();
    }

    @Override
    public BigDecimal getPartyId() {
        if (null == entity) {
            return null;
        }
        return entity.getPartyId();
    }

    @Override
    public void setAcntId(BigDecimal acntId) {
        if (null == entity) {
            entity = new ThirdPartyAccountEntity();
        }
        entity.setAcntId(acntId);
    }

    @Override
    public void setAcntType(ThirdPartyAcntType acntType) {
        if (null == entity) {
            entity = new ThirdPartyAccountEntity();
        }
        entity.setAcntType(acntType.name());
    }

    @Override
    public void setAcntVal(String acntVal) {
        if (null == entity) {
            entity = new ThirdPartyAccountEntity();
        }
        entity.setAcntVal(acntVal);
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new ThirdPartyAccountEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            thirdPartyAccountMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            thirdPartyAccountMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            thirdPartyAccountMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setAcntId(null);
        }
    }

}
