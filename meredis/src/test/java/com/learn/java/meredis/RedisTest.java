package com.learn.java.meredis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public Jedis CreateRedis() {
		// 连接本地服务器
		Jedis jedis = new Jedis("localhost");
		System.out.println("连接成功");
		return jedis;
	}

	/**
	 * 连接到 redis 服务
	 */
	@Test
	public void testRedisJava() {
		// 连接本地Redis服务
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis + "连接成功");
		// 查看服务是否运行
		System.out.println("服务正在进行" + jedis.ping());
	}

	/**
	 * Redis Java String(字符串) 实例
	 */
	@Test
	public void testRedisStringJava() {
		Jedis jedis = CreateRedis();
		//设置Redis字符串数据
		jedis.set("myKey", "myRedis");
		//获取存储的数据并输出
		System.out.println("redis存储的字符串是" + jedis.get("myKey"));
	}
	
	/**
	 * Redis Java List(列表) 实例
	 */
	@Test
	public void testRedisListJava() {
		Jedis jedis = CreateRedis();
		//存储数据列表中
		jedis.lpush("city","深圳");
		jedis.lpush("city","广州");
		jedis.lpush("city","上海");
		jedis.lpush("city","北京");
		//获取存储数据并输出
		List<String> cityList = jedis.lrange("city", 0, 3);
		for(String city : cityList) {
			System.out.println("一线城市：" + city);
		}
	}
	
	/**
	 * Redis Java Keys 实例
	 */
	@Test
	public void testRedisKeyJava() {
		Jedis jedis = CreateRedis();
		//获取数据并输出
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
	}
}
