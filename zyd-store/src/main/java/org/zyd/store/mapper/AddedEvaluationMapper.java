package org.zyd.store.mapper;

import java.util.List;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.AddedEvaluationEntity;
import org.zyd.store.term.AddedEvaluationTerm;

/**
 * 
 * AddedEvaluationMapper
 * 
 * @author GeJianKui
 * 
 */
public interface AddedEvaluationMapper extends DBActionMapper<AddedEvaluationEntity, AddedEvaluationTerm>,
        PaginatingMapper<AddedEvaluationEntity, AddedEvaluationTerm> {

    List<AddedEvaluationEntity> selectWithSort(AddedEvaluationTerm param);

}
