package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.common.constants.AccountStatus;
import org.zyd.common.constants.AccountType;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface PartyAccountBean extends BaseOperation, RemoveOperation {

    BigDecimal getAcntId();

    AccountType getAcntType();

    String getAcntVal();

    AccountStatus getAcntStatus();

    BigDecimal getPartyId();

    void setAcntId(BigDecimal acntId);

    void setAcntType(AccountType acntType);

    void setAcntVal(String acntVal);

    void setAcntStatus(AccountStatus acntStatus);

    void setPartyId(BigDecimal partyId);

}
