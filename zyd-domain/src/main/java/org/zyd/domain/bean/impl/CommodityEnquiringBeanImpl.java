package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.CommodityEnquiringBean;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.exception.ZydException;
import org.zyd.store.entity.CommodityEnquiringEntity;
import org.zyd.store.mapper.CommodityEnquiringMapper;

public class CommodityEnquiringBeanImpl implements CommodityEnquiringBean {

    private CommodityEnquiringEntity entity;

    @Autowired
    private CommodityEnquiringMapper commodityEnquiringMapper;

    public CommodityEnquiringBeanImpl(CommodityEnquiringEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getEnquiringId() {
        if (null == entity) {
            return null;
        }
        return entity.getEnquiringId();
    }

    @Override
    public String getEnquiringContent() {
        if (null == entity) {
            return null;
        }
        return entity.getEnquiringContent();
    }

    @Override
    public Timestamp getEventTs() {
        if (null == entity) {
            return null;
        }
        return entity.getEventTs();
    }

    @Override
    public BigDecimal getCmmdtyId() {
        if (null == entity) {
            return null;
        }
        return entity.getCmmdtyId();
    }

    @Override
    public BigDecimal getPartyId() {
        if (null == entity) {
            return null;
        }
        return entity.getPartyId();
    }

    @Override
    public String getAnswerer() {
        if (null == entity) {
            return null;
        }
        return entity.getAnswerer();
    }

    @Override
    public String getAcntVal() {
        if (null == entity) {
            return null;
        }
        return entity.getAcntVal();
    }

    @Override
    public String getAnswer() {
        if (null == entity) {
            return null;
        }
        return entity.getAnswer();
    }

    @Override
    public Timestamp getAnswerTs() {
        if (null == entity) {
            return null;
        }
        return entity.getAnswerTs();
    }

    @Override
    public void setEnquiringId(BigDecimal enquiringId) {
        if (null == entity) {
            entity = new CommodityEnquiringEntity();
        }
        entity.setEnquiringId(enquiringId);
    }

    @Override
    public void setEnquiringContent(String enquiringContent) {
        if (null == entity) {
            entity = new CommodityEnquiringEntity();
        }
        entity.setEnquiringContent(enquiringContent);
    }

    @Override
    public void setEventTs(Timestamp eventTs) {
        if (null == entity) {
            entity = new CommodityEnquiringEntity();
        }
        entity.setEventTs(eventTs);
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new CommodityEnquiringEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new CommodityEnquiringEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void setAnswerer(String answerer) {
        if (null == entity) {
            entity = new CommodityEnquiringEntity();
        }
        entity.setAnswerer(answerer);
    }

    @Override
    public void setAnswer(String answer) {
        if (null == entity) {
            entity = new CommodityEnquiringEntity();
        }
        entity.setAnswer(answer);
    }

    @Override
    public void setAnswerTs(Timestamp answerTs) {
        if (null == entity) {
            entity = new CommodityEnquiringEntity();
        }
        entity.setAnswerTs(answerTs);
    }

    @Override
    public void setAcntVal(String acntVal) {
        if (null == entity) {
            entity = new CommodityEnquiringEntity();
        }
        entity.setAcntVal(acntVal);
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            entity.setEventTs(now);
            commodityEnquiringMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setAnswerTs(now);
            entity.setUpdateTime(now);
            commodityEnquiringMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            commodityEnquiringMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setEnquiringId(null);
        }
    }

}
