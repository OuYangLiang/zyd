package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.Level;
import org.zyd.common.constants.LevelChangeType;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.CommodityEnquiringBean;
import org.zyd.domain.bean.CommodityEvaluationBean;
import org.zyd.domain.bean.PartyAccountBean;
import org.zyd.domain.bean.PartyContactInfoBean;
import org.zyd.domain.bean.PartyIdentifyBean;
import org.zyd.domain.bean.PartyInfoBean;
import org.zyd.domain.bean.PartyLevelBean;
import org.zyd.domain.bean.PartyPasswordBean;
import org.zyd.domain.bean.PartyPointBean;
import org.zyd.domain.bean.PurchaseOrderBean;
import org.zyd.domain.bean.ReturnOrderBean;
import org.zyd.domain.factory.CommodityFactory;
import org.zyd.domain.factory.EvaluationFactory;
import org.zyd.domain.factory.PartyFactory;
import org.zyd.store.entity.CollectedListEntity;
import org.zyd.store.entity.PartyIdentifyEntity;
import org.zyd.store.entity.RecommendedListEntity;
import org.zyd.store.entity.ShoppingCartEntity;
import org.zyd.store.mapper.CollectedListMapper;
import org.zyd.store.mapper.PartyContactInfoMapper;
import org.zyd.store.mapper.PartyIdentifyMapper;
import org.zyd.store.mapper.RecommendedListMapper;
import org.zyd.store.mapper.ShoppingCartMapper;

public class PartyIdentifyBeanImpl implements PartyIdentifyBean {

    private PartyIdentifyEntity entity;
    private List<PartyAccountBean> partyAccountBeans;
    private List<PartyPasswordBean> partyPasswordBeans;
    private PartyInfoBean partyInfoBean;
    private List<PartyContactInfoBean> partyContactInfoBeans;
    private List<PartyIdentifyBean> recommendedList;

    @Autowired
    private PartyIdentifyMapper partyIdentifyMapper;
    @Autowired
    private PartyContactInfoMapper partyContactInfoMapper;
    @Autowired
    private RecommendedListMapper recommendedListMapper;
    @Autowired
    private CollectedListMapper collectedListMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private PartyFactory partyFactory;
    @Autowired
    private CommodityFactory commodityFactory;
    @Autowired
    private EvaluationFactory evaluationFactory;

