package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.domain.bean.OrderGiftBean;
import org.zyd.domain.bean.OrderGiftItemListBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.EvaluationStatus;
import org.zyd.common.constants.OrderCommodityStatus;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.OrderGiftEntity;
import org.zyd.store.mapper.OrderGiftMapper;

public class OrderGiftBeanImpl implements OrderGiftBean {

    private OrderGiftEntity entity;
    private List<OrderGiftItemListBean> orderGiftItemListBeans;
    @Autowired
    private OrderGiftMapper orderGiftMapper;

    public OrderGiftBeanImpl(OrderGiftEntity entity) {
        this.entity = entity;
    }

    @Override
    public List<OrderGiftItemListBean> getOrderGiftItemListBeans() {
        return this.orderGiftItemListBeans;
    }

    @Override
    public void setOrderGiftItemListBeans(List<OrderGiftItemListBean> orderGiftItemListBeans) {
        this.orderGiftItemListBeans = orderGiftItemListBeans;
    }

    @Override
    public BigDecimal getOrderCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderCmmdtyId();
    }

    @Override
    public BigDecimal getOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderId();
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
    public BigDecimal getProposedPrice() {
        if (null == entity) {
            return null;
        }
        return entity.getProposedPrice();
    }

    @Override
    public Integer getQty() {
        if (null == entity) {
            return null;
        }
        return entity.getQty();
    }

    @Override
    public String getDefaultImageAddrs() {
        if (null == entity) {
            return null;
        }
        return entity.getDefaultImageAddrs();
    }

    @Override
    public BigDecimal getOrderGiftId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderGiftId();
    }

    @Override
    public OrderCommodityStatus getCommodityStatus() {
        if (null == entity) {
            return null;
        }
        return OrderCommodityStatus.valueOf(entity.getCommodityStatus());
    }

    @Override
    public void setOrderGiftId(BigDecimal orderGiftId) {
        if (null == entity) {
            entity = new OrderGiftEntity();
        }
        entity.setOrderGiftId(orderGiftId);
    }

    @Override
    public void setCommodityStatus(OrderCommodityStatus commodityStatus) {
        if (null == entity) {
            entity = new OrderGiftEntity();
        }
        entity.setCommodityStatus(commodityStatus.name());
    }

    @Override
    public void setEvaluationStatus(EvaluationStatus evaluationStatus) {
        if (null == entity) {
            entity = new OrderGiftEntity();
        }
        entity.setEvaluationStatus(evaluationStatus.name());
    }

    @Override
    public Integer getTimesExchanged() {
        if (null == entity) {
            return null;
        }
        return entity.getTimesExchanged();
    }

    @Override
    public EvaluationStatus getEvaluationStatus() {
        if (null == entity) {
            return null;
        }
        return EvaluationStatus.valueOf(entity.getEvaluationStatus());
    }

    @Override
    public void setOrderCmmdtyId(BigDecimal orderCmmdtyId) {
        if (null == entity) {
            entity = new OrderGiftEntity();
        }
        entity.setOrderCmmdtyId(orderCmmdtyId);
    }

    @Override
    public void setOrderId(BigDecimal orderId) {
        if (null == entity) {
            entity = new OrderGiftEntity();
        }
        entity.setOrderId(orderId);
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new OrderGiftEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void setCmmdtyName(String cmmdtyName) {
        if (null == entity) {
            entity = new OrderGiftEntity();
        }
        entity.setCmmdtyName(cmmdtyName);
    }

    @Override
    public void setProposedPrice(BigDecimal proposedPrice) {
        if (null == entity) {
            entity = new OrderGiftEntity();
        }
        entity.setProposedPrice(proposedPrice);
    }

    @Override
    public void setQty(Integer qty) {
        if (null == entity) {
            entity = new OrderGiftEntity();
        }
        entity.setQty(qty);
    }

    @Override
    public void setDefaultImageAddrs(String defaultImageAddrs) {
        if (null == entity) {
            entity = new OrderGiftEntity();
        }
        entity.setDefaultImageAddrs(defaultImageAddrs);
    }

    @Override
    public void setTimesExchanged(Integer timesExchanged) {
        if (null == entity) {
            entity = new OrderGiftEntity();
        }
        entity.setTimesExchanged(timesExchanged);
    }

    @Override
    public void saveRecursively() throws ZydException {
        this.save();
        if (null == this.getOrderGiftId()) {
            throw new ZydException(ErrorCode.EZYD0002);
        }
        // 保存赠品清单
        List<OrderGiftItemListBean> itemList = this.getOrderGiftItemListBeans();
        if (CollectionUtils.isEmpty(itemList)) {
            return;
        }
        for (OrderGiftItemListBean item : itemList) {
            item.setOrderGiftId(this.getOrderGiftId());
            item.save();
        }
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            orderGiftMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            orderGiftMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void remove() throws ZydException {
        try {
            orderGiftMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setOrderGiftId(null);
        }
    }

}
