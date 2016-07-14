package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface OrderEventBean extends BaseOperation, RemoveOperation {

    BigDecimal getEventId();

    Timestamp getEventTs();

    String getEventDesc();

    BigDecimal getOrderId();

    void setEventId(BigDecimal eventId);

    void setEventTs(Timestamp eventTs);

    void setEventDesc(String eventDesc);

    void setOrderId(BigDecimal orderId);

}
