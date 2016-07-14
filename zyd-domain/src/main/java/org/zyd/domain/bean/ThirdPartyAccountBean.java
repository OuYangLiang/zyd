package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.common.constants.ThirdPartyAcntType;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface ThirdPartyAccountBean extends BaseOperation, RemoveOperation {

    BigDecimal getAcntId();

    ThirdPartyAcntType getAcntType();

    String getAcntVal();

    BigDecimal getPartyId();

    void setAcntId(BigDecimal acntId);

    void setAcntType(ThirdPartyAcntType acntType);

    void setAcntVal(String acntVal);

    void setPartyId(BigDecimal partyId);

}
