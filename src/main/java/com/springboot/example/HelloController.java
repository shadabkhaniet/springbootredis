package com.springboot.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

@RestController
public class HelloController {

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/")
    String home() {
        return "home";
    }

    @RequestMapping("/add")
    public String index() {

        System.err.println("in index method");
  

        return "Greetings from Spring Boot!";
    }

}
