package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.common.constants.ReturnOrderCmmdtyType;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface ReturnOrderCommodityBean extends BaseOperation, RemoveOperation {
	
	void saveRecursively() throws ZydException;
	
	List<ReturnOrderItemListBean> getReturnOrderItemListBeans();
	
	void setReturnOrderItemListBeans(List<ReturnOrderItemListBean> returnOrderItemListBeans);

    BigDecimal getReturnOrderCmmdtyId();

    ReturnOrderCmmdtyType getReturnOrderCmmdtyType();

    BigDecimal getSourceOrderCmmdtyId();

    BigDecimal getCmmdtyId();

    String getCmmdtyName();

    BigDecimal getActualPrice();

    Integer getQty();

    BigDecimal getReturnOrderId();

    void setReturnOrderCmmdtyId(BigDecimal returnOrderCmmdtyId);

    void setReturnOrderCmmdtyType(ReturnOrderCmmdtyType returnOrderCmmdtyType);

    void setSourceOrderCmmdtyId(BigDecimal sourceOrderCmmdtyId);

    void setCmmdtyId(BigDecimal cmmdtyId);

    void setCmmdtyName(String cmmdtyName);

    void setActualPrice(BigDecimal actualPrice);

    void setQty(Integer qty);

    void setReturnOrderId(BigDecimal returnOrderId);

}
