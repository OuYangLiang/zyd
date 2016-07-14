package org.zyd.domain.cache.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;

public class Test {

	public static void main(String[] args) {
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
//		shards.add(new JedisShardInfo("127.0.0.1", "SHARD-0", 6379, 20, 1));
//		shards.add(new JedisShardInfo("127.0.0.1", "SHARD-1", 6380, 20, 1));
//		shards.add(new JedisShardInfo("127.0.0.1", "SHARD-2", 6381, 20, 1));
		
		shards.add(new JedisShardInfo("127.0.0.1", 6379));
		shards.add(new JedisShardInfo("127.0.0.1", 6380));
		shards.add(new JedisShardInfo("127.0.0.1", 6381));
		
		ShardedJedisPool pool = new ShardedJedisPool(new GenericObjectPoolConfig(), shards);
		
		ShardedJedis jedis = pool.getResource();
		
		JedisCommandsWrapper wrapper = new JedisCommandsWrapper();
		wrapper.setCommands(jedis);
		wrapper.setSplitMod(3);
		
		for (int i=0; i <=1000; i++) {
			wrapper.hset("account", "party" + i, "1855160250" + i);
		}
		
	}

}
