package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.zyd.common.constants.TeaLevel;
import org.zyd.common.constants.TeaPacking;
import org.zyd.common.constants.TeaPriceRegion;
import org.zyd.common.constants.TeaType;

public interface TeaBean extends CommodityBean{

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

    TeaType getTeaType();

    String getPlaceOfOrigin();

    TeaLevel getLevel();

    TeaPacking getPacking();

    TeaPriceRegion getPriceRegion();

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

    void setTeaType(TeaType teaType);

    void setPlaceOfOrigin(String placeOfOrigin);

    void setLevel(TeaLevel level);

    void setPacking(TeaPacking packing);

    void setPriceRegion(TeaPriceRegion priceRegion);

}
