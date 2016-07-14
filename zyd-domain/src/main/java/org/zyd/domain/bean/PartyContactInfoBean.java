package org.zyd.domain.bean;

import java.math.BigDecimal;

import org.zyd.common.constants.ContactType;
import org.zyd.common.constants.Country;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface PartyContactInfoBean extends BaseOperation, RemoveOperation {

    BigDecimal getCntctId();

    ContactType getCntctType();

    Integer getCntctSeq();

    String getCntctName();

    String getCntctMobile();

    Country getCntctCountry();

    String getCntctState();

    String getCntctCity();
    
    String getCntctTownCode();

    String getCntctTown();

    String getCntctStreet();

    String getCntctAddress();

    String getCntctPostCode();

    boolean isPreferFlag();

    BigDecimal getPartyId();

    void setCntctId(BigDecimal cntctId);

    void setCntctType(ContactType cntctType);

    void setCntctSeq(Integer cntctSeq);

    void setCntctName(String cntctName);

    void setCntctMobile(String cntctMobile);

    void setCntctCountry(Country cntctCountry);

    void setCntctState(String cntctState);

    void setCntctCity(String cntctCity);
    
    void setCntctTownCode(String cntctTownCode);

    void setCntctTown(String cntctTown);

    void setCntctStreet(String cntctStreet);

    void setCntctAddress(String cntctAddress);

    void setCntctPostCode(String cntctPostCode);

    void setPreferFlag(boolean preferFlag);

    void setPartyId(BigDecimal partyId);

}
