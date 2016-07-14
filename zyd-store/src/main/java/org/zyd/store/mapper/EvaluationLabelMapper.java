package org.zyd.store.mapper;

import java.util.List;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.EvaluationLabelEntity;
import org.zyd.store.term.EvaluationLabelTerm;

/**
 * 
 * EvaluationLabelMapper
 * 
 * @author GeJianKui
 * 
 */
public interface EvaluationLabelMapper extends DBActionMapper<EvaluationLabelEntity, EvaluationLabelTerm>,
        PaginatingMapper<EvaluationLabelEntity, EvaluationLabelTerm> {

    List<EvaluationLabelEntity> selectWithSort(EvaluationLabelTerm param);

    int hit(EvaluationLabelEntity param);

}
