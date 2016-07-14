package org.zyd.domain.cache.util;

import java.math.BigDecimal;

import org.zyd.common.constants.AccountStatus;
import org.zyd.common.constants.AccountType;
import org.zyd.domain.bean.PartyAccountBean;
import org.zyd.domain.bean.impl.PartyAccountBeanImpl;

import com.google.gson.Gson;

public class Test2 {
	public static void main(String[] args) {
		PartyAccountBean bean = new PartyAccountBeanImpl(null);
		bean.setPartyId(BigDecimal.valueOf(1));
		bean.setAcntType(AccountType.A0800010);
		bean.setAcntVal("18551602500");
		bean.setAcntStatus(AccountStatus.A0900010);
		bean.setAcntId(BigDecimal.valueOf(1));
		
		String json = new Gson().toJson(bean);
		
		bean = new Gson().fromJson(json, PartyAccountBeanImpl.class);
		
		System.out.println(bean.getAcntVal());
		
		
	}
	
}
