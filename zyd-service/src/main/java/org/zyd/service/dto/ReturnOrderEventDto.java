package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ReturnOrderEventDto implements java.io.Serializable{
	private static final long serialVersionUID = 377843293310586528L;
	
	private BigDecimal eventId;
    private Timestamp eventTs;
    private String eventDesc;
    private BigDecimal returnOrderId;

    public BigDecimal getEventId() {
        return this.eventId;
    }

    public Timestamp getEventTs() {
        return this.eventTs;
    }

    public String getEventDesc() {
        return this.eventDesc;
    }

    public BigDecimal getReturnOrderId() {
        return this.returnOrderId;
    }

    public void setEventId(BigDecimal eventId) {
        this.eventId = eventId;
    }

    public void setEventTs(Timestamp eventTs) {
        this.eventTs = eventTs == null ? null : (Timestamp) eventTs.clone();
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc == null ? null : eventDesc.trim();
    }

    public void setReturnOrderId(BigDecimal returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

}