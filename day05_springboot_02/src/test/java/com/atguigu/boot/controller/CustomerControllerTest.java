package com.atguigu.boot.controller;

import com.atguigu.boot.entities.Customer;
import com.atguigu.boot.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;


/**
 * @author 姽辫
 * @className CustomerControllerTest
 * @date Create in 2022-09-13 20:06
 */
@SpringBootTest
class CustomerControllerTest {
    @Autowired
    private CustomerService customerService;

    @Test
    void addCustomer() {


    }

    @Test
    void getById() {
        System.out.println(this.customerService.getById(2));
    }

    @Test
    void list() {
        System.out.println(this.customerService.list());
    }
}