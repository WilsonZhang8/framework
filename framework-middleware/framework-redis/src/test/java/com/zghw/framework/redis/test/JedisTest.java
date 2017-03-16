package com.zghw.framework.redis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class JedisTest {

	//数据类型
	public static void main(String[] args) {
		// 客户端连接redis
		Jedis jedis = new Jedis("127.0.0.1", 6379, 2000);

		// =========字符串命令STRING=========
		// 1.GET获取存储在给定键中的值
		String test = jedis.get("test");
		// 不存在则返回null
		System.out.println(test);
		// 2.SET设置存储在给定键中的值
		String result = jedis.set("test1", "val1");
		// 设置完成后返回OK
		System.out.println(result);
		String test1 = jedis.get("test1");
		System.out.println(test1);
		// 3.DEL删除存储在给定键中的值（这个命令可以用于所有类型）
		Long res = jedis.del("test1", "test");
		// 返回删除后的数量
		System.out.println(res);
		test1 = jedis.get("test1");
		System.out.println(test1);

		// =======列表命令LIST========列表可以存储多个相同的字符串
		// 1.LPUSH将给定的值推入列表左端.
		jedis.lpush("list", "1");
		// 返回列表中元素的个数
		res = jedis.lpush("list", "2");
		System.out.println(res);
		// 2.RPUSH将给定的值推入列表右端.
		jedis.rpush("list", "3");
		// 3.LRANGE返回列表某个范围值,0开始代表第一个元素,-1代表最后一个元素,-2代表倒数第二个元素.如果取前两个元素则设置("list",
		// 0, 1)
		List<String> list = jedis.lrange("list", 0, -1);
		System.out.println(list);
		// 4.LINDEX 列表中某个索引值.
		String last = jedis.lindex("list", -1);
		System.out.println(last);
		// 5.LPOP从列表左端弹出一个元素
		// jedis.lpop("list");
		list = jedis.lrange("list", 0, -1);
		System.out.println(list);
		// 6.LPOP从列表右端弹出一个元素
		// jedis.rpop("list");
		list = jedis.lrange("list", 0, -1);
		System.out.println(list);
		// 全部删除用del
		// jedis.del("list");
		list = jedis.lrange("list", 0, -1);
		System.out.println(list);
		// 7.LREM移除列表集合中某个元素,0代表全部包含value为3元素全部移除.如果为整数则代表从开始删除,负数为从后面开始删除
		jedis.lrem("list", 0, "1");
		list = jedis.lrange("list", 0, -1);
		System.out.println(list);

		// ==========SET==========存储的每个字符串都是各不相同的
		// 1.SADD添加元素
		res = jedis.sadd("set", "member1");
		System.out.println(res);
		// 2.SMEMBERS返回所有元素集合
		Set<String> set = jedis.smembers("set");
		System.out.println(set);
		// 添加相同元素则返回0,没有元素则为1
		res = jedis.sadd("set", "member1");
		System.out.println(res);
		set = jedis.smembers("set");
		System.out.println(set);
		// 3.SISMEMBER是否存在该会员
		Boolean isMember = jedis.sismember("set", "member1");
		System.out.println(isMember);
		// 4.SREM删除会员
		jedis.srem("set", "member1");
		// 删除全部集合数据
		// jedis.del("set");
		isMember = jedis.sismember("set", "member1");
		System.out.println(isMember);

		// ==========HASH==========
		// 1.HSET添加hash值
		res = jedis.hset("hash", "filed1", "val1");
		System.out.println(res);
		// 2.HGET取出hash值
		String val = jedis.hget("hash", "filed1");
		System.out.println(val);
		// 3.HEXISTS取出值是否存在
		Boolean hexists = jedis.hexists("hash", "filed1");
		System.out.println(hexists);
		res = jedis.hset("hash", "filed2", "val2");
		System.out.println(res);
		// 4.HLEN代表hash的长度
		Long len = jedis.hlen("hash");
		System.out.println(len);
		// 5.HKEYS包含的所有key
		Set<String> hkeys = jedis.hkeys("hash");
		System.out.println(hkeys);
		// 6.HVALS包含的所有值
		List<String> hvals = jedis.hvals("hash");
		System.out.println(hvals);
		// 7.HGETALL包含的map
		Map<String, String> allMap = jedis.hgetAll("hash");
		System.out.println(allMap);

		// ============ZSET==============有序集合是Redis里面唯一一个既可以根据成员访问元素（这一点和散列一样），又可以根据分值以及分值的排列顺序来访问元素的结构
		Map<String, Double> scoreMembers = new HashMap<String, Double>();
		scoreMembers.put("s1", 1.0);
		scoreMembers.put("ss", 1.3);
		scoreMembers.put("s2", 2.0);
		scoreMembers.put("s3", 3.0);
		// 1.ZADD添加zset元素
		jedis.zadd("zset", scoreMembers);
		// 2.ZRANGE查询zset中值列表范围,0代表第一个,-1代表最后一个. 查询前两个则使用jedis.zrange("zset", 0, 1);
		Set<String> zsetVal = jedis.zrange("zset", 0, -1);
		System.out.println(zsetVal);
		// 3.ZCOUNT根据分值范围查询值个数
		Long count = jedis.zcount("zset", 1.0, 2.0);
		System.out.println(count);
		//4.ZRAGNEBYSCORE根据分值范围查询需要的数据
		zsetVal =jedis.zrangeByScore("zset", 1.0, 2.0);
		System.out.println(zsetVal);
		//5.ZCARD 有序集合中的个数
		count=jedis.zcard("zset");
		System.out.println(count);
		//6.ZSCORE 查询有序集合中相应key值对应的分值
		Double score=jedis.zscore("zset", "ss");
		System.out.println(score);
		
		jedis.close();
	}

}
