package org.zyd.domain.bean.operation;

import java.math.BigDecimal;

import org.zyd.domain.bean.CommodityEvaluationBean;
import org.zyd.domain.bean.PartyAccountBean;
import org.zyd.domain.bean.PartyContactInfoBean;
import org.zyd.domain.bean.PartyInfoBean;
import org.zyd.domain.bean.PartyPasswordBean;
import org.zyd.domain.bean.PurchaseOrderBean;
import org.zyd.domain.bean.ReturnOrderBean;
import org.zyd.common.exception.ZydException;

public interface PartyIdentifyOperation {
	
	/**
	 * 设置会员基本信息
	 * 
	 * @param partyInfo 会员基本信息
	 * @throws ZydException
	 */
	void configPartyInfo(PartyInfoBean partyInfo) throws ZydException;
	
	
	/**
	 * 更新会员基本信息
	 * 
	 * @param partyInfo 会员基本信息
	 * @throws ZydException
	 */
	void changePartyInfo(PartyInfoBean partyInfo) throws ZydException;
	
	/**
	 * 配置会员联系信息 支持增加和修改会员联系信息
	 * 
	 * @param contactInfo 会员联系信息
	 * @throws ZydException
	 */
	void configContactInfo(PartyContactInfoBean contactInfo)
			throws ZydException;

	/**
	 * 删除会员联系信息
	 * 
	 * @param cntctId 会员联系信息id
	 * @throws ZydException
	 */
	void removeContactInfo(BigDecimal cntctId)
			throws ZydException;

	/**
	 * 初始化会员等级
	 * 
	 * @throws ZydException
	 */
	void initPartyLevel() throws ZydException;

	/**
	 * 初始化会员积分账户
	 * 
	 * @throws ZydException
	 */
	void initPartyPoint() throws ZydException;

	/**
	 * 设置会员密码 支持创建和更新
	 * 
	 * @param partyPassword 会员密码
	 * @throws ZydException
	 */
	void configPartyPassword(PartyPasswordBean partyPassword)
			throws ZydException;

	/**
	 * 设置会员账号 支持创建与更新账号
	 * 
	 * @param partyAccount 会员账号
	 * @throws ZydException
	 */
	void configPartyAccount(PartyAccountBean partyAccount) throws ZydException;

	/**
	 * 推荐会员
	 * 
	 * @param partyId 被推荐会员party id
	 * @throws ZydException
	 */
	void recommendPartyIdentify(BigDecimal partyId)
			throws ZydException;

	/**
	 * 资询商品
	 * 
	 * @param cmmdtyId 待资询商品id
	 * @param content 资询内容
	 * @throws ZydException
	 */
	void enquiring(BigDecimal cmmdtyId, String content) throws ZydException;

	/**
	 * 收藏商品
	 * 
	 * @param cmmdtyId 待收藏商品id
	 * @throws ZydException
	 */
	void collect(BigDecimal cmmdtyId) throws ZydException;
	
	/**
	 * 消取商品收藏
	 * 
	 * @param cmmdtyId 已收藏商品id
	 * @throws ZydException
	 */
	void uncollect(BigDecimal cmmdtyId) throws ZydException;
	
	/**
	 * 清空购物车
	 * 
	 * @throws ZydException
	 */
	void cleanShoppingCart() throws ZydException;
	
	/**
	 * 提交订单
	 * 
	 * @param order 订单
	 * @throws ZydException
	 */
	void submitOrder(PurchaseOrderBean order) throws ZydException;
	
	/**
	 * 评论商品
	 * 
	 * @param evaluation 评价
	 * @throws ZydException
	 */
	void evaluateCommodity(CommodityEvaluationBean evaluation)
			throws ZydException;

	/**
	 * 提交退换货订单
	 * 
	 * @param returnOrder 退换货订单
	 * @throws ZydException
	 */
	void submitReturnOrder(ReturnOrderBean returnOrder) throws ZydException;

}
