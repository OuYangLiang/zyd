package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.common.constants.PasswordStatus;
import org.zyd.common.constants.PasswordStrongth;
import org.zyd.common.constants.PasswordType;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface PartyPasswordBean extends BaseOperation, RemoveOperation {

    BigDecimal getPwdId();

    PasswordType getPwdType();

    String getPwdVal();

    Integer getPwdSalt();

    PasswordStrongth getPwdStrongth();

    Timestamp getFirstWrongCheckTime();

    Integer getWrongCheckTimes();

    PasswordStatus getPwdStatus();

    BigDecimal getPartyId();

    void setPwdId(BigDecimal pwdId);

    void setPwdType(PasswordType pwdType);

    void setPwdVal(String pwdVal);

    void setPwdSalt(Integer pwdSalt);

    void setPwdStrongth(PasswordStrongth pwdStrongth);

    void setFirstWrongCheckTime(Timestamp firstWrongCheckTime);

    void setWrongCheckTimes(Integer wrongCheckTimes);

    void setPwdStatus(PasswordStatus pwdStatus);

    void setPartyId(BigDecimal partyId);

}
