package org.zyd.domain.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.common.constants.CommonConstants;
import org.zyd.store.entity.SequenceEntity;
import org.zyd.store.mapper.SequenceMapper;

public class SequenceGenerator {
    @Autowired 
    private SequenceMapper sequenceMapper;

    public String generateBoutiqueCmmdtyNum() {
        SequenceEntity param = new SequenceEntity();
        sequenceMapper.insertBoutiqueSequence(param);
        return CommonConstants.CMMDTY_NUM_PREFIX_G + param.getSeq();
    }

    public String generateTeaCmmdtyNum() {
    	SequenceEntity param = new SequenceEntity();
        sequenceMapper.insertTeaSequence(param);
        return CommonConstants.CMMDTY_NUM_PREFIX_C + param.getSeq();
    }

    public String generateTeapotCmmdtyNum() {
    	SequenceEntity param = new SequenceEntity();
        sequenceMapper.insertTeapotSequence(param);
        return CommonConstants.CMMDTY_NUM_PREFIX_H + param.getSeq();
    }

    public String generatePurchaseOrderNum() {
    	SequenceEntity param = new SequenceEntity();
        sequenceMapper.insertPurchaseOrderSequence(param);
        return param.getSeq().toString();
    }

    public String generateReturnOrderNum() {
    	SequenceEntity param = new SequenceEntity();
        sequenceMapper.insertReturnOrderSequence(param);
        return param.getSeq().toString();
    }
    
    public String generateRecommendCode() {
    	SequenceEntity param = new SequenceEntity();
        sequenceMapper.insertRecommendSequence(param);
        return param.getSeq().toString();
    }
}
