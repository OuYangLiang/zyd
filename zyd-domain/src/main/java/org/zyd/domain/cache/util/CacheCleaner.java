package org.zyd.domain.cache.util;

import java.lang.reflect.Method;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class CacheCleaner implements AfterReturningAdvice{
	
	public static final ThreadLocal<Set<String>> pendingDomainCache = new ThreadLocal<Set<String>>();
	private static final Logger log = LoggerFactory.getLogger(CacheCleaner.class);
	
	@Autowired
	private ShardedJedisPool pool;
	
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		Set<String> keys = pendingDomainCache.get();
		
		if (null != keys && !keys.isEmpty()) {
			ShardedJedis jedis = null; 
			try {
				jedis = pool.getResource();
				
				for (String key : keys) {
					jedis.del(key);
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				
			} finally {
				if (null != jedis) {
					jedis.close();
				}
			}
		}
		
		pendingDomainCache.remove();
	}
}
