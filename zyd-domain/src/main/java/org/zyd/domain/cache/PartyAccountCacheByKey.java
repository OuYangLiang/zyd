package org.zyd.domain.cache;

import java.math.BigDecimal;

import org.zyd.domain.bean.PartyAccountBean;

public interface PartyAccountCacheByKey extends RedisCache<PartyAccountBean>{
	PartyAccountBean queryAccount(BigDecimal acntId);
}
