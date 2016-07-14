package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface PartyPointBean extends BaseOperation, RemoveOperation {

    BigDecimal getPartyId();

    BigDecimal getTotalAmt();

    BigDecimal getUsedAmt();

    BigDecimal getBalanceAmt();

    void setPartyId(BigDecimal partyId);

    void setTotalAmt(BigDecimal totalAmt);

    void setUsedAmt(BigDecimal usedAmt);

    void setBalanceAmt(BigDecimal balanceAmt);

}
