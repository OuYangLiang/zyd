package org.zyd.service.convertor;

import org.zyd.domain.bean.AddedEvaluationBean;
import org.zyd.domain.bean.CommodityEvaluationBean;
import org.zyd.domain.bean.EvaluationImageBean;
import org.zyd.domain.bean.EvaluationLabelBean;
import org.zyd.service.dto.AddedEvaluationDto;
import org.zyd.service.dto.CommodityEvaluationDto;
import org.zyd.service.dto.EvaluationImageDto;
import org.zyd.service.dto.EvaluationLabelDto;

public class EvaluationConvertor {

    public CommodityEvaluationDto convertCommodityEvaluation(CommodityEvaluationBean bean) {
        if (null == bean) {
            return null;
        }
        CommodityEvaluationDto dto = new CommodityEvaluationDto();
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setContainsAddedEval(bean.isContainsAddedEval());
        dto.setContainsImage(bean.isContainsImage());
        dto.setEvalContent(bean.getEvalContent());
        dto.setEvalId(bean.getEvalId());
        dto.setEvalLevel(bean.getEvalLevel());
        dto.setEventTs(bean.getEventTs());
        dto.setForbidden(bean.isForbidden());
        dto.setNumOfStars(bean.getNumOfStars());
        dto.setOrderId(bean.getOrderId());
        dto.setPartyId(bean.getPartyId());
        return dto;
    }

    public EvaluationImageDto convertEvaluationImage(EvaluationImageBean bean) {
        if (null == bean) {
            return null;
        }
        EvaluationImageDto dto = new EvaluationImageDto();
        dto.setEvalId(bean.getEvalId());
        dto.setImageAddrs(bean.getImageAddrs());
        dto.setImageId(bean.getImageId());
        dto.setImageSeq(bean.getImageSeq());
        return dto;
    }

    public AddedEvaluationDto convertAddedEvaluation(AddedEvaluationBean bean) {
        if (null == bean) {
            return null;
        }
        AddedEvaluationDto dto = new AddedEvaluationDto();
        dto.setAddedEvalContent(bean.getAddedEvalContent());
        dto.setAddedEvalId(bean.getAddedEvalId());
        dto.setAddedEvalType(bean.getAddedEvalType());
        dto.setEvalId(bean.getEvalId());
        dto.setEventTs(bean.getEventTs());
        return dto;
    }

    public EvaluationLabelDto convertEvaluationLabel(EvaluationLabelBean bean) {
        if (null == bean) {
            return null;
        }
        EvaluationLabelDto dto = new EvaluationLabelDto();
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setHitTimes(bean.getHitTimes());
        dto.setLabel(bean.getLabel());
        dto.setLabelId(bean.getLabelId());
        return dto;
    }

}
