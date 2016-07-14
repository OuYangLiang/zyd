package org.zyd.store.mapper;

import org.zyd.store.entity.SequenceEntity;


/**
 * 
 * BoutiqueSequenceMapper
 * 
 * @author GeJianKui
 * 
 */
public interface SequenceMapper {
    int insertTeaSequence(SequenceEntity param);
    
    int insertTeapotSequence(SequenceEntity param);
    
    int insertBoutiqueSequence(SequenceEntity param);
    
    int insertPurchaseOrderSequence(SequenceEntity param);
    
    int insertReturnOrderSequence(SequenceEntity param);
    
    int insertRecommendSequence(SequenceEntity param);
}
