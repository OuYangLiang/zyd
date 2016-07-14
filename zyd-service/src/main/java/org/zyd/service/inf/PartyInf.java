package org.zyd.service.inf;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.common.constants.AccountType;
import org.zyd.common.constants.ContactType;
import org.zyd.common.constants.PasswordType;
import org.zyd.common.exception.ZydException;
import org.zyd.service.dto.PartyAccountDto;
import org.zyd.service.dto.PartyContactInfoDto;
import org.zyd.service.dto.PartyInfoDto;
import org.zyd.service.dto.PartyLevelDto;
import org.zyd.service.dto.PartyPasswordDto;
import org.zyd.service.dto.PartyPointDto;
import org.zyd.service.dto.PointEventDto;
import org.zyd.service.dto.ShoppingCartDto;
import org.zyd.service.dto.ShoppingCartItemDto;

public interface PartyInf {

	/**
	 * 创建新会员<p/>
	 * 
	 * 备注：<p/>
	 * 1. 账号状态默认为A0900010（可用）<p/>
	 * 2. 密码类型默认为A1100010（登录密码）<p/>
	 * 3. 密码状态默认为A1300010（可用）<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE001 推荐码不存在
     * EZYDE002 手机不能为空
     * EZYDE003 手机格式不正确
     * EZYDE004 密码不能为空
     * EZYDE005 密码长度不足
     * EZYDE038 密码格式不正确
     * EZYDE024 手机号码已存在
	 * </pre>
	 * @param phoneNo 手机账号
	 * @param pwdVal 登录密码
	 * @param recommendCode 推荐码
	 * @throws ZydException
	 */
	void createParty(String phoneNo, String pwdVal, String recommendCode) throws ZydException;
	
	
	
