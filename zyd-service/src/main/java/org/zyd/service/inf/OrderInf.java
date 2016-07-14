package org.zyd.service.inf;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.common.constants.InvoiceType;
import org.zyd.common.constants.LogisticsCompCode;
import org.zyd.common.constants.PaymentChannel;
import org.zyd.common.constants.PaymentMethod;
import org.zyd.common.constants.ReturnOrderLogisticsType;
import org.zyd.common.exception.ZydException;
import org.zyd.service.dto.InvoiceDto;
import org.zyd.service.dto.OrderCommodityDto;
import org.zyd.service.dto.OrderEventDto;
import org.zyd.service.dto.OrderGiftDto;
import org.zyd.service.dto.OrderGiftItemListDto;
import org.zyd.service.dto.OrderItemListDto;
import org.zyd.service.dto.OrderLogisticsDto;
import org.zyd.service.dto.OrderPaymentDto;
import org.zyd.service.dto.PurchaseOrderDto;
import org.zyd.service.dto.ReturnOrderCommodityDto;
import org.zyd.service.dto.ReturnOrderContactInfoDto;
import org.zyd.service.dto.ReturnOrderDto;
import org.zyd.service.dto.ReturnOrderEventDto;
import org.zyd.service.dto.ReturnOrderItemListDto;
import org.zyd.service.dto.ReturnOrderLogisticsDto;
import org.zyd.service.dto.ReturnOrderRefundInfoDto;

/**
 * @author bobyes
 *
 */
public interface OrderInf {

