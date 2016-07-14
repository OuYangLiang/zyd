package org.zyd.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.domain.bean.InvoiceBean;
import org.zyd.domain.bean.OrderCommodityBean;
import org.zyd.domain.bean.OrderContactInfoBean;
import org.zyd.domain.bean.OrderEventBean;
import org.zyd.domain.bean.OrderGiftBean;
import org.zyd.domain.bean.OrderGiftItemListBean;
import org.zyd.domain.bean.OrderItemListBean;
import org.zyd.domain.bean.OrderLogisticsBean;
import org.zyd.domain.bean.OrderPaymentBean;
import org.zyd.domain.bean.PurchaseOrderBean;
import org.zyd.domain.bean.ReturnOrderBean;
import org.zyd.domain.bean.ReturnOrderCommodityBean;
import org.zyd.domain.bean.ReturnOrderContactInfoBean;
import org.zyd.domain.bean.ReturnOrderEventBean;
import org.zyd.domain.bean.ReturnOrderItemListBean;
import org.zyd.domain.bean.ReturnOrderLogisticsBean;
import org.zyd.domain.bean.ReturnOrderRefundInfoBean;
import org.zyd.common.constants.ReturnOrderLogisticsType;
import org.zyd.common.exception.ZydException;

public interface OrderRepos {

    /**
     * 根据订单号查询购物订单
     * 
     * @param orderNum 订单号
     * @return 购物订单
     * @throws ZydException
     */
    PurchaseOrderBean queryPurchaseOrderByNum(String orderNum) throws ZydException;

    /**
     * 根据订单id查询购物订单
     * 
     * @param orderId 订单id
     * @return 购物订单
     * @throws ZydException
     */
    PurchaseOrderBean queryPurchaseOrderByKey(BigDecimal orderId) throws ZydException;

    /**
     * 查询会员id查询购物订单，根据submit_time降序排序
     * 
     * @param partyId 会员id
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 购物订单集合
     * @throws ZydException
     */
    List<PurchaseOrderBean> queryPurchaseOrdersByParty(BigDecimal partyId, int pageSize, int page) throws ZydException;

    /**
     * 根据订单id查询发票
     * 
     * @param orderId 订单id
     * @return 发票
     * @throws ZydException
     */
    InvoiceBean queryInvoiceByPurchaseOrder(BigDecimal orderId) throws ZydException;

    /**
     * 根据订单id查询订单事件，根据event_ts降序排序
     * 
     * @param orderId 订单id
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 订单事件集合
     * @throws ZydException
     */
    List<OrderEventBean> queryOrderEventsByPurchaseOrder(BigDecimal orderId, int pageSize, int page)
            throws ZydException;

    /**
     * 根据订单id查询订单商品
     * 
     * @param orderId 订单id
     * @return 订单商品集合
     * @throws ZydException
     */
    List<OrderCommodityBean> queryOrderCommodityBeansByPurchaseOrder(BigDecimal orderId) throws ZydException;

    /**
     * 根据订单id与商品id查询订单商品
     * 
     * @param orderId 订单id
     * @param cmmdtyId 商品id
     * @return 订单商品
     * @throws ZydException
     */
    OrderCommodityBean queryOrderCommodityBeanByPurchaseOrderAndCommodity(BigDecimal orderId, BigDecimal cmmdtyId)
            throws ZydException;

    /**
     * 根据订单商品id查询物品清单
     * 
     * @param orderCmmdtyId 订单商品id
     * @return 订单商品清单集合
     * @throws ZydException
     */
    List<OrderItemListBean> queryItemListBeansByOrderCommodity(BigDecimal orderCmmdtyId) throws ZydException;

    /**
     * 根据订单商品id查询订单商品赠品
     * 
     * @param orderCmmdtyid 订单商品id
     * @return 订单商品赠品集合
     * @throws ZydException
     */
    List<OrderGiftBean> queryOrderGiftBeansByOrderCommodity(BigDecimal orderCmmdtyId) throws ZydException;

    /**
     * 根据订单赠品id查询赠品清单
     * 
     * @param orderGiftId 订单赠品id
     * @return 赠品清单集合
     * @throws ZydException
     */
    List<OrderGiftItemListBean> queryOrderGiftItemListBeansByOrderGift(BigDecimal orderGiftId) throws ZydException;

    /**
     * 根据订单id查询物流信息
     * 
     * @param orderId 订单id
     * @return 物流信息
     * @throws ZydException
     */
    OrderLogisticsBean queryOrderLogisticsBeanByPurchaseOrder(BigDecimal orderId) throws ZydException;

