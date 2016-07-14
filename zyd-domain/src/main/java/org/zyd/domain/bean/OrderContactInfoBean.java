package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface OrderContactInfoBean extends BaseOperation, RemoveOperation {

    BigDecimal getOrderId();

    String getCntctName();

    String getCntctMobile();

    String getCntctCountry();

    String getCntctState();

    String getCntctCity();

    String getCntctTown();

    String getCntctStreet();

    String getCntctAddress();

    String getCntctPostCode();

    void setOrderId(BigDecimal orderId);

    void setCntctName(String cntctName);

    void setCntctMobile(String cntctMobile);

    void setCntctCountry(String cntctCountry);

    void setCntctState(String cntctState);

    void setCntctCity(String cntctCity);

    void setCntctTown(String cntctTown);

    void setCntctStreet(String cntctStreet);

    void setCntctAddress(String cntctAddress);

    void setCntctPostCode(String cntctPostCode);

}
