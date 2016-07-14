package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.LogisticsCompCode;
import org.zyd.common.constants.OperatorType;
import org.zyd.common.constants.OrderStatus;
import org.zyd.common.constants.PaymentMethod;
import org.zyd.common.constants.PaymentStatus;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.InvoiceBean;
import org.zyd.domain.bean.OrderCommodityBean;
import org.zyd.domain.bean.OrderContactInfoBean;
import org.zyd.domain.bean.OrderEventBean;
import org.zyd.domain.bean.OrderLogisticsBean;
import org.zyd.domain.bean.OrderPaymentBean;
import org.zyd.domain.bean.PurchaseOrderBean;
import org.zyd.domain.factory.OrderFactory;
import org.zyd.domain.repository.OrderRepos;
import org.zyd.domain.util.SequenceGenerator;
import org.zyd.store.entity.OrderLogEntity;
import org.zyd.store.entity.PurchaseOrderEntity;
import org.zyd.store.mapper.OrderLogMapper;
import org.zyd.store.mapper.PurchaseOrderMapper;

public class PurchaseOrderBeanImpl implements PurchaseOrderBean {

    private PurchaseOrderEntity entity;

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private OrderLogMapper orderLogMapper;

    private List<OrderCommodityBean> orderCommodityBeans;
    private OrderPaymentBean orderPaymentBean;
    private InvoiceBean invoiceBean;
    private OrderContactInfoBean orderContactInfoBean;
    private OrderLogisticsBean orderLogisticsBean;

    @Autowired
    private OrderFactory orderFactory;
    @Autowired
    private OrderRepos orderRepos;
    @Autowired
    private SequenceGenerator sequenceGenerator;

    public PurchaseOrderBeanImpl(PurchaseOrderEntity entity) {
        this.entity = entity;
    }

