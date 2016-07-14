package org.zyd.service.inf.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.EvaluationStatus;
import org.zyd.common.constants.InvoiceType;
import org.zyd.common.constants.LogisticsCompCode;
import org.zyd.common.constants.OrderCommodityStatus;
import org.zyd.common.constants.OrderStatus;
import org.zyd.common.constants.PaymentChannel;
import org.zyd.common.constants.PaymentMethod;
import org.zyd.common.constants.PaymentStatus;
import org.zyd.common.constants.ReturnOrderLogisticsType;
import org.zyd.common.constants.ReturnOrderStatus;
import org.zyd.common.constants.ReturnOrderType;
import org.zyd.common.constants.SortCriteria;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.BoutiqueBean;
import org.zyd.domain.bean.CommodityBean;
import org.zyd.domain.bean.InvoiceBean;
import org.zyd.domain.bean.ItemListBean;
import org.zyd.domain.bean.OrderCommodityBean;
import org.zyd.domain.bean.OrderContactInfoBean;
import org.zyd.domain.bean.OrderEventBean;
import org.zyd.domain.bean.OrderGiftBean;
import org.zyd.domain.bean.OrderGiftItemListBean;
import org.zyd.domain.bean.OrderItemListBean;
import org.zyd.domain.bean.OrderLogisticsBean;
import org.zyd.domain.bean.OrderPaymentBean;
import org.zyd.domain.bean.PartyContactInfoBean;
import org.zyd.domain.bean.PartyIdentifyBean;
import org.zyd.domain.bean.PurchaseOrderBean;
import org.zyd.domain.bean.ReturnOrderBean;
import org.zyd.domain.bean.ReturnOrderCommodityBean;
import org.zyd.domain.bean.ReturnOrderContactInfoBean;
import org.zyd.domain.bean.ReturnOrderEventBean;
import org.zyd.domain.bean.ReturnOrderItemListBean;
import org.zyd.domain.bean.ReturnOrderLogisticsBean;
import org.zyd.domain.bean.ReturnOrderRefundInfoBean;
import org.zyd.domain.bean.TeaBean;
import org.zyd.domain.bean.TeapotBean;
import org.zyd.domain.factory.OrderFactory;
import org.zyd.domain.repository.CommodityRepos;
import org.zyd.domain.repository.OrderRepos;
import org.zyd.domain.repository.PartyRepos;
import org.zyd.service.convertor.OrderConvertor;
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
import org.zyd.service.inf.OrderInf;
import org.zyd.store.entity.OrderLogEntity;
import org.zyd.store.mapper.OrderLogMapper;
import org.zyd.store.term.OrderLogTerm;

public class OrderInfImpl implements OrderInf {
    @Autowired
    private PartyRepos partyRepos;
    @Autowired
    private CommodityRepos commodityRepos;
    @Autowired
    private OrderRepos orderRepos;
    @Autowired
    private OrderFactory orderFactory;
    @Autowired
    private OrderConvertor orderConvertor;
    @Autowired
    private OrderLogMapper orderLogMapper;