	/**
	 * <pre>
	 * 创建、提交购物订单
	 * 
	 * 备注：
	 * 1. 订单状态根据支付方式确定：若支付方式为货到付款：则状态为A3400020("待发货")，否则为A3400010("待支付")
	 * 2. order_total_price为所有商品当前价格之和
	 * 3. logistics_amt根据收货地址动态判断（这个难，先放一放）
	 * 4. 当order_total_price >= free_logistics_condition时，free_logistics_amt为true，否则为false
	 * 5. order_should_payment = free_logistics_amt ? (order_total_price - (pointUsed*100)) : (order_total_price + logistics_amt - (pointUsed*100))
	 * 6. order_actual_payment = order_should_payment - discount
	 * 7. 创建一条订单事件记录，event_desc为“提交订单”。不写订单状态记录
	 * 8. 为每个商品创建订单商品记录与订单赠品记录：商品状态为A4500010("正常")，评价状态为A4600010("待评价")，换货次数为0
	 * 9. 当支付方式为货到付款时，支付渠道固定为A4800010("第三方代收")
	 * 10. discount字段默认为0
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDE013 会员不存在
	 * EZYDE032 商品不存在
	 * EZYDR001 商品购买数量必须大于0
	 * EZYDR002 商品库存余量不足
	 * EZYDR003 积分使用量不能小于
	 * EZYDE039 积分余额不足
	 * EZYDR004 订单备注最大为100个字符
	 * EZYDR005 收货地址信息不能为空
	 * EZYDR006 联系id对应的地址不存在
	 * EZYDR007 联系id对应的地址不属于该会员
	 * EZYDR008 订单支付方式不能为空
	 * EZYDR009 暂不支持开具增值发票
	 * EZYDR010 发票抬头最大为100个字符
	 * 
	 * </pre>
	 * 
	 * @param partyId 会员id
	 * @param cmmdtyIds 购买商品id集合
	 * @param qties 商品购买数量
	 * @param pointUsed 积分使用量
	 * @param remarks 订单备注（可选）
	 * @param cntctId 收货地址id
	 * @param paymentMethod 支付方式
	 * @param paymentChannel 支付渠道
	 * @param invoiceType 发票类型（可选）
	 * @param invoiceTitle 发票抬头（可选）
	 * @throws ZydException
	 */
	void createPurchaseOrder(BigDecimal partyId, List<BigDecimal> cmmdtyIds,
			int[] qties, BigDecimal pointUsed, String remarks,
			BigDecimal cntctId, PaymentMethod paymentMethod,
			PaymentChannel paymentChannel, InvoiceType invoiceType,
			String invoiceTitle) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据订单号查询购物订单
	 * 
	 * 备注：
	 * 1. 只查询purchase_order表信息
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param orderNum 购物订单号
	 * @return 购物订单对象
	 * @throws ZydException
	 */
	PurchaseOrderDto queryPurchaseOrderByOrderNum(String orderNum) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据会员id查询购物订单
	 * 
	 * 备注：
	 * 1. 只查询purchase_order表信息
	 * 2. 根据submit_time降序排序
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param partyId 会员id
	 * @param pageSize 分页大小
     * @param page 请求页
	 * @return 购物订单对象集合
	 * @throws ZydException
	 */
	List<PurchaseOrderDto> queryPurchaseOrdersByParty(BigDecimal partyId,
			int pageSize, int page) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 取消订单
	 * 
	 * 备注：
	 * 1. 只有订单状态为“待支付”和“待发货”状态时，可以取消订单
	 * 2. 取消订单后的状态，需要根据支付方式及当时状态判断：
	 *       若支付方式为A4700010("货到付款")，则当前订单状态只能是“待发货”，取消后状态为A3400060("已取消")
	 *       若支付方式为A4700020("在线支付")，且当前订单状态为“待支付”，取消后状态为A3400060("已取消")
	 *       若支付方式为A4700020("在线支付")，且当前订单状态为“待发货”，取消后状态为A3400030("待退款")
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP001 订单不存在
	 * EZYDR011 订单状态不正确，不支持取消操作
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @throws ZydException
	 */
	void cancel(BigDecimal orderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 支付订单
	 * 
	 * 备注：
	 * 1. 只有支付方式为“在线支付”且订单状态为“待支付”状态时，可以支付订单
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP001 订单不存在
	 * EZYDR012 订单状态不正确，不支持支付操作
	 * EZYDR013 支付账号不能为空
	 * EZYDR014 支付账号最大为100个字符
	 * EZYDR015 支付单号不能为空
	 * EZYDR016 支付单号最大为50个字符
	 * EZYDR017 支付渠道不能为空
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @param paymentChannel 支付渠道
	 * @param paymentAccount 支付账号
	 * @param paymentNum 支付单号
	 * @throws ZydException
	 */
	void pay(BigDecimal orderId, PaymentChannel paymentChannel,
			String paymentAccount, String paymentNum) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 订单发货
	 * 
	 * 备注：
	 * 1. 只有订单状态为“待发货”状态时，可以发货
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP001 订单不存在
	 * EZYDR018 订单状态不正确，不支持发货操作
	 * EZYDR019 物流公司代码不能为空
	 * EZYDR020 物流公司名称不能为空
	 * EZYDR021 物流公司名称最大为10个字符
	 * EZYDR022 物流单号不能为空
	 * EZYDR023 物流单号最大为50个字符
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @param logisticsCompCode 物流公司代码
	 * @param logisticsCompDesc 物流公司名称
	 * @param logisticsNum 物流单号
	 * @throws ZydException
	 */
	void deliverGoods(BigDecimal orderId, LogisticsCompCode logisticsCompCode,
			String logisticsCompDesc, String logisticsNum) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 申请退款
	 * 
	 * 备注：
	 * 1. 只有支付方式为“在线支付”且订单状态为“待收货”状态时，可以申请退款
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP001 订单不存在
	 * EZYDR024 订单状态不正确，不支持申请退款操作
	 * EZYDR025 退款申请原因不能为空
	 * EZYDR026 退款申请原因最大为150个字符
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @param reason 申请退款原因
	 * @throws ZydException
	 */
	void applyForRefund(BigDecimal orderId, String reason) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 取消退款申请
	 * 
	 * 备注：
	 * 1. 只有支付方式为“在线支付”，且订单状态为“待退款”状态，且前一次订单状态为“待收货”时，可以取消退款申请
	 * 2. 前一次订单状态通过order_log表判断
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP001 订单不存在
	 * EZYDR029 订单状态不正确，不支持取消退款申请操作
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @throws ZydException
	 */
	void cancelApplyForRefund(BigDecimal orderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 购物订单退款
	 * 
	 * 备注：
	 * 1. 只有支付方式为“在线支付”且订单状态为“待退款”状态时，可以退款
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP001 订单不存在
	 * EZYDR027 订单状态不正确，不支持退款操作
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @throws ZydException
	 */
	void refund(BigDecimal orderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 购物订单确认收货
	 * 
	 * 备注：
	 * 1. 只有订单状态为“待收货”状态时，可以确认收货
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP001 订单不存在
	 * EZYDR028 订单状态不正确，不支持确认收货操作
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @throws ZydException
	 */
	void takeDelivery(BigDecimal orderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 购物订单拒绝收货
	 * 
	 * 备注：
	 * 1. 只有订单状态为“待收货”状态时，可以拒收
	 * 2. 若支付方式为“在线支付”，拒收时需退款
	 * 3. 拒收操作由后台人员发起
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDP001 订单不存在
	 * EZYDR030 订单状态不正确，不支持拒收操作
	 * EZYDR031 拒收原因不能为空
	 * EZYDR032 拒收原因最大为150个字符
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @param refuseReason 拒收原因
	 * @throws ZydException
	 */
	void refuseDelivery(BigDecimal orderId, String refuseReason) throws ZydException;
	
	//******************************************************************************
	// 订单发票 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据购物订单id查询订单发票信息
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @return 订单发票信息
	 * @throws ZydException
	 */
	InvoiceDto queryInvoiceByPurchaseOrder(BigDecimal orderId) throws ZydException;
	
	//******************************************************************************
	// 订单发票 - End
	//******************************************************************************
	
	//******************************************************************************
	// 订单事件 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据购物订单id查询订单事件
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @param pageSize 分页大小
	 * @param page 请求页
	 * @return 订单事件集合
	 * @throws ZydException
	 */
	List<OrderEventDto> queryOrderEventsByPurchaseOrder(BigDecimal orderId, int pageSize, int page)
            throws ZydException;
	
	//******************************************************************************
	// 订单事件 - End
	//******************************************************************************
	
	//******************************************************************************
	// 订单商品、赠品、清单 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据购物订单id查询订单商品
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @return 订单商品对象集合
	 * @throws ZydException
	 */
	List<OrderCommodityDto> queryOrderCommoditiesByPurchaseOrder(
			BigDecimal orderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据购物订单商品id查询订单商品清单
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param orderCmmdtyId 购物订单商品id
	 * @return 购物订单商品清单对象集合
	 * @throws ZydException
	 */
	List<OrderItemListDto> queryItemListsByOrderCommodity(
			BigDecimal orderCmmdtyId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据购物订单商品id查询订单赠品
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param orderCmmdtyId 购物订单商品id
	 * @return 购物订单赠品对象集合
	 * @throws ZydException
	 */
	List<OrderGiftDto> queryOrderGiftsByOrderCommodity(
			BigDecimal orderCmmdtyId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据购物订单赠品id查询订单赠品清单
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param orderGiftId 购物订单赠品id
	 * @return 订单赠品清单对象集合
	 * @throws ZydException
	 */
	List<OrderGiftItemListDto> queryOrderGiftItemListsByOrderGift(
			BigDecimal orderGiftId) throws ZydException;
	
	//******************************************************************************
	// 订单商品、赠品、清单 - End
	//******************************************************************************
	
	//******************************************************************************
	// 订单物流 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据购物订单id查询物流信息
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @return 购物订单物流信息
	 * @throws ZydException
	 */
	OrderLogisticsDto queryOrderLogisticsByPurchaseOrder(BigDecimal orderId)
			throws ZydException;
	
	//******************************************************************************
	// 订单物流 - End
	//******************************************************************************
	
	//******************************************************************************
	// 订单支付 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据购物订单id查询支付信息
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param orderId 购物订单id
	 * @return 购物订单支付信息
	 * @throws ZydException
	 */
	OrderPaymentDto queryOrderPaymentByPurchaseOrder(BigDecimal orderId)
			throws ZydException;
	
	//******************************************************************************
	// 订单支付 - End
	//******************************************************************************
	
	//******************************************************************************
	// 退换货订单 - Start
	//******************************************************************************
	
    /**
     * <pre>
     * 根据退换货订单编号查询退换货订单
     * 
     * 备注：
     * 1. 只查询return_order表信息
     * 
     * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
     * </pre>
     * 
     * @param returnOrderNum 退换货订单编号
     * @return 退换货订单
     * @throws ZydException
     */
	ReturnOrderDto queryReturnOrderByReturnOrderNum(String returnOrderNum)
			throws ZydException;

    
    
    /**
     * <pre>
     * 根据会员id查询退换货订单
     * 
     * 备注：
     * 1. 根据submit_time降序排序
     * 2. 只查询return_order表信息
     * 
     * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
     * </pre>
     * 
     * @param partyId 会员id
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 退换货订单集合
     * @throws ZydException
     */
	List<ReturnOrderDto> queryReturnOrdersByParty(BigDecimal partyId,
			int pageSize, int page) throws ZydException;

    
    
    /**
     * <pre>
     * 根据购物订单id查询退换货订单
     * 
     * 备注：
     * 1. 根据submit_time降序排序
     * 2. 只查询return_order表信息
     * 
     * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
     * </pre>
     * 
     * @param orderId 购物订单id
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 退换货订单集合
     * @throws ZydException
     */
	List<ReturnOrderDto> queryReturnOrdersByPurchaseOrder(BigDecimal orderId,
			int pageSize, int page) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 同意退换货
	 * 
	 * 备注：
	 * 1. 只有退换货订单状态为“审核中”状态时，可以批准同意
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDR033 退换货订单不存在
	 * EZYDR034 退换货订单状态不正确，不支持审批操作
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @throws ZydException
	 */
	void approveReturnOrder(BigDecimal returnOrderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 不同意退换货
	 * 
	 * 备注：
	 * 1. 只有退换货订单状态为“审核中”状态时，可以操作
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDR033 退换货订单不存在
	 * EZYDR034 退换货订单状态不正确，不支持审批操作
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @param reason 不同意原因
	 * @throws ZydException
	 */
	void disApproveReturnOrder(BigDecimal returnOrderId, String reason) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 退换货寄件
	 * 
	 * 备注：
	 * 1. 只有退换货订单状态为“待寄件”状态时，可以操作
	 * 2. 是否免除邮费根据退换货原因判断
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDR033 退换货订单不存在
	 * EZYDR035 退换货订单状态不正确，不支持寄件操作
	 * EZYDR020 物流公司名称不能为空
	 * EZYDR021 物流公司名称最大为10个字符
	 * EZYDR022 物流单号不能为空
	 * EZYDR023 物流单号最大为50个字符
	 * EZYDR036 物流费用不能为空
	 * EZYDR037 物流费用不能小于0
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @param logisticsCompCode 物流公司代码
	 * @param logisticsCompDesc 物流公司名称
	 * @param logisticsNum 物流单号
	 * @param logisticsAmt 物流费用
	 * @throws ZydException
	 */
	void deliveryBack(BigDecimal returnOrderId,
			LogisticsCompCode logisticsCompCode, String logisticsCompDesc,
			String logisticsNum, BigDecimal logisticsAmt) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 退换货寄件拒收
	 * 
	 * 备注：
	 * 1. 只有退换货订单状态为“待收件”状态时，可以操作
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDR033 退换货订单不存在
	 * EZYDR038 退换货订单状态不正确，不支持寄件拒收操作
	 * EZYDR031 拒收原因不能为空
	 * EZYDR032 拒收原因最大为150个字符
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @param reason 拒收原因
	 * @throws ZydException
	 */
	void refuseDeliveryBack(BigDecimal returnOrderId, String reason)
			throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 退换货寄件收件
	 * 
	 * 备注：
	 * 1. 只有退换货订单状态为“待收件”状态时，可以操作
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDR033 退换货订单不存在
	 * EZYDR039 退换货订单状态不正确，不支持寄件收件操作
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @throws ZydException
	 */
	void takeDeliverBack(BigDecimal returnOrderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 退换货退款
	 * 
	 * 备注：
	 * 1. 只有退换货类型为“退货”且退换货订单状态为“待退款”状态时，可以操作
	 * 2. 或退换货类型为“换货”且退换货订单状态为“退款审核”状态时，可以操作
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDR033 退换货订单不存在
	 * EZYDR040 退换货订单状态不正确，不支持退款操作
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @throws ZydException
	 */
	void refundReturnOrder(BigDecimal returnOrderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 退换货再次发货
	 * 
	 * 备注：
	 * 1. 只有退换货类型为“换货”且订单状态为“待发货”状态时，可以操作
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDR033 退换货订单不存在
	 * EZYDR041 退换货订单类型不正确，不支持发货操作
	 * EZYDR042 退换货订单状态不正确，不支持发货操作
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @throws ZydException
	 */
	void deliveryAgain(BigDecimal returnOrderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 退换货确认收货
	 * 
	 * 备注：
	 * 1. 只有退换货类型为“换货”且订单状态为“待收货”状态时，可以操作
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDR033 退换货订单不存在
	 * EZYDR043 退换货订单类型不正确，不支持收货操作
	 * EZYDR044 退换货订单状态不正确，不支持收货操作
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @throws ZydException
	 */
	void takeDeliveryAgain(BigDecimal returnOrderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 退换货再次发货拒收
	 * 
	 * 备注：
	 * 1. 只有退换货类型为“换货”且订单状态为“待收货”状态时，可以操作
	 * 2. 该方法涉及退款
	 * 3. 拒收操作由后台人员发起
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDR033 退换货订单不存在
	 * EZYDR045 退换货订单类型不正确，不支持拒收操作
	 * EZYDR046 退换货订单状态不正确，不支持拒收操作
	 * EZYDR031 拒收原因不能为空
	 * EZYDR032 拒收原因最大为150个字符
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @param refuseReason 拒收原因
	 * @throws ZydException
	 */
	void refuseDeliveryAgain(BigDecimal returnOrderId, String refuseReason) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 退换货申请退款
	 * 
	 * 备注：
	 * 1. 只有退换货类型为“换货”且订单状态为“待收货”状态时，可以操作
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDR033 退换货订单不存在
	 * EZYDR047 退换货订单类型不正确，不支持退款申请操作
	 * EZYDR048 退换货订单状态不正确，不支持退款申请操作
	 * EZYDR025 退款申请原因不能为空
	 * EZYDR026 退款申请原因最大为150个字符
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @param reason 申请退款原因
	 * @throws ZydException
	 */
	void applyForRefundOfReturnOrder(BigDecimal returnOrderId, String reason) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 取消退换货退款申请
	 * 
	 * 备注：
	 * 1. 只有退换货类型为“换货”且订单状态为“退款审核”状态时，可以操作
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * EZYDR033 退换货订单不存在
	 * EZYDR049 退换货订单类型不正确，不支持取消退款申请操作
	 * EZYDR050 退换货订单状态不正确，不支持取消退款申请操作
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @throws ZydException
	 */
	void cancelApplyForRefundOfReturnOrder(BigDecimal returnOrderId) throws ZydException;

	//******************************************************************************
	// 退换货订单 - End
	//******************************************************************************
	
	//******************************************************************************
	// 退换货订单事件 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 查询退换货订单id查询退换货订单事件
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param returnOrderId
	 * @param pageSize 分页大小
	 * @param page 请求页
	 * @return 退换货订单事件集合
	 * @throws ZydException
	 */
	List<ReturnOrderEventDto> queryReturnOrderEventsByReturnOrder(
			BigDecimal returnOrderId, int pageSize, int page)
			throws ZydException;
	
	//******************************************************************************
	// 退换货订单事件 - End
	//******************************************************************************
	
	//******************************************************************************
	// 退换货订单物流 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据退换货订单id与物流类型查询退换货订单物流信息
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @param returnOrderLogisticsType 物流类型
	 * @return 退换货订单物流信息
	 * @throws ZydException
	 */
	ReturnOrderLogisticsDto queryReturnOrderLogisticsByReturnOrder(BigDecimal returnOrderId,
            ReturnOrderLogisticsType returnOrderLogisticsType) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据退换货订单id查询退换货订单物流信息
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @return 退换货订单物流信息
	 * @throws ZydException
	 */
	List<ReturnOrderLogisticsDto> queryReturnOrderLogisticsesByReturnOrder(
			BigDecimal returnOrderId) throws ZydException;
	
	//******************************************************************************
	// 退换货订单物流 - End
	//******************************************************************************
	
	//******************************************************************************
	// 退换货订单配送信息 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据退换货订单id查询退换货订单配送信息
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @return 退换货订单配送信息
	 * @throws ZydException
	 */
	ReturnOrderContactInfoDto queryReturnOrderContactInfoByReturnOrder(
			BigDecimal returnOrderId) throws ZydException;
	
	//******************************************************************************
	// 退换货订单配送信息 - End
	//******************************************************************************
	
	//******************************************************************************
	// 退换货订单退款信息 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据退换货订单id查询退换货订单退款信息
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @return 退换货订单退款信息
	 * @throws ZydException
	 */
	ReturnOrderRefundInfoDto queryReturnOrderRefundInfoByReturnOrder(
			BigDecimal returnOrderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据会员id查询退换货订单退款信息
	 * 
	 * 备注：
	 * 1. 根据submit_time降序排序
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param partyId 会员id
	 * @param pageSize 分页大小
	 * @param page 请求页
	 * @return 退换货订单退款信息集合
	 * @throws ZydException
	 */
	List<ReturnOrderRefundInfoDto> queryReturnOrderRefundInfosByParyty(
			BigDecimal partyId, int pageSize, int page) throws ZydException;
	
	//******************************************************************************
	// 退换货订单退款信息 - End
	//******************************************************************************
	
	//******************************************************************************
	// 退换货订单物品、清单 - Start
	//******************************************************************************
	
	/**
	 * <pre>
	 * 根据退换货订单id查询退换货订单物品
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param returnOrderId 退换货订单id
	 * @return 退换货订单物品
	 * @throws ZydException
	 */
	ReturnOrderCommodityDto queryReturnOrderCommodityByReturnOrder(
			BigDecimal returnOrderId) throws ZydException;
	
	
	
	/**
	 * <pre>
	 * 根据退换货物品id查询退换货物品清单
	 * 
	 * 错误码：
	 * EZYD0001 系统错误
	 * EZYD0002 数据库错误
	 * </pre>
	 * 
	 * @param returnOrderCmmdtyId 退换货物品id
	 * @return 退换货物品清单集合
	 * @throws ZydException
	 */
	List<ReturnOrderItemListDto> queryReturnOrderItemListsByReturnOrderCommodity(
			BigDecimal returnOrderCmmdtyId) throws ZydException;
	
	//******************************************************************************
	// 退换货订单物品、清单 - End
	//******************************************************************************
	
}
