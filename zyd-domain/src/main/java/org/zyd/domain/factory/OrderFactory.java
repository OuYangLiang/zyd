package org.zyd.domain.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
import org.zyd.domain.bean.impl.InvoiceBeanImpl;
import org.zyd.domain.bean.impl.OrderCommodityBeanImpl;
import org.zyd.domain.bean.impl.OrderContactInfoBeanImpl;
import org.zyd.domain.bean.impl.OrderEventBeanImpl;
import org.zyd.domain.bean.impl.OrderGiftBeanImpl;
import org.zyd.domain.bean.impl.OrderGiftItemListBeanImpl;
import org.zyd.domain.bean.impl.OrderItemListBeanImpl;
import org.zyd.domain.bean.impl.OrderLogisticsBeanImpl;
import org.zyd.domain.bean.impl.OrderPaymentBeanImpl;
import org.zyd.domain.bean.impl.PurchaseOrderBeanImpl;
import org.zyd.domain.bean.impl.ReturnOrderBeanImpl;
import org.zyd.domain.bean.impl.ReturnOrderCommodityBeanImpl;
import org.zyd.domain.bean.impl.ReturnOrderContactInfoBeanImpl;
import org.zyd.domain.bean.impl.ReturnOrderEventBeanImpl;
import org.zyd.domain.bean.impl.ReturnOrderItemListBeanImpl;
import org.zyd.domain.bean.impl.ReturnOrderLogisticsBeanImpl;
import org.zyd.domain.bean.impl.ReturnOrderRefundInfoBeanImpl;
import org.zyd.store.entity.InvoiceEntity;
import org.zyd.store.entity.OrderCommodityEntity;
import org.zyd.store.entity.OrderContactInfoEntity;
import org.zyd.store.entity.OrderEventEntity;
import org.zyd.store.entity.OrderGiftEntity;
import org.zyd.store.entity.OrderGiftItemListEntity;
import org.zyd.store.entity.OrderItemListEntity;
import org.zyd.store.entity.OrderLogisticsEntity;
import org.zyd.store.entity.OrderPaymentEntity;
import org.zyd.store.entity.PurchaseOrderEntity;
import org.zyd.store.entity.ReturnOrderCommodityEntity;
import org.zyd.store.entity.ReturnOrderContactInfoEntity;
import org.zyd.store.entity.ReturnOrderEntity;
import org.zyd.store.entity.ReturnOrderEventEntity;
import org.zyd.store.entity.ReturnOrderItemListEntity;
import org.zyd.store.entity.ReturnOrderLogisticsEntity;
import org.zyd.store.entity.ReturnOrderRefundInfoEntity;

public class OrderFactory implements ApplicationContextAware {
    private ApplicationContext context;

    public PurchaseOrderBean createPurchaseOrderBean() {
        return this.createPurchaseOrderBean(null);
    }

