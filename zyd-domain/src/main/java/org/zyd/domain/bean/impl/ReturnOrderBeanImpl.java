package org.zyd.domain.bean.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.zyd.common.constants.ErrorCode;
import org.zyd.common.constants.LogisticsCompCode;
import org.zyd.common.constants.OperatorType;
import org.zyd.common.constants.ReturnOrderLogisticsType;
import org.zyd.common.constants.ReturnOrderStatus;
import org.zyd.common.constants.ReturnOrderType;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.ReturnOrderBean;
import org.zyd.domain.bean.ReturnOrderCommodityBean;
import org.zyd.domain.bean.ReturnOrderContactInfoBean;
import org.zyd.domain.bean.ReturnOrderEventBean;
import org.zyd.domain.bean.ReturnOrderLogisticsBean;
import org.zyd.domain.bean.ReturnOrderRefundInfoBean;
import org.zyd.domain.factory.OrderFactory;
import org.zyd.domain.util.SequenceGenerator;
import org.zyd.store.entity.ReturnOrderEntity;
import org.zyd.store.entity.ReturnOrderLogEntity;
import org.zyd.store.mapper.ReturnOrderLogMapper;
import org.zyd.store.mapper.ReturnOrderMapper;

public class ReturnOrderBeanImpl implements ReturnOrderBean {

    private ReturnOrderEntity entity;
    private List<ReturnOrderCommodityBean> returnOrderCommodityBeans;
    private ReturnOrderRefundInfoBean returnOrderRefundInfoBean;
    private ReturnOrderContactInfoBean returnOrderContactInfoBean;
    private List<ReturnOrderEventBean> returnOrderEventBeans;
    private List<ReturnOrderLogisticsBean> returnOrderLogisticsBeans;

    @Autowired
    private ReturnOrderMapper returnOrderMapper;
    @Autowired
    private ReturnOrderLogMapper returnOrderLogMapper;
    @Autowired
    private OrderFactory orderFactory;
    @Autowired
    private SequenceGenerator sequenceGenerator;

    public ReturnOrderBeanImpl(ReturnOrderEntity entity) {
        this.entity = entity;
    }

    @Override
    public List<ReturnOrderCommodityBean> getReturnOrderCommodityBeans() {
        return returnOrderCommodityBeans;
    }

    @Override
    public void setReturnOrderCommodityBeans(List<ReturnOrderCommodityBean> returnOrderCommodityBeans) {
        this.returnOrderCommodityBeans = returnOrderCommodityBeans;
    }

    @Override
    public ReturnOrderRefundInfoBean getReturnOrderRefundInfoBean() {
        return returnOrderRefundInfoBean;
    }

    @Override
    public void setReturnOrderRefundInfoBean(ReturnOrderRefundInfoBean returnOrderRefundInfoBean) {
        this.returnOrderRefundInfoBean = returnOrderRefundInfoBean;
    }

    @Override
    public ReturnOrderContactInfoBean getReturnOrderContactInfoBean() {
        return returnOrderContactInfoBean;
    }

    @Override
    public void setReturnOrderContactInfoBean(ReturnOrderContactInfoBean returnOrderContactInfoBean) {
        this.returnOrderContactInfoBean = returnOrderContactInfoBean;
    }

    @Override
    public List<ReturnOrderEventBean> getReturnOrderEventBeans() {
        return returnOrderEventBeans;
    }

    @Override
    public void setReturnOrderEventBeans(List<ReturnOrderEventBean> returnOrderEventBeans) {
        this.returnOrderEventBeans = returnOrderEventBeans;
    }

    @Override
    public List<ReturnOrderLogisticsBean> getReturnOrderLogisticsBeans() {
        return returnOrderLogisticsBeans;
    }

    @Override
    public void setReturnOrderLogisticsBeans(List<ReturnOrderLogisticsBean> returnOrderLogisticsBeans) {
        this.returnOrderLogisticsBeans = returnOrderLogisticsBeans;
    }

