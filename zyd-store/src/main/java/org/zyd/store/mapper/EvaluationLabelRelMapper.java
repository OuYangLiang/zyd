package org.zyd.store.mapper;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.EvaluationLabelRelEntity;
import org.zyd.store.term.EvaluationLabelRelTerm;

/**
 * 
 * EvaluationLabelRelMapper
 * 
 * @author GeJianKui
 * 
 */
public interface EvaluationLabelRelMapper extends DBActionMapper<EvaluationLabelRelEntity, EvaluationLabelRelTerm>,
        PaginatingMapper<EvaluationLabelRelEntity, EvaluationLabelRelTerm> {

}
