package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.ReturnOrderRefundInfoBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.RefundChannel;
import org.zyd.common.constants.RefundMethod;
import org.zyd.common.constants.RefundStatus;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.ReturnOrderRefundInfoEntity;
import org.zyd.store.mapper.ReturnOrderRefundInfoMapper;

public class ReturnOrderRefundInfoBeanImpl implements ReturnOrderRefundInfoBean {

    private ReturnOrderRefundInfoEntity entity;

    @Autowired
    private ReturnOrderRefundInfoMapper returnOrderRefundInfoMapper;

    public ReturnOrderRefundInfoBeanImpl(ReturnOrderRefundInfoEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getReturnOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getReturnOrderId();
    }

    @Override
    public Timestamp getSubmitTime() {
        if (null == entity) {
            return null;
        }
        return entity.getSubmitTime();
    }

    @Override
    public RefundMethod getRefundMethod() {
        if (null == entity) {
            return null;
        }
        return RefundMethod.valueOf(entity.getRefundMethod());
    }

    @Override
    public RefundChannel getRefundChannel() {
        if (null == entity) {
            return null;
        }
        return RefundChannel.valueOf(entity.getRefundChannel());
    }

    @Override
    public String getRefundAccount() {
        if (null == entity) {
            return null;
        }
        return entity.getRefundAccount();
    }

    @Override
    public String getRefundNum() {
        if (null == entity) {
            return null;
        }
        return entity.getRefundNum();
    }

    @Override
    public BigDecimal getRefundAmt() {
        if (null == entity) {
            return null;
        }
        return entity.getRefundAmt();
    }

    @Override
    public Timestamp getRefundTime() {
        if (null == entity) {
            return null;
        }
        return entity.getRefundTime();
    }

    @Override
    public RefundStatus getRefundStatus() {
        if (null == entity) {
            return null;
        }
        return RefundStatus.valueOf(entity.getRefundStatus());
    }

    @Override
    public BigDecimal getPartyId() {
        if (null == entity) {
            return null;
        }
        return entity.getPartyId();
    }

    @Override
    public void setReturnOrderId(BigDecimal returnOrderId) {
        if (null == entity) {
            entity = new ReturnOrderRefundInfoEntity();
        }
        entity.setReturnOrderId(returnOrderId);
    }

    @Override
    public void setSubmitTime(Timestamp submitTime) {
        if (null == entity) {
            entity = new ReturnOrderRefundInfoEntity();
        }
        entity.setSubmitTime(submitTime);
    }

    @Override
    public void setRefundMethod(RefundMethod refundMethod) {
        if (null == entity) {
            entity = new ReturnOrderRefundInfoEntity();
        }
        entity.setRefundMethod(refundMethod.name());
    }

    @Override
    public void setRefundChannel(RefundChannel refundChannel) {
        if (null == entity) {
            entity = new ReturnOrderRefundInfoEntity();
        }
        entity.setRefundChannel(refundChannel.name());
    }

    @Override
    public void setRefundAccount(String refundAccount) {
        if (null == entity) {
            entity = new ReturnOrderRefundInfoEntity();
        }
        entity.setRefundAccount(refundAccount);
    }

    @Override
    public void setRefundNum(String refundNum) {
        if (null == entity) {
            entity = new ReturnOrderRefundInfoEntity();
        }
        entity.setRefundNum(refundNum);
    }

    @Override
    public void setRefundAmt(BigDecimal refundAmt) {
        if (null == entity) {
            entity = new ReturnOrderRefundInfoEntity();
        }
        entity.setRefundAmt(refundAmt);
    }

    @Override
    public void setRefundTime(Timestamp refundTime) {
        if (null == entity) {
            entity = new ReturnOrderRefundInfoEntity();
        }
        entity.setRefundTime(refundTime);
    }

    @Override
    public void setRefundStatus(RefundStatus refundStatus) {
        if (null == entity) {
            entity = new ReturnOrderRefundInfoEntity();
        }
        entity.setRefundStatus(refundStatus.name());
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new ReturnOrderRefundInfoEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            returnOrderRefundInfoMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            returnOrderRefundInfoMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            returnOrderRefundInfoMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setReturnOrderId(null);
        }
    }

}
