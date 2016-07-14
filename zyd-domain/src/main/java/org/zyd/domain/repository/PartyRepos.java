package org.zyd.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.common.constants.AccountType;
import org.zyd.common.constants.ContactType;
import org.zyd.common.constants.PasswordType;
import org.zyd.common.constants.Scenario;
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

public interface PartyRepos {

    /**
     * 根据会员id查询会员标识
     * 
     * @param partyId 会员id
     * @return 会员标识
     * @throws ZydException
     */
    PartyIdentifyBean queryPartyIdentifyByKey(BigDecimal partyId) throws ZydException;

    /**
     * 根据推荐码查询会员标识
     * 
     * @param recommendCode 会员推荐码
     * @return 会员标识
     * @throws ZydException
     */
    PartyIdentifyBean queryPartyIdentifyByRecommendCode(String recommendCode) throws ZydException;

    /**
     * 根据会员id查询会员基本信息
     * 
     * @param partyId 会员id
     * @return 会员基本信息
     * @throws ZydException
     */
    PartyInfoBean queryPartyInfoByKey(BigDecimal partyId) throws ZydException;

    /**
     * 根据会员联系信息id查询会员联系信息
     * 
     * @param cntctId 会员联系信息id
     * @return 会员联系信息
     * @throws ZydException
     */
    PartyContactInfoBean queryPartyContactInfoBeanByKey(BigDecimal cntctId) throws ZydException;

    /**
     * 根据会员id与信息类型查询会员联系信息，结果根据cntct_seq字段升序排序。
     * 
     * @param partyId 会员id
     * @param cntctType 联系信息类型
     * @return 会员联系信息集合
     * @throws ZydException
     */
    List<PartyContactInfoBean> queryPartyContactInfoBeans(BigDecimal partyId, ContactType cntctType)
            throws ZydException;

    /**
     * 根据账号id查询会员账号
     * 
     * @param acntId 账号id
     * @return 账号
     * @throws ZydException
     */
    PartyAccountBean queryPartyAccountByKey(BigDecimal acntId) throws ZydException;

    /**
     * 根据账号值查询会员账号
     * 
     * @param acntVal 账号值
     * @return 账号
     * @throws ZydException
     */
    PartyAccountBean queryPartyAccountByVal(String acntVal) throws ZydException;

    /**
     * 根据会员id与账号类型查询会员账号
     * 
     * @param partyId 会员id
     * @param acntType 账号类型
     * @return 账号
     * @throws ZydException
     */
    PartyAccountBean queryPartyAccountByType(BigDecimal partyId, AccountType acntType) throws ZydException;

    /**
     * 根据密码id查询会员密码
     * 
     * @param pwdId 密码id
     * @return 密码
     * @throws ZydException
     */
    PartyPasswordBean queryPasswordByKey(BigDecimal pwdId) throws ZydException;

    /**
     * 根据会员id与密码类型查询会员密码
     * 
     * @param partyId 会员id
     * @param pwdType 密码类型
     * @return 密码
     * @throws ZydException
     */
    PartyPasswordBean queryPasswordByType(BigDecimal partyId, PasswordType pwdType) throws ZydException;

    /**
     * 根据会员id查询会员积分
     * 
     * @param partyId 会员id
     * @return 会员积分
     * @throws ZydException
     */
    PartyPointBean queryPartyPointByKey(BigDecimal partyId) throws ZydException;

    /**
     * 根据会员id查询会员积分明细，根据event_ts降序排序
     * 
     * @param partyId 会员id
     * @param pageSize 分页大小
     * @param page 查询页
     * @return 会员积分明细集合
     * @throws ZydException
     */
    List<PointEventBean> queryPointEvents(BigDecimal partyId, int pageSize, int page) throws ZydException;

    /**
     * 根据订单号与场景查询会员积分明细
     * 
     * @param orderNum 订单号
     * @param scenario 场景
     * @return 会员积分明细
     * @throws ZydException
     */
    PointEventBean queryPointEvent(String orderNum, Scenario scenario) throws ZydException;

    /**
     * 根据会员id查询会员等级
     * 
     * @param partyId 会员id
     * @return 会员等级
     * @throws ZydException
     */
    PartyLevelBean queryPartyLevel(BigDecimal partyId) throws ZydException;
    
    /**
     * 根据会员id查询购物车，根据add_time字段降序排序
     * 
     * @param partyId 会员id
     * @return 购物车
     * @throws ZydException
     */
    ShoppingCartBean queryShoppingCartBeanByParty(BigDecimal partyId) throws ZydException;
    
    /**
     * 根据商品id查询购物车商品
     * 
     * @param partyId 会员id
     * @param cmmdtyId 商品id
     * @return 购物车
     * @throws ZydException
     */
    ShoppingCartItemBean queryShoppingCartItemBeanByCmmdty(BigDecimal partyId, BigDecimal cmmdtyId) throws ZydException;

    // PartyLevelFactorBean queryPartyLevelFactorByKey(BigDecimal factorId) throws ZydException;

    // PartyLevelFactorBean queryPartyLevelFactorByFactor(BigDecimal partyId, LevelFactor factor) throws ZydException;

    // List<PartyLevelDetailBean> queryLevelDetail(BigDecimal partyId, int pageSize, int page) throws ZydException;

    // PartyLevelDetailBean queryLevelDetail(String orderNum, Scenario scenario, LevelFactor factor) throws
    // ZydException;

}
