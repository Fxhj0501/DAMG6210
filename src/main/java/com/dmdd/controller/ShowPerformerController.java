package com.dmdd.controller;

import com.dmdd.dao.ShowPerformer;
import com.dmdd.mapper.ShowPerformerMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowPerformerController {
    @Autowired
    private ShowPerformerMapper showPerformerMapper;

    @GetMapping("/showPerformer")
    public PageInfo<ShowPerformer> showPerformer(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<ShowPerformer> showPerformers = showPerformerMapper.selectList(null);
        PageInfo<ShowPerformer> pageInfo = new PageInfo<>(showPerformers);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/showPerformer/delete")
    public String deleteShowPerformer(@RequestBody ShowPerformer showPerformer) {
        showPerformerMapper.deleteByPerformerIdAndShowId(showPerformer.getPerformerId().longValue(), showPerformer.getShowId().longValue());
        return "delete success";
    }

    @PostMapping("/showPerformer/insert")
    public String insertShowPerformer(@RequestBody ShowPerformer showPerformer) {
        showPerformerMapper.insert(showPerformer);
        return "insert success";
    }
}
