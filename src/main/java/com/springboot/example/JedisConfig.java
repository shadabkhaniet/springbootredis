package com.springboot.example;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;

@Configuration
public class JedisConfig {
	@Value("${redis.datasource.url}")
	private String redisUrl;
	
	@Bean
	public JedisPool jedisPool(){
	    GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

	        return new JedisPool(poolConfig, redisUrl, 6379, 120000);
	}
}
