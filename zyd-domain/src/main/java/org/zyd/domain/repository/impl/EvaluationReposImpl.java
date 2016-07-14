package org.zyd.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.EvaluationLevel;
import org.zyd.common.constants.SortCriteria;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.AddedEvaluationBean;
import org.zyd.domain.bean.CommodityEvaluationBean;
import org.zyd.domain.bean.EvaluationImageBean;
import org.zyd.domain.bean.EvaluationLabelBean;
import org.zyd.domain.factory.EvaluationFactory;
import org.zyd.domain.repository.EvaluationRepos;
import org.zyd.store.entity.AddedEvaluationEntity;
import org.zyd.store.entity.CommodityEvaluationEntity;
import org.zyd.store.entity.EvaluationImageEntity;
import org.zyd.store.entity.EvaluationLabelEntity;
import org.zyd.store.entity.EvaluationLabelRelEntity;
import org.zyd.store.mapper.AddedEvaluationMapper;
import org.zyd.store.mapper.CommodityEvaluationMapper;
import org.zyd.store.mapper.EvaluationImageMapper;
import org.zyd.store.mapper.EvaluationLabelMapper;
import org.zyd.store.mapper.EvaluationLabelRelMapper;
import org.zyd.store.term.AddedEvaluationTerm;
import org.zyd.store.term.CommodityEvaluationTerm;
import org.zyd.store.term.EvaluationImageTerm;
import org.zyd.store.term.EvaluationLabelRelTerm;
import org.zyd.store.term.EvaluationLabelTerm;

public class EvaluationReposImpl implements EvaluationRepos {

    @Autowired
    private CommodityEvaluationMapper commodityEvaluationMapper;
    @Autowired
    private EvaluationImageMapper evaluationImageMapper;
    @Autowired
    private AddedEvaluationMapper addedEvaluationMapper;
    @Autowired
    private EvaluationLabelMapper evaluationLabelMapper;
    @Autowired
    private EvaluationLabelRelMapper evaluationLabelRelMapper;
    @Autowired
    private EvaluationFactory evaluationFactory;

