package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface ShoppingCartItemBean {

    BigDecimal getShoppingId();

    void setShoppingId(BigDecimal shoppingId);

    BigDecimal getCmmdtyId();

    void setCmmdtyId(BigDecimal cmmdtyId);

    Integer getQtyToBuy();

    void setQtyToBuy(Integer qtyToBuy);

    Timestamp getAddTime();

    void setAddTime(Timestamp addTime);

}
