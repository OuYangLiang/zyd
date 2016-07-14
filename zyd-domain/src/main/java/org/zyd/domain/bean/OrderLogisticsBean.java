package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.common.constants.LogisticsCompCode;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface OrderLogisticsBean extends BaseOperation, RemoveOperation {

    BigDecimal getOrderId();

    LogisticsCompCode getLogisticsCompanyCode();

    String getLogisticsCompanyDesc();

    String getLogisticsNum();

    void setOrderId(BigDecimal orderId);

    void setLogisticsCompanyCode(LogisticsCompCode logisticsCompanyCode);

    void setLogisticsCompanyDesc(String logisticsCompanyDesc);

    void setLogisticsNum(String logisticsNum);

}
