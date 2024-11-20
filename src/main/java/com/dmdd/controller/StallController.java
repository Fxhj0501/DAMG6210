package com.dmdd.controller;

import com.dmdd.dao.Stall;
import com.dmdd.mapper.StallMapper;
import com.dmdd.mapper.StallStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StallController{
    @Autowired
    private StallMapper stallMapper;

    @Autowired
    private StallStaffMapper stallStaffMapper;

    @GetMapping("/stall")
    public PageInfo<Stall> stall(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Stall> stalls = stallMapper.selectList(null);
        PageInfo<Stall> pageInfo = new PageInfo<>(stalls);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/stall/delete")
    public String deleteStall(@RequestBody Stall stall) {
        System.out.println("delete stall id: " + stall.getStallId());
        stallStaffMapper.deleteByStallId(stall.getStallId().longValue());
        stallMapper.deleteById(stall.getStallId().longValue());
        return "delete success";
    }

    @PostMapping("/stall/update")
    public String updateStall(@RequestBody Stall stall) {
        System.out.println("update stall id: " + stall.getStallId());
        stallMapper.updateById(stall);
        return "update success";
    }

    @PostMapping("/stall/insert")
    public String insertStall(@RequestBody Stall stall) {
        System.out.println("insert stall id: " + stall.getStallId());
        stallMapper.insert(stall);
        return "insert success";
    }

}