    /**
     * 根据订单id查询配送信息
     * 
     * @param orderId 订单id
     * @return 配送信息
     * @throws ZydException
     */
    OrderContactInfoBean queryOrderContactInfoBeanByPurchaseOrder(BigDecimal orderId) throws ZydException;

    /**
     * 根据订单id查询订单支付信息
     * 
     * @param orderId 订单id
     * @return 订单支付信息
     * @throws ZydException
     */
    OrderPaymentBean queryOrderPaymentBeanByPurchaseOrder(BigDecimal orderId) throws ZydException;

    /**
     * 根据退换货单号查询退换货订单
     * 
     * @param returnOrderNum 退换货单号
     * @return 退换货订单
     * @throws ZydException
     */
    ReturnOrderBean queryReturnOrderBeanByNum(String returnOrderNum) throws ZydException;
    
    /**
     * 根据退换货id查询退换货订单
     * 
     * @param returnOrderId 退换货id
     * @return 退换货订单
     * @throws ZydException
     */
    ReturnOrderBean queryReturnOrderBeanByKey(BigDecimal returnOrderId) throws ZydException;

    /**
     * 根据会员id查询退换货订单，根据submit_time降序排序
     * 
     * @param partyId 会员id
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 退换货订单集合
     * @throws ZydException
     */
    List<ReturnOrderBean> queryReturnOrderBeansByParty(BigDecimal partyId, int pageSize, int page) throws ZydException;

    /**
     * 根据购物订单id查询退换货订单，根据submit_time降序排序
     * 
     * @param orderId 购物订单id
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 退换货订单集合
     * @throws ZydException
     */
    List<ReturnOrderBean> queryReturnOrderBeansByPurchaseOrder(BigDecimal orderId, int pageSize, int page)
            throws ZydException;

    /**
     * 根据退换货订单id查询退换货订单事件，根据event_ts降序排序
     * 
     * @param returnOrderId 退换货订单id
     * @param pageSize 分页大小
     * @param page 请求页
     * @return 退换货订单事件集合
     * @throws ZydException
     */
    List<ReturnOrderEventBean> queryReturnOrderEventsByReturnOrder(BigDecimal returnOrderId, int pageSize, int page)
            throws ZydException;

    /**
     * 根据退换货订单id与物流信息类型查询退换货订单物流信息
     * 
     * @param returnOrderid 退换货订单id
     * @param returnOrderLogisticsType 物流信息类型
     * @return 退换货订单物流信息
     * @throws ZydException
     */
    ReturnOrderLogisticsBean queryReturnOrderLogisticsBeanByReturnOrder(BigDecimal returnOrderId,
            ReturnOrderLogisticsType returnOrderLogisticsType) throws ZydException;

    /**
     * 根据退换货订单id查询退换货订单物流信息
     * 
     * @param returnOrderId 退换货订单id
     * @return 退换货订单物流信息集合
     * @throws ZydException
     */
    List<ReturnOrderLogisticsBean> queryReturnOrderLogisticsBeansByReturnOrder(BigDecimal returnOrderId)
            throws ZydException;

    /**
     * 根据退换货订单id查询配送信息
     * 
     * @param returnOrderId 退换货订单id
     * @return 配送信息
     * @throws ZydException
     */
    ReturnOrderContactInfoBean queryReturnOrderContactInfoBeanByReturnOrder(BigDecimal returnOrderId)
            throws ZydException;

    /**
     * 根据退换货订单id查询退款信息
     * 
     * @param returnOrderId 退换货订单id
     * @return 退款信息
     * @throws ZydException
     */
    ReturnOrderRefundInfoBean queryReturnOrderRefundInfoBeanByReturnOrder(BigDecimal returnOrderId) throws ZydException;

    /**
     * 根据会员id查询退换货订单退款信息，根据submit_time降序排序
     * 
     * @param partyId 会员id
     * @return 退换货订单退款信息集合
     * @throws ZydException
     */
    List<ReturnOrderRefundInfoBean> queryReturnOrderRefundInfoBeansByParyty(BigDecimal partyId, int pageSize, int page)
            throws ZydException;

    /**
     * 根据退换货订单id查询退换货物品
     * 
     * @param returnOrderId 退换货订单id
     * @return 退换货物品
     * @throws ZydException
     */
    ReturnOrderCommodityBean queryReturnOrderCommodityBeanByReturnOrder(BigDecimal returnOrderId)
            throws ZydException;

    /**
     * 根据退换货物品id查询退换货物品清单
     * 
     * @param returnOrderCmmdtyId 退换货物品id
     * @return 退换货物品清单集合
     * @throws ZydException
     */
    List<ReturnOrderItemListBean> queryReturnOrderItemListBeansByReturnOrderCommodity(BigDecimal returnOrderCmmdtyId)
            throws ZydException;
}