    @Override
    public void createPurchaseOrder(BigDecimal partyId, List<BigDecimal> cmmdtyIds, int[] qties, BigDecimal pointUsed,
            String remarks, BigDecimal cntctId, PaymentMethod paymentMethod, PaymentChannel paymentChannel,
            InvoiceType invoiceType, String invoiceTitle) throws ZydException {
        if (null == partyId || CollectionUtils.isEmpty(cmmdtyIds) || null == qties) {
            throw new IllegalArgumentException();
        }
        if (null == cntctId) {
            throw new ZydException(ErrorCode.EZYDR005);
        }
        if (null == paymentMethod) {
            throw new ZydException(ErrorCode.EZYDR008);
        }
        if (null != invoiceType && InvoiceType.A3500020.equals(invoiceType)) {
            throw new ZydException(ErrorCode.EZYDR009);
        }
        if (!StringUtils.isEmpty(remarks) && remarks.length() > 100) {
            throw new ZydException(ErrorCode.EZYDR004);
        }
        if (!StringUtils.isEmpty(invoiceTitle) && invoiceTitle.length() > 100) {
            throw new ZydException(ErrorCode.EZYDR010);
        }

        // 验证会员是否存在
        PartyIdentifyBean partyIdentifyBean = partyRepos.queryPartyIdentifyByKey(partyId);
        if (null == partyIdentifyBean) {
            throw new ZydException(ErrorCode.EZYDE013);
        }
        PartyContactInfoBean cntct = partyRepos.queryPartyContactInfoBeanByKey(cntctId);
        if (null == cntct) {
            throw new ZydException(ErrorCode.EZYDR006);
        }
        if (!cntct.getPartyId().equals(partyId)) {
            throw new ZydException(ErrorCode.EZYDR007);
        }
        PurchaseOrderBean bean = orderFactory.createPurchaseOrderBean();
        BigDecimal orderTotalAmt = BigDecimal.ZERO;
        List<OrderCommodityBean> cmmdtys = new ArrayList<OrderCommodityBean>();
        for (int i = 0; i < cmmdtyIds.size(); i++) {
            int qty = qties[i];
            if (qty <= 0) {
                throw new ZydException(ErrorCode.EZYDR001);
            }
            CommodityBean cmmdtyBean = commodityRepos.queryCommodityByKey(cmmdtyIds.get(i));
            if (null == cmmdtyBean) {
                throw new ZydException(ErrorCode.EZYDE032);
            }
            if (cmmdtyBean instanceof TeapotBean) {
                TeapotBean teapotBean = (TeapotBean) cmmdtyBean;
                if (teapotBean.getNumStored() < qty) {
                    throw new ZydException(ErrorCode.EZYDR002);
                }
                orderTotalAmt = orderTotalAmt.add(teapotBean.getCurrentPrice().multiply(new BigDecimal(qty)));
                OrderCommodityBean cmmdty = orderFactory.createOrderCommodityBean();
                cmmdty.setActualPrice(teapotBean.getCurrentPrice());
                cmmdty.setCmmdtyId(teapotBean.getCmmdtyId());
                cmmdty.setCmmdtyName(teapotBean.getCmmdtyName());
                cmmdty.setCommodityStatus(OrderCommodityStatus.A4500010);
                cmmdty.setDefaultImageAddrs(teapotBean.getDefaultImageAddrs());
                cmmdty.setEvaluationStatus(EvaluationStatus.A4600010);
                cmmdty.setProposedPrice(teapotBean.getProposedPrice());
                cmmdty.setQty(qty);
                cmmdty.setTimesExchanged(0);
                List<ItemListBean> itemLists = commodityRepos.queryItemListBeans(cmmdtyBean.getCmmdtyId());
                if (CollectionUtils.isEmpty(itemLists)) {
                    cmmdty.setOrderItemListBeans(null);
                } else {
                    List<OrderItemListBean> orderItemListBeans = new ArrayList<OrderItemListBean>();
                    for (ItemListBean item : itemLists) {
                        OrderItemListBean orderItem = orderFactory.createOrderItemListBean();
                        orderItem.setItemDesc(item.getItemDesc());
                        orderItem.setItemQty(item.getItemQty());
                        orderItemListBeans.add(orderItem);
                    }
                    cmmdty.setOrderItemListBeans(orderItemListBeans);
                }
                List<CommodityBean> gifts = commodityRepos.queryGiftsByCommodity(cmmdtyBean.getCmmdtyId());
                if (CollectionUtils.isEmpty(gifts)) {
                    cmmdty.setOrderGiftBeans(null);
                } else {
                    List<OrderGiftBean> orderGiftBeans = new ArrayList<OrderGiftBean>();
                    for (CommodityBean gift : gifts) {
                        OrderGiftBean orderGift = orderFactory.createOrderGiftBean();
                        if (gift instanceof TeapotBean) {
                            TeapotBean teapotGift = (TeapotBean) gift;
                            orderGift.setCmmdtyId(teapotGift.getCmmdtyId());
                            orderGift.setCmmdtyName(teapotGift.getCmmdtyName());
                            orderGift.setCommodityStatus(OrderCommodityStatus.A4500010);
                            orderGift.setDefaultImageAddrs(teapotGift.getDefaultImageAddrs());
                            orderGift.setEvaluationStatus(EvaluationStatus.A4600010);
                            orderGift.setProposedPrice(teapotGift.getProposedPrice());
                            // TODO
                            orderGift.setQty(1);
                            orderGift.setTimesExchanged(0);
                            List<ItemListBean> giftItemLists = commodityRepos.queryItemListBeans(cmmdtyBean
                                    .getCmmdtyId());
                            if (CollectionUtils.isEmpty(giftItemLists)) {
                                orderGift.setOrderGiftItemListBeans(null);
                            } else {
                                List<OrderGiftItemListBean> orderGiftItemListBeans = new ArrayList<OrderGiftItemListBean>();
                                for (ItemListBean item : giftItemLists) {
                                    OrderGiftItemListBean orderGiftItem = orderFactory.createOrderGiftItemListBean();
                                    orderGiftItem.setItemDesc(item.getItemDesc());
                                    orderGiftItem.setItemQty(item.getItemQty());
                                    orderGiftItemListBeans.add(orderGiftItem);
                                }
                                orderGift.setOrderGiftItemListBeans(orderGiftItemListBeans);
                            }
                        } else if (gift instanceof BoutiqueBean) {
                            BoutiqueBean boutiqueGift = (BoutiqueBean) gift;
                            orderGift.setCmmdtyId(boutiqueGift.getCmmdtyId());
                            orderGift.setCmmdtyName(boutiqueGift.getCmmdtyName());
                            orderGift.setCommodityStatus(OrderCommodityStatus.A4500010);
                            orderGift.setDefaultImageAddrs(boutiqueGift.getDefaultImageAddrs());
                            orderGift.setEvaluationStatus(EvaluationStatus.A4600010);
                            orderGift.setProposedPrice(boutiqueGift.getProposedPrice());
                            // TODO
                            orderGift.setQty(1);
                            orderGift.setTimesExchanged(0);
                            List<ItemListBean> giftItemLists = commodityRepos.queryItemListBeans(cmmdtyBean
                                    .getCmmdtyId());
                            if (CollectionUtils.isEmpty(giftItemLists)) {
                                orderGift.setOrderGiftItemListBeans(null);
                            } else {
                                List<OrderGiftItemListBean> orderGiftItemListBeans = new ArrayList<OrderGiftItemListBean>();
                                for (ItemListBean item : giftItemLists) {
                                    OrderGiftItemListBean orderGiftItem = orderFactory.createOrderGiftItemListBean();
                                    orderGiftItem.setItemDesc(item.getItemDesc());
                                    orderGiftItem.setItemQty(item.getItemQty());
                                    orderGiftItemListBeans.add(orderGiftItem);
                                }
                                orderGift.setOrderGiftItemListBeans(orderGiftItemListBeans);
                            }
                        } else if (cmmdtyBean instanceof TeaBean) {
                            TeaBean teaGift = (TeaBean) gift;
                            orderGift.setCmmdtyId(teaGift.getCmmdtyId());
                            orderGift.setCmmdtyName(teaGift.getCmmdtyName());
                            orderGift.setCommodityStatus(OrderCommodityStatus.A4500010);
                            orderGift.setDefaultImageAddrs(teaGift.getDefaultImageAddrs());
                            orderGift.setEvaluationStatus(EvaluationStatus.A4600010);
                            orderGift.setProposedPrice(teaGift.getProposedPrice());
                            // TODO
                            orderGift.setQty(1);
                            orderGift.setTimesExchanged(0);
                            List<ItemListBean> giftItemLists = commodityRepos.queryItemListBeans(cmmdtyBean
                                    .getCmmdtyId());
                            if (CollectionUtils.isEmpty(giftItemLists)) {
                                orderGift.setOrderGiftItemListBeans(null);
                            } else {
                                List<OrderGiftItemListBean> orderGiftItemListBeans = new ArrayList<OrderGiftItemListBean>();
                                for (ItemListBean item : giftItemLists) {
                                    OrderGiftItemListBean orderGiftItem = orderFactory.createOrderGiftItemListBean();
                                    orderGiftItem.setItemDesc(item.getItemDesc());
                                    orderGiftItem.setItemQty(item.getItemQty());
                                    orderGiftItemListBeans.add(orderGiftItem);
                                }
                                orderGift.setOrderGiftItemListBeans(orderGiftItemListBeans);
                            }
                        }
                        orderGiftBeans.add(orderGift);
                    }
                    cmmdty.setOrderGiftBeans(orderGiftBeans);
                }
                cmmdtys.add(cmmdty);
            } else if (cmmdtyBean instanceof BoutiqueBean) {
                BoutiqueBean boutiqueBean = (BoutiqueBean) cmmdtyBean;
                if (boutiqueBean.getNumStored() < qty) {
                    throw new ZydException(ErrorCode.EZYDR002);
                }
                orderTotalAmt = orderTotalAmt.add(boutiqueBean.getCurrentPrice().multiply(new BigDecimal(qty)));
                OrderCommodityBean cmmdty = orderFactory.createOrderCommodityBean();
                cmmdty.setActualPrice(boutiqueBean.getCurrentPrice());
                cmmdty.setCmmdtyId(boutiqueBean.getCmmdtyId());
                cmmdty.setCmmdtyName(boutiqueBean.getCmmdtyName());
                cmmdty.setCommodityStatus(OrderCommodityStatus.A4500010);
                cmmdty.setDefaultImageAddrs(boutiqueBean.getDefaultImageAddrs());
                cmmdty.setEvaluationStatus(EvaluationStatus.A4600010);
                cmmdty.setProposedPrice(boutiqueBean.getProposedPrice());
                cmmdty.setQty(qty);
                cmmdty.setTimesExchanged(0);
                List<ItemListBean> itemLists = commodityRepos.queryItemListBeans(cmmdtyBean.getCmmdtyId());
                if (CollectionUtils.isEmpty(itemLists)) {
                    cmmdty.setOrderItemListBeans(null);
                } else {
                    List<OrderItemListBean> orderItemListBeans = new ArrayList<OrderItemListBean>();
                    for (ItemListBean item : itemLists) {
                        OrderItemListBean orderItem = orderFactory.createOrderItemListBean();
                        orderItem.setItemDesc(item.getItemDesc());
                        orderItem.setItemQty(item.getItemQty());
                        orderItemListBeans.add(orderItem);
                    }
                    cmmdty.setOrderItemListBeans(orderItemListBeans);
                }
                List<CommodityBean> gifts = commodityRepos.queryGiftsByCommodity(cmmdtyBean.getCmmdtyId());
                if (CollectionUtils.isEmpty(gifts)) {
                    cmmdty.setOrderGiftBeans(null);
                } else {
                    List<OrderGiftBean> orderGiftBeans = new ArrayList<OrderGiftBean>();
                    for (CommodityBean gift : gifts) {
                        OrderGiftBean orderGift = orderFactory.createOrderGiftBean();
                        if (gift instanceof TeapotBean) {
                            TeapotBean teapotGift = (TeapotBean) gift;
                            orderGift.setCmmdtyId(teapotGift.getCmmdtyId());
                            orderGift.setCmmdtyName(teapotGift.getCmmdtyName());
                            orderGift.setCommodityStatus(OrderCommodityStatus.A4500010);
                            orderGift.setDefaultImageAddrs(teapotGift.getDefaultImageAddrs());
                            orderGift.setEvaluationStatus(EvaluationStatus.A4600010);
                            orderGift.setProposedPrice(teapotGift.getProposedPrice());
                            // TODO
                            orderGift.setQty(1);
                            orderGift.setTimesExchanged(0);
                            List<ItemListBean> giftItemLists = commodityRepos.queryItemListBeans(cmmdtyBean
                                    .getCmmdtyId());
                            if (CollectionUtils.isEmpty(giftItemLists)) {
                                orderGift.setOrderGiftItemListBeans(null);
                            } else {
                                List<OrderGiftItemListBean> orderGiftItemListBeans = new ArrayList<OrderGiftItemListBean>();
                                for (ItemListBean item : giftItemLists) {
                                    OrderGiftItemListBean orderGiftItem = orderFactory.createOrderGiftItemListBean();
                                    orderGiftItem.setItemDesc(item.getItemDesc());
                                    orderGiftItem.setItemQty(item.getItemQty());
                                    orderGiftItemListBeans.add(orderGiftItem);
                                }
                                orderGift.setOrderGiftItemListBeans(orderGiftItemListBeans);
                            }
                        } else if (gift instanceof BoutiqueBean) {
                            BoutiqueBean boutiqueGift = (BoutiqueBean) gift;
                            orderGift.setCmmdtyId(boutiqueGift.getCmmdtyId());
                            orderGift.setCmmdtyName(boutiqueGift.getCmmdtyName());
                            orderGift.setCommodityStatus(OrderCommodityStatus.A4500010);
                            orderGift.setDefaultImageAddrs(boutiqueGift.getDefaultImageAddrs());
                            orderGift.setEvaluationStatus(EvaluationStatus.A4600010);
                            orderGift.setProposedPrice(boutiqueGift.getProposedPrice());
                            // TODO
                            orderGift.setQty(1);
                            orderGift.setTimesExchanged(0);
                            List<ItemListBean> giftItemLists = commodityRepos.queryItemListBeans(cmmdtyBean
                                    .getCmmdtyId());
                            if (CollectionUtils.isEmpty(giftItemLists)) {
                                orderGift.setOrderGiftItemListBeans(null);
                            } else {
                                List<OrderGiftItemListBean> orderGiftItemListBeans = new ArrayList<OrderGiftItemListBean>();
                                for (ItemListBean item : giftItemLists) {
                                    OrderGiftItemListBean orderGiftItem = orderFactory.createOrderGiftItemListBean();
                                    orderGiftItem.setItemDesc(item.getItemDesc());
                                    orderGiftItem.setItemQty(item.getItemQty());
                                    orderGiftItemListBeans.add(orderGiftItem);
                                }
                                orderGift.setOrderGiftItemListBeans(orderGiftItemListBeans);
                            }
                        } else if (cmmdtyBean instanceof TeaBean) {
                            TeaBean teaGift = (TeaBean) gift;
                            orderGift.setCmmdtyId(teaGift.getCmmdtyId());
                            orderGift.setCmmdtyName(teaGift.getCmmdtyName());
                            orderGift.setCommodityStatus(OrderCommodityStatus.A4500010);
                            orderGift.setDefaultImageAddrs(teaGift.getDefaultImageAddrs());
                            orderGift.setEvaluationStatus(EvaluationStatus.A4600010);
                            orderGift.setProposedPrice(teaGift.getProposedPrice());
                            // TODO
                            orderGift.setQty(1);
                            orderGift.setTimesExchanged(0);
                            List<ItemListBean> giftItemLists = commodityRepos.queryItemListBeans(cmmdtyBean
                                    .getCmmdtyId());
                            if (CollectionUtils.isEmpty(giftItemLists)) {
                                orderGift.setOrderGiftItemListBeans(null);
                            } else {
                                List<OrderGiftItemListBean> orderGiftItemListBeans = new ArrayList<OrderGiftItemListBean>();
                                for (ItemListBean item : giftItemLists) {
                                    OrderGiftItemListBean orderGiftItem = orderFactory.createOrderGiftItemListBean();
                                    orderGiftItem.setItemDesc(item.getItemDesc());
                                    orderGiftItem.setItemQty(item.getItemQty());
                                    orderGiftItemListBeans.add(orderGiftItem);
                                }
                                orderGift.setOrderGiftItemListBeans(orderGiftItemListBeans);
                            }
                        }
                        orderGiftBeans.add(orderGift);
                    }
                    cmmdty.setOrderGiftBeans(orderGiftBeans);
                }
                cmmdtys.add(cmmdty);
            } else if (cmmdtyBean instanceof TeaBean) {
                TeaBean teaBean = (TeaBean) cmmdtyBean;
                if (teaBean.getNumStored() < qty) {
                    throw new ZydException(ErrorCode.EZYDR002);
                }
                orderTotalAmt = orderTotalAmt.add(teaBean.getCurrentPrice().multiply(new BigDecimal(qty)));
                OrderCommodityBean cmmdty = orderFactory.createOrderCommodityBean();
                cmmdty.setActualPrice(teaBean.getCurrentPrice());
                cmmdty.setCmmdtyId(teaBean.getCmmdtyId());
                cmmdty.setCmmdtyName(teaBean.getCmmdtyName());
                cmmdty.setCommodityStatus(OrderCommodityStatus.A4500010);
                cmmdty.setDefaultImageAddrs(teaBean.getDefaultImageAddrs());
                cmmdty.setEvaluationStatus(EvaluationStatus.A4600010);
                cmmdty.setProposedPrice(teaBean.getProposedPrice());
                cmmdty.setQty(qty);
                cmmdty.setTimesExchanged(0);
                List<ItemListBean> itemLists = commodityRepos.queryItemListBeans(cmmdtyBean.getCmmdtyId());
                if (CollectionUtils.isEmpty(itemLists)) {
                    cmmdty.setOrderItemListBeans(null);
                } else {
                    List<OrderItemListBean> orderItemListBeans = new ArrayList<OrderItemListBean>();
                    for (ItemListBean item : itemLists) {
                        OrderItemListBean orderItem = orderFactory.createOrderItemListBean();
                        orderItem.setItemDesc(item.getItemDesc());
                        orderItem.setItemQty(item.getItemQty());
                        orderItemListBeans.add(orderItem);
                    }
                    cmmdty.setOrderItemListBeans(orderItemListBeans);
                }
                List<CommodityBean> gifts = commodityRepos.queryGiftsByCommodity(cmmdtyBean.getCmmdtyId());
                if (CollectionUtils.isEmpty(gifts)) {
                    cmmdty.setOrderGiftBeans(null);
                } else {
                    List<OrderGiftBean> orderGiftBeans = new ArrayList<OrderGiftBean>();
                    for (CommodityBean gift : gifts) {
                        OrderGiftBean orderGift = orderFactory.createOrderGiftBean();
                        if (gift instanceof TeapotBean) {
                            TeapotBean teapotGift = (TeapotBean) gift;
                            orderGift.setCmmdtyId(teapotGift.getCmmdtyId());
                            orderGift.setCmmdtyName(teapotGift.getCmmdtyName());
                            orderGift.setCommodityStatus(OrderCommodityStatus.A4500010);
                            orderGift.setDefaultImageAddrs(teapotGift.getDefaultImageAddrs());
                            orderGift.setEvaluationStatus(EvaluationStatus.A4600010);
                            orderGift.setProposedPrice(teapotGift.getProposedPrice());
                            // TODO
                            orderGift.setQty(1);
                            orderGift.setTimesExchanged(0);
                            List<ItemListBean> giftItemLists = commodityRepos.queryItemListBeans(cmmdtyBean
                                    .getCmmdtyId());
                            if (CollectionUtils.isEmpty(giftItemLists)) {
                                orderGift.setOrderGiftItemListBeans(null);
                            } else {
                                List<OrderGiftItemListBean> orderGiftItemListBeans = new ArrayList<OrderGiftItemListBean>();
                                for (ItemListBean item : giftItemLists) {
                                    OrderGiftItemListBean orderGiftItem = orderFactory.createOrderGiftItemListBean();
                                    orderGiftItem.setItemDesc(item.getItemDesc());
                                    orderGiftItem.setItemQty(item.getItemQty());
                                    orderGiftItemListBeans.add(orderGiftItem);
                                }
                                orderGift.setOrderGiftItemListBeans(orderGiftItemListBeans);
                            }
                        } else if (gift instanceof BoutiqueBean) {
                            BoutiqueBean boutiqueGift = (BoutiqueBean) gift;
                            orderGift.setCmmdtyId(boutiqueGift.getCmmdtyId());
                            orderGift.setCmmdtyName(boutiqueGift.getCmmdtyName());
                            orderGift.setCommodityStatus(OrderCommodityStatus.A4500010);
                            orderGift.setDefaultImageAddrs(boutiqueGift.getDefaultImageAddrs());
                            orderGift.setEvaluationStatus(EvaluationStatus.A4600010);
                            orderGift.setProposedPrice(boutiqueGift.getProposedPrice());
                            // TODO
                            orderGift.setQty(1);
                            orderGift.setTimesExchanged(0);
                            List<ItemListBean> giftItemLists = commodityRepos.queryItemListBeans(cmmdtyBean
                                    .getCmmdtyId());
                            if (CollectionUtils.isEmpty(giftItemLists)) {
                                orderGift.setOrderGiftItemListBeans(null);
                            } else {
                                List<OrderGiftItemListBean> orderGiftItemListBeans = new ArrayList<OrderGiftItemListBean>();
                                for (ItemListBean item : giftItemLists) {
                                    OrderGiftItemListBean orderGiftItem = orderFactory.createOrderGiftItemListBean();
                                    orderGiftItem.setItemDesc(item.getItemDesc());
                                    orderGiftItem.setItemQty(item.getItemQty());
                                    orderGiftItemListBeans.add(orderGiftItem);
                                }
                                orderGift.setOrderGiftItemListBeans(orderGiftItemListBeans);
                            }
                        } else if (cmmdtyBean instanceof TeaBean) {
                            TeaBean teaGift = (TeaBean) gift;
                            orderGift.setCmmdtyId(teaGift.getCmmdtyId());
                            orderGift.setCmmdtyName(teaGift.getCmmdtyName());
                            orderGift.setCommodityStatus(OrderCommodityStatus.A4500010);
                            orderGift.setDefaultImageAddrs(teaGift.getDefaultImageAddrs());
                            orderGift.setEvaluationStatus(EvaluationStatus.A4600010);
                            orderGift.setProposedPrice(teaGift.getProposedPrice());
                            // TODO
                            orderGift.setQty(1);
                            orderGift.setTimesExchanged(0);
                            List<ItemListBean> giftItemLists = commodityRepos.queryItemListBeans(cmmdtyBean
                                    .getCmmdtyId());
                            if (CollectionUtils.isEmpty(giftItemLists)) {
                                orderGift.setOrderGiftItemListBeans(null);
                            } else {
                                List<OrderGiftItemListBean> orderGiftItemListBeans = new ArrayList<OrderGiftItemListBean>();
                                for (ItemListBean item : giftItemLists) {
                                    OrderGiftItemListBean orderGiftItem = orderFactory.createOrderGiftItemListBean();
                                    orderGiftItem.setItemDesc(item.getItemDesc());
                                    orderGiftItem.setItemQty(item.getItemQty());
                                    orderGiftItemListBeans.add(orderGiftItem);
                                }
                                orderGift.setOrderGiftItemListBeans(orderGiftItemListBeans);
                            }
                        }
                        orderGiftBeans.add(orderGift);
                    }
                    cmmdty.setOrderGiftBeans(orderGiftBeans);
                }
                cmmdtys.add(cmmdty);
            }
        }

        OrderPaymentBean orderPayment = orderFactory.createOrderPaymentBean();
        if (PaymentMethod.A4700010.equals(paymentMethod)) {
            bean.setOrderStatus(OrderStatus.A3400020);
            orderPayment.setPaymentChannel(PaymentChannel.A4800010);
        } else {
            bean.setOrderStatus(OrderStatus.A3400010);
            orderPayment.setPaymentChannel(paymentChannel);
        }
        orderPayment.setPaymentMethod(paymentMethod);
        orderPayment.setPaymentStatus(PaymentStatus.A4900010);
        orderPayment.setPaymentAmt(bean.getOrderActualPayment());
        bean.setOrderPaymentBean(orderPayment);

        InvoiceBean invoice = orderFactory.createInvoiceBean();
        invoice.setInvoiceTitle(invoiceTitle);
        invoice.setInvoiceType(invoiceType);
        bean.setInvoiceBean(invoice);

        OrderContactInfoBean orderContactInfo = orderFactory.createOrderContactInfoBean();
        orderContactInfo.setCntctAddress(cntct.getCntctAddress());
        orderContactInfo.setCntctCity(cntct.getCntctCity());
        orderContactInfo.setCntctCountry(cntct.getCntctCountry().getDesc());
        orderContactInfo.setCntctMobile(cntct.getCntctMobile());
        orderContactInfo.setCntctName(cntct.getCntctName());
        orderContactInfo.setCntctPostCode(cntct.getCntctPostCode());
        orderContactInfo.setCntctState(cntct.getCntctState());
        orderContactInfo.setCntctStreet(cntct.getCntctStreet());
        orderContactInfo.setCntctTown(cntct.getCntctTown());
        bean.setOrderContactInfoBean(orderContactInfo);

        bean.setOrderTotalPrice(orderTotalAmt);
        bean.setFreeLogisticsCondition(new BigDecimal(300));
        if (orderTotalAmt.compareTo(bean.getFreeLogisticsCondition()) < 0) {
            bean.setFreeLogisticsAmt(false);
        } else {
            bean.setFreeLogisticsAmt(true);
        }
        // TODO 应付金额 = 订单商品总额 + 运费，实付金额 = 应付金额 - 积分抵用金额 -（是否免邮 ？ 0 : 运费）
        // BigDecimal orderShouldPayment = bean.isFreeLogisticsAmt() ? orderTotalAmt : orderTotalAmt + logisticsAmt;
        // bean.setLogisticsAmt(logisticsAmt);
        bean.setOrderShouldPayment(orderTotalAmt);
        // BigDecimal orderActualPayment = orderTotalAmt.subtract(bean.isFreeLogisticsAmt() ? 0 : logisticsAmt);
        bean.setOrderActualPayment(orderTotalAmt);
        bean.setDiscount(BigDecimal.ZERO);

        // TODO 订单编号
        // bean.setOrderNum(orderNum);
        bean.setRemarks(remarks);
        partyIdentifyBean.submitOrder(bean);
    }

