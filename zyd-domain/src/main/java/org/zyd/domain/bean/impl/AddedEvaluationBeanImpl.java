package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.AddedEvaluationBean;
import org.zyd.common.constants.AddedEvalType;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.AddedEvaluationEntity;
import org.zyd.store.mapper.AddedEvaluationMapper;

public class AddedEvaluationBeanImpl implements AddedEvaluationBean {

    private static final Logger log = LoggerFactory.getLogger(AddedEvaluationBean.class);

    private AddedEvaluationEntity entity;

    @Autowired
    private AddedEvaluationMapper addedEvaluationMapper;

    public AddedEvaluationBeanImpl(AddedEvaluationEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getAddedEvalId() {
        if (null == entity) {
            return null;
        }

        return entity.getAddedEvalId();
    }

    @Override
    public AddedEvalType getAddedEvalType() {
        if (null == entity) {
            return null;
        }

        return AddedEvalType.valueOf(entity.getAddedEvalType());
    }

    @Override
    public String getAddedEvalContent() {
        if (null == entity) {
            return null;
        }

        return entity.getAddedEvalContent();
    }

    @Override
    public Timestamp getEventTs() {
        if (null == entity) {
            return null;
        }

        return entity.getEventTs();
    }

    @Override
    public BigDecimal getEvalId() {
        if (null == entity) {
            return null;
        }

        return entity.getEvalId();
    }

    @Override
    public void setAddedEvalId(BigDecimal addedEvalId) {
        if (null == entity) {
            entity = new AddedEvaluationEntity();
        }

        entity.setAddedEvalId(addedEvalId);
    }

    @Override
    public void setAddedEvalType(AddedEvalType addedEvalType) {
        if (null == entity) {
            entity = new AddedEvaluationEntity();
        }

        entity.setAddedEvalType(addedEvalType.name());
    }

    @Override
    public void setAddedEvalContent(String addedEvalContent) {
        if (null == entity) {
            entity = new AddedEvaluationEntity();
        }

        entity.setAddedEvalContent(addedEvalContent);
    }

    @Override
    public void setEventTs(Timestamp eventTs) {
        if (null == entity) {
            entity = new AddedEvaluationEntity();
        }

        entity.setEventTs(eventTs);
    }

    @Override
    public void setEvalId(BigDecimal evalId) {
        if (null == entity) {
            entity = new AddedEvaluationEntity();
        }

        entity.setEvalId(evalId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            addedEvaluationMapper.insert(this.entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            addedEvaluationMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            addedEvaluationMapper.delete(this.entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setAddedEvalId(null);
        }
    }

}