    public PurchaseOrderBean createPurchaseOrderBean(PurchaseOrderEntity entity) {
        PurchaseOrderBeanImpl rlt = new PurchaseOrderBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public InvoiceBean createInvoiceBean() {
        return this.createInvoiceBean(null);
    }

    public InvoiceBean createInvoiceBean(InvoiceEntity entity) {
        InvoiceBeanImpl rlt = new InvoiceBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public OrderEventBean createOrderEventBean() {
        return this.createOrderEventBean(null);
    }

    public OrderEventBean createOrderEventBean(OrderEventEntity entity) {
        OrderEventBeanImpl rlt = new OrderEventBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public OrderCommodityBean createOrderCommodityBean() {
        return this.createOrderCommodityBean(null);
    }

    public OrderCommodityBean createOrderCommodityBean(OrderCommodityEntity entity) {
        OrderCommodityBeanImpl rlt = new OrderCommodityBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public OrderItemListBean createOrderItemListBean() {
        return this.createOrderItemListBean(null);
    }

    public OrderItemListBean createOrderItemListBean(OrderItemListEntity entity) {
        OrderItemListBeanImpl rlt = new OrderItemListBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public OrderGiftBean createOrderGiftBean() {
        return this.createOrderGiftBean(null);
    }

    public OrderGiftBean createOrderGiftBean(OrderGiftEntity entity) {
        OrderGiftBeanImpl rlt = new OrderGiftBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public OrderGiftItemListBean createOrderGiftItemListBean() {
        return this.createOrderGiftItemListBean(null);
    }

    public OrderGiftItemListBean createOrderGiftItemListBean(OrderGiftItemListEntity entity) {
        OrderGiftItemListBeanImpl rlt = new OrderGiftItemListBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public OrderLogisticsBean createOrderLogisticsBean() {
        return this.createOrderLogisticsBean(null);
    }

    public OrderLogisticsBean createOrderLogisticsBean(OrderLogisticsEntity entity) {
        OrderLogisticsBeanImpl rlt = new OrderLogisticsBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public OrderContactInfoBean createOrderContactInfoBean() {
        return this.createOrderContactInfoBean(null);
    }

    public OrderContactInfoBean createOrderContactInfoBean(OrderContactInfoEntity entity) {
        OrderContactInfoBeanImpl rlt = new OrderContactInfoBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public OrderPaymentBean createOrderPaymentBean() {
        return this.createOrderPaymentBean(null);
    }

    public OrderPaymentBean createOrderPaymentBean(OrderPaymentEntity entity) {
        OrderPaymentBeanImpl rlt = new OrderPaymentBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public ReturnOrderBean createReturnOrderBean() {
        return this.createReturnOrderBean(null);
    }

    public ReturnOrderBean createReturnOrderBean(ReturnOrderEntity entity) {
        ReturnOrderBeanImpl rlt = new ReturnOrderBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public ReturnOrderEventBean createReturnOrderEventBean() {
        return this.createReturnOrderEventBean(null);
    }

    public ReturnOrderEventBean createReturnOrderEventBean(ReturnOrderEventEntity entity) {
        ReturnOrderEventBeanImpl rlt = new ReturnOrderEventBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public ReturnOrderLogisticsBean createReturnOrderLogisticsBean() {
        return this.createReturnOrderLogisticsBean(null);
    }

    public ReturnOrderLogisticsBean createReturnOrderLogisticsBean(ReturnOrderLogisticsEntity entity) {
        ReturnOrderLogisticsBeanImpl rlt = new ReturnOrderLogisticsBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public ReturnOrderContactInfoBean createReturnOrderContactInfoBean() {
        return this.createReturnOrderContactInfoBean(null);
    }

    public ReturnOrderContactInfoBean createReturnOrderContactInfoBean(ReturnOrderContactInfoEntity entity) {
        ReturnOrderContactInfoBeanImpl rlt = new ReturnOrderContactInfoBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public ReturnOrderRefundInfoBean createReturnOrderRefundInfoBean() {
        return this.createReturnOrderRefundInfoBean(null);
    }

    public ReturnOrderRefundInfoBean createReturnOrderRefundInfoBean(ReturnOrderRefundInfoEntity entity) {
        ReturnOrderRefundInfoBeanImpl rlt = new ReturnOrderRefundInfoBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public ReturnOrderCommodityBean createReturnOrderCommodityBean() {
        return this.createReturnOrderCommodityBean(null);
    }

    public ReturnOrderCommodityBean createReturnOrderCommodityBean(ReturnOrderCommodityEntity entity) {
        ReturnOrderCommodityBeanImpl rlt = new ReturnOrderCommodityBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    public ReturnOrderItemListBean createReturnOrderItemListBean() {
        return this.createReturnOrderItemListBean(null);
    }

    public ReturnOrderItemListBean createReturnOrderItemListBean(ReturnOrderItemListEntity entity) {
        ReturnOrderItemListBeanImpl rlt = new ReturnOrderItemListBeanImpl(entity);
        context.getAutowireCapableBeanFactory().autowireBean(rlt);

        return rlt;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }
}
