package org.zyd.service.convertor;

import org.zyd.domain.bean.InvoiceBean;
import org.zyd.domain.bean.OrderCommodityBean;
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

public class OrderConvertor {

    public PurchaseOrderDto convertPurchaseOrder(PurchaseOrderBean bean) {
        if (null == bean) {
            return null;
        }
        PurchaseOrderDto dto = new PurchaseOrderDto();
        dto.setFreeLogisticsAmt(bean.isFreeLogisticsAmt());
        dto.setFreeLogisticsCondition(bean.getFreeLogisticsCondition());
        dto.setDiscount(bean.getDiscount());
        dto.setLogisticsAmt(bean.getLogisticsAmt());
        dto.setOrderActualPayment(bean.getOrderActualPayment());
        dto.setOrderId(bean.getOrderId());
        dto.setOrderNum(bean.getOrderNum());
        dto.setOrderShouldPayment(bean.getOrderShouldPayment());
        dto.setOrderStatus(bean.getOrderStatus());
        dto.setOrderTotalPrice(bean.getOrderTotalPrice());
        dto.setPartyId(bean.getPartyId());
        dto.setPointConsumed(bean.getPointConsumed());
        dto.setRemarks(bean.getRemarks());
        dto.setRemarks2(bean.getRemarks2());
        dto.setSubmitTime(bean.getSubmitTime());
        return dto;
    }

    public InvoiceDto convertInvoice(InvoiceBean bean) {
        if (null == bean) {
            return null;
        }
        InvoiceDto dto = new InvoiceDto();
        dto.setInvoiceId(bean.getInvoiceId());
        dto.setInvoiceTitle(bean.getInvoiceTitle());
        dto.setInvoiceType(bean.getInvoiceTitle());
        dto.setOrderId(bean.getOrderId());
        return dto;
    }

    public OrderEventDto convertOrderEvent(OrderEventBean bean) {
        if (null == bean) {
            return null;
        }
        OrderEventDto dto = new OrderEventDto();
        dto.setEventDesc(bean.getEventDesc());
        dto.setEventId(bean.getEventId());
        dto.setEventTs(bean.getEventTs());
        dto.setOrderId(bean.getOrderId());
        return dto;
    }

    public OrderCommodityDto convertOrderCommodity(OrderCommodityBean bean) {
        if (null == bean) {
            return null;
        }
        OrderCommodityDto dto = new OrderCommodityDto();
        dto.setActualPrice(bean.getActualPrice());
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setCmmdtyName(bean.getCmmdtyName());
        dto.setCommodityStatus(bean.getCommodityStatus());
        dto.setDefaultImageAddrs(bean.getDefaultImageAddrs());
        dto.setEvaluationStatus(bean.getEvaluationStatus());
        dto.setOrderCmmdtyId(bean.getOrderCmmdtyId());
        dto.setOrderId(bean.getOrderId());
        dto.setProposedPrice(bean.getProposedPrice());
        dto.setQty(bean.getQty());
        dto.setTimesExchanged(bean.getTimesExchanged());
        return dto;
    }

    public OrderItemListDto convertOrderItemList(OrderItemListBean bean) {
        if (null == bean) {
            return null;
        }
        OrderItemListDto dto = new OrderItemListDto();
        dto.setItemDesc(bean.getItemDesc());
        dto.setItemId(bean.getItemId());
        dto.setItemQty(bean.getItemQty());
        dto.setOrderCmmdtyId(bean.getOrderCmmdtyId());
        return dto;
    }

    public OrderGiftDto convertOrderGift(OrderGiftBean bean) {
        if (null == bean) {
            return null;
        }
        OrderGiftDto dto = new OrderGiftDto();
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setCmmdtyName(bean.getCmmdtyName());
        dto.setCommodityStatus(bean.getCommodityStatus());
        dto.setDefaultImageAddrs(bean.getDefaultImageAddrs());
        dto.setEvaluationStatus(bean.getEvaluationStatus());
        dto.setOrderCmmdtyId(bean.getOrderCmmdtyId());
        dto.setOrderGiftId(bean.getOrderGiftId());
        dto.setOrderId(bean.getOrderId());
        dto.setProposedPrice(bean.getProposedPrice());
        dto.setQty(bean.getQty());
        dto.setTimesExchanged(bean.getTimesExchanged());
        return dto;
    }

    public OrderGiftItemListDto convertOrderGiftItemList(OrderGiftItemListBean bean) {
        if (null == bean) {
            return null;
        }
        OrderGiftItemListDto dto = new OrderGiftItemListDto();
        dto.setItemDesc(bean.getItemDesc());
        dto.setItemId(bean.getItemId());
        dto.setItemQty(bean.getItemQty());
        dto.setOrderGiftId(bean.getOrderGiftId());
        return dto;
    }

    public OrderLogisticsDto convertOrderLogistics(OrderLogisticsBean bean) {
        if (null == bean) {
            return null;
        }
        OrderLogisticsDto dto = new OrderLogisticsDto();
        dto.setLogisticsCompanyCode(bean.getLogisticsCompanyCode());
        dto.setLogisticsCompanyDesc(bean.getLogisticsCompanyDesc());
        dto.setLogisticsNum(bean.getLogisticsNum());
        dto.setOrderId(bean.getOrderId());
        return dto;
    }

    public OrderPaymentDto convertOrderPayment(OrderPaymentBean bean) {
        if (null == bean) {
            return null;
        }
        OrderPaymentDto dto = new OrderPaymentDto();
        dto.setOrderId(bean.getOrderId());
        dto.setPaymentAccount(bean.getPaymentAccount());
        dto.setPaymentAmt(bean.getPaymentAmt());
        dto.setPaymentChannel(bean.getPaymentChannel());
        dto.setPaymentMethod(bean.getPaymentMethod());
        dto.setPaymentNum(bean.getPaymentNum());
        dto.setPaymentStatus(bean.getPaymentStatus());
        dto.setPaymentTime(bean.getPaymentTime());
        return dto;
    }

