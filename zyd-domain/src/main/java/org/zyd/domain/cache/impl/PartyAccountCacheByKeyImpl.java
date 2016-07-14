package org.zyd.domain.cache.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zyd.domain.bean.PartyAccountBean;
import org.zyd.domain.cache.PartyAccountCacheByKey;
import org.zyd.domain.factory.PartyFactory;

import com.google.gson.Gson;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class PartyAccountCacheByKeyImpl implements PartyAccountCacheByKey {
	
	private static final Logger log = LoggerFactory.getLogger(PartyAccountCacheByKey.class);
	
	@Autowired
	private ShardedJedisPool pool;
	@Autowired
	private PartyFactory partyFactory;

	@Override
	public void add(PartyAccountBean param) {
		ShardedJedis jedis = null; 
		
		try {
			jedis = pool.getResource();
			jedis.set(keyPrefix() + param.getAcntId(), new Gson().toJson(param));
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}

	@Override
	public String keyPrefix() {
		return "PartyAccountBean:ByKey:";
	}

	@Override
	public PartyAccountBean queryAccount(BigDecimal acntId) {
		ShardedJedis jedis = null; 
		
		try {
			jedis = pool.getResource();
			String rlt = jedis.get(keyPrefix() + acntId);
			
			if (null == rlt || rlt.trim().isEmpty()) {
				return null;
			}
			
			return partyFactory.createPartyAccountBeanFromJson(rlt);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			return null;
		} finally {
			if (null != jedis) {
				jedis.close();
			}
		}
	}

}
