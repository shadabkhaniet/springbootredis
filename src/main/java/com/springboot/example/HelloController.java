package com.springboot.example;

import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloController {

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/")
    String home() {
        return "home";
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String index(@RequestParam(value="rate", required=false) Float rate, @RequestParam(value="Age", required=false) String age,@RequestParam(value="Email", required=false) String email) {

        System.err.println("in index method");
// 	Jedis jedis = jedisPool.getResource();
Map<String,String> userValues = new HashMap<String,String>();
userValues.put("Name", "testName");
//userValues.put("Age", age);
//userValues.put("Email", email);

 //System.err.println("values "+name+" "+age+" "+email);

Jedis jedis = jedisPool.getResource();
jedis.hmset("Rate_"+rate, userValues);

jedis.close();



        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/jsontest") 
    public @ResponseBody Map<String, String> callSomething () {
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("url", "http://www.leveluplunch.com");
        
        return map;
    }

}
