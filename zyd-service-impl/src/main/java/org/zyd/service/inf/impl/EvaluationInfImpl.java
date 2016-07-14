package org.zyd.service.inf.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.AddedEvalType;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.EvaluationLevel;
import org.zyd.common.constants.EvaluationStatus;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.AddedEvaluationBean;
import org.zyd.domain.bean.CommodityEvaluationBean;
import org.zyd.domain.bean.EvaluationImageBean;
import org.zyd.domain.bean.EvaluationLabelBean;
import org.zyd.domain.bean.OrderCommodityBean;
import org.zyd.domain.bean.PartyIdentifyBean;
import org.zyd.domain.bean.PurchaseOrderBean;
import org.zyd.domain.factory.EvaluationFactory;
import org.zyd.domain.repository.EvaluationRepos;
import org.zyd.domain.repository.OrderRepos;
import org.zyd.domain.repository.PartyRepos;
import org.zyd.service.convertor.EvaluationConvertor;
import org.zyd.service.dto.AddedEvaluationDto;
import org.zyd.service.dto.CommodityEvaluationDto;
import org.zyd.service.dto.EvaluationImageDto;
import org.zyd.service.dto.EvaluationLabelDto;
import org.zyd.service.inf.EvaluationInf;

public class EvaluationInfImpl implements EvaluationInf {
    @Autowired
    private EvaluationRepos evaluationRepos;
    @Autowired
    private EvaluationConvertor evaluationConvertor;
    @Autowired
    private OrderRepos orderRepos;
    @Autowired
    private PartyRepos partyRepos;
    @Autowired
    private EvaluationFactory evaluationFactory;

    @Override
    public List<CommodityEvaluationDto> queryEvaluationsByCommodity(BigDecimal cmmdtyId, int pageSize, int page)
            throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        List<CommodityEvaluationBean> beans = evaluationRepos.queryCommodityEvaluationBeansByCommodity(cmmdtyId,
                pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<CommodityEvaluationDto> dtos = new ArrayList<CommodityEvaluationDto>();
        for (CommodityEvaluationBean bean : beans) {
            dtos.add(evaluationConvertor.convertCommodityEvaluation(bean));
        }
        return dtos;
    }

