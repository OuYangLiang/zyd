package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.util.Date;

public interface BoutiqueBean extends CommodityBean{

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

}
