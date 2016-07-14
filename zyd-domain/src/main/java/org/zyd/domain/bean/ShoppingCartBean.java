package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.util.List;

import org.zyd.domain.bean.operation.ShoppingCartOperation;

public interface ShoppingCartBean extends ShoppingCartOperation{
	
	BigDecimal getPartyId();
	
	void setPartyId(BigDecimal partyId);
	
	List<ShoppingCartItemBean> getItems();
	
	void setItems(List<ShoppingCartItemBean> items);
}
