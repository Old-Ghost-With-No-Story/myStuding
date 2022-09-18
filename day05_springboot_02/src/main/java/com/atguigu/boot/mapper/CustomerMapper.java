package com.atguigu.boot.mapper;


import com.atguigu.boot.entities.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 姽辫
 * @className CustomerMapper
 * @date Create in 2022-09-15 14:02
 */
public interface CustomerMapper {
    public int add(Customer customer);
    public Customer getById(@Param("id") int id);
    public List<Customer> list();

}