    public ReturnOrderDto convertReturnOrder(ReturnOrderBean bean) {
        if (null == bean) {
            return null;
        }
        ReturnOrderDto dto = new ReturnOrderDto();
        dto.setActualRefundAmt(bean.getActualRefundAmt());
        dto.setOrderId(bean.getOrderId());
        dto.setPartyId(bean.getPartyId());
        dto.setRemarks(bean.getRemarks());
        dto.setReturnOrderId(bean.getReturnOrderId());
        dto.setReturnOrderNum(bean.getReturnOrderNum());
        dto.setReturnOrderStatus(bean.getReturnOrderStatus());
        dto.setReturnOrderType(bean.getReturnOrderType());
        dto.setReturnReason(bean.getReturnReason());
        dto.setReturnReasonDesc(bean.getReturnReasonDesc());
        dto.setShouldRefundAmt(bean.getShouldRefundAmt());
        dto.setSubmitTime(bean.getSubmitTime());
        return dto;
    }

    public ReturnOrderEventDto convertReturnOrderEvent(ReturnOrderEventBean bean) {
        if (null == bean) {
            return null;
        }
        ReturnOrderEventDto dto = new ReturnOrderEventDto();
        dto.setEventDesc(bean.getEventDesc());
        dto.setEventId(bean.getEventId());
        dto.setEventTs(bean.getEventTs());
        dto.setReturnOrderId(bean.getReturnOrderId());
        return dto;
    }

    public ReturnOrderLogisticsDto convertReturnOrderLogistics(ReturnOrderLogisticsBean bean) {
        if (null == bean) {
            return null;
        }
        ReturnOrderLogisticsDto dto = new ReturnOrderLogisticsDto();
        dto.setFreeLogisticsAmt(bean.isFreeLogisticsAmt());
        dto.setLogisticsAmt(bean.getLogisticsAmt());
        dto.setLogisticsCompanyCode(bean.getLogisticsCompanyCode());
        dto.setLogisticsCompanyDesc(bean.getLogisticsCompanyDesc());
        dto.setLogisticsId(bean.getLogisticsId());
        dto.setLogisticsNum(bean.getLogisticsNum());
        dto.setLogisticsType(bean.getLogisticsType());
        dto.setReturnOrderId(bean.getReturnOrderId());
        return dto;
    }

    public ReturnOrderContactInfoDto convertReturnOrderContactInfo(ReturnOrderContactInfoBean bean) {
        if (null == bean) {
            return null;
        }
        ReturnOrderContactInfoDto dto = new ReturnOrderContactInfoDto();
        dto.setCntctAddress(bean.getCntctAddress());
        dto.setCntctCity(bean.getCntctCity());
        dto.setCntctCountry(bean.getCntctCountry());
        dto.setCntctMobile(bean.getCntctMobile());
        dto.setCntctName(bean.getCntctName());
        dto.setCntctPostCode(bean.getCntctPostCode());
        dto.setCntctState(bean.getCntctState());
        dto.setCntctStreet(bean.getCntctStreet());
        dto.setCntctTown(bean.getCntctTown());
        dto.setReturnOrderId(bean.getReturnOrderId());
        return dto;
    }

    public ReturnOrderRefundInfoDto convertReturnOrderRefundInfo(ReturnOrderRefundInfoBean bean) {
        if (null == bean) {
            return null;
        }
        ReturnOrderRefundInfoDto dto = new ReturnOrderRefundInfoDto();
        dto.setPartyId(bean.getPartyId());
        dto.setRefundAccount(bean.getRefundAccount());
        dto.setRefundAmt(bean.getRefundAmt());
        dto.setRefundChannel(bean.getRefundChannel());
        dto.setRefundMethod(bean.getRefundMethod());
        dto.setRefundNum(bean.getRefundNum());
        dto.setRefundStatus(bean.getRefundStatus());
        dto.setRefundTime(bean.getRefundTime());
        dto.setReturnOrderId(bean.getReturnOrderId());
        dto.setSubmitTime(bean.getSubmitTime());
        return dto;
    }

    public ReturnOrderCommodityDto convertReturnOrderCommodity(ReturnOrderCommodityBean bean) {
        if (null == bean) {
            return null;
        }
        ReturnOrderCommodityDto dto = new ReturnOrderCommodityDto();
        dto.setActualPrice(bean.getActualPrice());
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setCmmdtyName(bean.getCmmdtyName());
        dto.setQty(bean.getQty());
        dto.setReturnOrderCmmdtyId(bean.getReturnOrderCmmdtyId());
        dto.setReturnOrderCmmdtyType(bean.getReturnOrderCmmdtyType());
        dto.setReturnOrderId(bean.getReturnOrderId());
        dto.setSourceOrderCmmdtyId(bean.getSourceOrderCmmdtyId());
        return dto;
    }

    public ReturnOrderItemListDto convertReturnOrderItemList(ReturnOrderItemListBean bean) {
        if (null == bean) {
            return null;
        }
        ReturnOrderItemListDto dto = new ReturnOrderItemListDto();
        dto.setItemDesc(bean.getItemDesc());
        dto.setItemId(bean.getItemId());
        dto.setItemQty(bean.getItemQty());
        dto.setReturnOrderCmmdtyId(bean.getReturnOrderCmmdtyId());
        return dto;
    }

}
