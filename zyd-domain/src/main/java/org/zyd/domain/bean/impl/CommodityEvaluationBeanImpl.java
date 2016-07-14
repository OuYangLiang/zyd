package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.AddedEvalType;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.EvaluationLevel;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.AddedEvaluationBean;
import org.zyd.domain.bean.CommodityEvaluationBean;
import org.zyd.domain.bean.EvaluationImageBean;
import org.zyd.domain.bean.EvaluationLabelBean;
import org.zyd.domain.factory.EvaluationFactory;
import org.zyd.store.entity.CommodityEvaluationEntity;
import org.zyd.store.entity.EvaluationLabelRelEntity;
import org.zyd.store.mapper.CommodityEvaluationMapper;
import org.zyd.store.mapper.EvaluationLabelMapper;
import org.zyd.store.mapper.EvaluationLabelRelMapper;

public class CommodityEvaluationBeanImpl implements CommodityEvaluationBean {

    private CommodityEvaluationEntity entity;
    private List<EvaluationImageBean> evaluationImageBeans;
    private List<EvaluationLabelBean> evaluationLabelBeans;
    private List<AddedEvaluationBean> addedEvaluationBeans;

    @Autowired
    private CommodityEvaluationMapper commodityEvaluationMapper;
    @Autowired
    private EvaluationLabelMapper evaluationLabelMapper;
    @Autowired
    private EvaluationLabelRelMapper evaluationLabelRelMapper;
    @Autowired
    private EvaluationFactory evaluationFactory;

    public CommodityEvaluationBeanImpl(CommodityEvaluationEntity entity) {
        this.entity = entity;
    }

    @Override
    public List<EvaluationImageBean> getEvaluationImageBeans() {
        return evaluationImageBeans;
    }

    @Override
    public void setEvaluationImageBeans(List<EvaluationImageBean> evaluationImageBeans) {
        this.evaluationImageBeans = evaluationImageBeans;
    }

    @Override
    public List<EvaluationLabelBean> getEvaluationLabelBeans() {
        return evaluationLabelBeans;
    }

    @Override
    public void setEvaluationLabelBeans(List<EvaluationLabelBean> evaluationLabelBeans) {
        this.evaluationLabelBeans = evaluationLabelBeans;
    }

    @Override
    public List<AddedEvaluationBean> getAddedEvaluationBeans() {
        return addedEvaluationBeans;
    }

    @Override
    public void setAddedEvaluationBeans(List<AddedEvaluationBean> addedEvaluationBeans) {
        this.addedEvaluationBeans = addedEvaluationBeans;
    }

    @Override
    public BigDecimal getEvalId() {
        if (null == entity) {
            return null;
        }
        return entity.getEvalId();
    }

    @Override
    public EvaluationLevel getEvalLevel() {
        if (null == entity) {
            return null;
        }
        return EvaluationLevel.valueOf(entity.getEvalLevel());
    }

    @Override
    public Integer getNumOfStars() {
        if (null == entity) {
            return null;
        }
        return entity.getNumOfStars();
    }

    @Override
    public String getEvalContent() {
        if (null == entity) {
            return null;
        }
        return entity.getEvalContent();
    }

    @Override
    public Timestamp getEventTs() {
        if (null == entity) {
            return null;
        }
        return entity.getEventTs();
    }

    @Override
    public boolean isContainsImage() {
        if (null == entity) {
            return false;
        }
        return entity.isContainsImage();
    }

    @Override
    public boolean isContainsAddedEval() {
        if (null == entity) {
            return false;
        }
        return entity.isContainsAddedEval();
    }

    @Override
    public boolean isForbidden() {
        if (null == entity) {
            return false;
        }
        return entity.isForbidden();
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
    public BigDecimal getOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderId();
    }

    @Override
    public void setEvalId(BigDecimal evalId) {
        if (null == entity) {
            entity = new CommodityEvaluationEntity();
        }
        entity.setEvalId(evalId);
    }

    @Override
    public void setEvalLevel(EvaluationLevel evalLevel) {
        if (null == entity) {
            entity = new CommodityEvaluationEntity();
        }
        entity.setEvalLevel(evalLevel.name());
    }

    @Override
    public void setNumOfStars(Integer numOfStars) {
        if (null == entity) {
            entity = new CommodityEvaluationEntity();
        }
        entity.setNumOfStars(numOfStars);
    }

    @Override
    public void setEvalContent(String evalContent) {
        if (null == entity) {
            entity = new CommodityEvaluationEntity();
        }
        entity.setEvalContent(evalContent);
    }

    @Override
    public void setEventTs(Timestamp eventTs) {
        if (null == entity) {
            entity = new CommodityEvaluationEntity();
        }
        entity.setEventTs(eventTs);
    }

    @Override
    public void setContainsImage(boolean containsImage) {
        if (null == entity) {
            entity = new CommodityEvaluationEntity();
        }
        entity.setContainsImage(containsImage);
    }

    @Override
    public void setContainsAddedEval(boolean containsAddedEval) {
        if (null == entity) {
            entity = new CommodityEvaluationEntity();
        }
        entity.setContainsAddedEval(containsAddedEval);
    }

    @Override
    public void setForbidden(boolean forbidden) {
        if (null == entity) {
            entity = new CommodityEvaluationEntity();
        }
        entity.setForbidden(forbidden);
    }

    @Override
    public void setCmmdtyId(BigDecimal cmmdtyId) {
        if (null == entity) {
            entity = new CommodityEvaluationEntity();
        }
        entity.setCmmdtyId(cmmdtyId);
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new CommodityEvaluationEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void setOrderId(BigDecimal orderId) {
        if (null == entity) {
            entity = new CommodityEvaluationEntity();
        }
        entity.setOrderId(orderId);
    }

    @Override
    public void saveRecursively() throws ZydException {
        this.save();

        // TODO 商品评价总数修改

        BigDecimal evalId = this.getEvalId();

        if (null == evalId)
            throw new ZydException(ErrorCode.EZYD0002);

        List<EvaluationImageBean> images = this.getEvaluationImageBeans();
        if (!CollectionUtils.isEmpty(images)) {
            int i = 1;
            for (EvaluationImageBean image : images) {
                image.setEvalId(evalId);
                image.setImageSeq(i++);
                image.save();
            }
        }
        List<EvaluationLabelBean> labels = this.getEvaluationLabelBeans();
        if (!CollectionUtils.isEmpty(labels)) {
            for (EvaluationLabelBean label : labels) {
                if (null == label.getLabelId()) {
                    label.setHitTimes(1);
                    label.save();
                } else {
                    label.hit();
                }

                EvaluationLabelRelEntity entity = new EvaluationLabelRelEntity();
                entity.setEvalId(evalId);
                entity.setLabelId(label.getLabelId());
                evaluationLabelRelMapper.insert(entity);
            }
        }
    }

    @Override
    public void addAddedEvaluation(AddedEvalType addedEvalType, String addedEvalContent) throws ZydException {
        if (null == addedEvalType || StringUtils.isEmpty(addedEvalContent)) {
            throw new IllegalArgumentException();
        }
        AddedEvaluationBean bean = evaluationFactory.createAddedEvaluationBean();
        bean.setAddedEvalContent(addedEvalContent);
        bean.setAddedEvalType(addedEvalType);
        bean.setEvalId(this.getEvalId());
        bean.setEventTs(new Timestamp(new Date().getTime()));
        bean.save();
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            entity.setEventTs(now);

            commodityEvaluationMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            commodityEvaluationMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void remove() throws ZydException {
        try {
            commodityEvaluationMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setEvalId(null);
        }
    }
}
