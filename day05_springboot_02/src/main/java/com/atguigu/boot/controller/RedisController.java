package com.atguigu.boot.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 姽辫
 * @className RedisController
 * @date Create in 2022-09-15 14:45
 */
@RestController
@Slf4j
@RequestMapping("/redis")
@Api(description = "Redis测试接口")
public class RedisController {
    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation("测试读值")
    @GetMapping("/testGet/{key}")
    public String testGet(@PathVariable("key") String key) {
        return (String) this.redisTemplate.opsForValue().get(key);
    }

    @ApiOperation("测试写入值")
    @PostMapping("/testSet")
    public void testSet(String key, String value) {
        this.redisTemplate.opsForValue().set(key, value);
    }
}
