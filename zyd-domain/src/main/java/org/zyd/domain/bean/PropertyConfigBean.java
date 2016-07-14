package org.zyd.domain.bean;

import org.zyd.common.constants.Category;
import org.zyd.domain.bean.operation.BaseOperation;

public interface PropertyConfigBean extends BaseOperation {
    
	Category getCategory();
	
	void setCategory(Category category);
	
	String getPropName();
	
	void setPropName(String propName);
	
	Integer getSeq();
	
	void setSeq(Integer seq);
}
