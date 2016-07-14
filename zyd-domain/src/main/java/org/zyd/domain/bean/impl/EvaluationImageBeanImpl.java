package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.EvaluationImageBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.EvaluationImageEntity;
import org.zyd.store.mapper.EvaluationImageMapper;

public class EvaluationImageBeanImpl implements EvaluationImageBean {

    private EvaluationImageEntity entity;

    @Autowired
    private EvaluationImageMapper evaluationImageMapper;

    public EvaluationImageBeanImpl(EvaluationImageEntity entity) {
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
    public BigDecimal getEvalId() {
        if (null == entity) {
            return null;
        }
        return entity.getEvalId();
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
            entity = new EvaluationImageEntity();
        }
        entity.setImageId(imageId);
    }

    @Override
    public void setEvalId(BigDecimal evalId) {
        if (null == entity) {
            entity = new EvaluationImageEntity();
        }
        entity.setEvalId(evalId);
    }

    @Override
    public void setImageSeq(Integer imageSeq) {
        if (null == entity) {
            entity = new EvaluationImageEntity();
        }
        entity.setImageSeq(imageSeq);
    }

    @Override
    public void setImageAddrs(String imageAddrs) {
        if (null == entity) {
            entity = new EvaluationImageEntity();
        }
        entity.setImageAddrs(imageAddrs);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            evaluationImageMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            evaluationImageMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            evaluationImageMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setImageId(null);
        }
    }

}
