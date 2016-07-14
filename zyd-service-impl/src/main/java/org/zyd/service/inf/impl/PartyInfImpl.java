package org.zyd.service.inf.impl;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.AccountStatus;
import org.zyd.common.constants.AccountType;
import org.zyd.common.constants.ContactType;
import org.zyd.common.constants.Country;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.PasswordStatus;
import org.zyd.common.constants.PasswordStrongth;
import org.zyd.common.constants.PasswordType;
import org.zyd.common.exception.ZydException;
import org.zyd.common.util.PwdEncoder;
import org.zyd.common.util.SaltGenerator;
import org.zyd.common.util.Validator;
import org.zyd.domain.bean.BoutiqueBean;
import org.zyd.domain.bean.CommodityBean;
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
import org.zyd.domain.bean.TeaBean;
import org.zyd.domain.bean.TeapotBean;
import org.zyd.domain.factory.PartyFactory;
import org.zyd.domain.repository.CommodityRepos;
import org.zyd.domain.repository.PartyRepos;
import org.zyd.domain.util.SequenceGenerator;
import org.zyd.service.convertor.PartyConvertor;
import org.zyd.service.dto.PartyAccountDto;
import org.zyd.service.dto.PartyContactInfoDto;
import org.zyd.service.dto.PartyInfoDto;
import org.zyd.service.dto.PartyLevelDto;
import org.zyd.service.dto.PartyPasswordDto;
import org.zyd.service.dto.PartyPointDto;
import org.zyd.service.dto.PointEventDto;
import org.zyd.service.dto.ShoppingCartDto;
import org.zyd.service.dto.ShoppingCartItemDto;
import org.zyd.service.inf.PartyInf;
import org.zyd.store.entity.CollectedListEntity;
import org.zyd.store.entity.PartyContactInfoEntity;
import org.zyd.store.entity.RecommendedListEntity;
import org.zyd.store.entity.ShoppingCartEntity;
import org.zyd.store.mapper.CollectedListMapper;
import org.zyd.store.mapper.PartyContactInfoMapper;
import org.zyd.store.mapper.RecommendedListMapper;
import org.zyd.store.mapper.ShoppingCartMapper;
import org.zyd.store.term.CollectedListTerm;
import org.zyd.store.term.PartyContactInfoTerm;
import org.zyd.store.term.ShoppingCartTerm;

public class PartyInfImpl implements PartyInf {

