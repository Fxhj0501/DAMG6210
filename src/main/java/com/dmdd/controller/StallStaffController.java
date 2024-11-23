package com.dmdd.controller;

import com.dmdd.dao.StallStaff;
import com.dmdd.mapper.StallStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StallStaffController {
    @Autowired
    private StallStaffMapper stallStaffMapper;

    @GetMapping("/stallStaff")
    public PageInfo<StallStaff> stallStaff(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<StallStaff> stallStaffs = stallStaffMapper.selectList(null);
        PageInfo<StallStaff> pageInfo = new PageInfo<>(stallStaffs);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/stallStaff/delete")
    public String deleteStallStaff(@RequestBody StallStaff stallStaff) {
        stallStaffMapper.deleteByStaffIdAndStallId(stallStaff.getStaffId().longValue(), stallStaff.getStallId().longValue());
        return "delete success";
    }

    @PostMapping("/stallStaff/insert")
    public String insertStallStaff(@RequestBody StallStaff stallStaff) {
        stallStaffMapper.insert(stallStaff);
        return "insert success";
    }
}
