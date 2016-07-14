package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderEventDto implements java.io.Serializable{
	private static final long serialVersionUID = 5773365361817302446L;
	
	private BigDecimal eventId;
    private Timestamp eventTs;
    private String eventDesc;
    private BigDecimal orderId;

    public BigDecimal getEventId() {
        return this.eventId;
    }

    public Timestamp getEventTs() {
        return this.eventTs;
    }

    public String getEventDesc() {
        return this.eventDesc;
    }

    public BigDecimal getOrderId() {
        return this.orderId;
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

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

}