    @Override
    public BigDecimal getOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderId();
    }

    @Override
    public String getOrderNum() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderNum();
    }

    @Override
    public Timestamp getSubmitTime() {
        if (null == entity) {
            return null;
        }
        return entity.getSubmitTime();
    }

    @Override
    public OrderStatus getOrderStatus() {
        if (null == entity) {
            return null;
        }
        return OrderStatus.valueOf(entity.getOrderStatus());
    }

    @Override
    public BigDecimal getOrderTotalPrice() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderTotalPrice();
    }

    @Override
    public BigDecimal getPointConsumed() {
        if (null == entity) {
            return null;
        }
        return entity.getPointConsumed();
    }

    @Override
    public BigDecimal getLogisticsAmt() {
        if (null == entity) {
            return null;
        }
        return entity.getLogisticsAmt();
    }

    @Override
    public BigDecimal getOrderShouldPayment() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderShouldPayment();
    }

    @Override
    public BigDecimal getOrderActualPayment() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderActualPayment();
    }

    @Override
    public String getRemarks() {
        if (null == entity) {
            return null;
        }
        return entity.getRemarks();
    }

    @Override
    public String getRemarks2() {
        if (null == entity) {
            return null;
        }
        return entity.getRemarks2();
    }

    @Override
    public BigDecimal getPartyId() {
        if (null == entity) {
            return null;
        }
        return entity.getPartyId();
    }

    @Override
    public void setOrderId(BigDecimal orderId) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setOrderId(orderId);
    }

    @Override
    public void setOrderNum(String orderNum) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setOrderNum(orderNum);
    }

    @Override
    public void setSubmitTime(Timestamp submitTime) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setSubmitTime(submitTime);
    }

    @Override
    public void setOrderStatus(OrderStatus orderStatus) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setOrderStatus(orderStatus.name());
    }

    @Override
    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setOrderTotalPrice(orderTotalPrice);
    }

    @Override
    public void setPointConsumed(BigDecimal pointConsumed) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setPointConsumed(pointConsumed);
    }

    @Override
    public void setLogisticsAmt(BigDecimal logisticsAmt) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setLogisticsAmt(logisticsAmt);
    }

    @Override
    public boolean isFreeLogisticsAmt() {
        if (null == entity) {
            return false;
        }
        return entity.isFreeLogisticsAmt();
    }

    @Override
    public void setFreeLogisticsAmt(boolean freeLogisticsAmt) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setFreeLogisticsAmt(freeLogisticsAmt);
    }

    @Override
    public void setOrderShouldPayment(BigDecimal orderShouldPayment) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setOrderShouldPayment(orderShouldPayment);
    }

    @Override
    public void setOrderActualPayment(BigDecimal orderActualPayment) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setOrderActualPayment(orderActualPayment);
    }

    @Override
    public void setRemarks(String remarks) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setRemarks(remarks);
    }

    @Override
    public void setRemarks2(String remarks2) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setRemarks2(remarks2);
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void cancel() throws ZydException {
        // 订单事件
        Timestamp now = new Timestamp(new Date().getTime());
        OrderEventBean orderEvent = orderFactory.createOrderEventBean();
        orderEvent.setOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("取消订单");
        orderEvent.save();
        // 订单状态变化日志
        OrderLogEntity orderLog = new OrderLogEntity();
        orderLog.setOrderStatusBefore(this.getOrderStatus().name());

        OrderPaymentBean payment = orderRepos.queryOrderPaymentBeanByPurchaseOrder(getOrderId());

        if (PaymentMethod.A4700010.equals(payment.getPaymentMethod())
                && this.getOrderStatus().equals(OrderStatus.A3400020)) {
            orderLog.setOrderStatusAfter(OrderStatus.A3400060.name());
        } else if (this.getOrderStatus().equals(OrderStatus.A3400010)) {
            orderLog.setOrderStatusAfter(OrderStatus.A3400060.name());
        } else if (this.getOrderStatus().equals(OrderStatus.A3400020)) {
            orderLog.setOrderStatusAfter(OrderStatus.A3400030.name());
        }
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400030.name());
        orderLog.setLogDesc("取消订单");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        orderLogMapper.insert(orderLog);

        this.setOrderStatus(OrderStatus.valueOf(orderLog.getOrderStatusAfter()));
        this.change();
    }

    @Override
    public void pay() throws ZydException {
        // 订单事件
        Timestamp now = new Timestamp(new Date().getTime());
        OrderEventBean orderEvent = orderFactory.createOrderEventBean();
        orderEvent.setOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("支付成功");
        orderEvent.save();
        // 订单状态变化日志
        OrderLogEntity orderLog = new OrderLogEntity();
        orderLog.setOrderStatusBefore(this.getOrderStatus().name());
        orderLog.setOrderStatusAfter(OrderStatus.A3400020.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400030.name());
        orderLog.setLogDesc("支付成功");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        orderLogMapper.insert(orderLog);

        if (null == orderPaymentBean) {
            orderPaymentBean = orderRepos.queryOrderPaymentBeanByPurchaseOrder(getOrderId());

            // TODO 支付账号等信息
            orderPaymentBean.setPaymentTime(now);
            orderPaymentBean.setPaymentStatus(PaymentStatus.A4900020);
            orderPaymentBean.save();
        } else {
            // TODO 支付账号等信息
            orderPaymentBean.setPaymentTime(now);
            orderPaymentBean.setPaymentStatus(PaymentStatus.A4900020);
            orderPaymentBean.change();
        }

        this.setOrderStatus(OrderStatus.A3400020);
        this.change();

    }

    @Override
    public void deliverGoods(LogisticsCompCode logisticsCompCode, String logisticsCompDesc, String logisticsNum)
            throws ZydException {
        // 订单事件
        Timestamp now = new Timestamp(new Date().getTime());
        OrderEventBean orderEvent = orderFactory.createOrderEventBean();
        orderEvent.setOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("发货");
        orderEvent.save();
        // 订单状态变化日志
        OrderLogEntity orderLog = new OrderLogEntity();
        orderLog.setOrderStatusBefore(this.getOrderStatus().name());
        orderLog.setOrderStatusAfter(OrderStatus.A3400040.name());
        orderLog.setOperatorType(OperatorType.A4400020.name());
        orderLog.setLogDesc("发货");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        orderLogMapper.insert(orderLog);

        OrderLogisticsBean bean = orderFactory.createOrderLogisticsBean();
        bean.setLogisticsCompanyCode(logisticsCompCode);
        bean.setLogisticsCompanyDesc(logisticsCompDesc);
        bean.setLogisticsNum(logisticsNum);
        bean.setOrderId(getOrderId());
        bean.save();

        this.setOrderStatus(OrderStatus.A3400040);
        this.change();
    }

    @Override
    public void applyForRefund(String reason) throws ZydException {
        // 订单事件
        Timestamp now = new Timestamp(new Date().getTime());
        OrderEventBean orderEvent = orderFactory.createOrderEventBean();
        orderEvent.setOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc(reason);
        orderEvent.save();
        // 订单状态变化日志
        OrderLogEntity orderLog = new OrderLogEntity();
        orderLog.setOrderStatusBefore(this.getOrderStatus().name());
        orderLog.setOrderStatusAfter(OrderStatus.A3400030.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400030.name());
        orderLog.setLogDesc(reason);
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        orderLogMapper.insert(orderLog);

        this.setOrderStatus(OrderStatus.A3400030);
        this.change();
    }

    @Override
    public void refund() throws ZydException {
        // 订单事件
        Timestamp now = new Timestamp(new Date().getTime());
        OrderEventBean orderEvent = orderFactory.createOrderEventBean();
        orderEvent.setOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("退款成功");
        orderEvent.save();
        // 订单状态变化日志
        OrderLogEntity orderLog = new OrderLogEntity();
        orderLog.setOrderStatusBefore(this.getOrderStatus().name());
        orderLog.setOrderStatusAfter(OrderStatus.A3400070.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400020.name());
        orderLog.setLogDesc("退款成功");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        orderLogMapper.insert(orderLog);

        this.setOrderStatus(OrderStatus.A3400070);
        this.change();
    }

    @Override
    public void takeDelivery() throws ZydException {
        // 订单事件
        Timestamp now = new Timestamp(new Date().getTime());
        OrderEventBean orderEvent = orderFactory.createOrderEventBean();
        orderEvent.setOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("确认收货");
        orderEvent.save();
        // 订单状态变化日志
        OrderLogEntity orderLog = new OrderLogEntity();
        orderLog.setOrderStatusBefore(this.getOrderStatus().name());
        orderLog.setOrderStatusAfter(OrderStatus.A3400050.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400030.name());
        orderLog.setLogDesc("确认收货");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        orderLogMapper.insert(orderLog);

        this.setOrderStatus(OrderStatus.A3400050);
        this.change();
    }

    @Override
    public void updateContactInfo(OrderContactInfoBean orderContactInfoBean) throws ZydException {
        orderContactInfoBean.setOrderId(this.getOrderId());
        orderContactInfoBean.change();
    }

    @Override
    public void removeOrderCommodity(BigDecimal orderCmmdtyId) throws ZydException {
        if (null == orderCmmdtyId) {
            throw new IllegalArgumentException();
        }
        OrderCommodityBean bean = orderFactory.createOrderCommodityBean();
        bean.setOrderCmmdtyId(orderCmmdtyId);
        bean.remove();
    }

    @Override
    public void updateOrderCommodityQty(BigDecimal orderCmmdtyId, Integer qty) throws ZydException {
        if (null == orderCmmdtyId || null == qty) {
            throw new IllegalArgumentException();
        }
        OrderCommodityBean bean = orderFactory.createOrderCommodityBean();
        bean.setOrderCmmdtyId(orderCmmdtyId);
        bean.setQty(qty);
        bean.change();
    }

    @Override
    public void cancelApplyForRefund() throws ZydException {
        // 订单事件
        Timestamp now = new Timestamp(new Date().getTime());
        OrderEventBean orderEvent = orderFactory.createOrderEventBean();
        orderEvent.setOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("取消退款申请");
        orderEvent.save();
        // 订单状态变化日志
        OrderLogEntity orderLog = new OrderLogEntity();
        orderLog.setOrderStatusBefore(this.getOrderStatus().name());
        orderLog.setOrderStatusAfter(OrderStatus.A3400040.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400030.name());
        orderLog.setLogDesc("取消退款申请");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        orderLogMapper.insert(orderLog);

        this.setOrderStatus(OrderStatus.A3400040);
        this.change();
    }

    @Override
    public void refuseDelivery(String refuseReason) throws ZydException {
        // 订单事件
        Timestamp now = new Timestamp(new Date().getTime());
        OrderEventBean orderEvent = orderFactory.createOrderEventBean();
        orderEvent.setOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc(refuseReason);
        orderEvent.save();
        // 订单状态变化日志
        OrderLogEntity orderLog = new OrderLogEntity();
        orderLog.setOrderStatusBefore(this.getOrderStatus().name());
        //TODO 拒收后状态
        orderLog.setOrderStatusAfter(OrderStatus.A3400070.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400020.name());
        orderLog.setLogDesc(refuseReason);
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        orderLogMapper.insert(orderLog);

        this.setOrderStatus(OrderStatus.A3400070);
        this.change();
    }

    @Override
    public void saveRecursively() throws ZydException {
        this.save();
        BigDecimal orderId = this.getOrderId();

        if (null == orderId)
            throw new ZydException(ErrorCode.EZYD0002);

        // 订单事件
        Timestamp now = new Timestamp(new Date().getTime());
        OrderEventBean orderEvent = orderFactory.createOrderEventBean();
        orderEvent.setOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("提交订单");
        orderEvent.save();

        // 保存商品及相关
        List<OrderCommodityBean> cmmdtys = this.getOrderCommodityBeans();
        for (OrderCommodityBean cmmdty : cmmdtys) {
            cmmdty.setOrderId(orderId);
            cmmdty.saveRecursively();
        }
        // 保存支付方式
        OrderPaymentBean orderPayment = this.getOrderPaymentBean();
        orderPayment.setOrderId(orderId);
        orderPayment.save();
        // 保存发票信息
        InvoiceBean invoice = this.getInvoiceBean();
        if (null != invoice) {
            invoice.setOrderId(orderId);
            invoice.save();
        }
        // 保存配送信息
        OrderContactInfoBean contactInfo = this.getOrderContactInfoBean();
        contactInfo.setOrderId(orderId);
        contactInfo.save();
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            entity.setSubmitTime(now);
            this.setOrderNum(sequenceGenerator.generatePurchaseOrderNum());
            purchaseOrderMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            purchaseOrderMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void remove() throws ZydException {
        try {
            purchaseOrderMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setOrderId(null);
        }
    }

    @Override
    public List<OrderCommodityBean> getOrderCommodityBeans() {
        return orderCommodityBeans;
    }

    @Override
    public void setOrderCommodityBeans(List<OrderCommodityBean> orderCommodityBeans) {
        this.orderCommodityBeans = orderCommodityBeans;
    }

    @Override
    public OrderPaymentBean getOrderPaymentBean() {
        return orderPaymentBean;
    }

    @Override
    public void setOrderPaymentBean(OrderPaymentBean orderPaymentBean) {
        this.orderPaymentBean = orderPaymentBean;
    }

    @Override
    public InvoiceBean getInvoiceBean() {
        return invoiceBean;
    }

    @Override
    public void setInvoiceBean(InvoiceBean invoiceBean) {
        this.invoiceBean = invoiceBean;
    }

    @Override
    public OrderContactInfoBean getOrderContactInfoBean() {
        return orderContactInfoBean;
    }

    @Override
    public void setOrderContactInfoBean(OrderContactInfoBean orderContactInfoBean) {
        this.orderContactInfoBean = orderContactInfoBean;
    }

    @Override
    public OrderLogisticsBean getOrderLogisticsBean() {
        return orderLogisticsBean;
    }

    @Override
    public void setOrderLogisticsBean(OrderLogisticsBean orderLogisticsBean) {
        this.orderLogisticsBean = orderLogisticsBean;
    }

    @Override
    public void setFreeLogisticsCondition(BigDecimal freeLogisticsCondition) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }

        entity.setFreeLogisticsCondition(freeLogisticsCondition);
    }

    @Override
    public BigDecimal getFreeLogisticsCondition() {
        if (null == entity) {
            return null;
        }
        return entity.getFreeLogisticsCondition();
    }

    @Override
    public void setDiscount(BigDecimal discount) {
        if (null == entity) {
            entity = new PurchaseOrderEntity();
        }

        entity.setDiscount(discount);
    }

    @Override
    public BigDecimal getDiscount() {
        if (null == entity) {
            return null;
        }
        return entity.getDiscount();
    }

}
