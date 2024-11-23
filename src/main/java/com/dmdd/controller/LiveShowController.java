package com.dmdd.controller;

import com.dmdd.dao.LiveShow;
import com.dmdd.mapper.LiveShowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LiveShowController {
    @Autowired
    private LiveShowMapper liveShowMapper;

    @GetMapping("/liveShow")
    public PageInfo<LiveShow> liveShow(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<LiveShow> liveShows = liveShowMapper.selectList(null);
        PageInfo<LiveShow> pageInfo = new PageInfo<>(liveShows);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/liveShow/delete")
    public String deleteLiveShow(@RequestBody LiveShow liveShow) {
        System.out.println("delete liveShow id: " + liveShow.getPerformerId());
        liveShowMapper.deleteById(liveShow.getPerformerId().longValue());
        return "delete success";
    }

    @PostMapping("/liveShow/update")
    public String updateLiveShow(@RequestBody LiveShow liveShow) {
        System.out.println("update liveShow id: " + liveShow.getPerformerId());
        liveShowMapper.updateById(liveShow);
        return "update success";
    }

    @PostMapping("/liveShow/insert")
    public String insertLiveShow(@RequestBody LiveShow liveShow) {
        System.out.println("insert liveShow id: " + liveShow.getPerformerId());
        liveShowMapper.insert(liveShow);
        return "insert success";
    }
}
