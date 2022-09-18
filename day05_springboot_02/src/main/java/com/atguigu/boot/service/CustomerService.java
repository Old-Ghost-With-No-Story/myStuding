package com.atguigu.boot.service;


import com.atguigu.boot.entities.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 姽辫
 * @className CustomerService
 * @date Create in 2022-09-15 14:08
 */
public interface CustomerService {
    public int add(Customer customer);
    public Customer getById(int id);
    public List<Customer> list();
}
