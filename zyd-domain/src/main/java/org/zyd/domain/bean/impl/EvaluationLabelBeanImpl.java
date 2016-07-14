package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.EvaluationLabelBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.EvaluationLabelEntity;
import org.zyd.store.mapper.EvaluationLabelMapper;

public class EvaluationLabelBeanImpl implements EvaluationLabelBean {

    private EvaluationLabelEntity entity;

    @Autowired
    private EvaluationLabelMapper evaluationLabelMapper;

    public EvaluationLabelBeanImpl(EvaluationLabelEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getLabelId() {
        if (null == entity) {
            return null;
        }
        return entity.getLabelId();
    }

    @Override
    public String getLabel() {
        if (null == entity) {
            return null;
        }
        return entity.getLabel();
    }

    @Override
    public Integer getHitTimes() {
        if (null == entity) {
            return null;
        }
        return entity.getHitTimes();
    }

    @Override
    public BigDecimal getCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyId();
    }

    @Override
    public void setLabelId(BigDecimal labelId) {
        if (null == entity) {
            entity = new EvaluationLabelEntity();
        }
        entity.setLabelId(labelId);
    }

    @Override
    public void setLabel(String label) {
        if (null == entity) {
            entity = new EvaluationLabelEntity();
        }
        entity.setLabel(label);
    }

    @Override
    public void setHitTimes(Integer hitTimes) {
        if (null == entity) {
            entity = new EvaluationLabelEntity();
        }
        entity.setHitTimes(hitTimes);
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new EvaluationLabelEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void hit() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            evaluationLabelMapper.hit(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            evaluationLabelMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            evaluationLabelMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            evaluationLabelMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setLabelId(null);
        }
    }
}
