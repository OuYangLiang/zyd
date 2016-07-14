package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.PartyAccountBean;
import org.zyd.common.constants.AccountStatus;
import org.zyd.common.constants.AccountType;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.PartyAccountEntity;
import org.zyd.store.mapper.PartyAccountMapper;

public class PartyAccountBeanImpl implements PartyAccountBean {

    private PartyAccountEntity entity;

    @Autowired
    private transient PartyAccountMapper partyAccountMapper;

    public PartyAccountBeanImpl(PartyAccountEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getAcntId() {
        if (null == entity) {
            return null;
        }
        return entity.getAcntId();
    }

    @Override
    public AccountType getAcntType() {
        if (null == entity) {
            return null;
        }
        return AccountType.valueOf(entity.getAcntType());
    }

    @Override
    public String getAcntVal() {
        if (null == entity) {
            return null;
        }
        return entity.getAcntVal();
    }

    @Override
    public AccountStatus getAcntStatus() {
        if (null == entity) {
            return null;
        }
        return AccountStatus.valueOf(entity.getAcntStatus());
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
            entity = new PartyAccountEntity();
        }
        entity.setAcntId(acntId);
    }

    @Override
    public void setAcntType(AccountType acntType) {
        if (null == entity) {
            entity = new PartyAccountEntity();
        }
        entity.setAcntType(acntType.name());
    }

    @Override
    public void setAcntVal(String acntVal) {
        if (null == entity) {
            entity = new PartyAccountEntity();
        }
        entity.setAcntVal(acntVal);
    }

    @Override
    public void setAcntStatus(AccountStatus acntStatus) {
        if (null == entity) {
            entity = new PartyAccountEntity();
        }
        entity.setAcntStatus(acntStatus.name());
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new PartyAccountEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            partyAccountMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            partyAccountMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            partyAccountMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setAcntId(null);
        }
    }

}
