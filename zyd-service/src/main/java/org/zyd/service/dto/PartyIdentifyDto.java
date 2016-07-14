package org.zyd.service.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PartyIdentifyDto implements java.io.Serializable{
	private static final long serialVersionUID = 3870184667600427778L;
	
	private BigDecimal partyId;
	private String recommendCode;
	private Timestamp registerDate;

	public BigDecimal getPartyId() {
		return this.partyId;
	}

	public String getRecommendCode() {
		return this.recommendCode;
	}

	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setPartyId(BigDecimal partyId) {
		this.partyId = partyId;
	}

	public void setRecommendCode(String recommendCode) {
		this.recommendCode = recommendCode == null ? null : recommendCode
				.trim();
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate == null ? null
				: (Timestamp) registerDate.clone();
	}

}