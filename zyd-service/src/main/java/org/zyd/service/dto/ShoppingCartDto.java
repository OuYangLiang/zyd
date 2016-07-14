package org.zyd.service.dto;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartDto implements java.io.Serializable{
	private static final long serialVersionUID = 9184380458025372469L;

	private BigDecimal partyId;
	private List<ShoppingCartItemDto> items;

	public BigDecimal getPartyId() {
		return partyId;
	}

	public void setPartyId(BigDecimal partyId) {
		this.partyId = partyId;
	}

	public List<ShoppingCartItemDto> getItems() {
		return items;
	}

	public void setItems(List<ShoppingCartItemDto> items) {
		this.items = items;
	}

}
