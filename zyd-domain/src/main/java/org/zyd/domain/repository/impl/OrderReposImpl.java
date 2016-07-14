package org.zyd.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
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
import org.zyd.common.constants.SortCriteria;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.factory.OrderFactory;
import org.zyd.domain.repository.OrderRepos;
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
import org.zyd.store.mapper.InvoiceMapper;
import org.zyd.store.mapper.OrderCommodityMapper;
import org.zyd.store.mapper.OrderContactInfoMapper;
import org.zyd.store.mapper.OrderEventMapper;
import org.zyd.store.mapper.OrderGiftItemListMapper;
import org.zyd.store.mapper.OrderGiftMapper;
import org.zyd.store.mapper.OrderItemListMapper;
import org.zyd.store.mapper.OrderLogisticsMapper;
import org.zyd.store.mapper.OrderPaymentMapper;
import org.zyd.store.mapper.PurchaseOrderMapper;
import org.zyd.store.mapper.ReturnOrderCommodityMapper;
import org.zyd.store.mapper.ReturnOrderContactInfoMapper;
import org.zyd.store.mapper.ReturnOrderEventMapper;
import org.zyd.store.mapper.ReturnOrderItemListMapper;
import org.zyd.store.mapper.ReturnOrderLogisticsMapper;
import org.zyd.store.mapper.ReturnOrderMapper;
import org.zyd.store.mapper.ReturnOrderRefundInfoMapper;
import org.zyd.store.term.InvoiceTerm;
import org.zyd.store.term.OrderCommodityTerm;
import org.zyd.store.term.OrderContactInfoTerm;
import org.zyd.store.term.OrderEventTerm;
import org.zyd.store.term.OrderGiftItemListTerm;
import org.zyd.store.term.OrderGiftTerm;
import org.zyd.store.term.OrderItemListTerm;
import org.zyd.store.term.OrderLogisticsTerm;
import org.zyd.store.term.OrderPaymentTerm;
import org.zyd.store.term.PurchaseOrderTerm;
import org.zyd.store.term.ReturnOrderCommodityTerm;
import org.zyd.store.term.ReturnOrderContactInfoTerm;
import org.zyd.store.term.ReturnOrderEventTerm;
import org.zyd.store.term.ReturnOrderItemListTerm;
import org.zyd.store.term.ReturnOrderLogisticsTerm;
import org.zyd.store.term.ReturnOrderRefundInfoTerm;
import org.zyd.store.term.ReturnOrderTerm;

public class OrderReposImpl implements OrderRepos {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private OrderEventMapper orderEventMapper;
    @Autowired
    private OrderCommodityMapper orderCommodityMapper;
    @Autowired
    private OrderItemListMapper orderItemListMapper;
    @Autowired
    private OrderGiftMapper orderGiftMapper;
    @Autowired
    private OrderGiftItemListMapper orderGiftItemListMapper;
    @Autowired
    private OrderLogisticsMapper orderLogisticsMapper;
    @Autowired
    private OrderContactInfoMapper orderContactInfoMapper;
    @Autowired
    private OrderPaymentMapper orderPaymentMapper;
    @Autowired
    private ReturnOrderMapper returnOrderMapper;
    @Autowired
    private ReturnOrderEventMapper returnOrderEventMapper;
    @Autowired
    private ReturnOrderLogisticsMapper returnOrderLogisticsMapper;
    @Autowired
    private ReturnOrderContactInfoMapper returnOrderContactInfoMapper;
    @Autowired
    private ReturnOrderRefundInfoMapper returnOrderRefundInfoMapper;
    @Autowired
    private ReturnOrderCommodityMapper returnOrderCommodityMapper;
    @Autowired
    private ReturnOrderItemListMapper returnOrderItemListMapper;
    @Autowired
    private OrderFactory orderFactory;

    @Override
    public PurchaseOrderBean queryPurchaseOrderByNum(String orderNum) throws ZydException {
        if (StringUtils.isEmpty(orderNum)) {
            throw new IllegalArgumentException();
        }
        PurchaseOrderTerm term = new PurchaseOrderTerm();
        term.setOrderNum(orderNum);
        List<PurchaseOrderEntity> entitys = purchaseOrderMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createPurchaseOrderBean(entitys.get(0));
    }

