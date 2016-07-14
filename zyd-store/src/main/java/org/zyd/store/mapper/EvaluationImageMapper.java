package org.zyd.store.mapper;

import java.util.List;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.EvaluationImageEntity;
import org.zyd.store.term.EvaluationImageTerm;

/**
 * 
 * EvaluationImageMapper
 * 
 * @author GeJianKui
 * 
 */
public interface EvaluationImageMapper extends DBActionMapper<EvaluationImageEntity, EvaluationImageTerm>,
        PaginatingMapper<EvaluationImageEntity, EvaluationImageTerm> {

    List<EvaluationImageEntity> selectWithSort(EvaluationImageTerm param);

}
