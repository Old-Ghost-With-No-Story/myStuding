package com.atguigu.boot.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;
import java.util.RandomAccess;

/**
 * @author 姽辫
 * @className RedisController
 * @date Create in 2022-09-15 11:03
 */
@RestController
@Slf4j
@RequestMapping("/redis")
public class RedisTestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/testAdd")
    public void testAdd() {
        redisTemplate.opsForValue().set("k1", "redis测试" + new Random().nextInt(100) + 1);
    }

    @GetMapping("/testGet/{key}")
    public String testGet(@PathVariable("key") String k) {
        String value = (String) redisTemplate.opsForValue().get(k);
        System.out.println(value);
        return value;
    }
}
