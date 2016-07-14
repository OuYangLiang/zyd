package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.ReturnOrderItemListBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.ReturnOrderItemListEntity;
import org.zyd.store.mapper.ReturnOrderItemListMapper;

public class ReturnOrderItemListBeanImpl implements ReturnOrderItemListBean {

    private ReturnOrderItemListEntity entity;

    @Autowired
    private ReturnOrderItemListMapper returnOrderItemListMapper;

    public ReturnOrderItemListBeanImpl(ReturnOrderItemListEntity entity) {
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
    public BigDecimal getReturnOrderCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getReturnOrderCmmdtyId();
    }

    @Override
    public void setItemId(BigDecimal itemId) {
        if (null == entity) {
            entity = new ReturnOrderItemListEntity();
        }
        entity.setItemId(itemId);
    }

    @Override
    public void setItemDesc(String itemDesc) {
        if (null == entity) {
            entity = new ReturnOrderItemListEntity();
        }
        entity.setItemDesc(itemDesc);
    }

    @Override
    public void setItemQty(Integer itemQty) {
        if (null == entity) {
            entity = new ReturnOrderItemListEntity();
        }
        entity.setItemQty(itemQty);
    }

    @Override
    public void setReturnOrderCmmdtyId(BigDecimal returnOrderCmmdtyId) {
        if (null == entity) {
            entity = new ReturnOrderItemListEntity();
        }
        entity.setReturnOrderCmmdtyId(returnOrderCmmdtyId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            returnOrderItemListMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            returnOrderItemListMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            returnOrderItemListMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setItemId(null);
        }
    }

}
