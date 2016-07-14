package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.PartyPasswordBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.PasswordStatus;
import org.zyd.common.constants.PasswordStrongth;
import org.zyd.common.constants.PasswordType;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.PartyPasswordEntity;
import org.zyd.store.mapper.PartyPasswordMapper;

public class PartyPasswordBeanImpl implements PartyPasswordBean {

    private PartyPasswordEntity entity;

    @Autowired
    private PartyPasswordMapper partyPasswordMapper;

    public PartyPasswordBeanImpl(PartyPasswordEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getPwdId() {
        if (null == entity) {
            return null;
        }
        return entity.getPwdId();
    }

    @Override
    public PasswordType getPwdType() {
        if (null == entity) {
            return null;
        }
        return PasswordType.valueOf(entity.getPwdType());
    }

    @Override
    public String getPwdVal() {
        if (null == entity) {
            return null;
        }
        return entity.getPwdVal();
    }

    @Override
    public Integer getPwdSalt() {
        if (null == entity) {
            return null;
        }
        return entity.getPwdSalt();
    }

    @Override
    public PasswordStrongth getPwdStrongth() {
        if (null == entity) {
            return null;
        }
        return PasswordStrongth.valueOf(entity.getPwdStrongth());
    }

    @Override
    public Timestamp getFirstWrongCheckTime() {
        if (null == entity) {
            return null;
        }
        return entity.getFirstWrongCheckTime();
    }

    @Override
    public Integer getWrongCheckTimes() {
        if (null == entity) {
            return null;
        }
        return entity.getWrongCheckTimes();
    }

    @Override
    public PasswordStatus getPwdStatus() {
        if (null == entity) {
            return null;
        }
        return PasswordStatus.valueOf(entity.getPwdStatus());
    }

    @Override
    public BigDecimal getPartyId() {
        if (null == entity) {
            return null;
        }
        return entity.getPartyId();
    }

    @Override
    public void setPwdId(BigDecimal pwdId) {
        if (null == entity) {
            entity = new PartyPasswordEntity();
        }
        entity.setPwdId(pwdId);
    }

    @Override
    public void setPwdType(PasswordType pwdType) {
        if (null == entity) {
            entity = new PartyPasswordEntity();
        }
        entity.setPwdType(pwdType.name());
    }

    @Override
    public void setPwdVal(String pwdVal) {
        if (null == entity) {
            entity = new PartyPasswordEntity();
        }
        entity.setPwdVal(pwdVal);
    }

    @Override
    public void setPwdSalt(Integer pwdSalt) {
        if (null == entity) {
            entity = new PartyPasswordEntity();
        }
        entity.setPwdSalt(pwdSalt);
    }

    @Override
    public void setPwdStrongth(PasswordStrongth pwdStrongth) {
        if (null == entity) {
            entity = new PartyPasswordEntity();
        }
        entity.setPwdStrongth(pwdStrongth.name());
    }

    @Override
    public void setFirstWrongCheckTime(Timestamp firstWrongCheckTime) {
        if (null == entity) {
            entity = new PartyPasswordEntity();
        }
        entity.setFirstWrongCheckTime(firstWrongCheckTime);
    }

    @Override
    public void setWrongCheckTimes(Integer wrongCheckTimes) {
        if (null == entity) {
            entity = new PartyPasswordEntity();
        }
        entity.setWrongCheckTimes(wrongCheckTimes);
    }

    @Override
    public void setPwdStatus(PasswordStatus pwdStatus) {
        if (null == entity) {
            entity = new PartyPasswordEntity();
        }
        entity.setPwdStatus(pwdStatus.name());
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new PartyPasswordEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            partyPasswordMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            partyPasswordMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            partyPasswordMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setPwdId(null);
        }
    }

}
