package org.zyd.domain.bean.operation;

import java.math.BigDecimal;

import org.zyd.domain.bean.OrderContactInfoBean;
import org.zyd.common.constants.LogisticsCompCode;
import org.zyd.common.exception.ZydException;

public interface PurchaseOrderOperation {
	/**
	 * 取消订单
	 * 
	 * @throws ZydException
	 */
	void cancel() throws ZydException;
	
	/**
	 * 支付订单
	 * 
	 * @throws ZydException
	 */
	void pay() throws ZydException;
	
	/**
	 * 发货
	 * 
	 * @param logisticsCompCode 物流公司代码
	 * @param logisticsCompDesc 物流公司名称
	 * @param logisticsNum 物流单号
	 * @throws ZydException
	 */
	void deliverGoods(LogisticsCompCode logisticsCompCode,
			String logisticsCompDesc, String logisticsNum) throws ZydException;	
	
	/**
	 * 申请退款
	 * 
	 * @param reason 原因
	 * @throws ZydException
	 */
	void applyForRefund(String reason) throws ZydException;
	
	/**
	 * 取消退款申请
	 * 
	 * @throws ZydException
	 */
	void cancelApplyForRefund() throws ZydException;
	
	/**
	 * 退款
	 * 
	 * @throws ZydException
	 */
	void refund() throws ZydException;
	
	/**
	 * 确认收货
	 * 
	 * @throws ZydException
	 */
	void takeDelivery() throws ZydException;
	
	/**
	 * 拒绝收货
	 * 
	 * @param refuseReason 拒收货原因
	 * @throws ZydException
	 */
	void refuseDelivery(String refuseReason) throws ZydException;
	
	/**
	 * 更新配送信息
	 * 
	 * @param orderContactInfoBean 订单配送信息
	 * @throws ZydException
	 */
	void updateContactInfo(OrderContactInfoBean orderContactInfoBean) throws ZydException;
	
	/**
	 * 删除订单商品
	 * 
	 * @param orderCmmdtyId 记录id
	 * @throws ZydException
	 */
	void removeOrderCommodity(BigDecimal orderCmmdtyId) throws ZydException;
	
	/**
	 * 更新订单商品购买数量
	 * 
	 * @param orderCmmdtyId 记录id
	 * @param qty 数量
	 * @throws ZydException
	 */
	void updateOrderCommodityQty(BigDecimal orderCmmdtyId, Integer qty) throws ZydException;
}
