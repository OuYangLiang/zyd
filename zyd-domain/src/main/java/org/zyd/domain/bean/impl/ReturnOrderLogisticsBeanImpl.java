package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.ReturnOrderLogisticsBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.LogisticsCompCode;
import org.zyd.common.constants.ReturnOrderLogisticsType;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.ReturnOrderLogisticsEntity;
import org.zyd.store.mapper.ReturnOrderLogisticsMapper;

public class ReturnOrderLogisticsBeanImpl implements ReturnOrderLogisticsBean {

    private ReturnOrderLogisticsEntity entity;

    @Autowired
    private ReturnOrderLogisticsMapper returnOrderLogisticsMapper;

    public ReturnOrderLogisticsBeanImpl(ReturnOrderLogisticsEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getLogisticsId() {
        if (null == entity) {
            return null;
        }
        return entity.getLogisticsId();
    }

    @Override
    public ReturnOrderLogisticsType getLogisticsType() {
        if (null == entity) {
            return null;
        }
        return ReturnOrderLogisticsType.valueOf(entity.getLogisticsType());
    }

    @Override
    public LogisticsCompCode getLogisticsCompanyCode() {
        if (null == entity) {
            return null;
        }
        return LogisticsCompCode.valueOf(entity.getLogisticsCompanyCode());
    }

    @Override
    public String getLogisticsCompanyDesc() {
        if (null == entity) {
            return null;
        }
        return entity.getLogisticsCompanyDesc();
    }

    @Override
    public String getLogisticsNum() {
        if (null == entity) {
            return null;
        }
        return entity.getLogisticsNum();
    }

    @Override
    public BigDecimal getLogisticsAmt() {
        if (null == entity) {
            return null;
        }
        return entity.getLogisticsAmt();
    }

    @Override
    public boolean isFreeLogisticsAmt() {
        if (null == entity) {
            return false;
        }
        return entity.isFreeLogisticsAmt();
    }

    @Override
    public BigDecimal getReturnOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getReturnOrderId();
    }

    @Override
    public void setLogisticsId(BigDecimal logisticsId) {
        if (null == entity) {
            entity = new ReturnOrderLogisticsEntity();
        }
        entity.setLogisticsId(logisticsId);
    }

    @Override
    public void setLogisticsType(ReturnOrderLogisticsType logisticsType) {
        if (null == entity) {
            entity = new ReturnOrderLogisticsEntity();
        }
        entity.setLogisticsType(logisticsType.name());
    }

    @Override
    public void setLogisticsCompanyCode(LogisticsCompCode logisticsCompanyCode) {
        if (null == entity) {
            entity = new ReturnOrderLogisticsEntity();
        }
        entity.setLogisticsCompanyCode(logisticsCompanyCode.name());
    }

    @Override
    public void setLogisticsCompanyDesc(String logisticsCompanyDesc) {
        if (null == entity) {
            entity = new ReturnOrderLogisticsEntity();
        }
        entity.setLogisticsCompanyDesc(logisticsCompanyDesc);
    }

    @Override
    public void setLogisticsNum(String logisticsNum) {
        if (null == entity) {
            entity = new ReturnOrderLogisticsEntity();
        }
        entity.setLogisticsNum(logisticsNum);
    }

    @Override
    public void setLogisticsAmt(BigDecimal logisticsAmt) {
        if (null == entity) {
            entity = new ReturnOrderLogisticsEntity();
        }
        entity.setLogisticsAmt(logisticsAmt);
    }

    @Override
    public void setFreeLogisticsAmt(boolean freeLogisticsAmt) {
        if (null == entity) {
            entity = new ReturnOrderLogisticsEntity();
        }
        entity.setFreeLogisticsAmt(freeLogisticsAmt);
    }

    @Override
    public void setReturnOrderId(BigDecimal returnOrderId) {
        if (null == entity) {
            entity = new ReturnOrderLogisticsEntity();
        }
        entity.setReturnOrderId(returnOrderId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            returnOrderLogisticsMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            returnOrderLogisticsMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            returnOrderLogisticsMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setLogisticsId(null);
        }
    }

}
