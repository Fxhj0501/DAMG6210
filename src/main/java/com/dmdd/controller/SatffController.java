package com.dmdd.controller;

import com.dmdd.dao.Staff;
import com.dmdd.mapper.StaffMapper;
import com.dmdd.mapper.StallStaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SatffController {
    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private StallStaffMapper stallStaffMapper;

    @GetMapping("/staff")
    public PageInfo<Staff> staff(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Staff> staffs = staffMapper.selectList(null);
        PageInfo<Staff> pageInfo = new PageInfo<>(staffs);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/staff/delete")
    public String deleteStaff(@RequestBody Staff staff) {
        System.out.println("delete staff id: " + staff.getStaffId());
        System.out.println("delete staff name: " + staff.getStaffName());
        stallStaffMapper.deleteByStaffId(staff.getStaffId().longValue());
        staffMapper.deleteById(staff.getStaffId().longValue());
        return "delete success";
    }

    @PostMapping("/staff/update")
public String updateStaff(@RequestBody Staff staff) {
        System.out.println("update staff id: " + staff.getStaffId());
        System.out.println("update staff name: " + staff.getStaffName());
        staffMapper.updateById(staff);
        return "update success";
    }

    @PostMapping("/staff/insert")
    public String insertStaff(@RequestBody Staff staff) {
        System.out.println("insert staff id: " + staff.getStaffId());
        System.out.println("insert staff name: " + staff.getStaffName());
        System.out.println("insert staff address: " + staff.getPhoneNo());
        staffMapper.insert(staff);
        return "insert success";
    }
}
