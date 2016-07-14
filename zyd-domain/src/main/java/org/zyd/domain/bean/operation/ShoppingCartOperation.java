package org.zyd.domain.bean.operation;

import java.math.BigDecimal;

import org.zyd.common.exception.ZydException;

public interface ShoppingCartOperation {

	/**
	 * 增加商品
	 * 
	 * @param cmmdtyId 商品id
	 * @param qty 商品数量
	 * @throws ZydException
	 */
	void addCommodity(BigDecimal cmmdtyId, int qty) throws ZydException;
	
	/**
	 * 更新商品数量
	 * 
	 * @param cmmdtyId 商品id
	 * @param qty 商品数量
	 * @throws ZydException
	 */
	void changeCommodityQty(BigDecimal cmmdtyId, int qty) throws ZydException;
	
	/**
	 * 移除商品
	 * 
	 * @param cmmdtyId 商品id
	 * @throws ZydException
	 */
	void removeCommodity(BigDecimal cmmdtyId) throws ZydException;

}