    @Override
    public List<CommodityEvaluationBean> queryCommodityEvaluationBeansByCommodity(BigDecimal cmmdtyId, int pageSize,
            int page) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityEvaluationTerm term = new CommodityEvaluationTerm();
        term.setCmmdtyId(cmmdtyId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.commodity_evaluation_event_ts_desc.getField());
        term.setSortDir(SortCriteria.commodity_evaluation_event_ts_desc.getDir());
        List<CommodityEvaluationEntity> entitys = commodityEvaluationMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityEvaluationBean> rlt = new ArrayList<CommodityEvaluationBean>();
        for (CommodityEvaluationEntity entity : entitys) {
            rlt.add(evaluationFactory.createCommodityEvaluationBean(entity));
        }
        return rlt;
    }

    @Override
    public List<CommodityEvaluationBean> queryCommodityEvaluationBeansByLevel(BigDecimal cmmdtyId,
            EvaluationLevel evaluationLevel, int pageSize, int page) throws ZydException {
        if (null == cmmdtyId || null == evaluationLevel) {
            throw new IllegalArgumentException();
        }
        CommodityEvaluationTerm term = new CommodityEvaluationTerm();
        term.setCmmdtyId(cmmdtyId);
        term.setEvalLevel(evaluationLevel.name());
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.commodity_evaluation_event_ts_desc.getField());
        term.setSortDir(SortCriteria.commodity_evaluation_event_ts_desc.getDir());
        List<CommodityEvaluationEntity> entitys = commodityEvaluationMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityEvaluationBean> rlt = new ArrayList<CommodityEvaluationBean>();
        for (CommodityEvaluationEntity entity : entitys) {
            rlt.add(evaluationFactory.createCommodityEvaluationBean(entity));
        }
        return rlt;
    }

    @Override
    public int queryCountOfCommodityEvaluationBeansByLevel(BigDecimal cmmdtyId, EvaluationLevel evaluationLevel)
            throws ZydException {
        if (null == cmmdtyId || null == evaluationLevel) {
            throw new IllegalArgumentException();
        }
        CommodityEvaluationTerm term = new CommodityEvaluationTerm();
        term.setCmmdtyId(cmmdtyId);
        term.setEvalLevel(evaluationLevel.name());
        term.setForbidden(false);
        return commodityEvaluationMapper.countOfSummary(term);
    }

    @Override
    public List<CommodityEvaluationBean> queryImagedCommodityEvaluationBeansByCommodity(BigDecimal cmmdtyId,
            int pageSize, int page) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityEvaluationTerm term = new CommodityEvaluationTerm();
        term.setCmmdtyId(cmmdtyId);
        // 是否有图片
        term.setContainsImage(true);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.commodity_evaluation_event_ts_desc.getField());
        term.setSortDir(SortCriteria.commodity_evaluation_event_ts_desc.getDir());
        List<CommodityEvaluationEntity> entitys = commodityEvaluationMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityEvaluationBean> rlt = new ArrayList<CommodityEvaluationBean>();
        for (CommodityEvaluationEntity entity : entitys) {
            rlt.add(evaluationFactory.createCommodityEvaluationBean(entity));
        }
        return rlt;
    }

    @Override
    public int queryCountOfImagedCommodityEvaluationBeansByCommodity(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityEvaluationTerm term = new CommodityEvaluationTerm();
        term.setCmmdtyId(cmmdtyId);
        // 是否有图片
        term.setContainsImage(true);
        term.setForbidden(false);
        return commodityEvaluationMapper.countOfSummary(term);
    }

    @Override
    public List<CommodityEvaluationBean> queryCommodityEvaluationBeansWhichContainsAddedEvaluationsByCommodity(
            BigDecimal cmmdtyId, int pageSize, int page) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityEvaluationTerm term = new CommodityEvaluationTerm();
        term.setCmmdtyId(cmmdtyId);
        // 是否有追评
        term.setContainsAddedEval(true);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.commodity_evaluation_event_ts_desc.getField());
        term.setSortDir(SortCriteria.commodity_evaluation_event_ts_desc.getDir());
        List<CommodityEvaluationEntity> entitys = commodityEvaluationMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityEvaluationBean> rlt = new ArrayList<CommodityEvaluationBean>();
        for (CommodityEvaluationEntity entity : entitys) {
            rlt.add(evaluationFactory.createCommodityEvaluationBean(entity));
        }
        return rlt;
    }

    @Override
    public int queryCountOfCommodityEvaluationBeansWhichContainsAddedEvaluationsByCommodity(BigDecimal cmmdtyId)
            throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        CommodityEvaluationTerm term = new CommodityEvaluationTerm();
        term.setCmmdtyId(cmmdtyId);
        // 是否有追评
        term.setContainsAddedEval(true);
        term.setForbidden(false);
        return commodityEvaluationMapper.countOfSummary(term);
    }

    @Override
    public List<CommodityEvaluationBean> queryCommodityEvaluationBeansByPartyId(BigDecimal partyId, int pageSize,
            int page) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        CommodityEvaluationTerm term = new CommodityEvaluationTerm();
        term.setPartyId(partyId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.commodity_evaluation_event_ts_desc.getField());
        term.setSortDir(SortCriteria.commodity_evaluation_event_ts_desc.getDir());
        List<CommodityEvaluationEntity> entitys = commodityEvaluationMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<CommodityEvaluationBean> rlt = new ArrayList<CommodityEvaluationBean>();
        for (CommodityEvaluationEntity entity : entitys) {
            rlt.add(evaluationFactory.createCommodityEvaluationBean(entity));
        }
        return rlt;
    }

    @Override
    public CommodityEvaluationBean queryCommodityEvaluationBeanByKey(BigDecimal evalId) throws ZydException {
        if (null == evalId) {
            throw new IllegalArgumentException();
        }
        CommodityEvaluationTerm term = new CommodityEvaluationTerm();
        term.setEvalId(evalId);
        List<CommodityEvaluationEntity> entitys = commodityEvaluationMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return evaluationFactory.createCommodityEvaluationBean(entitys.get(0));
    }

    @Override
    public List<EvaluationImageBean> queryEvaluationImageBeansByEvaluation(BigDecimal evalId) throws ZydException {
        if (null == evalId) {
            throw new IllegalArgumentException();
        }
        EvaluationImageTerm term = new EvaluationImageTerm();
        term.setEvalId(evalId);
        term.setSortField(SortCriteria.evaluation_image_image_seq_asc.getField());
        term.setSortDir(SortCriteria.evaluation_image_image_seq_asc.getDir());
        List<EvaluationImageEntity> entitys = evaluationImageMapper.selectWithSort(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<EvaluationImageBean> rlt = new ArrayList<EvaluationImageBean>();
        for (EvaluationImageEntity entity : entitys) {
            rlt.add(evaluationFactory.createEvaluationImageBean(entity));
        }
        return rlt;
    }

    @Override
    public List<AddedEvaluationBean> queryAddedEvaluationBeansByEvaluation(BigDecimal evalId) throws ZydException {
        if (null == evalId) {
            throw new IllegalArgumentException();
        }
        AddedEvaluationTerm term = new AddedEvaluationTerm();
        term.setEvalId(evalId);
        term.setSortField(SortCriteria.added_evaluation_event_ts_asc.getField());
        term.setSortDir(SortCriteria.added_evaluation_event_ts_asc.getDir());
        List<AddedEvaluationEntity> entitys = addedEvaluationMapper.selectWithSort(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<AddedEvaluationBean> rlt = new ArrayList<AddedEvaluationBean>();
        for (AddedEvaluationEntity entity : entitys) {
            rlt.add(evaluationFactory.createAddedEvaluationBean(entity));
        }
        return rlt;
    }

    @Override
    public List<EvaluationLabelBean> queryEvaluationLabelBeansByCommodity(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        EvaluationLabelTerm term = new EvaluationLabelTerm();
        term.setCmmdtyId(cmmdtyId);
        term.setSortField(SortCriteria.evaluation_label_hit_times_desc.getField());
        term.setSortDir(SortCriteria.evaluation_label_hit_times_desc.getDir());
        List<EvaluationLabelEntity> entitys = evaluationLabelMapper.selectWithSort(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<EvaluationLabelBean> rlt = new ArrayList<EvaluationLabelBean>();
        for (EvaluationLabelEntity entity : entitys) {
            rlt.add(evaluationFactory.createEvaluationLabelBean(entity));
        }
        return rlt;
    }

    @Override
    public EvaluationLabelBean queryEvaluationLabelBeanByKey(BigDecimal labelId) throws ZydException {
        if (null == labelId) {
            throw new IllegalArgumentException();
        }
        EvaluationLabelTerm term = new EvaluationLabelTerm();
        term.setLabelId(labelId);
        List<EvaluationLabelEntity> entitys = evaluationLabelMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        return evaluationFactory.createEvaluationLabelBean(entitys.get(0));
    }

    @Override
    public List<EvaluationLabelBean> queryEvaluationLabelsByEvaluation(BigDecimal evalId) throws ZydException {
        if (null == evalId) {
            throw new IllegalArgumentException();
        }
        EvaluationLabelRelTerm term = new EvaluationLabelRelTerm();
        term.setEvalId(evalId);
        List<EvaluationLabelRelEntity> entitys = evaluationLabelRelMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<EvaluationLabelBean> rlt = new ArrayList<EvaluationLabelBean>();
        for (EvaluationLabelRelEntity entity : entitys) {
            EvaluationLabelTerm param = new EvaluationLabelTerm();
            param.setLabelId(entity.getLabelId());
            List<EvaluationLabelEntity> labels = evaluationLabelMapper.select(param);
            if (CollectionUtils.isEmpty(labels)) {
                continue;
            }
            rlt.add(evaluationFactory.createEvaluationLabelBean(labels.get(0)));
        }
        return rlt;
    }

}
