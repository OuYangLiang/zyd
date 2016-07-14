package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.common.constants.CommodityImageType;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface CommodityImageBean extends BaseOperation, RemoveOperation {
    
    BigDecimal getImageId();

    BigDecimal getCmmdtyId();

    Integer getImageSeq();

    String getImageAddrs();

    void setImageId(BigDecimal imageId);

    void setCmmdtyId(BigDecimal cmmdtyId);

    void setImageSeq(Integer imageSeq);

    void setImageAddrs(String imageAddrs);
    
    void setImageType(CommodityImageType imageType);
    
    CommodityImageType getImageType();

}
