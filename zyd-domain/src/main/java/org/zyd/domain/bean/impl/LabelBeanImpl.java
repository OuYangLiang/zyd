package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.LabelBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.LabelStyle;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.LabelEntity;
import org.zyd.store.mapper.LabelMapper;

public class LabelBeanImpl implements LabelBean {

    private LabelEntity entity;

    @Autowired
    private LabelMapper mapper;

    public LabelBeanImpl(LabelEntity entity) {
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
    public void setLabelId(BigDecimal labelId) {
        if (null == entity) {
            entity = new LabelEntity();
        }

        entity.setLabelId(labelId);
    }

    @Override
    public LabelStyle getLabelStyle() {
        if (null == entity) {
            return null;
        }

        return LabelStyle.valueOf(entity.getLabelStyle());
    }

    @Override
    public void setLabelStyle(LabelStyle labelStyle) {
        if (null == entity) {
            entity = new LabelEntity();
        }

        entity.setLabelStyle(labelStyle.name());
    }

    @Override
    public String getLabelVal() {
        if (null == entity) {
            return null;
        }

        return entity.getLabelVal();
    }

    @Override
    public void setLabelVal(String labelVal) {
        if (null == entity) {
            entity = new LabelEntity();
        }

        entity.setLabelVal(labelVal);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            mapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            mapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            mapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setLabelId(null);
        }
    }

}