    @Override
    public PurchaseOrderBean queryPurchaseOrderByKey(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        PurchaseOrderTerm term = new PurchaseOrderTerm();
        term.setOrderId(orderId);
        List<PurchaseOrderEntity> entitys = purchaseOrderMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createPurchaseOrderBean(entitys.get(0));
    }

    @Override
    public List<PurchaseOrderBean> queryPurchaseOrdersByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        PurchaseOrderTerm term = new PurchaseOrderTerm();
        term.setPartyId(partyId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.purchase_order_submit_time_desc.getField());
        term.setSortDir(SortCriteria.purchase_order_submit_time_desc.getDir());
        List<PurchaseOrderEntity> entitys = purchaseOrderMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<PurchaseOrderBean> rlt = new ArrayList<PurchaseOrderBean>();
        for (PurchaseOrderEntity entity : entitys) {
            rlt.add(orderFactory.createPurchaseOrderBean(entity));
        }
        return rlt;
    }

    @Override
    public InvoiceBean queryInvoiceByPurchaseOrder(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        InvoiceTerm term = new InvoiceTerm();
        term.setOrderId(orderId);
        List<InvoiceEntity> entitys = invoiceMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createInvoiceBean(entitys.get(0));
    }

    @Override
    public List<OrderEventBean> queryOrderEventsByPurchaseOrder(BigDecimal orderId, int pageSize, int page)
            throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        OrderEventTerm term = new OrderEventTerm();
        term.setOrderId(orderId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.order_event_event_ts_desc.getField());
        term.setSortDir(SortCriteria.order_event_event_ts_desc.getDir());
        List<OrderEventEntity> entitys = orderEventMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<OrderEventBean> rlt = new ArrayList<OrderEventBean>();
        for (OrderEventEntity entity : entitys) {
            rlt.add(orderFactory.createOrderEventBean(entity));
        }
        return rlt;
    }

    @Override
    public List<OrderCommodityBean> queryOrderCommodityBeansByPurchaseOrder(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        OrderCommodityTerm term = new OrderCommodityTerm();
        term.setOrderId(orderId);
        List<OrderCommodityEntity> entitys = orderCommodityMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        List<OrderCommodityBean> rlt = new ArrayList<OrderCommodityBean>();
        for (OrderCommodityEntity entity : entitys) {
            rlt.add(orderFactory.createOrderCommodityBean(entity));
        }
        return rlt;
    }

    @Override
    public OrderCommodityBean queryOrderCommodityBeanByPurchaseOrderAndCommodity(BigDecimal orderId, BigDecimal cmmdtyId)
            throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        OrderCommodityTerm term = new OrderCommodityTerm();
        term.setOrderId(orderId);
        term.setCmmdtyId(cmmdtyId);
        List<OrderCommodityEntity> entitys = orderCommodityMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createOrderCommodityBean(entitys.get(0));
    }

    @Override
    public List<OrderItemListBean> queryItemListBeansByOrderCommodity(BigDecimal orderCmmdtyId) throws ZydException {
        if (null == orderCmmdtyId) {
            throw new IllegalArgumentException();
        }
        OrderItemListTerm term = new OrderItemListTerm();
        term.setOrderCmmdtyId(orderCmmdtyId);
        List<OrderItemListEntity> entitys = orderItemListMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        List<OrderItemListBean> rlt = new ArrayList<OrderItemListBean>();
        for (OrderItemListEntity entity : entitys) {
            rlt.add(orderFactory.createOrderItemListBean(entity));
        }
        return rlt;
    }

    @Override
    public List<OrderGiftBean> queryOrderGiftBeansByOrderCommodity(BigDecimal orderCmmdtyId) throws ZydException {
        if (null == orderCmmdtyId) {
            throw new IllegalArgumentException();
        }
        OrderGiftTerm term = new OrderGiftTerm();
        term.setOrderCmmdtyId(orderCmmdtyId);
        List<OrderGiftEntity> entitys = orderGiftMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        List<OrderGiftBean> rlt = new ArrayList<OrderGiftBean>();
        for (OrderGiftEntity entity : entitys) {
            rlt.add(orderFactory.createOrderGiftBean(entity));
        }
        return rlt;
    }

    @Override
    public List<OrderGiftItemListBean> queryOrderGiftItemListBeansByOrderGift(BigDecimal orderGiftId)
            throws ZydException {
        if (null == orderGiftId) {
            throw new IllegalArgumentException();
        }
        OrderGiftItemListTerm term = new OrderGiftItemListTerm();
        term.setOrderGiftId(orderGiftId);
        List<OrderGiftItemListEntity> entitys = orderGiftItemListMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        List<OrderGiftItemListBean> rlt = new ArrayList<OrderGiftItemListBean>();
        for (OrderGiftItemListEntity entity : entitys) {
            rlt.add(orderFactory.createOrderGiftItemListBean(entity));
        }
        return rlt;
    }

    @Override
    public OrderLogisticsBean queryOrderLogisticsBeanByPurchaseOrder(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        OrderLogisticsTerm term = new OrderLogisticsTerm();
        term.setOrderId(orderId);
        List<OrderLogisticsEntity> entitys = orderLogisticsMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createOrderLogisticsBean(entitys.get(0));
    }

    @Override
    public OrderContactInfoBean queryOrderContactInfoBeanByPurchaseOrder(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        OrderContactInfoTerm term = new OrderContactInfoTerm();
        term.setOrderId(orderId);
        List<OrderContactInfoEntity> entitys = orderContactInfoMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createOrderContactInfoBean(entitys.get(0));
    }

    @Override
    public OrderPaymentBean queryOrderPaymentBeanByPurchaseOrder(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        OrderPaymentTerm term = new OrderPaymentTerm();
        term.setOrderId(orderId);
        List<OrderPaymentEntity> entitys = orderPaymentMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createOrderPaymentBean(entitys.get(0));
    }

    @Override
    public ReturnOrderBean queryReturnOrderBeanByNum(String returnOrderNum) throws ZydException {
        if (StringUtils.isEmpty(returnOrderNum)) {
            throw new IllegalArgumentException();
        }
        ReturnOrderTerm term = new ReturnOrderTerm();
        term.setReturnOrderNum(returnOrderNum);
        List<ReturnOrderEntity> entitys = returnOrderMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createReturnOrderBean(entitys.get(0));
    }

    @Override
    public ReturnOrderBean queryReturnOrderBeanByKey(BigDecimal returnOrderId) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderTerm term = new ReturnOrderTerm();
        term.setReturnOrderId(returnOrderId);
        List<ReturnOrderEntity> entitys = returnOrderMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createReturnOrderBean(entitys.get(0));
    }

    @Override
    public List<ReturnOrderBean> queryReturnOrderBeansByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderTerm term = new ReturnOrderTerm();
        term.setPartyId(partyId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.return_order_submit_time_desc.getField());
        term.setSortDir(SortCriteria.return_order_submit_time_desc.getDir());
        List<ReturnOrderEntity> entitys = returnOrderMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<ReturnOrderBean> rlt = new ArrayList<ReturnOrderBean>();
        for (ReturnOrderEntity entity : entitys) {
            rlt.add(orderFactory.createReturnOrderBean(entity));
        }
        return rlt;
    }

    @Override
    public List<ReturnOrderBean> queryReturnOrderBeansByPurchaseOrder(BigDecimal orderId, int pageSize, int page)
            throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderTerm term = new ReturnOrderTerm();
        term.setOrderId(orderId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.return_order_submit_time_desc.getField());
        term.setSortDir(SortCriteria.return_order_submit_time_desc.getDir());
        List<ReturnOrderEntity> entitys = returnOrderMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<ReturnOrderBean> rlt = new ArrayList<ReturnOrderBean>();
        for (ReturnOrderEntity entity : entitys) {
            rlt.add(orderFactory.createReturnOrderBean(entity));
        }
        return rlt;
    }

    @Override
    public List<ReturnOrderEventBean> queryReturnOrderEventsByReturnOrder(BigDecimal returnOrderId, int pageSize,
            int page) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderEventTerm term = new ReturnOrderEventTerm();
        term.setReturnOrderId(returnOrderId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.return_order_event_event_ts_desc.getField());
        term.setSortDir(SortCriteria.return_order_event_event_ts_desc.getDir());
        List<ReturnOrderEventEntity> entitys = returnOrderEventMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<ReturnOrderEventBean> rlt = new ArrayList<ReturnOrderEventBean>();
        for (ReturnOrderEventEntity entity : entitys) {
            rlt.add(orderFactory.createReturnOrderEventBean(entity));
        }
        return rlt;
    }

    @Override
    public ReturnOrderLogisticsBean queryReturnOrderLogisticsBeanByReturnOrder(BigDecimal returnOrderId,
            ReturnOrderLogisticsType returnOrderLogisticsType) throws ZydException {
        if (null == returnOrderId || null == returnOrderLogisticsType) {
            throw new IllegalArgumentException();
        }
        ReturnOrderLogisticsTerm term = new ReturnOrderLogisticsTerm();
        term.setReturnOrderId(returnOrderId);
        term.setLogisticsType(returnOrderLogisticsType.name());
        List<ReturnOrderLogisticsEntity> entitys = returnOrderLogisticsMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createReturnOrderLogisticsBean(entitys.get(0));
    }

    @Override
    public List<ReturnOrderLogisticsBean> queryReturnOrderLogisticsBeansByReturnOrder(BigDecimal returnOrderId)
            throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderLogisticsTerm term = new ReturnOrderLogisticsTerm();
        term.setReturnOrderId(returnOrderId);
        List<ReturnOrderLogisticsEntity> entitys = returnOrderLogisticsMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<ReturnOrderLogisticsBean> rlt = new ArrayList<ReturnOrderLogisticsBean>();
        for (ReturnOrderLogisticsEntity entity : entitys) {
            rlt.add(orderFactory.createReturnOrderLogisticsBean(entity));
        }
        return rlt;
    }

    @Override
    public ReturnOrderContactInfoBean queryReturnOrderContactInfoBeanByReturnOrder(BigDecimal returnOrderId)
            throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderContactInfoTerm term = new ReturnOrderContactInfoTerm();
        term.setReturnOrderId(returnOrderId);
        List<ReturnOrderContactInfoEntity> entitys = returnOrderContactInfoMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createReturnOrderContactInfoBean(entitys.get(0));
    }

    @Override
    public ReturnOrderRefundInfoBean queryReturnOrderRefundInfoBeanByReturnOrder(BigDecimal returnOrderId)
            throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderRefundInfoTerm term = new ReturnOrderRefundInfoTerm();
        term.setReturnOrderId(returnOrderId);
        List<ReturnOrderRefundInfoEntity> entitys = returnOrderRefundInfoMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }
        return orderFactory.createReturnOrderRefundInfoBean(entitys.get(0));
    }

    @Override
    public List<ReturnOrderRefundInfoBean> queryReturnOrderRefundInfoBeansByParyty(BigDecimal partyId, int pageSize,
            int page) throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderRefundInfoTerm term = new ReturnOrderRefundInfoTerm();
        term.setPartyId(partyId);
        term.setPage(page);
        term.setPageSize(pageSize);
        term.setSortField(SortCriteria.return_order_refund_info_submit_time_desc.getField());
        term.setSortDir(SortCriteria.return_order_refund_info_submit_time_desc.getDir());
        List<ReturnOrderRefundInfoEntity> entitys = returnOrderRefundInfoMapper.listOfSummary(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<ReturnOrderRefundInfoBean> rlt = new ArrayList<ReturnOrderRefundInfoBean>();
        for (ReturnOrderRefundInfoEntity entity : entitys) {
            rlt.add(orderFactory.createReturnOrderRefundInfoBean(entity));
        }
        return rlt;
    }

    @Override
    public ReturnOrderCommodityBean queryReturnOrderCommodityBeanByReturnOrder(BigDecimal returnOrderId)
            throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderCommodityTerm term = new ReturnOrderCommodityTerm();
        term.setReturnOrderId(returnOrderId);
        List<ReturnOrderCommodityEntity> entitys = returnOrderCommodityMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        return orderFactory.createReturnOrderCommodityBean(entitys.get(0));
    }

    @Override
    public List<ReturnOrderItemListBean> queryReturnOrderItemListBeansByReturnOrderCommodity(
            BigDecimal returnOrderCmmdtyId) throws ZydException {
        if (null == returnOrderCmmdtyId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderItemListTerm term = new ReturnOrderItemListTerm();
        term.setReturnOrderCmmdtyId(returnOrderCmmdtyId);
        List<ReturnOrderItemListEntity> entitys = returnOrderItemListMapper.select(term);
        if (CollectionUtils.isEmpty(entitys)) {
            return null;
        }

        List<ReturnOrderItemListBean> rlt = new ArrayList<ReturnOrderItemListBean>();
        for (ReturnOrderItemListEntity entity : entitys) {
            rlt.add(orderFactory.createReturnOrderItemListBean(entity));
        }
        return rlt;
    }

}
