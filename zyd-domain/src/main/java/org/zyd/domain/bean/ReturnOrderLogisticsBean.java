package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.common.constants.LogisticsCompCode;
import org.zyd.common.constants.ReturnOrderLogisticsType;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface ReturnOrderLogisticsBean extends BaseOperation, RemoveOperation {

    BigDecimal getLogisticsId();

    ReturnOrderLogisticsType getLogisticsType();

    LogisticsCompCode getLogisticsCompanyCode();

    String getLogisticsCompanyDesc();

    String getLogisticsNum();

    BigDecimal getLogisticsAmt();

    boolean isFreeLogisticsAmt();

    BigDecimal getReturnOrderId();

    void setLogisticsId(BigDecimal logisticsId);

    void setLogisticsType(ReturnOrderLogisticsType logisticsType);

    void setLogisticsCompanyCode(LogisticsCompCode logisticsCompanyCode);

    void setLogisticsCompanyDesc(String logisticsCompanyDesc);

    void setLogisticsNum(String logisticsNum);

    void setLogisticsAmt(BigDecimal logisticsAmt);

    void setFreeLogisticsAmt(boolean freeLogisticsAmt);

    void setReturnOrderId(BigDecimal returnOrderId);
}
