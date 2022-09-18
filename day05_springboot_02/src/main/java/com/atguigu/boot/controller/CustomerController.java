package com.atguigu.boot.controller;


import com.atguigu.boot.entities.Customer;
import com.atguigu.boot.mapper.CustomerMapper;
import com.atguigu.boot.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 姽辫
 * @className CustomerController
 * @date Create in 2022-09-15 14:14
 */
@RestController
@Slf4j
@RequestMapping("/customer")
@Api(description = "Customer接口")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation("根据id获得相应顾客")
    @GetMapping("/get/{id}")
    public Customer getById(@PathVariable("id") int id) {
        return this.customerService.getById(id);
    }

    @ApiOperation("获得所有顾客的List集合")
    @GetMapping("/list")
    public List<Customer> list() {
        return this.customerService.list();
    }

    @ApiOperation("新增一个顾客")
    @PostMapping("/add")
    public int add(Customer customer) {
        return this.customerService.add(customer);
    }
}
