package com.zghw.framework.redis.test;

import redis.clients.jedis.Jedis;

public class JedisPipeLineTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379, 2000);
	}

}
