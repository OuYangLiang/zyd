package org.zyd.domain.cache;

import org.zyd.domain.bean.PartyAccountBean;

public interface PartyAccountCacheByVal extends RedisCache<PartyAccountBean> {
	PartyAccountBean queryAccount(String acntVal);
}
