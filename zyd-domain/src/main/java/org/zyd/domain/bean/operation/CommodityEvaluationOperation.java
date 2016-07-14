package org.zyd.domain.bean.operation;

import org.zyd.common.constants.AddedEvalType;
import org.zyd.common.exception.ZydException;

public interface CommodityEvaluationOperation {

	/**
	 * 增加追评
	 * 
	 * @param addedEvalType 追评类型
	 * @param addedEvalContent 追评内容
	 * @throws ZydException
	 */
	void addAddedEvaluation(AddedEvalType addedEvalType, String addedEvalContent) throws ZydException;

}
