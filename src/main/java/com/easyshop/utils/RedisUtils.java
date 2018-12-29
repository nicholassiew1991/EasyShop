package com.easyshop.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.function.Supplier;

@Component
public class RedisUtils {

	@Value("${spring.redis.host}")
	private String host;

	private final Supplier<Jedis> jedisSupplier = () -> new Jedis(host);

	private RedisUtils() {
	}

	public long hset(String key, String field, String value) {
		try (Jedis j = jedisSupplier.get()) {
			return j.hset(key, field, value);
		}
	}

	public long hset(String key, Map<String, String> hash) {
		try (Jedis j = jedisSupplier.get()) {
			return j.hset(key, hash);
		}
	}
}
