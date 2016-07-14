package org.zyd.store.mapper;

import java.util.List;

import org.zyd.store.base.mapper.DBActionMapper;
import org.zyd.store.base.mapper.PaginatingMapper;
import org.zyd.store.entity.PartyContactInfoEntity;
import org.zyd.store.term.PartyContactInfoTerm;

/**
 * 
 * PartyContactInfoMapper
 * 
 * @author GeJianKui
 * 
 */
public interface PartyContactInfoMapper extends DBActionMapper<PartyContactInfoEntity, PartyContactInfoTerm>,
        PaginatingMapper<PartyContactInfoEntity, PartyContactInfoTerm> {

    List<PartyContactInfoEntity> selectWithSort(PartyContactInfoTerm param);
    
    PartyContactInfoEntity selectMaxSeq(PartyContactInfoTerm param);

    int updateByPartyIdAndType(PartyContactInfoEntity entity);

}
