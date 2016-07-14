package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.ItemListBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.ItemListEntity;
import org.zyd.store.mapper.ItemListMapper;

public class ItemListBeanImpl implements ItemListBean {

    private ItemListEntity entity;

    @Autowired
    private ItemListMapper itemListMapper;

    public ItemListBeanImpl(ItemListEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getItemId() {
        if (null == entity) {
            return null;
        }
        return entity.getItemId();
    }

    @Override
    public String getItemDesc() {
        if (null == entity) {
            return null;
        }
        return entity.getItemDesc();
    }

    @Override
    public Integer getItemQty() {
        if (null == entity) {
            return null;
        }
        return entity.getItemQty();
    }

    @Override
    public BigDecimal getCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyId();
    }

    @Override
    public void setItemId(BigDecimal itemId) {
        if (null == entity) {
            entity = new ItemListEntity();
        }
        entity.setItemId(itemId);
    }

    @Override
    public void setItemDesc(String itemDesc) {
        if (null == entity) {
            entity = new ItemListEntity();
        }
        entity.setItemDesc(itemDesc);
    }

    @Override
    public void setItemQty(Integer itemQty) {
        if (null == entity) {
            entity = new ItemListEntity();
        }
        entity.setItemQty(itemQty);
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new ItemListEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            itemListMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            itemListMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            itemListMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setItemId(null);
        }
    }
}