    @Autowired
    private PartyFactory partyFactory;
    @Autowired
    private PartyRepos partyRepos;
    @Autowired
    private CommodityRepos commodityRepos;
    @Autowired
    private PartyConvertor partyConvertor;
    @Autowired
    private PartyContactInfoMapper partyContactInfoMapper;
    @Autowired
    private CollectedListMapper collectedListMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private RecommendedListMapper recommendedListMapper;
    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Override
    public void createParty(String phoneNo, String pwdVal, String recommendCode) throws ZydException {
        if (null == phoneNo || phoneNo.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (null == pwdVal || pwdVal.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (StringUtils.isEmpty(phoneNo)) {
            throw new ZydException(ErrorCode.EZYDE002);
        }

        if (!Validator.isMobile(phoneNo)) {
            throw new ZydException(ErrorCode.EZYDE003);
        }

        // 校验手机是否已存在
        PartyAccountBean partyAccount = partyRepos.queryPartyAccountByVal(phoneNo);
        if (null != partyAccount) {
            throw new ZydException(ErrorCode.EZYDE024);
        }

        if (StringUtils.isEmpty(pwdVal)) {
            throw new ZydException(ErrorCode.EZYDE004);
        }

        if (!Validator.isPassword(pwdVal)) {
            throw new ZydException(ErrorCode.EZYDE038);
        }

        PartyIdentifyBean recommender = null;
        if (StringUtils.isNotEmpty(recommendCode)) {
            recommender = partyRepos.queryPartyIdentifyByRecommendCode(recommendCode);
            if (null == recommender) {
                throw new ZydException(ErrorCode.EZYDE001);
            }
        }

        // 验证结束
        // 插入会员标识
        PartyIdentifyBean partyIdentifyBean = partyFactory.createPartyIdentifyBean();
        partyIdentifyBean.setRegisterDate(new Timestamp(new Date().getTime()));
        partyIdentifyBean.setRecommendCode(sequenceGenerator.generateRecommendCode());
        partyIdentifyBean.save();

        // 插入会员账号
        PartyAccountBean partyAccountBean = partyFactory.createPartyAccountBean();
        partyAccountBean.setPartyId(partyIdentifyBean.getPartyId());
        partyAccountBean.setAcntType(AccountType.A0800010);
        partyAccountBean.setAcntVal(phoneNo);
        partyAccountBean.setAcntStatus(AccountStatus.A0900010);
        partyIdentifyBean.configPartyAccount(partyAccountBean);

        // 插入会员密码
        PartyPasswordBean partyPasswordBean = partyFactory.createPartyPasswordBean();
        partyPasswordBean.setPartyId(partyIdentifyBean.getPartyId());
        partyPasswordBean.setPwdType(PasswordType.A1100010);
        partyPasswordBean.setPwdSalt(SaltGenerator.generateSalt());
        partyPasswordBean.setPwdStrongth(PasswordStrongth.A1200010);
        partyPasswordBean.setFirstWrongCheckTime(null);
        partyPasswordBean.setWrongCheckTimes(0);
        partyPasswordBean.setPwdStatus(PasswordStatus.A1300010);

        try {
            // 密码加密
            partyPasswordBean.setPwdVal(PwdEncoder.encodePassword(partyPasswordBean.getPwdSalt() + pwdVal));
        } catch (NoSuchAlgorithmException e) {
            throw new ZydException(ErrorCode.EZYD0001, e);
        }

        partyIdentifyBean.configPartyPassword(partyPasswordBean);

        if (StringUtils.isNotEmpty(recommendCode)) {
            // 绑定推荐关系
            RecommendedListEntity recommendedListEntity = new RecommendedListEntity();
            recommendedListEntity.setPartyId(recommender.getPartyId());
            recommendedListEntity.setPresenteeId(partyIdentifyBean.getPartyId());

            recommendedListMapper.insert(recommendedListEntity);
        }
    }

    @Override
    public PartyInfoDto queryPartyInfo(BigDecimal partyId) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        return partyConvertor.convertPartyInfo(partyRepos.queryPartyInfoByKey(partyId));
    }

    @Override
    public void configPartyInfo(PartyInfoDto partyInfoDto) throws ZydException {
        if (null == partyInfoDto || null == partyInfoDto.getPartyId()) {
            throw new IllegalArgumentException();
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyInfoDto.getPartyId());
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }

        PartyInfoBean oldPartyInfoBean = partyRepos.queryPartyInfoByKey(partyInfoDto.getPartyId());
        // 校验格式
        if (StringUtils.isNotEmpty(partyInfoDto.getPartyName()) && !Validator.isPartyName(partyInfoDto.getPartyName())) {
            throw new ZydException(ErrorCode.EZYDE007);
        }
        if (StringUtils.isNotEmpty(partyInfoDto.getPartyAlias())
                && !Validator.isPartyAlias(partyInfoDto.getPartyAlias())) {
            throw new ZydException(ErrorCode.EZYDE010);
        }

        PartyInfoBean partyInfoBean = partyConvertor.convertPartyInfo(partyInfoDto);
        // 不存在基本信息，则新增，并校验非空
        if (null == oldPartyInfoBean) {

            if (StringUtils.isEmpty(partyInfoDto.getPartyName())) {
                throw new ZydException(ErrorCode.EZYDE006);
            }
            if (StringUtils.isEmpty(partyInfoDto.getPartyAlias())) {
                throw new ZydException(ErrorCode.EZYDE009);
            }
            if (null == partyInfoDto.getBirthday()) {
                throw new ZydException(ErrorCode.EZYDE012);
            }
            partyIdentifyBean.configPartyInfo(partyInfoBean);
        } else {
            // 存在，则修改
            partyIdentifyBean.changePartyInfo(partyInfoBean);
        }
    }