    @Override
    public BigDecimal getReturnOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getReturnOrderId();
    }

    @Override
    public String getReturnOrderNum() {
        if (null == entity) {
            return null;
        }
        return entity.getReturnOrderNum();
    }

    @Override
    public ReturnOrderType getReturnOrderType() {
        if (null == entity) {
            return null;
        }
        return ReturnOrderType.valueOf(entity.getReturnOrderType());
    }

    @Override
    public Timestamp getSubmitTime() {
        if (null == entity) {
            return null;
        }
        return entity.getSubmitTime();
    }

    @Override
    public ReturnOrderStatus getReturnOrderStatus() {
        if (null == entity) {
            return null;
        }
        return ReturnOrderStatus.valueOf(entity.getReturnOrderStatus());
    }

    @Override
    public String getReturnReason() {
        if (null == entity) {
            return null;
        }
        return entity.getReturnReason();
    }

    @Override
    public String getReturnReasonDesc() {
        if (null == entity) {
            return null;
        }
        return entity.getReturnReasonDesc();
    }

    @Override
    public BigDecimal getShouldRefundAmt() {
        if (null == entity) {
            return null;
        }
        return entity.getShouldRefundAmt();
    }

    @Override
    public BigDecimal getActualRefundAmt() {
        if (null == entity) {
            return null;
        }
        return entity.getActualRefundAmt();
    }

    @Override
    public String getRemarks() {
        if (null == entity) {
            return null;
        }
        return entity.getRemarks();
    }

    @Override
    public BigDecimal getOrderId() {
        if (null == entity) {
            return null;
        }
        return entity.getOrderId();
    }

    @Override
    public BigDecimal getPartyId() {
        if (null == entity) {
            return null;
        }
        return entity.getPartyId();
    }

    @Override
    public void setReturnOrderId(BigDecimal returnOrderId) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setReturnOrderId(returnOrderId);
    }

    @Override
    public void setReturnOrderNum(String returnOrderNum) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setReturnOrderNum(returnOrderNum);
    }

    @Override
    public void setReturnOrderType(ReturnOrderType returnOrderType) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setReturnOrderType(returnOrderType.name());
    }

    @Override
    public void setSubmitTime(Timestamp submitTime) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setSubmitTime(submitTime);
    }

    @Override
    public void setReturnOrderStatus(ReturnOrderStatus returnOrderStatus) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setReturnOrderStatus(returnOrderStatus.name());
    }

    @Override
    public void setReturnReason(String returnReason) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setReturnReason(returnReason);
    }

    @Override
    public void setReturnReasonDesc(String returnReasonDesc) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setReturnReasonDesc(returnReasonDesc);
    }

    @Override
    public void setShouldRefundAmt(BigDecimal shouldRefundAmt) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setShouldRefundAmt(shouldRefundAmt);
    }

    @Override
    public void setActualRefundAmt(BigDecimal actualRefundAmt) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setActualRefundAmt(actualRefundAmt);
    }

    @Override
    public void setRemarks(String remarks) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setRemarks(remarks);
    }

    @Override
    public void setOrderId(BigDecimal orderId) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setOrderId(orderId);
    }

    @Override
    public void setPartyId(BigDecimal partyId) {
        if (null == entity) {
            entity = new ReturnOrderEntity();
        }
        entity.setPartyId(partyId);
    }

    @Override
    public void approve() throws ZydException {
        // 退货单事件
        Timestamp now = new Timestamp(new Date().getTime());
        ReturnOrderEventBean orderEvent = orderFactory.createReturnOrderEventBean();
        orderEvent.setReturnOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("同意退换货申请");
        orderEvent.save();
        // 退换货单状态变化日志
        ReturnOrderLogEntity orderLog = new ReturnOrderLogEntity();
        orderLog.setOrderStatusBefore(this.getReturnOrderStatus().name());
        orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100020.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400020.name());
        orderLog.setLogDesc("同意退换货申请");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setReturnOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        returnOrderLogMapper.insert(orderLog);

        this.setReturnOrderStatus(ReturnOrderStatus.A5100020);
        this.change();

    }

    @Override
    public void disapprove(String reason) throws ZydException {
        // 退货单事件
        Timestamp now = new Timestamp(new Date().getTime());
        ReturnOrderEventBean orderEvent = orderFactory.createReturnOrderEventBean();
        orderEvent.setReturnOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc(reason);
        orderEvent.save();
        // 退换货单状态变化日志
        ReturnOrderLogEntity orderLog = new ReturnOrderLogEntity();
        orderLog.setOrderStatusBefore(this.getReturnOrderStatus().name());
        // 如果类型是退货
        if (this.getReturnOrderType().equals(ReturnOrderType.A5000010)) {
            orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100100.name());
        } else if (this.getReturnOrderType().equals(ReturnOrderType.A5000020)) {
            // 如果类型是换货
            orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100110.name());
        }
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400020.name());
        orderLog.setLogDesc(reason);
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setReturnOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        returnOrderLogMapper.insert(orderLog);

        this.setReturnOrderStatus(ReturnOrderStatus.valueOf(orderLog.getOrderStatusAfter()));
        this.change();

    }

    @Override
    public void deliveryBack(LogisticsCompCode logisticsCompCode, String logisticsCompDesc, String logisticsNum,
            BigDecimal logisticsAmt) throws ZydException {
        // 退货单事件
        Timestamp now = new Timestamp(new Date().getTime());
        ReturnOrderEventBean orderEvent = orderFactory.createReturnOrderEventBean();
        orderEvent.setReturnOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("客户寄回物品");
        orderEvent.save();
        // 退换货单状态变化日志
        ReturnOrderLogEntity orderLog = new ReturnOrderLogEntity();
        orderLog.setOrderStatusBefore(this.getReturnOrderStatus().name());
        orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100030.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400030.name());
        orderLog.setLogDesc("客户寄回物品");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);// TODO
        orderLog.setReturnOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        returnOrderLogMapper.insert(orderLog);

        ReturnOrderLogisticsBean bean = orderFactory.createReturnOrderLogisticsBean();
        // TODO 运费
        bean.setLogisticsAmt(BigDecimal.ZERO);
        bean.setLogisticsType(ReturnOrderLogisticsType.A5300020);
        bean.setLogisticsCompanyCode(logisticsCompCode);
        bean.setLogisticsCompanyDesc(logisticsCompDesc);
        bean.setLogisticsNum(logisticsNum);
        bean.setLogisticsAmt(logisticsAmt);
        bean.setReturnOrderId(getOrderId());
        bean.save();

        this.setReturnOrderStatus(ReturnOrderStatus.A5100030);
        this.change();
    }

    @Override
    public void refuseDeliveryBack(String reason) throws ZydException {
        // 退货单事件
        Timestamp now = new Timestamp(new Date().getTime());
        ReturnOrderEventBean orderEvent = orderFactory.createReturnOrderEventBean();
        orderEvent.setReturnOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc(reason);
        orderEvent.save();
        // 退换货单状态变化日志
        ReturnOrderLogEntity orderLog = new ReturnOrderLogEntity();
        orderLog.setOrderStatusBefore(this.getReturnOrderStatus().name());
        // 如果类型是退货
        if (this.getReturnOrderType().equals(ReturnOrderType.A5000010)) {
            orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100100.name());
        } else if (this.getReturnOrderType().equals(ReturnOrderType.A5000020)) {
            // 如果类型是换货
            orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100110.name());
        }
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400020.name());
        orderLog.setLogDesc(reason);
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setReturnOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        returnOrderLogMapper.insert(orderLog);

        this.setReturnOrderStatus(ReturnOrderStatus.valueOf(orderLog.getOrderStatusAfter()));
        this.change();
    }

    @Override
    public void takeDeliverBack() throws ZydException {
        // 退货单事件
        Timestamp now = new Timestamp(new Date().getTime());
        ReturnOrderEventBean orderEvent = orderFactory.createReturnOrderEventBean();
        orderEvent.setReturnOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("接收客户寄回物品");
        orderEvent.save();
        // 退换货单状态变化日志
        ReturnOrderLogEntity orderLog = new ReturnOrderLogEntity();
        orderLog.setOrderStatusBefore(this.getReturnOrderStatus().name());
        // 如果类型是退货，设置为待退款
        if (this.getReturnOrderType().equals(ReturnOrderType.A5000010)) {
            orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100040.name());
        } else if (this.getReturnOrderType().equals(ReturnOrderType.A5000020)) {
            // 如果类型是换货，设置为待发货
            orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100050.name());
        }
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400020.name());
        orderLog.setLogDesc("接收客户寄回物品");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setReturnOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        returnOrderLogMapper.insert(orderLog);

        this.setReturnOrderStatus(ReturnOrderStatus.valueOf(orderLog.getOrderStatusAfter()));
        this.change();
    }

    @Override
    public void applyForRefund(String reason) throws ZydException {
        // 退货单事件
        Timestamp now = new Timestamp(new Date().getTime());
        ReturnOrderEventBean orderEvent = orderFactory.createReturnOrderEventBean();
        orderEvent.setReturnOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc(reason);
        orderEvent.save();
        // 退换货单状态变化日志
        ReturnOrderLogEntity orderLog = new ReturnOrderLogEntity();
        orderLog.setOrderStatusBefore(this.getReturnOrderStatus().name());
        orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100070.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400030.name());
        orderLog.setLogDesc(reason);
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setReturnOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        returnOrderLogMapper.insert(orderLog);

        this.setReturnOrderStatus(ReturnOrderStatus.A5100070);
        this.change();
    }

    @Override
    public void refund() throws ZydException {
        // 退货单事件
        Timestamp now = new Timestamp(new Date().getTime());
        ReturnOrderEventBean orderEvent = orderFactory.createReturnOrderEventBean();
        orderEvent.setReturnOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("退款成功");
        orderEvent.save();
        // 退换货单状态变化日志
        ReturnOrderLogEntity orderLog = new ReturnOrderLogEntity();
        orderLog.setOrderStatusBefore(this.getReturnOrderStatus().name());
        orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100080.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400020.name());
        orderLog.setLogDesc("退款成功");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setReturnOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        returnOrderLogMapper.insert(orderLog);

        this.setReturnOrderStatus(ReturnOrderStatus.A5100080);
        this.change();
    }

    @Override
    public void deliveryAgain() throws ZydException {
        // 退货单事件
        Timestamp now = new Timestamp(new Date().getTime());
        ReturnOrderEventBean orderEvent = orderFactory.createReturnOrderEventBean();
        orderEvent.setReturnOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("换货再次发货");
        orderEvent.save();
        // 退换货单状态变化日志
        ReturnOrderLogEntity orderLog = new ReturnOrderLogEntity();
        orderLog.setOrderStatusBefore(this.getReturnOrderStatus().name());
        orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100060.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400020.name());
        orderLog.setLogDesc("换货再次发货");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setReturnOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        returnOrderLogMapper.insert(orderLog);

        this.setReturnOrderStatus(ReturnOrderStatus.A5100060);
        this.change();
    }

    @Override
    public void takeDelivery() throws ZydException {
        // 退货单事件
        Timestamp now = new Timestamp(new Date().getTime());
        ReturnOrderEventBean orderEvent = orderFactory.createReturnOrderEventBean();
        orderEvent.setReturnOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("换货确认收货");
        orderEvent.save();
        // 退换货单状态变化日志
        ReturnOrderLogEntity orderLog = new ReturnOrderLogEntity();
        orderLog.setOrderStatusBefore(this.getReturnOrderStatus().name());
        orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100090.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400030.name());
        orderLog.setLogDesc("换货确认收货");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setReturnOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        returnOrderLogMapper.insert(orderLog);

        this.setReturnOrderStatus(ReturnOrderStatus.A5100090);
        this.change();
    }

    @Override
    public void cancelApplyForRefund() throws ZydException {
        // 退货单事件
        Timestamp now = new Timestamp(new Date().getTime());
        ReturnOrderEventBean orderEvent = orderFactory.createReturnOrderEventBean();
        orderEvent.setReturnOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc("取消退换货退款申请");
        orderEvent.save();
        // 退换货单状态变化日志
        ReturnOrderLogEntity orderLog = new ReturnOrderLogEntity();
        orderLog.setOrderStatusBefore(this.getReturnOrderStatus().name());
        orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100060.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400030.name());
        orderLog.setLogDesc("取消退换货退款申请");
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setReturnOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        returnOrderLogMapper.insert(orderLog);

        this.setReturnOrderStatus(ReturnOrderStatus.A5100060);
        this.change();
    }

    @Override
    public void refuseDeliveryAgain(String refuseReason) throws ZydException {
        // 退货单事件
        Timestamp now = new Timestamp(new Date().getTime());
        ReturnOrderEventBean orderEvent = orderFactory.createReturnOrderEventBean();
        orderEvent.setReturnOrderId(getOrderId());
        orderEvent.setEventTs(now);
        // TODO ????
        orderEvent.setEventDesc(refuseReason);
        orderEvent.save();
        // 退换货单状态变化日志
        ReturnOrderLogEntity orderLog = new ReturnOrderLogEntity();
        orderLog.setOrderStatusBefore(this.getReturnOrderStatus().name());
        orderLog.setOrderStatusAfter(ReturnOrderStatus.A5100080.name());
        // TODO 从哪取
        orderLog.setOperatorType(OperatorType.A4400020.name());
        orderLog.setLogDesc(refuseReason);
        orderLog.setEventTs(now);
        orderLog.setOperator(null);
        orderLog.setReturnOrderId(this.getOrderId());
        orderLog.setCreateTime(now);
        orderLog.setUpdateTime(now);
        returnOrderLogMapper.insert(orderLog);

        this.setReturnOrderStatus(ReturnOrderStatus.A5100080);
        this.change();
    }

    @Override
    public void saveRecursively() throws ZydException {
        this.save();
        BigDecimal returnOrderId = this.getReturnOrderId();

        if (null == returnOrderId)
            throw new ZydException(ErrorCode.EZYD0002);

        // 保存退换货商品及相关
        List<ReturnOrderCommodityBean> cmmdtys = this.getReturnOrderCommodityBeans();
        for (ReturnOrderCommodityBean cmmdty : cmmdtys) {
            cmmdty.setReturnOrderId(returnOrderId);
            cmmdty.saveRecursively();
        }
        // 保存配送信息
        ReturnOrderContactInfoBean contactInfo = this.getReturnOrderContactInfoBean();
        contactInfo.setReturnOrderId(returnOrderId);
        contactInfo.save();
        // 保存退换货订单事件
        List<ReturnOrderEventBean> eventBeans = this.getReturnOrderEventBeans();
        if (!CollectionUtils.isEmpty(eventBeans)) {
            for (ReturnOrderEventBean event : eventBeans) {
                event.setReturnOrderId(returnOrderId);
                event.save();
            }
        }
    }

    @Override
    public void save() throws ZydException {
        try {
            Timestamp now = new Timestamp(new Date().getTime());
            entity.setUpdateTime(now);
            entity.setCreateTime(now);
            this.setReturnOrderNum(sequenceGenerator.generateReturnOrderNum());
            returnOrderMapper.insert(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void change() throws ZydException {
        try {
            entity.setUpdateTime(new Timestamp(new Date().getTime()));
            returnOrderMapper.updateBySelective(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }
    }

    @Override
    public void remove() throws ZydException {
        try {
            returnOrderMapper.delete(this.entity);
        } catch (Exception e) {
            throw new ZydException(ErrorCode.EZYD0002, e);
        }

        if (null != entity) {
            entity.setReturnOrderId(null);
        }
    }

}
