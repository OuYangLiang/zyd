package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.AddedEvalType;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface AddedEvaluationBean extends BaseOperation, RemoveOperation {

    BigDecimal getAddedEvalId();

    AddedEvalType getAddedEvalType();

    String getAddedEvalContent();

    Timestamp getEventTs();

    BigDecimal getEvalId();

    void setAddedEvalId(BigDecimal addedEvalId);

    void setAddedEvalType(AddedEvalType addedEvalType);

    void setAddedEvalContent(String addedEvalContent);

    void setEventTs(Timestamp eventTs);

    void setEvalId(BigDecimal evalId);

}