    @Override
    public List<PartyContactInfoDto> queryPartyContactInfo(BigDecimal partyId, ContactType cntctType)
            throws ZydException {
        if (null == partyId || null == cntctType) {
            throw new IllegalArgumentException();
        }
        List<PartyContactInfoBean> beans = partyRepos.queryPartyContactInfoBeans(partyId, cntctType);
        if (null == beans) {
            return null;
        }
        List<PartyContactInfoDto> dtos = new ArrayList<PartyContactInfoDto>();
        for (PartyContactInfoBean bean : beans) {
            dtos.add(partyConvertor.convertPartyContactInfo(bean));
        }
        return dtos;
    }

    @Override
    public void addPartyContactInfo(PartyContactInfoDto partyContactInfoDto) throws ZydException {
        if (null == partyContactInfoDto || null == partyContactInfoDto.getPartyId()) {
            throw new IllegalArgumentException();
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyContactInfoDto.getPartyId());
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        if (null == partyContactInfoDto.getCntctType()) {
            partyContactInfoDto.setCntctType(ContactType.A0600010);
        }
        if (null == partyContactInfoDto.getCntctCountry()) {
            partyContactInfoDto.setCntctCountry(Country.A0700010);
        }
        if (StringUtils.isEmpty(partyContactInfoDto.getCntctName())) {
            throw new ZydException(ErrorCode.EZYDE015);
        }
        if (StringUtils.isEmpty(partyContactInfoDto.getCntctMobile())) {
            throw new ZydException(ErrorCode.EZYDE016);
        }
        if (!Validator.isMobile(partyContactInfoDto.getCntctMobile())) {
            throw new ZydException(ErrorCode.EZYDE017);
        }
        if (StringUtils.isEmpty(partyContactInfoDto.getCntctState())) {
            throw new ZydException(ErrorCode.EZYDE018);
        }
        if (StringUtils.isEmpty(partyContactInfoDto.getCntctCity())) {
            throw new ZydException(ErrorCode.EZYDE019);
        }
        if (StringUtils.isEmpty(partyContactInfoDto.getCntctTown())) {
            throw new ZydException(ErrorCode.EZYDE020);
        }
        if (StringUtils.isEmpty(partyContactInfoDto.getCntctAddress())) {
            throw new ZydException(ErrorCode.EZYDE021);
        }
        if (StringUtils.isNotEmpty(partyContactInfoDto.getCntctPostCode())
                && !Validator.isPostCode(partyContactInfoDto.getCntctPostCode())) {
            throw new ZydException(ErrorCode.EZYDE022);
        }
        // 对象转换
        PartyContactInfoBean bean = partyConvertor.convertPartyContactInfo(partyContactInfoDto);

        // TODO Mapper替代方法
        // 如果首选标识为true，将同类型的其他联系信息设置为false
        if (bean.isPreferFlag()) {
            PartyContactInfoEntity contactInfoEntity = new PartyContactInfoEntity();
            contactInfoEntity.setPartyId(bean.getPartyId());
            contactInfoEntity.setCntctType(bean.getCntctType().name());
            contactInfoEntity.setPreferFlag(false);
            partyContactInfoMapper.updateByPartyIdAndType(contactInfoEntity);
        }
        // 设置序列号为最后一个
        PartyContactInfoTerm contactInfoTerm = new PartyContactInfoTerm();
        contactInfoTerm.setPartyId(bean.getPartyId());
        contactInfoTerm.setCntctType(bean.getCntctType().name());
        PartyContactInfoEntity maxSeqRecord = partyContactInfoMapper.selectMaxSeq(contactInfoTerm);
        if (null == maxSeqRecord) {
            bean.setCntctSeq(1);
        } else {
            bean.setCntctSeq(maxSeqRecord.getCntctSeq() + 1);
        }

        partyIdentifyBean.configContactInfo(bean);
    }

    @Override
    public void removePartyContactInfo(BigDecimal partyId, BigDecimal cntctId) throws ZydException {
        if (null == partyId || null == cntctId) {
            throw new IllegalArgumentException();
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        // 校验联系信息是否存在
        PartyContactInfoBean bean = partyRepos.queryPartyContactInfoBeanByKey(cntctId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE023);
        }
        if (!partyId.equals(bean.getPartyId())) {
            // TODO 新增错误码
            throw new ZydException(ErrorCode.EZYDE013);
        }

        partyIdentifyBean.removeContactInfo(cntctId);
    }