    @Override
    public PurchaseOrderDto queryPurchaseOrderByOrderNum(String orderNum) throws ZydException {
        if (StringUtils.isEmpty(orderNum)) {
            throw new IllegalArgumentException();
        }
        PurchaseOrderBean bean = orderRepos.queryPurchaseOrderByNum(orderNum);
        return orderConvertor.convertPurchaseOrder(bean);
    }

    @Override
    public List<PurchaseOrderDto> queryPurchaseOrdersByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        List<PurchaseOrderBean> beans = orderRepos.queryPurchaseOrdersByParty(partyId, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<PurchaseOrderDto> dtos = new ArrayList<PurchaseOrderDto>();
        for (PurchaseOrderBean bean : beans) {
            dtos.add(orderConvertor.convertPurchaseOrder(bean));
        }
        return dtos;
    }

    @Override
    public void cancel(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        PurchaseOrderBean bean = orderRepos.queryPurchaseOrderByKey(orderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDP001);
        }
        if (!OrderStatus.A3400010.equals(bean.getOrderStatus()) && !OrderStatus.A3400020.equals(bean.getOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR011);
        }
        bean.cancel();
    }

    @Override
    public void pay(BigDecimal orderId, PaymentChannel paymentChannel, String paymentAccount, String paymentNum)
            throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        PurchaseOrderBean bean = orderRepos.queryPurchaseOrderByKey(orderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDP001);
        }
        if (!OrderStatus.A3400010.equals(bean.getOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR012);
        }
        // TODO 支付前验证的方法，还是支付后修改状态的方法
        bean.pay();
    }

    @Override
    public void deliverGoods(BigDecimal orderId, LogisticsCompCode logisticsCompCode, String logisticsCompDesc,
            String logisticsNum) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        if (null == logisticsCompCode) {
            throw new ZydException(ErrorCode.EZYDR019);
        }
        if (StringUtils.isEmpty(logisticsCompDesc)) {
            throw new ZydException(ErrorCode.EZYDR020);
        }
        if (logisticsCompDesc.length() > 10) {
            throw new ZydException(ErrorCode.EZYDR021);
        }
        if (StringUtils.isEmpty(logisticsNum)) {
            throw new ZydException(ErrorCode.EZYDR022);
        }
        if (logisticsNum.length() > 10) {
            throw new ZydException(ErrorCode.EZYDR023);
        }
        PurchaseOrderBean bean = orderRepos.queryPurchaseOrderByKey(orderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDP001);
        }
        if (!OrderStatus.A3400020.equals(bean.getOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR018);
        }
        bean.deliverGoods(logisticsCompCode, logisticsCompDesc, logisticsNum);
    }

    @Override
    public void applyForRefund(BigDecimal orderId, String reason) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(reason)) {
            throw new ZydException(ErrorCode.EZYDR025);
        }
        if (reason.length() > 150) {
            throw new ZydException(ErrorCode.EZYDR026);
        }
        PurchaseOrderBean bean = orderRepos.queryPurchaseOrderByKey(orderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDP001);
        }
        OrderPaymentBean orderPayment = orderRepos.queryOrderPaymentBeanByPurchaseOrder(orderId);
        if (!PaymentMethod.A4700020.equals(orderPayment.getPaymentMethod())
                || !OrderStatus.A3400040.equals(bean.getOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR024);
        }
        bean.applyForRefund(reason);
    }

    @Override
    public void cancelApplyForRefund(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        PurchaseOrderBean bean = orderRepos.queryPurchaseOrderByKey(orderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDP001);
        }
        OrderPaymentBean orderPayment = orderRepos.queryOrderPaymentBeanByPurchaseOrder(orderId);
        if (!PaymentMethod.A4700020.equals(orderPayment.getPaymentMethod())
                || !OrderStatus.A3400030.equals(bean.getOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR029);
        }
        OrderLogTerm param = new OrderLogTerm();
        param.setOrderId(orderId);
        param.setSortDir(SortCriteria.order_log_event_ts_desc.getDir());
        param.setSortField(SortCriteria.order_log_event_ts_desc.getField());
        List<OrderLogEntity> entitys = orderLogMapper.select(param);
        if (CollectionUtils.isEmpty(entitys)) {
            throw new ZydException(ErrorCode.EZYDR029);
        }
        if (!OrderStatus.A3400040.equals(entitys.get(0).getOrderStatusBefore())) {
            throw new ZydException(ErrorCode.EZYDR029);
        }
        bean.cancelApplyForRefund();
    }

    @Override
    public void refund(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        PurchaseOrderBean bean = orderRepos.queryPurchaseOrderByKey(orderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDP001);
        }
        OrderPaymentBean orderPayment = orderRepos.queryOrderPaymentBeanByPurchaseOrder(orderId);
        if (!PaymentMethod.A4700020.equals(orderPayment.getPaymentMethod())
                || !OrderStatus.A3400030.equals(bean.getOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR027);
        }
        bean.refund();
    }

    @Override
    public void takeDelivery(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        PurchaseOrderBean bean = orderRepos.queryPurchaseOrderByKey(orderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDP001);
        }
        if (!OrderStatus.A3400040.equals(bean.getOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR028);
        }
        bean.refund();
    }

    @Override
    public void refuseDelivery(BigDecimal orderId, String refuseReason) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(refuseReason)) {
            throw new ZydException(ErrorCode.EZYDR031);
        }
        if (refuseReason.length() > 150) {
            throw new ZydException(ErrorCode.EZYDR032);
        }
        PurchaseOrderBean bean = orderRepos.queryPurchaseOrderByKey(orderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDP001);
        }
        if (!OrderStatus.A3400040.equals(bean.getOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR030);
        }
        // TODO 什么时候调用此方法，拒收后需要退款，退款何时处理，在哪里处理
        bean.refuseDelivery(refuseReason);
    }

    @Override
    public InvoiceDto queryInvoiceByPurchaseOrder(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        InvoiceBean bean = orderRepos.queryInvoiceByPurchaseOrder(orderId);
        return orderConvertor.convertInvoice(bean);
    }

    @Override
    public List<OrderEventDto> queryOrderEventsByPurchaseOrder(BigDecimal orderId, int pageSize, int page)
            throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        List<OrderEventBean> beans = orderRepos.queryOrderEventsByPurchaseOrder(orderId, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<OrderEventDto> dtos = new ArrayList<OrderEventDto>();
        for (OrderEventBean bean : beans) {
            dtos.add(orderConvertor.convertOrderEvent(bean));
        }
        return dtos;
    }

    @Override
    public List<OrderCommodityDto> queryOrderCommoditiesByPurchaseOrder(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        List<OrderCommodityBean> beans = orderRepos.queryOrderCommodityBeansByPurchaseOrder(orderId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<OrderCommodityDto> dtos = new ArrayList<OrderCommodityDto>();
        for (OrderCommodityBean bean : beans) {
            dtos.add(orderConvertor.convertOrderCommodity(bean));
        }
        return dtos;
    }

    @Override
    public List<OrderItemListDto> queryItemListsByOrderCommodity(BigDecimal orderCmmdtyId) throws ZydException {
        if (null == orderCmmdtyId) {
            throw new IllegalArgumentException();
        }
        List<OrderItemListBean> beans = orderRepos.queryItemListBeansByOrderCommodity(orderCmmdtyId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<OrderItemListDto> dtos = new ArrayList<OrderItemListDto>();
        for (OrderItemListBean bean : beans) {
            dtos.add(orderConvertor.convertOrderItemList(bean));
        }
        return dtos;
    }

    @Override
    public List<OrderGiftDto> queryOrderGiftsByOrderCommodity(BigDecimal orderCmmdtyId) throws ZydException {
        if (null == orderCmmdtyId) {
            throw new IllegalArgumentException();
        }
        List<OrderGiftBean> beans = orderRepos.queryOrderGiftBeansByOrderCommodity(orderCmmdtyId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<OrderGiftDto> dtos = new ArrayList<OrderGiftDto>();
        for (OrderGiftBean bean : beans) {
            dtos.add(orderConvertor.convertOrderGift(bean));
        }
        return dtos;
    }

    @Override
    public List<OrderGiftItemListDto> queryOrderGiftItemListsByOrderGift(BigDecimal orderGiftId) throws ZydException {
        if (null == orderGiftId) {
            throw new IllegalArgumentException();
        }
        List<OrderGiftItemListBean> beans = orderRepos.queryOrderGiftItemListBeansByOrderGift(orderGiftId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<OrderGiftItemListDto> dtos = new ArrayList<OrderGiftItemListDto>();
        for (OrderGiftItemListBean bean : beans) {
            dtos.add(orderConvertor.convertOrderGiftItemList(bean));
        }
        return dtos;
    }

    @Override
    public OrderLogisticsDto queryOrderLogisticsByPurchaseOrder(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        OrderLogisticsBean bean = orderRepos.queryOrderLogisticsBeanByPurchaseOrder(orderId);
        if (null == bean) {
            return null;
        }
        return orderConvertor.convertOrderLogistics(bean);
    }

    @Override
    public OrderPaymentDto queryOrderPaymentByPurchaseOrder(BigDecimal orderId) throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        OrderPaymentBean bean = orderRepos.queryOrderPaymentBeanByPurchaseOrder(orderId);
        if (null == bean) {
            return null;
        }
        return orderConvertor.convertOrderPayment(bean);
    }

    @Override
    public ReturnOrderDto queryReturnOrderByReturnOrderNum(String returnOrderNum) throws ZydException {
        if (StringUtils.isEmpty(returnOrderNum)) {
            throw new IllegalArgumentException();
        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByNum(returnOrderNum);
        if (null == bean) {
            return null;
        }
        return orderConvertor.convertReturnOrder(bean);
    }

    @Override
    public List<ReturnOrderDto> queryReturnOrdersByParty(BigDecimal partyId, int pageSize, int page)
            throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        List<ReturnOrderBean> beans = orderRepos.queryReturnOrderBeansByParty(partyId, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<ReturnOrderDto> dtos = new ArrayList<ReturnOrderDto>();
        for (ReturnOrderBean bean : beans) {
            dtos.add(orderConvertor.convertReturnOrder(bean));
        }
        return dtos;
    }

    @Override
    public List<ReturnOrderDto> queryReturnOrdersByPurchaseOrder(BigDecimal orderId, int pageSize, int page)
            throws ZydException {
        if (null == orderId) {
            throw new IllegalArgumentException();
        }
        List<ReturnOrderBean> beans = orderRepos.queryReturnOrderBeansByPurchaseOrder(orderId, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<ReturnOrderDto> dtos = new ArrayList<ReturnOrderDto>();
        for (ReturnOrderBean bean : beans) {
            dtos.add(orderConvertor.convertReturnOrder(bean));
        }
        return dtos;
    }

    @Override
    public void approveReturnOrder(BigDecimal returnOrderId) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByKey(returnOrderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDR033);
        }
        if (!ReturnOrderStatus.A5100010.equals(bean.getReturnOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR034);
        }
        bean.approve();
    }

    @Override
    public void disApproveReturnOrder(BigDecimal returnOrderId, String reason) throws ZydException {
        if (null == returnOrderId) {

        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByKey(returnOrderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDR033);
        }
        if (!ReturnOrderStatus.A5100010.equals(bean.getReturnOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR034);
        }
        bean.disapprove(reason);
    }

    @Override
    public void deliveryBack(BigDecimal returnOrderId, LogisticsCompCode logisticsCompCode, String logisticsCompDesc,
            String logisticsNum, BigDecimal logisticsAmt) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(logisticsCompDesc)) {
            throw new ZydException(ErrorCode.EZYDR020);
        }
        if (logisticsCompDesc.length() > 10) {
            throw new ZydException(ErrorCode.EZYDR021);
        }
        if (StringUtils.isEmpty(logisticsNum)) {
            throw new ZydException(ErrorCode.EZYDR022);
        }
        if (logisticsNum.length() > 10) {
            throw new ZydException(ErrorCode.EZYDR023);
        }
        if (null == logisticsAmt) {
            throw new ZydException(ErrorCode.EZYDR036);
        }
        if (logisticsAmt.compareTo(BigDecimal.ZERO) == -1) {
            throw new ZydException(ErrorCode.EZYDR037);
        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByKey(returnOrderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDR033);
        }
        if (!ReturnOrderStatus.A5100020.equals(bean.getReturnOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR035);
        }
        bean.deliveryBack(logisticsCompCode, logisticsCompDesc, logisticsNum, logisticsAmt);
    }

    @Override
    public void refuseDeliveryBack(BigDecimal returnOrderId, String reason) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(reason)) {
            throw new ZydException(ErrorCode.EZYDR031);
        }
        if (reason.length() > 150) {
            throw new ZydException(ErrorCode.EZYDR032);
        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByKey(returnOrderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDR033);
        }
        if (!ReturnOrderStatus.A5100030.equals(bean.getReturnOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR038);
        }
        bean.refuseDeliveryBack(reason);
    }

    @Override
    public void takeDeliverBack(BigDecimal returnOrderId) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByKey(returnOrderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDR033);
        }
        if (!ReturnOrderStatus.A5100030.equals(bean.getReturnOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR039);
        }
        bean.takeDeliverBack();
    }

    @Override
    public void refundReturnOrder(BigDecimal returnOrderId) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByKey(returnOrderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDR033);
        }
        if ((bean.getReturnOrderType().equals(ReturnOrderType.A5000010) && !ReturnOrderStatus.A5100040.equals(bean
                .getReturnOrderStatus()))
                || (bean.getReturnOrderType().equals(ReturnOrderType.A5000020) && !ReturnOrderStatus.A5100070
                        .equals(bean.getReturnOrderStatus()))) {
            throw new ZydException(ErrorCode.EZYDR040);
        }
        bean.refund();
    }

    @Override
    public void deliveryAgain(BigDecimal returnOrderId) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByKey(returnOrderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDR033);
        }
        if (!bean.getReturnOrderType().equals(ReturnOrderType.A5000020)) {
            throw new ZydException(ErrorCode.EZYDR041);
        }
        if (!ReturnOrderStatus.A5100050.equals(bean.getReturnOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR042);
        }
        bean.deliveryAgain();
    }

    @Override
    public void takeDeliveryAgain(BigDecimal returnOrderId) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByKey(returnOrderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDR033);
        }
        if (!bean.getReturnOrderType().equals(ReturnOrderType.A5000020)) {
            throw new ZydException(ErrorCode.EZYDR041);
        }
        if (!ReturnOrderStatus.A5100060.equals(bean.getReturnOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR042);
        }
        bean.takeDelivery();
    }

    @Override
    public void refuseDeliveryAgain(BigDecimal returnOrderId, String refuseReason) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(refuseReason)) {
            throw new ZydException(ErrorCode.EZYDR031);
        }
        if (refuseReason.length() > 150) {
            throw new ZydException(ErrorCode.EZYDR032);
        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByKey(returnOrderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDR033);
        }
        if (!bean.getReturnOrderType().equals(ReturnOrderType.A5000020)) {
            throw new ZydException(ErrorCode.EZYDR045);
        }
        if (!ReturnOrderStatus.A5100060.equals(bean.getReturnOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR046);
        }
        bean.refuseDeliveryAgain(refuseReason);
    }

    @Override
    public void applyForRefundOfReturnOrder(BigDecimal returnOrderId, String reason) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(reason)) {
            throw new ZydException(ErrorCode.EZYDR025);
        }
        if (reason.length() > 150) {
            throw new ZydException(ErrorCode.EZYDR026);
        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByKey(returnOrderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDR033);
        }
        if (!bean.getReturnOrderType().equals(ReturnOrderType.A5000020)) {
            throw new ZydException(ErrorCode.EZYDR047);
        }
        if (!ReturnOrderStatus.A5100060.equals(bean.getReturnOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR048);
        }
        bean.applyForRefund(reason);
        // oyl comment ReturnOrderOperation.applyForRefund方法
    }

    @Override
    public void cancelApplyForRefundOfReturnOrder(BigDecimal returnOrderId) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderBean bean = orderRepos.queryReturnOrderBeanByKey(returnOrderId);
        if (null == bean) {
            throw new ZydException(ErrorCode.EZYDR033);
        }
        if (!bean.getReturnOrderType().equals(ReturnOrderType.A5000020)) {
            throw new ZydException(ErrorCode.EZYDR049);
        }
        if (!ReturnOrderStatus.A5100070.equals(bean.getReturnOrderStatus())) {
            throw new ZydException(ErrorCode.EZYDR050);
        }
        bean.cancelApplyForRefund();
    }

    @Override
    public List<ReturnOrderEventDto> queryReturnOrderEventsByReturnOrder(BigDecimal returnOrderId, int pageSize,
            int page) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }

        List<ReturnOrderEventBean> beans = orderRepos
                .queryReturnOrderEventsByReturnOrder(returnOrderId, pageSize, page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<ReturnOrderEventDto> dtos = new ArrayList<ReturnOrderEventDto>();
        for (ReturnOrderEventBean bean : beans) {
            dtos.add(orderConvertor.convertReturnOrderEvent(bean));
        }
        return dtos;
    }

    @Override
    public ReturnOrderLogisticsDto queryReturnOrderLogisticsByReturnOrder(BigDecimal returnOrderId,
            ReturnOrderLogisticsType returnOrderLogisticsType) throws ZydException {
        if (null == returnOrderId || null == returnOrderLogisticsType) {
            throw new IllegalArgumentException();
        }
        ReturnOrderLogisticsBean bean = orderRepos.queryReturnOrderLogisticsBeanByReturnOrder(returnOrderId,
                returnOrderLogisticsType);
        if (null == bean) {
            return null;
        }
        return orderConvertor.convertReturnOrderLogistics(bean);
    }

    @Override
    public List<ReturnOrderLogisticsDto> queryReturnOrderLogisticsesByReturnOrder(BigDecimal returnOrderId)
            throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        List<ReturnOrderLogisticsBean> beans = orderRepos.queryReturnOrderLogisticsBeansByReturnOrder(returnOrderId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<ReturnOrderLogisticsDto> dtos = new ArrayList<ReturnOrderLogisticsDto>();
        for (ReturnOrderLogisticsBean bean : beans) {
            dtos.add(orderConvertor.convertReturnOrderLogistics(bean));
        }
        return dtos;
    }

    @Override
    public ReturnOrderContactInfoDto queryReturnOrderContactInfoByReturnOrder(BigDecimal returnOrderId)
            throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderContactInfoBean bean = orderRepos.queryReturnOrderContactInfoBeanByReturnOrder(returnOrderId);
        if (null == bean) {
            return null;
        }
        return orderConvertor.convertReturnOrderContactInfo(bean);
    }

    @Override
    public ReturnOrderRefundInfoDto queryReturnOrderRefundInfoByReturnOrder(BigDecimal returnOrderId)
            throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderRefundInfoBean bean = orderRepos.queryReturnOrderRefundInfoBeanByReturnOrder(returnOrderId);
        if (null == bean) {
            return null;
        }
        return orderConvertor.convertReturnOrderRefundInfo(bean);
    }

    @Override
    public List<ReturnOrderRefundInfoDto> queryReturnOrderRefundInfosByParyty(BigDecimal partyId, int pageSize, int page)
            throws ZydException {
        if (null == partyId) {
            throw new IllegalArgumentException();
        }
        List<ReturnOrderRefundInfoBean> beans = orderRepos.queryReturnOrderRefundInfoBeansByParyty(partyId, pageSize,
                page);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<ReturnOrderRefundInfoDto> dtos = new ArrayList<ReturnOrderRefundInfoDto>();
        for (ReturnOrderRefundInfoBean bean : beans) {
            dtos.add(orderConvertor.convertReturnOrderRefundInfo(bean));
        }
        return dtos;
    }

    @Override
    public ReturnOrderCommodityDto queryReturnOrderCommodityByReturnOrder(BigDecimal returnOrderId) throws ZydException {
        if (null == returnOrderId) {
            throw new IllegalArgumentException();
        }
        ReturnOrderCommodityBean bean = orderRepos.queryReturnOrderCommodityBeanByReturnOrder(returnOrderId);
        if (null == bean) {
            return null;
        }
        return orderConvertor.convertReturnOrderCommodity(bean);
    }

    @Override
    public List<ReturnOrderItemListDto> queryReturnOrderItemListsByReturnOrderCommodity(BigDecimal returnOrderCmmdtyId)
            throws ZydException {
        if (null == returnOrderCmmdtyId) {
            throw new IllegalArgumentException();
        }
        List<ReturnOrderItemListBean> beans = orderRepos
                .queryReturnOrderItemListBeansByReturnOrderCommodity(returnOrderCmmdtyId);
        if (CollectionUtils.isEmpty(beans)) {
            return null;
        }
        List<ReturnOrderItemListDto> dtos = new ArrayList<ReturnOrderItemListDto>();
        for (ReturnOrderItemListBean bean : beans) {
            dtos.add(orderConvertor.convertReturnOrderItemList(bean));
        }
        return dtos;
    }

}
