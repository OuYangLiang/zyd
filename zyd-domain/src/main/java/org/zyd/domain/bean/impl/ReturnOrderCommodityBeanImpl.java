package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.ReturnOrderCommodityBean;
import org.zyd.domain.bean.ReturnOrderItemListBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.ReturnOrderCmmdtyType;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.ReturnOrderCommodityEntity;
import org.zyd.store.mapper.ReturnOrderCommodityMapper;

public class ReturnOrderCommodityBeanImpl implements ReturnOrderCommodityBean {

    private ReturnOrderCommodityEntity entity;
    private List<ReturnOrderItemListBean> returnOrderItemListBeans;

    @Autowired
    private ReturnOrderCommodityMapper returnOrderCommodityMapper;

    public ReturnOrderCommodityBeanImpl(ReturnOrderCommodityEntity entity) {
        this.entity = entity;
    }

    @Override
    public List<ReturnOrderItemListBean> getReturnOrderItemListBeans() {
        return this.returnOrderItemListBeans;
    }

    @Override
    public void setReturnOrderItemListBeans(List<ReturnOrderItemListBean> returnOrderItemListBeans) {
        this.returnOrderItemListBeans = returnOrderItemListBeans;
    }

    @Override
    public BigDecimal getReturnOrderCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getReturnOrderCmmdtyId();
    }

    @Override
    public ReturnOrderCmmdtyType getReturnOrderCmmdtyType() {
        if (null == entity) {
            return null;
        }
        return ReturnOrderCmmdtyType.valueOf(entity.getReturnOrderCmmdtyType());
    }

    @Override
    public BigDecimal getSourceOrderCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getSourceOrderCmmdtyId();
    }

    @Override
    public BigDecimal getCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyId();
    }

    @Override
    public String getCmmdtyName() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyName();
    }

    @Override
    public BigDecimal getActualPrice() {
        if (null == entity) {
            return null;
        }
        return entity.getActualPrice();
    }

    @Override
    public Integer getQty() {
        if (null == entity) {
            return null;
        }
        return entity.getQty();
    }

    @Override
    public BigDecimal getReturnOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getReturnOrderId();
    }

    @Override
    public void setReturnOrderCmmdtyId(BigDecimal returnOrderCmmdtyId) {
        if (null == entity) {
            entity = new ReturnOrderCommodityEntity();
        }
        entity.setReturnOrderCmmdtyId(returnOrderCmmdtyId);
    }

    @Override
    public void setReturnOrderCmmdtyType(ReturnOrderCmmdtyType returnOrderCmmdtyType) {
        if (null == entity) {
            entity = new ReturnOrderCommodityEntity();
        }
        entity.setReturnOrderCmmdtyType(returnOrderCmmdtyType.name());
    }

    @Override
    public void setSourceOrderCmmdtyId(BigDecimal sourceOrderCmmdtyId) {
        if (null == entity) {
            entity = new ReturnOrderCommodityEntity();
        }
        entity.setSourceOrderCmmdtyId(sourceOrderCmmdtyId);
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new ReturnOrderCommodityEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void setCmmdtyName(String cmmdtyName) {
        if (null == entity) {
            entity = new ReturnOrderCommodityEntity();
        }
        entity.setCmmdtyName(cmmdtyName);
    }

    @Override
    public void setActualPrice(BigDecimal actualPrice) {
        if (null == entity) {
            entity = new ReturnOrderCommodityEntity();
        }
        entity.setActualPrice(actualPrice);
    }

    @Override
    public void setQty(Integer qty) {
        if (null == entity) {
            entity = new ReturnOrderCommodityEntity();
        }
        entity.setQty(qty);
    }

    @Override
    public void setReturnOrderId(BigDecimal returnOrderId) {
        if (null == entity) {
            entity = new ReturnOrderCommodityEntity();
        }
        entity.setReturnOrderId(returnOrderId);
    }

    @Override
    public void saveRecursively() throws ZydException {
        this.save();
        if (null == this.getReturnOrderCmmdtyId()) {
            throw new ZydException(ErrorCode.EZYD0002);
        }
        // 保存退换货订单清单
        List<ReturnOrderItemListBean> itemList = this.getReturnOrderItemListBeans();
        for (ReturnOrderItemListBean item : itemList) {
            item.setReturnOrderCmmdtyId(this.getReturnOrderCmmdtyId());
            item.save();
        }

    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            returnOrderCommodityMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            returnOrderCommodityMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            returnOrderCommodityMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setReturnOrderCmmdtyId(null);
        }
    }

}
