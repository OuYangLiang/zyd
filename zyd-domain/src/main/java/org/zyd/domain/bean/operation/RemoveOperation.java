package org.zyd.domain.bean.operation;

import org.zyd.common.exception.ZydException;

public interface RemoveOperation {
	/**
	 * 删除领域对象
	 * 
	 * @throws ZydException
	 */
	void remove() throws ZydException;
}
