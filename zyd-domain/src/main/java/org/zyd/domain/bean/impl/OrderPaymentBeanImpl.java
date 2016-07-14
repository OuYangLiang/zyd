package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.OrderPaymentBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.PaymentChannel;
import org.zyd.common.constants.PaymentMethod;
import org.zyd.common.constants.PaymentStatus;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.OrderPaymentEntity;
import org.zyd.store.mapper.OrderPaymentMapper;

public class OrderPaymentBeanImpl implements OrderPaymentBean {

    private OrderPaymentEntity entity;

    @Autowired
    private OrderPaymentMapper orderPaymentMapper;

    public OrderPaymentBeanImpl(OrderPaymentEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderId();
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        if (null == entity) {
            return null;
        }
        return PaymentMethod.valueOf(entity.getPaymentMethod());
    }

    @Override
    public PaymentChannel getPaymentChannel() {
        if (null == entity) {
            return null;
        }
        return PaymentChannel.valueOf(entity.getPaymentChannel());
    }

    @Override
    public String getPaymentAccount() {
        if (null == entity) {
            return null;
        }
        return entity.getPaymentAccount();
    }

    @Override
    public String getPaymentNum() {
        if (null == entity) {
            return null;
        }
        return entity.getPaymentNum();
    }

    @Override
    public BigDecimal getPaymentAmt() {
        if (null == entity) {
            return null;
        }
        return entity.getPaymentAmt();
    }

    @Override
    public Timestamp getPaymentTime() {
        if (null == entity) {
            return null;
        }
        return entity.getPaymentTime();
    }

    @Override
    public PaymentStatus getPaymentStatus() {
        if (null == entity) {
            return null;
        }
        return PaymentStatus.valueOf(entity.getPaymentStatus());
    }

    @Override
    public void setOrderId(BigDecimal orderId) {
        if (null == entity) {
            entity = new OrderPaymentEntity();
        }
        entity.setOrderId(orderId);
    }

    @Override
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        if (null == entity) {
            entity = new OrderPaymentEntity();
        }
        entity.setPaymentMethod(paymentMethod.name());
    }

    @Override
    public void setPaymentChannel(PaymentChannel paymentChannel) {
        if (null == entity) {
            entity = new OrderPaymentEntity();
        }
        entity.setPaymentChannel(paymentChannel.name());
    }

    @Override
    public void setPaymentAccount(String paymentAccount) {
        if (null == entity) {
            entity = new OrderPaymentEntity();
        }
        entity.setPaymentAccount(paymentAccount);
    }

    @Override
    public void setPaymentNum(String paymentNum) {
        if (null == entity) {
            entity = new OrderPaymentEntity();
        }
        entity.setPaymentNum(paymentNum);
    }

    @Override
    public void setPaymentAmt(BigDecimal paymentAmt) {
        if (null == entity) {
            entity = new OrderPaymentEntity();
        }
        entity.setPaymentAmt(paymentAmt);
    }

    @Override
    public void setPaymentTime(Timestamp paymentTime) {
        if (null == entity) {
            entity = new OrderPaymentEntity();
        }
        entity.setPaymentTime(paymentTime);
    }

    @Override
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        if (null == entity) {
            entity = new OrderPaymentEntity();
        }
        entity.setPaymentStatus(paymentStatus.name());
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            orderPaymentMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            orderPaymentMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            orderPaymentMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setOrderId(null);
        }
    }

}
