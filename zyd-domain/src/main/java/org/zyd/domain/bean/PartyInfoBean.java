package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.zyd.common.constants.Education;
import org.zyd.common.constants.Gender;
import org.zyd.common.constants.Industry;
import org.zyd.common.constants.LevelOfIncome;
import org.zyd.common.constants.MaritalStatus;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface PartyInfoBean extends BaseOperation, RemoveOperation {

    BigDecimal getPartyId();

    String getPartyName();

    String getPartyAlias();

    Gender getGender();

    Date getBirthday();

    Education getEducation();

    MaritalStatus getMaritalStatus();

    Industry getIndustry();

    LevelOfIncome getLevelOfIncome();

    void setPartyId(BigDecimal partyId);

    void setPartyName(String partyName);

    void setPartyAlias(String partyAlias);

    void setGender(Gender gender);

    void setBirthday(Date birthday);

    void setEducation(Education education);

    void setMaritalStatus(MaritalStatus maritalStatus);

    void setIndustry(Industry industry);

    void setLevelOfIncome(LevelOfIncome levelOfIncome);

}
