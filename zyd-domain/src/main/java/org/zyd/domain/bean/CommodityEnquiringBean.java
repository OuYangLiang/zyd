package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface CommodityEnquiringBean extends BaseOperation, RemoveOperation {

    BigDecimal getEnquiringId();

    String getEnquiringContent();

    Timestamp getEventTs();

    BigDecimal getCmmdtyId();

    BigDecimal getPartyId();

    String getAnswerer();

    String getAnswer();

    Timestamp getAnswerTs();
    
    String getAcntVal();

    void setEnquiringId(BigDecimal enquiringId);

    void setEnquiringContent(String enquiringContent);

    void setEventTs(Timestamp eventTs);

    void setCmmdtyId(BigDecimal cmmdtyId);

    void setPartyId(BigDecimal partyId);

    void setAnswerer(String answerer);

    void setAnswer(String answer);

    void setAnswerTs(Timestamp answerTs);

    void setAcntVal(String acntVal);
}
