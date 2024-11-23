package com.dmdd.controller;

import com.dmdd.dao.VirtualShow;
import com.dmdd.mapper.VirtualShowMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VirtualShowController {
    @Autowired
    private VirtualShowMapper virtualShowMapper;

    @GetMapping("/virtualShow")
    PageInfo<VirtualShow> virtualShow(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<VirtualShow> virtualShows = virtualShowMapper.selectList(null);
        PageInfo<VirtualShow> pageInfo = new PageInfo<>(virtualShows);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/virtualShow/delete")
    String deleteVirtualShow(@RequestBody VirtualShow virtualShow) {
        System.out.println("delete virtualShow id: " + virtualShow.getPerformerId());
        virtualShowMapper.deleteById(virtualShow.getPerformerId().longValue());
        return "delete success";
    }

    @PostMapping("/virtualShow/update")
    String updateVirtualShow(@RequestBody VirtualShow virtualShow) {
        System.out.println("update virtualShow id: " + virtualShow.getPerformerId());
        virtualShowMapper.updateById(virtualShow);
        return "update success";
    }

    @PostMapping("/virtualShow/insert")
    String insertVirtualShow(@RequestBody VirtualShow virtualShow) {
        System.out.println("insert virtualShow id: " + virtualShow.getPerformerId());
        virtualShowMapper.insert(virtualShow);
        return "insert success";
    }

}