    @Override
    public List<CommodityEvaluationDto> queryEvaluationsByLevel(BigDecimal cmmdtyId, EvaluationLevel evaluationLevel,
            int pageSize, int page) throws ZydException {
        if (null == cmmdtyId || null == evaluationLevel) {
            throw new IllegalArgumentException();
        }
        List<CommodityEvaluationBean> beans = evaluationRepos.queryCommodityEvaluationBeansByLevel(cmmdtyId,
                evaluationLevel, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<CommodityEvaluationDto> dtos = new ArrayList<CommodityEvaluationDto>();
        for (CommodityEvaluationBean bean : beans) {
            dtos.add(evaluationConvertor.convertCommodityEvaluation(bean));
        }
        return dtos;
    }

    @Override
    public int queryCountOfEvaluationsByLevel(BigDecimal cmmdtyId, EvaluationLevel evaluationLevel) throws ZydException {
        if (null == cmmdtyId || null == evaluationLevel) {
            throw new IllegalArgumentException();
        }
        return evaluationRepos.queryCountOfCommodityEvaluationBeansByLevel(cmmdtyId, evaluationLevel);
    }

    @Override
    public List<CommodityEvaluationDto> queryImagedEvaluations(BigDecimal cmmdtyId, int pageSize, int page)
            throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        List<CommodityEvaluationBean> beans = evaluationRepos.queryImagedCommodityEvaluationBeansByCommodity(cmmdtyId,
                pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<CommodityEvaluationDto> dtos = new ArrayList<CommodityEvaluationDto>();
        for (CommodityEvaluationBean bean : beans) {
            dtos.add(evaluationConvertor.convertCommodityEvaluation(bean));
        }
        return dtos;
    }

    @Override
    public int queryCountOfImagedEvaluations(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        return evaluationRepos.queryCountOfImagedCommodityEvaluationBeansByCommodity(cmmdtyId);
    }

    @Override
    public List<CommodityEvaluationDto> queryEvaluationsWithAddedEvaluations(BigDecimal cmmdtyId, int pageSize, int page)
            throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        List<CommodityEvaluationBean> beans = evaluationRepos
                .queryCommodityEvaluationBeansWhichContainsAddedEvaluationsByCommodity(cmmdtyId, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<CommodityEvaluationDto> dtos = new ArrayList<CommodityEvaluationDto>();
        for (CommodityEvaluationBean bean : beans) {
            dtos.add(evaluationConvertor.convertCommodityEvaluation(bean));
        }
        return dtos;
    }

    @Override
    public int queryCountOfEvaluationsWithAddedEvaluations(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        return evaluationRepos.queryCountOfCommodityEvaluationBeansWhichContainsAddedEvaluationsByCommodity(cmmdtyId);
    }

    @Override
    public List<CommodityEvaluationDto> queryEvaluationsByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        List<CommodityEvaluationBean> beans = evaluationRepos.queryCommodityEvaluationBeansByPartyId(partyId, pageSize,
                page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<CommodityEvaluationDto> dtos = new ArrayList<CommodityEvaluationDto>();
        for (CommodityEvaluationBean bean : beans) {
            dtos.add(evaluationConvertor.convertCommodityEvaluation(bean));
        }
        return dtos;
    }

    @Override
    public void createEvaluation(BigDecimal partyId, BigDecimal orderId, BigDecimal cmmdtyId, int numOfStars,
            String evalContent, List<BigDecimal> existLabelIds, List<String> newLabels, List<String> imageAddrs)
            throws ZydException {
        if (null == partyId || null == orderId || null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        if (numOfStars > 5 || numOfStars < 1) {
            throw new ZydException(ErrorCode.EZYDP003);
        }
        if (StringUtils.isEmpty(evalContent)) {
            throw new ZydException(ErrorCode.EZYDP004);
        }
        if (evalContent.length() < 5) {
            throw new ZydException(ErrorCode.EZYDP005);
        }
        if (evalContent.length() > 300) {
            throw new ZydException(ErrorCode.EZYDP006);
        }
        List<EvaluationLabelBean> evaluationLabelBeans = new ArrayList<EvaluationLabelBean>();
        if (!CollectionUtils.isEmpty(newLabels)) {
            for (String label : newLabels) {
                if (label.length() > 10) {
                    throw new ZydException(ErrorCode.EZYDP008);
                }
                EvaluationLabelBean labelBean = evaluationFactory.createEvaluationLabelBean();
                labelBean.setCmmdtyId(cmmdtyId);
                labelBean.setHitTimes(1);
                labelBean.setLabel(label);
                evaluationLabelBeans.add(labelBean);
            }
        }
        boolean containsImage = false;
        List<EvaluationImageBean> evaluationImageBeans = new ArrayList<EvaluationImageBean>();
        if (!CollectionUtils.isEmpty(imageAddrs)) {
            for (String addr : imageAddrs) {
                if (addr.length() > 200) {
                    throw new ZydException(ErrorCode.EZYDP009);
                }
                EvaluationImageBean image = evaluationFactory.createEvaluationImageBean();
                image.setImageAddrs(addr);
                evaluationImageBeans.add(image);
            }
            containsImage = true;
        }
        if (!CollectionUtils.isEmpty(existLabelIds)) {
            for (BigDecimal labelId : existLabelIds) {
                EvaluationLabelBean label = evaluationRepos.queryEvaluationLabelBeanByKey(labelId);
                if (null == label) {
                    throw new ZydException(ErrorCode.EZYDP007);
                }
                evaluationLabelBeans.add(label);
            }
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        PurchaseOrderBean order = orderRepos.queryPurchaseOrderByKey(orderId);
        if (null == order) {
            throw new ZydException(ErrorCode.EZYDP001);
        }
        OrderCommodityBean cmmdtyBean = orderRepos
                .queryOrderCommodityBeanByPurchaseOrderAndCommodity(orderId, cmmdtyId);
        if (null == cmmdtyBean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        if (EvaluationStatus.A4600020.equals(cmmdtyBean.getEvaluationStatus())) {
            throw new ZydException(ErrorCode.EZYDP002);
        }
        CommodityEvaluationBean evaluation = evaluationFactory.createCommodityEvaluationBean();
        if (numOfStars == 1) {
            evaluation.setEvalLevel(EvaluationLevel.A3100030);
        } else if (numOfStars < 4) {
            evaluation.setEvalLevel(EvaluationLevel.A3100020);
        } else {
            evaluation.setEvalLevel(EvaluationLevel.A3100010);
        }
        evaluation.setAddedEvaluationBeans(null);
        evaluation.setCmmdtyId(cmmdtyId);
        evaluation.setContainsAddedEval(false);
        evaluation.setEvalContent(evalContent);
        evaluation.setNumOfStars(numOfStars);
        evaluation.setOrderId(orderId);
        evaluation.setForbidden(false);
        evaluation.setContainsImage(containsImage);
        evaluation.setEvaluationImageBeans(evaluationImageBeans);
        evaluation.setEvaluationLabelBeans(evaluationLabelBeans);

        partyIdentifyBean.evaluateCommodity(evaluation);
    }

    @Override
    public void forbidEvaluation(BigDecimal evalId) throws ZydException {
        if (null == evalId) {
            throw new IllegalArgumentException();
        }
        CommodityEvaluationBean bean = evaluationRepos.queryCommodityEvaluationBeanByKey(evalId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDP010);
        }
        if (bean.isForbidden()) {
            throw new ZydException(ErrorCode.EZYDP011);
        }
        bean.change();
    }

    @Override
    public void acknowledgeEvaluation(BigDecimal evalId, String addedEvalContent) throws ZydException {
        if (null == evalId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(addedEvalContent)) {
            throw new ZydException(ErrorCode.EZYDP012);
        }
        if (addedEvalContent.length() < 5) {
            throw new ZydException(ErrorCode.EZYDP013);
        }
        if (addedEvalContent.length() > 300) {
            throw new ZydException(ErrorCode.EZYDP014);
        }
        CommodityEvaluationBean bean = evaluationRepos.queryCommodityEvaluationBeanByKey(evalId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDP010);
        }
        bean.addAddedEvaluation(AddedEvalType.A3150020, addedEvalContent);
    }

    @Override
    public List<EvaluationImageDto> queryImagesByEvaluation(BigDecimal evalId) throws ZydException {
        if (null == evalId) {
            throw new IllegalArgumentException();
        }
        List<EvaluationImageBean> beans = evaluationRepos.queryEvaluationImageBeansByEvaluation(evalId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<EvaluationImageDto> dtos = new ArrayList<EvaluationImageDto>();
        for (EvaluationImageBean bean : beans) {
            dtos.add(evaluationConvertor.convertEvaluationImage(bean));
        }
        return dtos;
    }

    @Override
    public List<AddedEvaluationDto> queryAddedEvaluations(BigDecimal evalId) throws ZydException {
        if (null == evalId) {
            throw new IllegalArgumentException();
        }
        List<AddedEvaluationBean> beans = evaluationRepos.queryAddedEvaluationBeansByEvaluation(evalId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<AddedEvaluationDto> dtos = new ArrayList<AddedEvaluationDto>();
        for (AddedEvaluationBean bean : beans) {
            dtos.add(evaluationConvertor.convertAddedEvaluation(bean));
        }
        return dtos;
    }

    @Override
    public void createAddedEvaluation(BigDecimal evalId, String addedEvalContent) throws ZydException {
        if (null == evalId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(addedEvalContent)) {
            throw new ZydException(ErrorCode.EZYDP015);
        }
        if (addedEvalContent.length() < 5) {
            throw new ZydException(ErrorCode.EZYDP016);
        }
        if (addedEvalContent.length() > 300) {
            throw new ZydException(ErrorCode.EZYDP017);
        }
        CommodityEvaluationBean eval = evaluationRepos.queryCommodityEvaluationBeanByKey(evalId);
        if (null == eval) {
            throw new ZydException(ErrorCode.EZYDP010);
        }

        eval.addAddedEvaluation(AddedEvalType.A3150010, addedEvalContent);
    }

    @Override
    public List<EvaluationLabelDto> queryEvaluationLabelsByCommodity(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        List<EvaluationLabelBean> beans = evaluationRepos.queryEvaluationLabelBeansByCommodity(cmmdtyId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<EvaluationLabelDto> dtos = new ArrayList<EvaluationLabelDto>();
        for (EvaluationLabelBean bean : beans) {
            dtos.add(evaluationConvertor.convertEvaluationLabel(bean));
        }
        return dtos;
    }

    @Override
    public List<EvaluationLabelDto> queryEvaluationLabelsByEvaluation(BigDecimal evalId) throws ZydException {
        if (null == evalId) {
            throw new IllegalArgumentException();
        }
        List<EvaluationLabelBean> beans = evaluationRepos.queryEvaluationLabelsByEvaluation(evalId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<EvaluationLabelDto> dtos = new ArrayList<EvaluationLabelDto>();
        for (EvaluationLabelBean bean : beans) {
            dtos.add(evaluationConvertor.convertEvaluationLabel(bean));
        }
        return dtos;
    }

}