    @Override
    public void setDefaultPartyContactInfo(BigDecimal partyId, BigDecimal cntctId) throws ZydException {
        if (null == partyId || null == cntctId) {
            throw new IllegalArgumentException();
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        PartyContactInfoBean bean = partyRepos.queryPartyContactInfoBeanByKey(cntctId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE023);
        }
        if (!partyId.equals(bean.getPartyId())) {
            // TODO 新增错误码
            throw new ZydException(ErrorCode.EZYDE013);
        }
        if (bean.isPreferFlag()) {
            return;
        }
        // TODO Mapper替代方法
        // 将同类型的其他联系信息设置为false
        PartyContactInfoEntity contactInfoEntity = new PartyContactInfoEntity();
        contactInfoEntity.setPartyId(bean.getPartyId());
        contactInfoEntity.setCntctType(bean.getCntctType().name());
        contactInfoEntity.setPreferFlag(false);
        partyContactInfoMapper.updateByPartyIdAndType(contactInfoEntity);

        bean.setPreferFlag(true);
        partyIdentifyBean.configContactInfo(bean);
    }

    @Override
    public PartyAccountDto queryPartyAccountDto(BigDecimal partyId, AccountType accountType) throws ZydException {
        if (null == partyId || null == accountType) {
            throw new IllegalArgumentException();
        }
        PartyAccountBean bean = partyRepos.queryPartyAccountByType(partyId, accountType);
        if (null == bean) {
            return null;
        }
        return partyConvertor.convertPartyAccount(bean);
    }

    @Override
    public PartyAccountDto queryPartyAccountDto(String acntVal) throws ZydException {
        if (null == acntVal || acntVal.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        PartyAccountBean bean = partyRepos.queryPartyAccountByVal(acntVal);

        if (null == bean) {
            return null;
        }

        return partyConvertor.convertPartyAccount(bean);
    }

    @Override
    public void updatePartyAccountDto(BigDecimal acntId, String acntVal) throws ZydException {
        if (null == acntId || StringUtils.isEmpty(acntVal)) {
            throw new IllegalArgumentException();
        }
        if (!Validator.isMobile(acntVal)) {
            throw new ZydException(ErrorCode.EZYDE003);
        }
        PartyAccountBean bean = partyRepos.queryPartyAccountByKey(acntId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE026);
        }
        bean.setAcntVal(acntVal);
        bean.change();
    }

