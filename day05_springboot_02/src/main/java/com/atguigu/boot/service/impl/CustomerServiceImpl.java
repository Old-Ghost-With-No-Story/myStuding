package com.atguigu.boot.service.impl;


import com.atguigu.boot.entities.Customer;
import com.atguigu.boot.mapper.CustomerMapper;
import com.atguigu.boot.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 姽辫
 * @className CustomerServiceImpl
 * @date Create in 2022-09-15 14:09
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public int add(Customer customer) {
        return this.customerMapper.add(customer);
    }

    @Override
    public Customer getById(int id) {
        return this.customerMapper.getById(id);
    }

    @Override
    public List<Customer> list() {
        return this.customerMapper.list();
    }
}
