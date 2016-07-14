package org.zyd.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.AccountType;
import org.zyd.common.constants.ContactType;
import org.zyd.common.constants.PasswordType;
import org.zyd.common.constants.Scenario;
import org.zyd.common.constants.SortCriteria;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.PartyAccountBean;
import org.zyd.domain.bean.PartyContactInfoBean;
import org.zyd.domain.bean.PartyIdentifyBean;
import org.zyd.domain.bean.PartyInfoBean;
import org.zyd.domain.bean.PartyLevelBean;
import org.zyd.domain.bean.PartyPasswordBean;
import org.zyd.domain.bean.PartyPointBean;
import org.zyd.domain.bean.PointEventBean;
import org.zyd.domain.bean.ShoppingCartBean;
import org.zyd.domain.bean.ShoppingCartItemBean;
import org.zyd.domain.cache.PartyAccountCacheByKey;
import org.zyd.domain.cache.PartyAccountCacheByVal;
import org.zyd.domain.factory.PartyFactory;
import org.zyd.domain.repository.PartyRepos;
import org.zyd.store.entity.PartyAccountEntity;
import org.zyd.store.entity.PartyContactInfoEntity;
import org.zyd.store.entity.PartyIdentifyEntity;
import org.zyd.store.entity.PartyInfoEntity;
import org.zyd.store.entity.PartyLevelEntity;
import org.zyd.store.entity.PartyPasswordEntity;
import org.zyd.store.entity.PartyPointEntity;
import org.zyd.store.entity.PointEventEntity;
import org.zyd.store.entity.ShoppingCartEntity;
import org.zyd.store.mapper.PartyAccountMapper;
import org.zyd.store.mapper.PartyContactInfoMapper;
import org.zyd.store.mapper.PartyIdentifyMapper;
import org.zyd.store.mapper.PartyInfoMapper;
import org.zyd.store.mapper.PartyLevelMapper;
import org.zyd.store.mapper.PartyPasswordMapper;
import org.zyd.store.mapper.PartyPointMapper;
import org.zyd.store.mapper.PointEventMapper;
import org.zyd.store.mapper.ShoppingCartMapper;
import org.zyd.store.term.PartyAccountTerm;
import org.zyd.store.term.PartyContactInfoTerm;
import org.zyd.store.term.PartyIdentifyTerm;
import org.zyd.store.term.PartyInfoTerm;
import org.zyd.store.term.PartyLevelTerm;
import org.zyd.store.term.PartyPasswordTerm;
import org.zyd.store.term.PartyPointTerm;
import org.zyd.store.term.PointEventTerm;
import org.zyd.store.term.ShoppingCartTerm;

public class PartyReposImpl implements PartyRepos {

    @Autowired
    private PartyIdentifyMapper partyIdentifyMapper;
    @Autowired
    private PartyInfoMapper partyInfoMapper;
    @Autowired
    private PartyContactInfoMapper partyContactInfoMapper;
    @Autowired
    private PartyAccountMapper partyAccountMapper;
    @Autowired
    private PartyPasswordMapper partyPasswordMapper;
    @Autowired
    private PartyPointMapper partyPointMapper;
    @Autowired
    private PointEventMapper pointEventMapper;
    @Autowired
    private PartyLevelMapper partyLevelMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private PartyFactory partyFactory;
    @Autowired
    private PartyAccountCacheByVal partyAccountCacheByVal;
    @Autowired
    private PartyAccountCacheByKey partyAccountCacheByKey;

