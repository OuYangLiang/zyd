package org.zyd.service.convertor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.PartyAccountBean;
import org.zyd.domain.bean.PartyContactInfoBean;
import org.zyd.domain.bean.PartyInfoBean;
import org.zyd.domain.bean.PartyLevelBean;
import org.zyd.domain.bean.PartyPasswordBean;
import org.zyd.domain.bean.PartyPointBean;
import org.zyd.domain.bean.PointEventBean;
import org.zyd.domain.bean.ShoppingCartBean;
import org.zyd.domain.bean.ShoppingCartItemBean;
import org.zyd.domain.factory.PartyFactory;
import org.zyd.service.dto.PartyAccountDto;
import org.zyd.service.dto.PartyContactInfoDto;
import org.zyd.service.dto.PartyInfoDto;
import org.zyd.service.dto.PartyLevelDto;
import org.zyd.service.dto.PartyPasswordDto;
import org.zyd.service.dto.PartyPointDto;
import org.zyd.service.dto.PointEventDto;
import org.zyd.service.dto.ShoppingCartDto;
import org.zyd.service.dto.ShoppingCartItemDto;

public class PartyConvertor {
    @Autowired
    private PartyFactory partyFactory;

    public PartyAccountDto convertPartyAccount(PartyAccountBean bean) {
        if (null == bean) {
            return null;
        }
        PartyAccountDto dto = new PartyAccountDto();
        dto.setAcntId(bean.getAcntId());
        dto.setAcntStatus(bean.getAcntStatus());
        dto.setAcntType(bean.getAcntType());
        dto.setAcntVal(bean.getAcntVal());
        dto.setPartyId(bean.getPartyId());
        return dto;
    }

    public PartyAccountBean convertPartyAccount(PartyAccountDto dto) {
        if (null == dto) {
            return null;
        }
        PartyAccountBean bean = partyFactory.createPartyAccountBean();
        bean.setAcntId(dto.getAcntId());
        bean.setAcntStatus(dto.getAcntStatus());
        bean.setAcntType(dto.getAcntType());
        bean.setAcntVal(dto.getAcntVal());
        bean.setPartyId(dto.getPartyId());
        return bean;
    }

    public PartyPasswordDto convertPartyPassword(PartyPasswordBean bean) {
        if (null == bean) {
            return null;
        }
        PartyPasswordDto dto = new PartyPasswordDto();
        dto.setFirstWrongCheckTime(bean.getFirstWrongCheckTime());
        dto.setPartyId(bean.getPartyId());
        dto.setPwdId(bean.getPwdId());
        dto.setPwdSalt(bean.getPwdSalt());
        dto.setPwdStatus(bean.getPwdStatus());
        dto.setPwdStrongth(bean.getPwdStrongth());
        dto.setPwdType(bean.getPwdType());
        dto.setPwdVal(bean.getPwdVal());
        dto.setWrongCheckTimes(bean.getWrongCheckTimes());
        return dto;
    }

    public PartyPasswordBean convertPartyPassword(PartyPasswordDto dto) {
        if (null == dto) {
            return null;
        }
        PartyPasswordBean bean = partyFactory.createPartyPasswordBean();
        bean.setFirstWrongCheckTime(dto.getFirstWrongCheckTime());
        bean.setPartyId(dto.getPartyId());
        bean.setPwdId(dto.getPwdId());
        bean.setPwdSalt(dto.getPwdSalt());
        bean.setPwdStatus(dto.getPwdStatus());
        bean.setPwdStrongth(dto.getPwdStrongth());
        bean.setPwdType(dto.getPwdType());
        bean.setPwdVal(dto.getPwdVal());
        bean.setWrongCheckTimes(dto.getWrongCheckTimes());
        return bean;
    }

    public PartyInfoDto convertPartyInfo(PartyInfoBean bean) {
        if (null == bean) {
            return null;
        }
        PartyInfoDto dto = new PartyInfoDto();
        dto.setBirthday(bean.getBirthday());
        dto.setEducation(bean.getEducation());
        dto.setGender(bean.getGender());
//        dto.setIndustry(bean.getIndustry());
        dto.setLevelOfIncome(bean.getLevelOfIncome());
        dto.setMaritalStatus(bean.getMaritalStatus());
        dto.setPartyAlias(bean.getPartyAlias());
        dto.setPartyName(bean.getPartyName());
        dto.setPartyId(bean.getPartyId());
        return dto;
    }

    public PartyInfoBean convertPartyInfo(PartyInfoDto dto) {
        if (null == dto) {
            return null;
        }
        PartyInfoBean bean = partyFactory.createPartyInfoBean();
        bean.setBirthday(dto.getBirthday());
        bean.setEducation(dto.getEducation());
        bean.setGender(dto.getGender());
//        bean.setIndustry(dto.getIndustry());
        bean.setLevelOfIncome(dto.getLevelOfIncome());
        bean.setMaritalStatus(dto.getMaritalStatus());
        bean.setPartyAlias(dto.getPartyAlias());
        bean.setPartyName(dto.getPartyName());
        bean.setPartyId(dto.getPartyId());
        return bean;
    }

