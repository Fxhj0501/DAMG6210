package com.dmdd.controller;

import com.dmdd.dao.Customer;
import com.dmdd.mapper.CustomerMapper;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping("/customer")
    public PageInfo<Customer> customer(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Customer> customers = customerMapper.selectList(null);
        PageInfo<Customer> pageInfo = new PageInfo<>(customers);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/customer/delete")
    public String deleteCustomer(@RequestBody Customer customer) {
        customerMapper.deleteById(customer.getCustomerId().longValue());
        return "delete success";
    }

    @PostMapping("/customer/update")
    public String updateCustomer(@RequestBody Customer customer) {
        customerMapper.updateById(customer);
        return "update success";
    }

    @PostMapping("/customer/insert")
    public String insertCustomer(@RequestBody Customer customer) {
        customerMapper.insert(customer);
        return "insert success";
    }
}
