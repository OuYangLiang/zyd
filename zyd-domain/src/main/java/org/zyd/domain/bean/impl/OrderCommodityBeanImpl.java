package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.domain.bean.OrderCommodityBean;
import org.zyd.domain.bean.OrderGiftBean;
import org.zyd.domain.bean.OrderItemListBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.EvaluationStatus;
import org.zyd.common.constants.OrderCommodityStatus;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.OrderCommodityEntity;
import org.zyd.store.mapper.OrderCommodityMapper;

public class OrderCommodityBeanImpl implements OrderCommodityBean {

    private OrderCommodityEntity entity;

    @Autowired
    private OrderCommodityMapper orderCommodityMapper;

    private List<OrderItemListBean> orderItemListBeans;
    private List<OrderGiftBean> orderGiftBeans;

    public OrderCommodityBeanImpl(OrderCommodityEntity entity) {
        this.entity = entity;
    }

    @Override
    public List<OrderItemListBean> getOrderItemListBeans() {
        return this.orderItemListBeans;
    }

    @Override
    public void setOrderItemListBeans(List<OrderItemListBean> orderItemListBeans) {
        this.orderItemListBeans = orderItemListBeans;
    }

    @Override
    public List<OrderGiftBean> getOrderGiftBeans() {
        return this.orderGiftBeans;
    }

    @Override
    public void setOrderGiftBeans(List<OrderGiftBean> orderGiftBeans) {
        this.orderGiftBeans = orderGiftBeans;
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
    public String getDefaultImageAddrs() {
        if (null == entity) {
            return null;
        }
        return entity.getDefaultImageAddrs();
    }

    @Override
    public OrderCommodityStatus getCommodityStatus() {
        if (null == entity) {
            return null;
        }
        return OrderCommodityStatus.valueOf(entity.getCommodityStatus());
    }

    @Override
    public EvaluationStatus getEvaluationStatus() {
        if (null == entity) {
            return null;
        }
        return EvaluationStatus.valueOf(entity.getEvaluationStatus());
    }

    @Override
    public Integer getTimesExchanged() {
        if (null == entity) {
            return null;
        }
        return entity.getTimesExchanged();
    }

    @Override
    public void setOrderCmmdtyId(BigDecimal orderCmmdtyId) {
        if (null == entity) {
            entity = new OrderCommodityEntity();
        }
        entity.setOrderCmmdtyId(orderCmmdtyId);
    }

    @Override
    public void setOrderId(BigDecimal orderId) {
        if (null == entity) {
            entity = new OrderCommodityEntity();
        }
        entity.setOrderId(orderId);
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new OrderCommodityEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void setCmmdtyName(String cmmdtyName) {
        if (null == entity) {
            entity = new OrderCommodityEntity();
        }
        entity.setCmmdtyName(cmmdtyName);
    }

    @Override
    public void setProposedPrice(BigDecimal proposedPrice) {
        if (null == entity) {
            entity = new OrderCommodityEntity();
        }
        entity.setProposedPrice(proposedPrice);
    }

    @Override
    public void setActualPrice(BigDecimal actualPrice) {
        if (null == entity) {
            entity = new OrderCommodityEntity();
        }
        entity.setActualPrice(actualPrice);
    }

    @Override
    public void setQty(Integer qty) {
        if (null == entity) {
            entity = new OrderCommodityEntity();
        }
        entity.setQty(qty);
    }

    @Override
    public void setDefaultImageAddrs(String defaultImageAddrs) {
        if (null == entity) {
            entity = new OrderCommodityEntity();
        }
        entity.setDefaultImageAddrs(defaultImageAddrs);
    }

    @Override
    public void setCommodityStatus(OrderCommodityStatus commodityStatus) {
        if (null == entity) {
            entity = new OrderCommodityEntity();
        }
        entity.setCommodityStatus(commodityStatus.name());
    }

    @Override
    public void setEvaluationStatus(EvaluationStatus evaluationStatus) {
        if (null == entity) {
            entity = new OrderCommodityEntity();
        }
        entity.setEvaluationStatus(evaluationStatus.name());
    }

    @Override
    public void setTimesExchanged(Integer timesExchanged) {
        if (null == entity) {
            entity = new OrderCommodityEntity();
        }
        entity.setTimesExchanged(timesExchanged);
    }

    @Override
    public void saveRecursively() throws ZydException {
        this.save();
        if (null == this.getOrderCmmdtyId()) {
            throw new ZydException(ErrorCode.EZYD0002);
        }
        // 保存订单清单
        List<OrderItemListBean> itemList = this.getOrderItemListBeans();
        if (!CollectionUtils.isEmpty(itemList)) {
            for (OrderItemListBean item : itemList) {
                item.setOrderCmmdtyId(this.getOrderCmmdtyId());
                item.save();
            }
        }
        // 保存赠品
        List<OrderGiftBean> gifts = this.getOrderGiftBeans();
        if (CollectionUtils.isEmpty(gifts)) {
            return;
        }
        for (OrderGiftBean gift : gifts) {
            gift.setOrderCmmdtyId(this.getOrderCmmdtyId());
            gift.setOrderId(this.getOrderId());
            gift.saveRecursively();
        }
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            orderCommodityMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            orderCommodityMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void remove() throws ZydException {
        try {
            orderCommodityMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setOrderCmmdtyId(null);
        }
    }

}
