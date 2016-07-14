package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.PartyInfoBean;
import org.zyd.common.constants.Education;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.Gender;
import org.zyd.common.constants.Industry;
import org.zyd.common.constants.LevelOfIncome;
import org.zyd.common.constants.MaritalStatus;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.PartyInfoEntity;
import org.zyd.store.mapper.PartyInfoMapper;

public class PartyInfoBeanImpl implements PartyInfoBean {

    private PartyInfoEntity entity;

    @Autowired
    private PartyInfoMapper partyInfoMapper;

    public PartyInfoBeanImpl(PartyInfoEntity entity) {
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
    public String getPartyName() {
        if (null == entity) {
            return null;
        }
        return entity.getPartyName();
    }

    @Override
    public String getPartyAlias() {
        if (null == entity) {
            return null;
        }
        return entity.getPartyAlias();
    }

    @Override
    public Gender getGender() {
        if (null == entity) {
            return null;
        }
        if (StringUtils.isEmpty(entity.getGender())) {
            return null;
        }
        return Gender.valueOf(entity.getGender());
    }

    @Override
    public Date getBirthday() {
        if (null == entity) {
            return null;
        }
        return entity.getBirthday();
    }

    @Override
    public Education getEducation() {
        if (null == entity) {
            return null;
        }
        if (StringUtils.isEmpty(entity.getEducation())) {
            return null;
        }
        return Education.valueOf(entity.getEducation());
    }

    @Override
    public MaritalStatus getMaritalStatus() {
        if (null == entity) {
            return null;
        }
        if (StringUtils.isEmpty(entity.getMaritalStatus())) {
            return null;
        }
        return MaritalStatus.valueOf(entity.getMaritalStatus());
    }

    @Override
    public Industry getIndustry() {
        if (null == entity) {
            return null;
        }
        if (StringUtils.isEmpty(entity.getIndustry())) {
            return null;
        }
        return Industry.valueOf(entity.getIndustry());
    }

    @Override
    public LevelOfIncome getLevelOfIncome() {
        if (null == entity) {
            return null;
        }
        if (StringUtils.isEmpty(entity.getLevelOfIncome())) {
            return null;
        }
        return LevelOfIncome.valueOf(entity.getLevelOfIncome());
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new PartyInfoEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void setPartyName(String partyName) {
        if (null == entity) {
            entity = new PartyInfoEntity();
        }
        entity.setPartyName(partyName);
    }

    @Override
    public void setPartyAlias(String partyAlias) {
        if (null == entity) {
            entity = new PartyInfoEntity();
        }
        entity.setPartyAlias(partyAlias);
    }

    @Override
    public void setGender(Gender gender) {
        if (null == entity) {
            entity = new PartyInfoEntity();
        }
        entity.setGender(gender.name());
    }

    @Override
    public void setBirthday(Date birthday) {
        if (null == entity) {
            entity = new PartyInfoEntity();
        }
        entity.setBirthday(birthday);
    }

    @Override
    public void setEducation(Education education) {
        if (null == entity) {
            entity = new PartyInfoEntity();
        }
        entity.setEducation(education.name());
    }

    @Override
    public void setMaritalStatus(MaritalStatus maritalStatus) {
        if (null == entity) {
            entity = new PartyInfoEntity();
        }
        entity.setMaritalStatus(maritalStatus.name());
    }

    @Override
    public void setIndustry(Industry industry) {
        if (null == entity) {
            entity = new PartyInfoEntity();
        }
        entity.setIndustry(industry.name());
    }

    @Override
    public void setLevelOfIncome(LevelOfIncome levelOfIncome) {
        if (null == entity) {
            entity = new PartyInfoEntity();
        }
        entity.setLevelOfIncome(levelOfIncome.name());
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            partyInfoMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            partyInfoMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            partyInfoMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setPartyId(null);
        }
    }

}
