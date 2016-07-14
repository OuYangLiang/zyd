package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.Scenario;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface PointEventBean extends BaseOperation, RemoveOperation {

    BigDecimal getEventId();

    Scenario getScenario();

    Timestamp getEventTs();

    String getOrderNum();

    String getReturnOrderNum();

    BigDecimal getOrderAmt();

    BigDecimal getChangeQty();

    BigDecimal getPointBalanceBefore();

    BigDecimal getPartyId();

    void setEventId(BigDecimal eventId);

    void setScenario(Scenario scenario);

    void setEventTs(Timestamp eventTs);

    void setOrderNum(String orderNum);

    void setReturnOrderNum(String returnOrderNum);

    void setOrderAmt(BigDecimal orderAmt);

    void setChangeQty(BigDecimal changeQty);

    void setPointBalanceBefore(BigDecimal pointBalanceBefore);

    void setPartyId(BigDecimal partyId);

}
