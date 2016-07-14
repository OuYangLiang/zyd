package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.PartyContactInfoBean;
import org.zyd.common.constants.ContactType;
import org.zyd.common.constants.Country;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.PartyContactInfoEntity;
import org.zyd.store.mapper.PartyContactInfoMapper;

public class PartyContactInfoBeanImpl implements PartyContactInfoBean {

    private PartyContactInfoEntity entity;

    @Autowired
    private PartyContactInfoMapper partyContactInfoMapper;

    public PartyContactInfoBeanImpl(PartyContactInfoEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getCntctId() {
        if (null == entity) {
            return null;
        }
        return entity.getCntctId();
    }

    @Override
    public ContactType getCntctType() {
        if (null == entity) {
            return null;
        }
        return ContactType.valueOf(entity.getCntctType());
    }

    @Override
    public Integer getCntctSeq() {
        if (null == entity) {
            return null;
        }
        return entity.getCntctSeq();
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
    public Country getCntctCountry() {
        if (null == entity) {
            return null;
        }
        return Country.valueOf(entity.getCntctCountry());
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
	public String getCntctTownCode() {
    	if (null == entity) {
            return null;
        }
        return entity.getCntctTownCode();
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
    public boolean isPreferFlag() {
        if (null == entity) {
            return false;
        }
        return entity.isPreferFlag();
    }

    @Override
    public BigDecimal getPartyId() {
        if (null == entity) {
            return null;
        }
        return entity.getPartyId();
    }

    @Override
    public void setCntctId(BigDecimal cntctId) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctId(cntctId);
    }

    @Override
    public void setCntctType(ContactType cntctType) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctType(cntctType.name());
    }

    @Override
    public void setCntctSeq(Integer cntctSeq) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctSeq(cntctSeq);
    }

    @Override
    public void setCntctName(String cntctName) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctName(cntctName);
    }

    @Override
    public void setCntctMobile(String cntctMobile) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctMobile(cntctMobile);
    }

    @Override
    public void setCntctCountry(Country cntctCountry) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctCountry(cntctCountry.name());
    }

    @Override
    public void setCntctState(String cntctState) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctState(cntctState);
    }

    @Override
    public void setCntctCity(String cntctCity) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctCity(cntctCity);
    }
    
    @Override
	public void setCntctTownCode(String cntctTownCode) {
    	if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctTownCode(cntctTownCode);
	}

    @Override
    public void setCntctTown(String cntctTown) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctTown(cntctTown);
    }

    @Override
    public void setCntctStreet(String cntctStreet) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctStreet(cntctStreet);
    }

    @Override
    public void setCntctAddress(String cntctAddress) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctAddress(cntctAddress);
    }

    @Override
    public void setCntctPostCode(String cntctPostCode) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setCntctPostCode(cntctPostCode);
    }

    @Override
    public void setPreferFlag(boolean preferFlag) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setPreferFlag(preferFlag);
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new PartyContactInfoEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            partyContactInfoMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            partyContactInfoMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            partyContactInfoMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setCntctId(null);
        }
    }

}
