package org.zyd.domain.bean.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.PropertyConfigBean;
import org.zyd.common.constants.Category;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.PropertyConfigEntity;
import org.zyd.store.mapper.PropertyConfigMapper;

public class PropertyConfigBeanImpl implements PropertyConfigBean {

    private PropertyConfigEntity entity;

    @Autowired
    private PropertyConfigMapper mapper;

    public PropertyConfigBeanImpl(PropertyConfigEntity entity) {
        this.entity = entity;
    }

    @Override
    public Category getCategory() {
        if (null == entity) {
            return null;
        }

        return Category.valueOf(entity.getCategory());
    }

    @Override
    public void setCategory(Category category) {
        if (null == entity) {
            entity = new PropertyConfigEntity();
        }

        entity.setCategory(category.name());
    }

    @Override
    public String getPropName() {
        if (null == entity) {
            return null;
        }

        return entity.getPropName();
    }

    @Override
    public void setPropName(String propName) {
        if (null == entity) {
            entity = new PropertyConfigEntity();
        }

        entity.setPropName(propName);
    }

    @Override
    public Integer getSeq() {
        if (null == entity) {
            return null;
        }

        return entity.getSeq();
    }

    @Override
    public void setSeq(Integer seq) {
        if (null == entity) {
            entity = new PropertyConfigEntity();
        }

        entity.setSeq(seq);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            mapper.insert(entity);

        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
	public void change() throws ZydException {
		throw new UnsupportedOperationException();
	}

}
