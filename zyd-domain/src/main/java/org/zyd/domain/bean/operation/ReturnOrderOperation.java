package org.zyd.domain.bean.operation;

import java.math.BigDecimal;

import org.zyd.common.constants.LogisticsCompCode;
import org.zyd.common.exception.ZydException;

public interface ReturnOrderOperation {

    /**
     * 审核 - 通过
     * 
     * @throws ZydException
     */
    void approve() throws ZydException;

    /**
     * 审核 - 不通过
     * 
     * @param reason 原因
     * @throws ZydException
     */
    void disapprove(String reason) throws ZydException;

    /**
     * 寄件 - 客户回寄物品
     * 
     * @param logisticsCompCode 物流公司代码
     * @param logisticsCompDesc 物流公司名称
     * @param logisticsNum 物流单号
     * @param logisticsAmt 物流费
     * @throws ZydException
     */
    void deliveryBack(LogisticsCompCode logisticsCompCode, String logisticsCompDesc, String logisticsNum, BigDecimal logisticsAmt)
            throws ZydException;

    /**
     * 拒收 － 拒收客户回寄物品
     * 
     * @throws ZydException
     */
    void refuseDeliveryBack(String reason) throws ZydException;

    /**
     * 收件 － 接收客户回寄物品
     * 
     * @throws ZydException
     */
    void takeDeliverBack() throws ZydException;

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
     * 换货再次发货
     * 
     * @throws ZydException
     */
    void deliveryAgain() throws ZydException;

    /**
     * 换货确认收货
     * 
     * @throws ZydException
     */
    void takeDelivery() throws ZydException;
    
    /**
     * 退换货再次发货拒收
     * 
     * @param refuseReason 拒收原因
     * @throws ZydException
     */
    void refuseDeliveryAgain(String refuseReason) throws ZydException;
}
