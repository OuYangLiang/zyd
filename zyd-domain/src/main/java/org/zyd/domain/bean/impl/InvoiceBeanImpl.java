package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.InvoiceBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.InvoiceType;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.InvoiceEntity;
import org.zyd.store.mapper.InvoiceMapper;

public class InvoiceBeanImpl implements InvoiceBean {

    private InvoiceEntity entity;

    @Autowired
    private InvoiceMapper invoiceMapper;

    public InvoiceBeanImpl(InvoiceEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getInvoiceId() {
        if (null == entity) {
            return null;
        }
        return entity.getInvoiceId();
    }

    @Override
    public InvoiceType getInvoiceType() {
        if (null == entity) {
            return null;
        }
        return InvoiceType.valueOf(entity.getInvoiceType());
    }

    @Override
    public String getInvoiceTitle() {
        if (null == entity) {
            return null;
        }
        return entity.getInvoiceTitle();
    }

    @Override
    public BigDecimal getOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderId();
    }

    @Override
    public void setInvoiceId(BigDecimal invoiceId) {
        if (null == entity) {
            entity = new InvoiceEntity();
        }
        entity.setInvoiceId(invoiceId);
    }

    @Override
    public void setInvoiceType(InvoiceType invoiceType) {
        if (null == entity) {
            entity = new InvoiceEntity();
        }
        entity.setInvoiceType(invoiceType.name());
    }

    @Override
    public void setInvoiceTitle(String invoiceTitle) {
        if (null == entity) {
            entity = new InvoiceEntity();
        }
        entity.setInvoiceTitle(invoiceTitle);
    }

    @Override
    public void setOrderId(BigDecimal orderId) {
        if (null == entity) {
            entity = new InvoiceEntity();
        }
        entity.setOrderId(orderId);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);

            invoiceMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            invoiceMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            invoiceMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setInvoiceId(null);
        }
    }
}
