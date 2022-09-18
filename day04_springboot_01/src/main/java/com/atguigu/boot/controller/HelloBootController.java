package com.atguigu.boot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author 姽辫
 * @className HelloBootController
 * @date Create in 2022-09-12 23:47
 */
@RestController
@RequestMapping("/helloBoot")
public class HelloBootController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello springboot";
    }
}