    public PartyContactInfoDto convertPartyContactInfo(PartyContactInfoBean bean) {
        if (null == bean) {
            return null;
        }
        PartyContactInfoDto dto = new PartyContactInfoDto();
        dto.setPartyId(bean.getPartyId());
        dto.setCntctAddress(bean.getCntctAddress());
        dto.setCntctCity(bean.getCntctCity());
        dto.setCntctCountry(bean.getCntctCountry());
        dto.setCntctId(bean.getCntctId());
        dto.setCntctMobile(bean.getCntctMobile());
        dto.setCntctName(bean.getCntctName());
        dto.setCntctPostCode(bean.getCntctPostCode());
        dto.setCntctSeq(bean.getCntctSeq());
        dto.setCntctState(bean.getCntctState());
        dto.setCntctStreet(bean.getCntctStreet());
        dto.setCntctTown(bean.getCntctTown());
        dto.setCntctType(bean.getCntctType());
        dto.setPreferFlag(bean.isPreferFlag());
        return dto;
    }

    public PartyContactInfoBean convertPartyContactInfo(PartyContactInfoDto dto) {
        if (null == dto) {
            return null;
        }
        PartyContactInfoBean bean = partyFactory.createPartyContactInfoBean();
        bean.setPartyId(dto.getPartyId());
        bean.setCntctAddress(dto.getCntctAddress());
        bean.setCntctCity(dto.getCntctCity());
        bean.setCntctCountry(dto.getCntctCountry());
        bean.setCntctId(dto.getCntctId());
        bean.setCntctMobile(dto.getCntctMobile());
        bean.setCntctName(dto.getCntctName());
        bean.setCntctPostCode(dto.getCntctPostCode());
        bean.setCntctSeq(dto.getCntctSeq());
        bean.setCntctState(dto.getCntctState());
        bean.setCntctStreet(dto.getCntctStreet());
        bean.setCntctTown(dto.getCntctTown());
        bean.setCntctType(dto.getCntctType());
        bean.setPreferFlag(dto.isPreferFlag());
        return bean;
    }

    public PartyPointDto convertPartyPoint(PartyPointBean bean) {
        if (null == bean) {
            return null;
        }
        PartyPointDto dto = new PartyPointDto();
        dto.setPartyId(bean.getPartyId());
        dto.setBalanceAmt(bean.getBalanceAmt());
        dto.setTotalAmt(bean.getTotalAmt());
        dto.setUsedAmt(bean.getUsedAmt());
        return dto;
    }

    public PointEventDto convertPointEvent(PointEventBean bean) {
        if (null == bean) {
            return null;
        }
        PointEventDto dto = new PointEventDto();
        dto.setPartyId(bean.getPartyId());
        dto.setChangeQty(bean.getChangeQty());
        dto.setEventId(bean.getEventId());
        dto.setEventTs(bean.getEventTs());
        dto.setOrderAmt(bean.getOrderAmt());
        dto.setOrderNum(bean.getOrderNum());
        dto.setPointBalanceBefore(bean.getPointBalanceBefore());
        dto.setReturnOrderNum(bean.getReturnOrderNum());
        dto.setScenario(bean.getScenario());
        return dto;
    }

    public PartyLevelDto convertPartyLevel(PartyLevelBean bean) {
        if (null == bean) {
            return null;
        }
        PartyLevelDto dto = new PartyLevelDto();
        dto.setPartyId(bean.getPartyId());
        dto.setLevel(bean.getLevel());
        dto.setLevelChgTs(bean.getLevelChgTs());
        dto.setLevelChgType(bean.getLevelChgType());
        return dto;
    }

    public ShoppingCartDto convertShoppingCart(ShoppingCartBean bean) {
        if (null == bean) {
            return null;
        }
        ShoppingCartDto dto = new ShoppingCartDto();
        dto.setPartyId(bean.getPartyId());
        List<ShoppingCartItemBean> itemBeans = bean.getItems();
        List<ShoppingCartItemDto> itemDtos = new ArrayList<ShoppingCartItemDto>();
        for (ShoppingCartItemBean itemBean : itemBeans) {
            itemDtos.add(this.convertShoppingCartItem(itemBean));
        }
        dto.setItems(itemDtos);
        return dto;
    }

    public ShoppingCartItemDto convertShoppingCartItem(ShoppingCartItemBean bean) {
        if (null == bean) {
            return null;
        }
        ShoppingCartItemDto dto = new ShoppingCartItemDto();
        dto.setAddTime(bean.getAddTime());
        dto.setCmmdtyId(bean.getCmmdtyId());
        dto.setQtyToBuy(bean.getQtyToBuy());
        dto.setShoppingId(bean.getShoppingId());
        return dto;
    }

}
