package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.common.constants.Country;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface ReturnOrderContactInfoBean extends BaseOperation, RemoveOperation {

    BigDecimal getReturnOrderId();

    String getCntctName();

    String getCntctMobile();

    Country getCntctCountry();

    String getCntctState();

    String getCntctCity();

    String getCntctTown();

    String getCntctStreet();

    String getCntctAddress();

    String getCntctPostCode();

    void setReturnOrderId(BigDecimal returnOrderId);

    void setCntctName(String cntctName);

    void setCntctMobile(String cntctMobile);

    void setCntctCountry(Country cntctCountry);

    void setCntctState(String cntctState);

    void setCntctCity(String cntctCity);

    void setCntctTown(String cntctTown);

    void setCntctStreet(String cntctStreet);

    void setCntctAddress(String cntctAddress);

    void setCntctPostCode(String cntctPostCode);

}
