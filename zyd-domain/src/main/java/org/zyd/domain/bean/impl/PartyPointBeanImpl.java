package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.PartyPointBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.PartyPointEntity;
import org.zyd.store.mapper.PartyPointMapper;

public class PartyPointBeanImpl implements PartyPointBean {

    private PartyPointEntity entity;

    @Autowired
    private PartyPointMapper partyPointMapper;

    public PartyPointBeanImpl(PartyPointEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getPartyId() {
        if (null == entity) {
            return null;
        }
        return entity.getPartyId();
    }

    @Override
    public BigDecimal getTotalAmt() {
        if (null == entity) {
            return null;
        }
        return entity.getTotalAmt();
    }

    @Override
    public BigDecimal getUsedAmt() {
        if (null == entity) {
            return null;
        }
        return entity.getUsedAmt();
    }

    @Override
    public BigDecimal getBalanceAmt() {
        if (null == entity) {
            return null;
        }
        return entity.getBalanceAmt();
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new PartyPointEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void setTotalAmt(BigDecimal totalAmt) {
        if (null == entity) {
            entity = new PartyPointEntity();
        }
        entity.setTotalAmt(totalAmt);
    }

    @Override
    public void setUsedAmt(BigDecimal usedAmt) {
        if (null == entity) {
            entity = new PartyPointEntity();
        }
        entity.setUsedAmt(usedAmt);
    }

    @Override
    public void setBalanceAmt(BigDecimal balanceAmt) {
        if (null == entity) {
            entity = new PartyPointEntity();
        }
        entity.setBalanceAmt(balanceAmt);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            partyPointMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            partyPointMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            partyPointMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setPartyId(null);
        }
    }

}
