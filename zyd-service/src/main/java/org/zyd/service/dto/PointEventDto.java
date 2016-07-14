package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.Scenario;

public class PointEventDto implements java.io.Serializable{
	private static final long serialVersionUID = -8032279981271613500L;
	
	private BigDecimal eventId;
    private Scenario scenario;
    private Timestamp eventTs;
    private String orderNum;
    private String returnOrderNum;
    private BigDecimal orderAmt;
    private BigDecimal changeQty;
    private BigDecimal pointBalanceBefore;
    private BigDecimal partyId;

    public BigDecimal getEventId() {
        return this.eventId;
    }

    public Scenario getScenario() {
        return this.scenario;
    }

    public Timestamp getEventTs() {
        return this.eventTs;
    }

    public String getOrderNum() {
        return this.orderNum;
    }

    public String getReturnOrderNum() {
        return this.returnOrderNum;
    }

    public BigDecimal getOrderAmt() {
        return this.orderAmt;
    }

    public BigDecimal getChangeQty() {
        return this.changeQty;
    }

    public BigDecimal getPointBalanceBefore() {
        return this.pointBalanceBefore;
    }

    public BigDecimal getPartyId() {
        return this.partyId;
    }

    public void setEventId(BigDecimal eventId) {
        this.eventId = eventId;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public void setEventTs(Timestamp eventTs) {
        this.eventTs = eventTs == null ? null : (Timestamp) eventTs.clone();
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public void setReturnOrderNum(String returnOrderNum) {
        this.returnOrderNum = returnOrderNum == null ? null : returnOrderNum.trim();
    }

    public void setOrderAmt(BigDecimal orderAmt) {
        this.orderAmt = orderAmt;
    }

    public void setChangeQty(BigDecimal changeQty) {
        this.changeQty = changeQty;
    }

    public void setPointBalanceBefore(BigDecimal pointBalanceBefore) {
        this.pointBalanceBefore = pointBalanceBefore;
    }

    public void setPartyId(BigDecimal partyId) {
        this.partyId = partyId;
    }

}