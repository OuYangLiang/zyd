package org.zyd.domain.bean.operation;

import org.zyd.common.exception.ZydException;

public interface BaseOperation {
	/**
	 * 保存领域对象
	 * 
	 * @throws ZydException
	 */
	void save() throws ZydException;
	
	/**
	 * 更新领域对象
	 * 
	 * @throws ZydException
	 */
	void change() throws ZydException;
}
