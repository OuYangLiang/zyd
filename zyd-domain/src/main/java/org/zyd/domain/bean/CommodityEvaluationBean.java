package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.zyd.common.constants.EvaluationLevel;
import org.zyd.common.exception.ZydException;
import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.CommodityEvaluationOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface CommodityEvaluationBean extends CommodityEvaluationOperation, BaseOperation, RemoveOperation {

    void saveRecursively() throws ZydException;

    List<EvaluationImageBean> getEvaluationImageBeans();

    void setEvaluationImageBeans(List<EvaluationImageBean> evaluationImageBeans);

    List<EvaluationLabelBean> getEvaluationLabelBeans();

    void setEvaluationLabelBeans(List<EvaluationLabelBean> evaluationLabelBeans);

    List<AddedEvaluationBean> getAddedEvaluationBeans();

    void setAddedEvaluationBeans(List<AddedEvaluationBean> addedEvaluationBeans);

    BigDecimal getEvalId();

    EvaluationLevel getEvalLevel();

    Integer getNumOfStars();

    String getEvalContent();

    Timestamp getEventTs();

    boolean isContainsImage();

    boolean isContainsAddedEval();

    boolean isForbidden();

    BigDecimal getCmmdtyId();

    BigDecimal getPartyId();

    BigDecimal getOrderId();

    void setEvalId(BigDecimal evalId);

    void setEvalLevel(EvaluationLevel evalLevel);

    void setNumOfStars(Integer numOfStars);

    void setEvalContent(String evalContent);

    void setEventTs(Timestamp eventTs);

    void setContainsImage(boolean containsImage);

    void setContainsAddedEval(boolean containsAddedEval);

    void setForbidden(boolean forbidden);

    void setCmmdtyId(BigDecimal cmmdtyId);

    void setPartyId(BigDecimal partyId);

    void setOrderId(BigDecimal orderId);
}
