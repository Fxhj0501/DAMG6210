package com.dmdd.controller;

import com.dmdd.dao.Performer;
import com.dmdd.mapper.LiveShowMapper;
import com.dmdd.mapper.PerformerMapper;
import com.dmdd.mapper.ShowPerformerMapper;
import com.dmdd.mapper.VirtualShowMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PerformerController {
    @Autowired
    private PerformerMapper performerMapper;

    @Autowired
    private ShowPerformerMapper showPerformerMapper;

    @Autowired
    private LiveShowMapper liveShowMapper;

    @Autowired
    private VirtualShowMapper virtualShowMapper;

    @GetMapping("/performer")
    public PageInfo<Performer> performer(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Performer> performers = performerMapper.selectList(null);
        PageInfo<Performer> pageInfo = new PageInfo<>(performers);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/performer/delete")
    public String deletePerformer(@RequestBody Performer performer) {
        showPerformerMapper.deleteByPerformerId(performer.getPerformerId().longValue());
        virtualShowMapper.deleteById(performer.getPerformerId().longValue());
        liveShowMapper.deleteById(performer.getPerformerId().longValue());
        performerMapper.deleteById(performer.getPerformerId().longValue());
        return "delete success";
    }

    @PostMapping("/performer/update")
    public String updatePerformer(@RequestBody Performer performer) {
        performerMapper.updateById(performer);
        return "update success";
    }

    @PostMapping("/performer/insert")
    public String insertPerformer(@RequestBody Performer performer) {
        performerMapper.insert(performer);
        return "insert success";
    }
}
