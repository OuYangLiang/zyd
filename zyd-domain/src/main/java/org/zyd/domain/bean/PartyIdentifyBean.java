package org.zyd.domain.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.zyd.domain.bean.operation.BaseOperation;
import org.zyd.domain.bean.operation.PartyIdentifyOperation;
import org.zyd.domain.bean.operation.RemoveOperation;

public interface PartyIdentifyBean extends PartyIdentifyOperation,
		BaseOperation, RemoveOperation {
	
	List<PartyPasswordBean> getPartyPasswordBeans();
	
	void setPartyPasswordBeans(List<PartyPasswordBean> partyPasswordBeans);
	
	List<PartyAccountBean> getPartyAccountBeans();
	
	void setPartyAccountBeans(List<PartyAccountBean> partyAccountBeans);
	
	PartyInfoBean getPartyInfoBean();
	
	void setPartyInfoBean(PartyInfoBean partyInfoBean);
	
	List<PartyContactInfoBean> getPartyContactInfoBeans();
	
	void setPartyContactInfoBeans(List<PartyContactInfoBean> partyContactInfoBeans);
	
	List<PartyIdentifyBean> getRecommendedList();
	
	void setRecommendedList(List<PartyIdentifyBean> recommendedList);

	BigDecimal getPartyId();

	String getRecommendCode();

	Timestamp getRegisterDate();

	void setRecommendCode(String recommendCode);

	void setRegisterDate(Timestamp registerDate);

}
