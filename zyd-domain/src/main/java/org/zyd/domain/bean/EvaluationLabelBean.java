package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface EvaluationLabelBean extends BaseOperation, RemoveOperation {

    void hit() throws ZydException;

    BigDecimal getLabelId();

    String getLabel();

    Integer getHitTimes();

    BigDecimal getCmmdtyId();

    void setLabelId(BigDecimal labelId);

    void setLabel(String label);

    void setHitTimes(Integer hitTimes);

    void setCmmdtyId(BigDecimal cmmdtyId);

}