    @Override
    public PartyIdentifyBean queryPartyIdentifyByKey(BigDecimal partyId) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        PartyIdentifyTerm term = new PartyIdentifyTerm();
        term.setPartyId(partyId);
        List<PartyIdentifyEntity> entitys = partyIdentifyMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return partyFactory.createPartyIdentifyBean(entitys.get(0));
    }

    @Override
    public PartyIdentifyBean queryPartyIdentifyByRecommendCode(String recommendCode) throws ZydException {
        if (StringUtils.isEmpty(recommendCode)) {
            throw new IllegalArgumentException();
        }
        PartyIdentifyTerm term = new PartyIdentifyTerm();
        term.setRecommendCode(recommendCode);
        List<PartyIdentifyEntity> entitys = partyIdentifyMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return partyFactory.createPartyIdentifyBean(entitys.get(0));
    }

    @Override
    public PartyInfoBean queryPartyInfoByKey(BigDecimal partyId) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        PartyInfoTerm term = new PartyInfoTerm();
        term.setPartyId(partyId);
        List<PartyInfoEntity> entitys = partyInfoMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return partyFactory.createPartyInfoBean(entitys.get(0));
    }

    @Override
    public PartyContactInfoBean queryPartyContactInfoBeanByKey(BigDecimal cntctId) throws ZydException {
        if (null == cntctId) {
            throw new IllegalArgumentException();
        }
        PartyContactInfoTerm term = new PartyContactInfoTerm();
        term.setCntctId(cntctId);
        List<PartyContactInfoEntity> entitys = partyContactInfoMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return partyFactory.createPartyContactInfoBean(entitys.get(0));
    }

    @Override
    public List<PartyContactInfoBean> queryPartyContactInfoBeans(BigDecimal partyId, ContactType cntctType)
            throws ZydException {
        if (null == partyId || null == cntctType) {
            throw new IllegalArgumentException();
        }
        PartyContactInfoTerm term = new PartyContactInfoTerm();
        term.setPartyId(partyId);
        term.setCntctType(cntctType.name());
        term.setSortField(SortCriteria.party_cntct_info_cntct_seq_asc.getField());
        term.setSortDir(SortCriteria.party_cntct_info_cntct_seq_asc.getDir());
        List<PartyContactInfoEntity> entitys = partyContactInfoMapper.selectWithSort(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<PartyContactInfoBean> rlt = new ArrayList<PartyContactInfoBean>();
        for (PartyContactInfoEntity entity : entitys) {
            rlt.add(partyFactory.createPartyContactInfoBean(entity));
        }
        return rlt;
    }

    @Override
    public PartyAccountBean queryPartyAccountByKey(BigDecimal acntId) throws ZydException {
        if (null == acntId) {
            throw new IllegalArgumentException();
        }

        PartyAccountBean rlt = partyAccountCacheByKey.queryAccount(acntId);
        if (null != rlt) {
            return rlt;
        }

        PartyAccountTerm term = new PartyAccountTerm();
        term.setAcntId(acntId);
        List<PartyAccountEntity> entitys = partyAccountMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        rlt = partyFactory.createPartyAccountBean(entitys.get(0));
        partyAccountCacheByKey.add(rlt);

        return rlt;
    }

    @Override
    public PartyAccountBean queryPartyAccountByVal(String acntVal) throws ZydException {
        if (StringUtils.isEmpty(acntVal)) {
            throw new IllegalArgumentException();
        }

        PartyAccountBean rlt = partyAccountCacheByVal.queryAccount(acntVal);
        if (null != rlt) {
            return rlt;
        }

        PartyAccountTerm term = new PartyAccountTerm();
        term.setAcntVal(acntVal);
        List<PartyAccountEntity> entitys = partyAccountMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        rlt = partyFactory.createPartyAccountBean(entitys.get(0));
        partyAccountCacheByVal.add(rlt);

        return rlt;
    }

    @Override
    public PartyAccountBean queryPartyAccountByType(BigDecimal partyId, AccountType acntType) throws ZydException {
        if (null == partyId || null == acntType) {
            throw new IllegalArgumentException();
        }
        PartyAccountTerm term = new PartyAccountTerm();
        term.setPartyId(partyId);
        term.setAcntType(acntType.name());
        List<PartyAccountEntity> entitys = partyAccountMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return partyFactory.createPartyAccountBean(entitys.get(0));
    }

    @Override
    public PartyPasswordBean queryPasswordByKey(BigDecimal pwdId) throws ZydException {
        if (null == pwdId) {
            throw new IllegalArgumentException();
        }
        PartyPasswordTerm term = new PartyPasswordTerm();
        term.setPwdId(pwdId);
        List<PartyPasswordEntity> entitys = partyPasswordMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return partyFactory.createPartyPasswordBean(entitys.get(0));
    }

    @Override
    public PartyPasswordBean queryPasswordByType(BigDecimal partyId, PasswordType pwdType) throws ZydException {
        if (null == partyId || null == pwdType) {
            throw new IllegalArgumentException();
        }
        PartyPasswordTerm term = new PartyPasswordTerm();
        term.setPartyId(partyId);
        term.setPwdType(pwdType.name());
        List<PartyPasswordEntity> entitys = partyPasswordMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return partyFactory.createPartyPasswordBean(entitys.get(0));
    }

    @Override
    public PartyPointBean queryPartyPointByKey(BigDecimal partyId) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        PartyPointTerm term = new PartyPointTerm();
        term.setPartyId(partyId);
        List<PartyPointEntity> entitys = partyPointMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return partyFactory.createPartyPointBean(entitys.get(0));
    }

    @Override
    public List<PointEventBean> queryPointEvents(BigDecimal partyId, int pageSize, int page) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        PointEventTerm term = new PointEventTerm();
        term.setPartyId(partyId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.point_event_event_ts_desc.getField());
        term.setSortDir(SortCriteria.point_event_event_ts_desc.getDir());
        List<PointEventEntity> entitys = pointEventMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<PointEventBean> rlt = new ArrayList<PointEventBean>();
        for (PointEventEntity entity : entitys) {
            rlt.add(partyFactory.createPointEventBean(entity));
        }
        return rlt;
    }

    @Override
    public PointEventBean queryPointEvent(String orderNum, Scenario scenario) throws ZydException {
        if (StringUtils.isEmpty(orderNum) || null == scenario) {
            throw new IllegalArgumentException();
        }
        PointEventTerm term = new PointEventTerm();
        term.setOrderNum(orderNum);
        term.setScenario(scenario.name());
        List<PointEventEntity> entitys = pointEventMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return partyFactory.createPointEventBean(entitys.get(0));
    }

    @Override
    public PartyLevelBean queryPartyLevel(BigDecimal partyId) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        PartyLevelTerm term = new PartyLevelTerm();
        term.setPartyId(partyId);
        List<PartyLevelEntity> entitys = partyLevelMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return partyFactory.createPartyLevelBean(entitys.get(0));
    }

    @Override
    public ShoppingCartBean queryShoppingCartBeanByParty(BigDecimal partyId) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        ShoppingCartTerm term = new ShoppingCartTerm();
        term.setPartyId(partyId);
        List<ShoppingCartEntity> entitys = shoppingCartMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        List<ShoppingCartItemBean> items = new ArrayList<ShoppingCartItemBean>();
        for (ShoppingCartEntity entity : entitys) {
            items.add(partyFactory.createShoppingCartItemBean(entity));
        }
        ShoppingCartBean bean = partyFactory.createShoppingCartBean();
        bean.setPartyId(partyId);
        bean.setItems(items);

        return bean;
    }

    @Override
    public ShoppingCartItemBean queryShoppingCartItemBeanByCmmdty(BigDecimal partyId, BigDecimal cmmdtyId)
            throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        ShoppingCartTerm term = new ShoppingCartTerm();
        term.setCmmdtyId(cmmdtyId);
        term.setPartyId(partyId);
        List<ShoppingCartEntity> entitys = shoppingCartMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return partyFactory.createShoppingCartItemBean(entitys.get(0));
    }

}