    public PartyIdentifyBeanImpl(PartyIdentifyEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getPartyId() {
        if (null == entity) {
            return null;
        }

        return entity.getPartyId();
    }

    @Override
    public String getRecommendCode() {
        if (null == entity) {
            return null;
        }

        return entity.getRecommendCode();
    }

    @Override
    public Timestamp getRegisterDate() {
        if (null == entity) {
            return null;
        }

        return entity.getRegisterDate();
    }

    @Override
    public void setRecommendCode(String recommendCode) {
        if (null == entity) {
            entity = new PartyIdentifyEntity();
        }

        entity.setRecommendCode(recommendCode);
    }

    @Override
    public void setRegisterDate(Timestamp registerDate) {
        if (null == entity) {
            entity = new PartyIdentifyEntity();
        }

        entity.setRegisterDate(registerDate);
    }

    @Override
    public List<PartyPasswordBean> getPartyPasswordBeans() {
        return this.partyPasswordBeans;
    }

    @Override
    public void setPartyPasswordBeans(List<PartyPasswordBean> partyPasswordBeans) {
        this.partyPasswordBeans = partyPasswordBeans;
    }

    @Override
    public List<PartyAccountBean> getPartyAccountBeans() {
        return this.partyAccountBeans;
    }

    @Override
    public void setPartyAccountBeans(List<PartyAccountBean> partyAccountBeans) {
        this.partyAccountBeans = partyAccountBeans;
    }

    @Override
    public PartyInfoBean getPartyInfoBean() {
        return this.partyInfoBean;
    }

    @Override
    public void setPartyInfoBean(PartyInfoBean partyInfoBean) {
        this.partyInfoBean = partyInfoBean;
    }

    @Override
    public List<PartyContactInfoBean> getPartyContactInfoBeans() {
        return this.partyContactInfoBeans;
    }

    @Override
    public void setPartyContactInfoBeans(List<PartyContactInfoBean> partyContactInfoBeans) {
        this.partyContactInfoBeans = partyContactInfoBeans;
    }

    @Override
    public List<PartyIdentifyBean> getRecommendedList() {
        return this.recommendedList;
    }

    @Override
    public void setRecommendedList(List<PartyIdentifyBean> recommendedList) {
        this.recommendedList = recommendedList;
    }

    @Override
    public void configContactInfo(PartyContactInfoBean contactInfo) throws ZydException {
        if (null == contactInfo) {
            throw new IllegalArgumentException();
        }
        if (null == contactInfo.getCntctId()) {
        	contactInfo.save();
        } else {
        	contactInfo.change();
        }
    }

    @Override
    public void removeContactInfo(BigDecimal cntctId) throws ZydException {
        if (null == cntctId) {
            throw new IllegalArgumentException();
        }
        PartyContactInfoBean bean = partyFactory.createPartyContactInfoBean();
        bean.setCntctId(cntctId);
        bean.remove();
    }

    @Override
    public void initPartyLevel() throws ZydException {
        PartyLevelBean bean = partyFactory.createPartyLevelBean();
        bean.setLevel(Level.A1600010);
        bean.setLevelChgType(LevelChangeType.A1700010);
        bean.setLevelChgTs(new Timestamp(System.currentTimeMillis()));
        bean.setPartyId(this.getPartyId());
        bean.save();
    }

    @Override
    public void initPartyPoint() throws ZydException {
        PartyPointBean bean = partyFactory.createPartyPointBean();
        bean.setBalanceAmt(BigDecimal.ZERO);
        bean.setTotalAmt(BigDecimal.ZERO);
        bean.setUsedAmt(BigDecimal.ZERO);
        bean.setPartyId(this.getPartyId());
        bean.save();
    }

    @Override
    public void configPartyInfo(PartyInfoBean partyInfo) throws ZydException {
        if (null == partyInfo) {
            throw new IllegalArgumentException();
        }
    	partyInfo.save();
    }

    @Override
	public void changePartyInfo(PartyInfoBean partyInfo) throws ZydException {
        if (null == partyInfo) {
            throw new IllegalArgumentException();
        }
    	partyInfo.change();
    }

	@Override
    public void configPartyPassword(PartyPasswordBean partyPassword) throws ZydException {
        if (null == partyPassword) {
            throw new IllegalArgumentException();
        }
        if (null == partyPassword.getPwdId()) {
        	partyPassword.save();
        } else {
        	partyPassword.change();
        }
    }

    @Override
    public void configPartyAccount(PartyAccountBean partyAccount) throws ZydException {
        if (null == partyAccount) {
            throw new IllegalArgumentException();
        }
        if (null == partyAccount.getAcntId()) {
        	partyAccount.save();
        } else {
        	partyAccount.change();
        }
    }

    @Override
    public void recommendPartyIdentify(BigDecimal partyId) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        try {
            Timestamp now = new Timestamp(new Date().getTime());

            RecommendedListEntity entity = new RecommendedListEntity();
            entity.setPartyId(this.getPartyId());
            entity.setPresenteeId(partyId);
            entity.setCreateTime(now);
            entity.setUpdateTime(now);

            recommendedListMapper.insert(entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void enquiring(BigDecimal cmmdtyId, String content) throws ZydException {
        if (null == cmmdtyId || StringUtils.isEmpty(content)) {
            throw new IllegalArgumentException();
        }
        CommodityEnquiringBean bean = commodityFactory.createCommodityEnquiringBean();
        bean.setPartyId(this.getPartyId());
        bean.setCmmdtyId(cmmdtyId);
        bean.setEnquiringContent(content);
        bean.save();
    }

    @Override
    public void collect(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        try {
            Timestamp now = new Timestamp(new Date().getTime());

            CollectedListEntity entity = new CollectedListEntity();
            entity.setPartyId(this.getPartyId());
            entity.setCmmdtyId(cmmdtyId);
            entity.setCreateTime(now);
            entity.setUpdateTime(now);

            collectedListMapper.insert(entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void cleanShoppingCart() throws ZydException {
        try {
            ShoppingCartEntity entity = new ShoppingCartEntity();
            entity.setPartyId(this.getPartyId());

            shoppingCartMapper.cleanShoppingCart(entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void submitOrder(PurchaseOrderBean order) throws ZydException {
        if (null == order) {
            throw new IllegalArgumentException();
        }
        order.setPartyId(getPartyId());
        order.saveRecursively();
    }

    @Override
    public void evaluateCommodity(CommodityEvaluationBean evaluation) throws ZydException {
        if (null == evaluation) {
            throw new IllegalArgumentException();
        }
        evaluation.setPartyId(getPartyId());
        evaluation.saveRecursively();
    }

    @Override
    public void submitReturnOrder(ReturnOrderBean returnOrder) throws ZydException {
        if (null == returnOrder) {
            throw new IllegalArgumentException();
        }
        returnOrder.setPartyId(getPartyId());
        returnOrder.saveRecursively();
    }

    @Override
    public void uncollect(BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        try {
            CollectedListEntity entity = new CollectedListEntity();
            entity.setPartyId(this.getPartyId());
            entity.setCmmdtyId(cmmdtyId);

            collectedListMapper.delete(entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());

            entity.setUpdateTime(now);
            if (null == this.getPartyId()) {
                entity.setCreateTime(now);

                partyIdentifyMapper.insert(this.entity);
            } else {
                partyIdentifyMapper.updateBySelective(this.entity);
            }
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
	public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            partyIdentifyMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

	@Override
    public void remove() throws ZydException {
        try {
            partyIdentifyMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setPartyId(null);
        }
    }

}
