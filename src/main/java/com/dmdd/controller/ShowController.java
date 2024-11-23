package com.dmdd.controller;

import com.dmdd.dao.Show;
import com.dmdd.mapper.ShowMapper;
import com.dmdd.mapper.ShowPerformerMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowController {
    @Autowired
    private ShowMapper showMapper;

    @Autowired
    private ShowPerformerMapper showPerformerMapper;

    @GetMapping("/show")
    public PageInfo<Show> show(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        int offset = (page - 1) * size;
        List<Show> shows = showMapper.selectPagedShows(offset, size);
        PageInfo<Show> pageInfo = new PageInfo<>(shows);
        return pageInfo;
    }

    @PostMapping("/show/delete")
    public String deleteShow(@RequestBody Show show) {
        showPerformerMapper.deleteByShowId(show.getShowId().longValue());
        showMapper.deleteById(show.getShowId().longValue());
        return "delete success";
    }

    @PostMapping("/show/update")
    public String updateShow(@RequestBody Show show) {
        showMapper.updateById(show);
        return "update success";
    }

    @PostMapping("/show/insert")
    public String insertShow(@RequestBody Show show) {
        showMapper.insertShow(show);
        return "insert success";
    }
}
