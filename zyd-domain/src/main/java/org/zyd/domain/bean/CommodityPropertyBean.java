package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface CommodityPropertyBean extends BaseOperation, RemoveOperation {

    BigDecimal getPropertyId();

    BigDecimal getCmmdtyId();

    String getPropName();

    String getPropVal();

    Integer getSeq();

    void setPropertyId(BigDecimal propertyId);

    void setCmmdtyId(BigDecimal cmmdtyId);

    void setPropName(String propName);

    void setPropVal(String propVal);

    void setSeq(Integer seq);

}
