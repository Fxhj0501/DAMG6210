package com.dmdd.controller;

import com.dmdd.dao.Orders;
import com.dmdd.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/orders")
    public PageInfo<Orders> order(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Orders> orders = orderMapper.selectList(null);
        PageInfo<Orders> pageInfo = new PageInfo<>(orders);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/orders/delete")
    public String deleteOrder(@RequestBody Orders order) {
        orderMapper.deleteById(order.getOrderId().longValue());
        return "delete success";
    }

    @PostMapping("/orders/update")
    public String updateOrder(@RequestBody Orders order) {
        orderMapper.updateById(order);
        return "update success";
    }

    @PostMapping("/orders/insert")
    public String insertOrder(@RequestBody Orders order) {
        orderMapper.insert(order);
        return "insert success";
    }

}
