package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.zyd.common.constants.SalesMode;
import org.zyd.common.constants.TeapotLevel;
import org.zyd.common.constants.TeapotMaterial;
import org.zyd.common.constants.TeapotPriceRegion;
import org.zyd.common.constants.TeapotShape;
import org.zyd.common.constants.TeapotType;

public interface TeapotBean extends CommodityBean{

    String getCmmdtyName();

    String getCmmdtyNum();

    String getCmmdtyDesc();

    Integer getNumStored();

    Integer getNumSales();

    Integer getNumEvaluated();
    
    Integer getNumEnquired();

    BigDecimal getProposedPrice();

    BigDecimal getCurrentPrice();

    Date getShelvesTime();

    Date getUnshelvesTime();

    String getDefaultImageAddrs();

    TeapotType getType();

    TeapotShape getShape();

    TeapotMaterial getMaterial();

    Integer getSize();

    TeapotLevel getLevel();

    String getProducer();

    SalesMode getSalesMode();

    TeapotPriceRegion getPriceRegion();

    void setCmmdtyName(String cmmdtyName);

    void setCmmdtyNum(String cmmdtyNum);

    void setCmmdtyDesc(String cmmdtyDesc);

    void setNumStored(Integer numStored);

    void setNumSales(Integer numSales);

    void setNumEvaluated(Integer numEvaluated);
    
    void setNumEnquired(Integer numEnquired);

    void setProposedPrice(BigDecimal proposedPrice);

    void setCurrentPrice(BigDecimal currentPrice);

    void setShelvesTime(Date shelvesTime);

    void setUnshelvesTime(Date unshelvesTime);

    void setDefaultImageAddrs(String defaultImageAddrs);

    void setType(TeapotType type);

    void setShape(TeapotShape shape);

    void setMaterial(TeapotMaterial material);

    void setSize(Integer size);

    void setLevel(TeapotLevel level);

    void setProducer(String producer);

    void setSalesMode(SalesMode salesMode);

    void setPriceRegion(TeapotPriceRegion priceRegion);

}
