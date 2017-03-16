package com.zghw.framework.redis.test;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class JedisTransTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379, 2000);
		//监控key
		jedis.watch("trans1");
		// 开启事务
		Transaction trans = jedis.multi();
		trans.set("trans1", "1");
		trans.incr("trans1");
		// 执行事务
		List<Object> results = trans.exec();
		//处理结果
		if(results!=null){
			for(Object obj:results){
				System.out.println(obj);
			}
		}
		
	}

}
