package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface EvaluationImageBean extends BaseOperation, RemoveOperation {

    BigDecimal getImageId();

    BigDecimal getEvalId();

    Integer getImageSeq();

    String getImageAddrs();

    void setImageId(BigDecimal imageId);

    void setEvalId(BigDecimal evalId);

    void setImageSeq(Integer imageSeq);

    void setImageAddrs(String imageAddrs);

}