	/**
	 * 根据会员id查询会员基本信息<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * </pre>
	 * @param partyId 会员id
	 * @return 会员基本信息
	 * @throws ZydException
	 */
	PartyInfoDto queryPartyInfo(BigDecimal partyId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 设置会员基本信息
	 * 
	 * 备注：
	 * 1. 先判断会员是否有基本信息
	 *        若无，则创建，同时对必填字段进行非空性校验。
	 *        若有，则更新，无需对必填字段进行非空性校验。
	 * 
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE013 会员不存在
     * EZYDE006 姓名不能为空
     * EZYDE007 姓名格式不正确
     * EZYDE008 姓名长度最大为5个汉字
     * EZYDE009 妮称不能为空
     * EZYDE010 妮称格式不正确
     * EZYDE011 妮称长度最大为10个字符
     * EZYDE012 出身年月不能为空
	 * </pre>
	 * 
	 * @param partyInfoDto 会员基本信息
	 * @throws ZydException
	 */
	void configPartyInfo(PartyInfoDto partyInfoDto) throws ZydException;
	
	
	
	/**
	 * 根据会员id与信息类型查询会员联系信息<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * </pre>
	 * @param partyId 会员id
	 * @param cntctType 联系信息类型
	 * @return 会员联系信息集合
	 * @throws ZydException
	 */
	List<PartyContactInfoDto> queryPartyContactInfo(BigDecimal partyId, ContactType cntctType) throws ZydException;
	
	
	
	/**
	 * 增加联系信息<p/>
	 * 
	 * 备注：<p/>
	 * 1. 联系类型为空，默认	A0600010（送货地址）<p/>
	 * 2. 国家为空，默认A0700010（中国）<p/>
	 * 3. 当首选标识为true时，更新该会员同类型当前首选联系类型首选标识为false<p/>
	 * 4. 忽略参数中的cntctSeq，序号默认加到该会员同类型最后一个<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
     * EZYDE013 会员不存在
     * EZYDE014 联系信息类型不能为空
     * EZYDE015 联系信息联系人姓名不能为空
     * EZYDE016 联系信息联系人手机不能为空
     * EZYDE017 联系信息联系人手机格式不正确
     * EZYDE018 联系信息省份不能为空
     * EZYDE019 联系信息城市不能为空
     * EZYDE020 联系信息区、镇不能为空
     * EZYDE021 联系信息详细地址不能为空
     * EZYDE022 联系信息邮编号码格式不正确
	 * </pre>
	 * @param partyContactInfoDto 会员联系信息
	 * @throws ZydException
	 */
	void addPartyContactInfo(PartyContactInfoDto partyContactInfoDto) throws ZydException;
	
	
	
	/**
	 * 删除会员联系信息<p/>
	 * 
	 * 备注：<p/>
	 * 1. 若被删除信息首选标识为true，则设置会员同类型第一个信息为首选<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013   会员不存在
	 * EZYDE023   联系信息不存在
	 * </pre>
	 * @param partyId 会员id
	 * @param cntctId 联系信息id
	 * @throws ZydException
	 */
	void removePartyContactInfo(BigDecimal partyId, BigDecimal cntctId) throws ZydException;
	
	
	
	/**
	 * 设计联系信息为首选联系信息<p/>
	 * 
	 * 备注：<p/>
	 * 1. 需要更新同类型原首选信息首先标识为false<p/>
	 * 2. 若cntctId对应的信息已经是首选信息，直接返回<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013   会员不存在
     * EZYDE023 联系信息不存在
	 * </pre>
	 * @param partyId 会员id
	 * @param cntctId 联系信息id
	 * @throws ZydException
	 */
	void setDefaultPartyContactInfo(BigDecimal partyId, BigDecimal cntctId) throws ZydException;
	
	
	
	/**
	 * 根据会员id与账号类型查询会员账号<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * </pre>
	 * @param partyId 会员id
	 * @param accountType 账号类型
	 * @return 会员账号
	 * @throws ZydException
	 */
	PartyAccountDto queryPartyAccountDto(BigDecimal partyId, AccountType accountType) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据会员账号值查询会员账号
	 * 
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * 
	 * </pre>
	 * 
	 * @param acntVal
	 * @return
	 * @throws ZydException
	 */
	PartyAccountDto queryPartyAccountDto(String acntVal) throws ZydException;
	
	
	
	/**
	 * 更新会员账号<p/>
	 * 
	 * 备注：<p/>
	 * 1. 目前只支持手机账号<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE002 手机不能为空
	 * EZYDE003 手机格式不正确
	 * EZYDE013   会员不存在
	 * EZYDE026 会员账号不存在
	 * </pre>
	 * @param acntId 会员账号id
	 * @param acntVal 账号值，目前只支持手机
	 * @throws ZydException
	 */
	void updatePartyAccountDto(BigDecimal acntId, String acntVal) throws ZydException;
	
	
	
	/**
	 * 锁定会员账号<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013   会员不存在
	 * EZYDE026   会员账号不存在
	 * EZYDE027   账号已是锁定状态
	 * </pre>
	 * @param acntId 会员账号id
	 * @throws ZydException
	 */
	void lockPartyAccountDto(BigDecimal acntId) throws ZydException;
	
	
	
	/**
	 * 解锁会员账号<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013   会员不存在
	 * EZYDE026   会员账号不存在
	 * EZYDE028   账号已是解锁状态
	 * </pre>
	 * @param acntId 会员账号id
	 * @throws ZydException
	 */
	void unlockPartyAccountDto(BigDecimal acntId) throws ZydException;
	
	
	
	/**
	 * 修改密码<p/>
	 * 
	 * 备注：<p/>
	 * 1. 如果原密码已经过期，则更新密码状态为可用<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
	 * EZYDE004 密码不能为空
	 * EZYDE005 密码长度不足
	 * EZYDE029 密码已经被锁定
	 * EZYDE030 新密码与原密码相同
	 * EZYDE031 密码不存在
	 * EZYDE038 密码格式不正确
	 * </pre>
	 * @param partyId 会员id
	 * @param pwdType 密码类型
	 * @param pwdVal 新密码
	 * @throws ZydException
	 */
	void changePassword(BigDecimal partyId, PasswordType pwdType, String pwdVal) throws ZydException;
	
	
	
	/**
	 * 根据会员id与密码类型查询会员密码<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * </pre>
	 * @param partyId 会员id
	 * @param pwdType 密码类型
	 * @return 会员密码
	 * @throws ZydException
	 */
	PartyPasswordDto queryPartyPasswordDto(BigDecimal partyId, PasswordType pwdType) throws ZydException;
	
	
	
	/**
	 * 根据会员id查询会员积分<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * </pre>
	 * @param partyId 会员id
	 * @return 会员积分
	 * @throws ZydException
	 */
	PartyPointDto queryPartyPoint(BigDecimal partyId) throws ZydException;
	
	
	
	/**
	 * 根据会员id查询会员积分明细，根据event_ts降序排序<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * </pre>
	 * @param partyId 会员id
	 * @param pageSize 分页大小
	 * @param page 请求页
	 * @return 会员积分明细集合
	 * @throws ZydException
	 */
	List<PointEventDto> queryPointEvents(BigDecimal partyId, int pageSize, int page) throws ZydException;
	
	
	
	/**
	 * 根据会员id查询会员等级<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * </pre>
	 * @param partyId 会员id
	 * @return 会员等级
	 * @throws ZydException
	 */
	PartyLevelDto queryPartyLevel(BigDecimal partyId) throws ZydException;
	
	
	
	/**
	 * 收藏商品<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
     * EZYDE032 商品不存在
	 * EZYDE033 商品已经被收藏
	 * </pre>
	 * @param partyId 会员id
	 * @param cmmdtyId 待收藏商品id
	 * @throws ZydException
	 */
	void collect(BigDecimal partyId, BigDecimal cmmdtyId) throws ZydException;
	
	
	
	/**
	 * 取消商品收藏<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
	 * EZYDE032 商品不存在
	 * EZYDE034 商品未被会员收藏
	 * <pre/>
	 * @param partyId 会员id
	 * @param cmmdtyId 已收藏商品id
	 * @throws ZydException
	 */
	void uncollect(BigDecimal partyId, BigDecimal cmmdtyId) throws ZydException;
	
	
	
	/**
	 * 清空会员购物车<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
	 * </pre>
	 * @param partyId 会员id
	 * @throws ZydException
	 */
	void cleanShoppingCart(BigDecimal partyId) throws ZydException;
	
	
	
	/**
	 * 加入购物车<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
	 * EZYDE032 商品不存在
	 * EZYDE035 商品已经加入购物车
	 * EZYDE036 购物车商品数量不能小于1
	 * </pre>
	 * @param partyId 会员id
	 * @param cmmdtyId 商品id
	 * @param qty 商品数量
	 * @throws ZydException
	 */
	void addCommodityToShoppingCart(BigDecimal partyId, BigDecimal cmmdtyId, int qty) throws ZydException;
	
	
	
	/**
	 * 商品移出购物车<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
	 * EZYDE032 商品不存在
	 * EZYDE037 商品不在购物车
	 * </pre>
	 * @param partyId 会员id
	 * @param cmmdtyId 商品id
	 * @throws ZydException
	 */
	void removeCommodityFromShoppingCart(BigDecimal partyId, BigDecimal cmmdtyId) throws ZydException;
	
	
	
	/**
	 * 变更购物车商品数量
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
	 * EZYDE032 商品不存在
	 * EZYDE037 商品不在购物车
	 * EZYDE036 购物车商品数量不能小于1
	 * </pre>
	 * @param partyId 会员id
	 * @param cmmdtyId 商品id
	 * @param qty 商品数量
	 * @throws ZydException
	 */
	void changeCommodityQtyFromShoppingCart(BigDecimal partyId, BigDecimal cmmdtyId, int qty) throws ZydException;
	
	
	
	/**
	 * 根据会员id查询会员购物车<p/>
	 * <pre>
	 * 错误码：
     * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
	 * </pre>
	 * @param partyId 会员id
	 * @return 购物车
	 * @throws ZydException
	 */
	ShoppingCartDto queryShoppingCartDto(BigDecimal partyId) throws ZydException;
	
	
	/**
	 * 根据商品id查询购物车商品<p/>
	 * <pre>
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * @param cmmdtyId 商品id
	 * @param partyId 会员id
	 * @return 购物车
	 * @throws ZydException
	 */
	ShoppingCartItemDto queryShoppingCartItemDto(BigDecimal partyId, BigDecimal cmmdtyId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 资询商品
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
     * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
	 * EZYDE032 商品不存在
	 * EZYDH048 资询内容不能为空
	 * EZYDH049 资询内容最大为300个字符
	 * </pre>
	 * 
	 * @param partyId 会员id
	 * @param cmmdtyId 商品id
	 * @param content 资询内容
	 * @throws ZydException
	 */
	void enquiringCommodity(BigDecimal partyId, BigDecimal cmmdtyId, String content) throws ZydException;
}
