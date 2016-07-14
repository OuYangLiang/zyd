package org.zyd.domain.cache;

public interface RedisCache<T> {
	void add(T param);
	
	String keyPrefix();
	
}