    @Override
    public void lockPartyAccountDto(BigDecimal acntId) throws ZydException {
        if (null == acntId) {
            throw new IllegalArgumentException();
        }
        PartyAccountBean bean = partyRepos.queryPartyAccountByKey(acntId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE026);
        }
        if (AccountStatus.A0900020.equals(bean.getAcntStatus())) {
            throw new ZydException(ErrorCode.EZYDE027);
        }
        bean.setAcntStatus(AccountStatus.A0900020);
        bean.change();
    }

    @Override
    public void unlockPartyAccountDto(BigDecimal acntId) throws ZydException {
        if (null == acntId) {
            throw new IllegalArgumentException();
        }
        PartyAccountBean bean = partyRepos.queryPartyAccountByKey(acntId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE026);
        }
        if (AccountStatus.A0900010.equals(bean.getAcntStatus())) {
            throw new ZydException(ErrorCode.EZYDE028);
        }
        bean.setAcntStatus(AccountStatus.A0900010);
        bean.change();
    }

    @Override
    public void changePassword(BigDecimal partyId, PasswordType pwdType, String pwdVal) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(pwdVal)) {
            throw new ZydException(ErrorCode.EZYDE004);
        }
        if (!Validator.isPassword(pwdVal)) {
            throw new ZydException(ErrorCode.EZYDE038);
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        // 校验密码是否存在
        PartyPasswordBean bean = partyRepos.queryPasswordByType(partyId, pwdType);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE031);
        }
        if (PasswordStatus.A1300020.equals(bean.getPwdStatus())) {
            throw new ZydException(ErrorCode.EZYDE029);
        }

        String encodeVal;
        try {
            encodeVal = PwdEncoder.encodePassword(bean.getPwdSalt() + pwdVal);
        } catch (NoSuchAlgorithmException e) {
            throw new ZydException(ErrorCode.EZYD0001, e);
        }
        // 校验密码是否与原密码相同
        if (encodeVal.equals(bean.getPwdVal())) {
            throw new ZydException(ErrorCode.EZYDE030);
        }
        bean.setPwdVal(encodeVal);
        partyIdentifyBean.configPartyPassword(bean);
    }

    @Override
    public PartyPasswordDto queryPartyPasswordDto(BigDecimal partyId, PasswordType pwdType) throws ZydException {
        if (null == partyId || null == pwdType) {
            throw new IllegalArgumentException();
        }
        PartyPasswordBean bean = partyRepos.queryPasswordByType(partyId, pwdType);
        if (null == bean) {
            return null;
        }
        return partyConvertor.convertPartyPassword(bean);
    }

    @Override
    public PartyPointDto queryPartyPoint(BigDecimal partyId) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        PartyPointBean bean = partyRepos.queryPartyPointByKey(partyId);
        if (null == bean) {
            return null;
        }
        return partyConvertor.convertPartyPoint(bean);
    }

    @Override
    public List<PointEventDto> queryPointEvents(BigDecimal partyId, int pageSize, int page) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        List<PointEventBean> beans = partyRepos.queryPointEvents(partyId, pageSize, page);
        if (null == beans) {
            return null;
        }
        List<PointEventDto> dtos = new ArrayList<PointEventDto>();
        for (PointEventBean bean : beans) {
            dtos.add(partyConvertor.convertPointEvent(bean));
        }
        return dtos;
    }

    @Override
    public PartyLevelDto queryPartyLevel(BigDecimal partyId) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        PartyLevelBean bean = partyRepos.queryPartyLevel(partyId);
        if (null == bean) {
            return null;
        }
        return partyConvertor.convertPartyLevel(bean);
    }

    @Override
    public void collect(BigDecimal partyId, BigDecimal cmmdtyId) throws ZydException {
        if (null == partyId || null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        // 校验商品是否存在
        CommodityBean bean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        // 校验是否已收藏过
        CollectedListTerm term = new CollectedListTerm();
        term.setPartyId(partyId);
        term.setCmmdtyId(cmmdtyId);// TODO Mapper替代方法
        List<CollectedListEntity> collectedListEntitys = collectedListMapper.select(term);
        if (!CollectionUtils.isEmpty(collectedListEntitys)) {
            throw new ZydException(ErrorCode.EZYDE033);
        }

        partyIdentifyBean.collect(cmmdtyId);
    }

    @Override
    public void uncollect(BigDecimal partyId, BigDecimal cmmdtyId) throws ZydException {
        if (null == partyId || null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        // 校验商品是否存在
        CommodityBean bean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        // 校验是否已收藏过
        CollectedListTerm term = new CollectedListTerm();
        term.setPartyId(partyId);
        term.setCmmdtyId(cmmdtyId);// TODO Mapper替代方法
        List<CollectedListEntity> collectedListEntitys = collectedListMapper.select(term);
        if (CollectionUtils.isEmpty(collectedListEntitys)) {
            throw new ZydException(ErrorCode.EZYDE034);
        }

        partyIdentifyBean.uncollect(cmmdtyId);
    }

    @Override
    public void cleanShoppingCart(BigDecimal partyId) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        partyIdentifyBean.cleanShoppingCart();
    }

    @Override
    public void addCommodityToShoppingCart(BigDecimal partyId, BigDecimal cmmdtyId, int qty) throws ZydException {
        if (null == partyId || null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        if (qty < 1) {
            throw new ZydException(ErrorCode.EZYDE036);
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        // 校验商品是否存在
        CommodityBean bean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        // 校验库存
        Integer numStored = 0;
        if (bean instanceof TeapotBean) {
            TeapotBean tpd = (TeapotBean) bean;
            numStored = tpd.getNumSales();
        } else if (bean instanceof BoutiqueBean) {
            BoutiqueBean bd = (BoutiqueBean) bean;
            numStored = bd.getNumStored();
        } else if (bean instanceof TeaBean) {
            TeaBean td = (TeaBean) bean;
            numStored = td.getNumStored();
        }
        if (numStored < qty) {
            throw new ZydException(ErrorCode.EZYDR002);
        }
        ShoppingCartBean shoppingCartBean = partyFactory.createShoppingCartBean();
        shoppingCartBean.setPartyId(partyId);

        // 校验商品是否已存在购物中
        ShoppingCartTerm term = new ShoppingCartTerm();
        term.setPartyId(partyId);
        term.setCmmdtyId(cmmdtyId);// TODO Mapper替代方法
        List<ShoppingCartEntity> entitys = shoppingCartMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            shoppingCartBean.addCommodity(cmmdtyId, qty);
        } else {
            // 已经存在应该是在原有的基础上增加数量
            // throw new ZydException(ErrorCode.EZYDE035);
            ShoppingCartEntity entity = entitys.get(0);
            shoppingCartBean.changeCommodityQty(cmmdtyId, entity.getQtyToBuy() + qty);
        }
    }

    @Override
    public void removeCommodityFromShoppingCart(BigDecimal partyId, BigDecimal cmmdtyId) throws ZydException {
        if (null == partyId || null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        // 校验商品是否存在
        CommodityBean bean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        // 校验商品是否已存在购物中
        ShoppingCartTerm term = new ShoppingCartTerm();
        term.setPartyId(partyId);
        term.setCmmdtyId(cmmdtyId);// TODO Mapper替代方法
        List<ShoppingCartEntity> entitys = shoppingCartMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            throw new ZydException(ErrorCode.EZYDE037);
        }
        ShoppingCartBean shoppingCartBean = partyFactory.createShoppingCartBean();
        shoppingCartBean.setPartyId(partyId);
        shoppingCartBean.removeCommodity(cmmdtyId);
    }

    @Override
    public void changeCommodityQtyFromShoppingCart(BigDecimal partyId, BigDecimal cmmdtyId, int qty)
            throws ZydException {
        if (null == partyId || null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        if (qty < 1) {
            throw new ZydException(ErrorCode.EZYDE036);
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        // 校验商品是否存在
        CommodityBean bean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }

        // 校验商品是否已存在购物中
        ShoppingCartTerm term = new ShoppingCartTerm();
        term.setPartyId(partyId);
        term.setCmmdtyId(cmmdtyId);// TODO Mapper替代方法
        List<ShoppingCartEntity> entitys = shoppingCartMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            throw new ZydException(ErrorCode.EZYDE037);
        }

        ShoppingCartBean shoppingCartBean = partyFactory.createShoppingCartBean();
        shoppingCartBean.setPartyId(partyId);
        shoppingCartBean.changeCommodityQty(cmmdtyId, qty);
    }

    @Override
    public ShoppingCartDto queryShoppingCartDto(BigDecimal partyId) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        ShoppingCartBean bean = partyRepos.queryShoppingCartBeanByParty(partyId);
        if (null == bean || CollectionUtils.isEmpty(bean.getItems())) {
            return null;
        }
        return partyConvertor.convertShoppingCart(bean);
    }

    @Override
    public ShoppingCartItemDto queryShoppingCartItemDto(BigDecimal partyId, BigDecimal cmmdtyId) throws ZydException {
        if (null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        ShoppingCartItemBean bean = partyRepos.queryShoppingCartItemBeanByCmmdty(partyId, cmmdtyId);
        if (null == bean) {
            return null;
        }
        return partyConvertor.convertShoppingCartItem(bean);
    }

    @Override
    public void enquiringCommodity(BigDecimal partyId, BigDecimal cmmdtyId, String content) throws ZydException {
        if (null == partyId || null == cmmdtyId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(content)) {
            throw new ZydException(ErrorCode.EZYDH048);
        }
        if (content.length() > 300) {
            throw new ZydException(ErrorCode.EZYDH049);
        }
        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        // 校验商品是否存在
        CommodityBean bean = commodityRepos.queryCommodityByKey(cmmdtyId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDE032);
        }
        partyIdentifyBean.enquiring(cmmdtyId, content);
    }

}
