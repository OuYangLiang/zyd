package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.PartyLevelBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.Level;
import org.zyd.common.constants.LevelChangeType;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.PartyLevelEntity;
import org.zyd.store.mapper.PartyLevelMapper;

public class PartyLevelBeanImpl implements PartyLevelBean {

    private PartyLevelEntity entity;

    @Autowired
    private PartyLevelMapper partyLevelMapper;

    public PartyLevelBeanImpl(PartyLevelEntity entity) {
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
    public Level getLevel() {
        if (null == entity) {
            return null;
        }
        return Level.valueOf(entity.getLevel());
    }

    @Override
    public LevelChangeType getLevelChgType() {
        if (null == entity) {
            return null;
        }
        return LevelChangeType.valueOf(entity.getLevelChgType());
    }

    @Override
    public Timestamp getLevelChgTs() {
        if (null == entity) {
            return null;
        }
        return entity.getLevelChgTs();
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new PartyLevelEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void setLevel(Level level) {
        if (null == entity) {
            entity = new PartyLevelEntity();
        }
        entity.setLevel(level.name());
    }

    @Override
    public void setLevelChgType(LevelChangeType levelChgType) {
        if (null == entity) {
            entity = new PartyLevelEntity();
        }
        entity.setLevelChgType(levelChgType.name());
    }

    @Override
    public void setLevelChgTs(Timestamp levelChgTs) {
        if (null == entity) {
            entity = new PartyLevelEntity();
        }
        entity.setLevelChgTs(levelChgTs);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            partyLevelMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            partyLevelMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            partyLevelMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setPartyId(null);
        }
    }

}
