package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.common.constants.LabelStyle;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface LabelBean extends BaseOperation, RemoveOperation{
	BigDecimal getLabelId();
	
	void setLabelId(BigDecimal labelId);

    LabelStyle getLabelStyle();
    
    void setLabelStyle(LabelStyle labelStyle);

    String getLabelVal();

    void setLabelVal(String labelVal);

}
