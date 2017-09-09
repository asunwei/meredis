package com.learn.java.meredis;

import redis.clients.jedis.Jedis;

public class RedisJava {
	public static void main(String[] args) {
		//连接本地Redis服务
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis + "连接成功");
		//查看服务是否运行
		System.out.println("服务正在进行" + jedis.ping());
	}
}
