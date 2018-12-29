package com.easyshop.managers;

import com.easyshop.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SessionManager {

	@Autowired
	private RedisUtils redisUtils;

	public void create(String sessionId, Map<String, String> hash) {

	}
}
