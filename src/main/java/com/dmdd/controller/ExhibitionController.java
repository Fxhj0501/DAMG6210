package com.dmdd.controller;

import com.dmdd.dao.Exhibition;
import com.dmdd.dao.Show;
import com.dmdd.mapper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class ExhibitionController {
    @Autowired
    private ExhibitionMapper exhibitionMapper;

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private StallMapper stallMapper;

    @Autowired
    private ShowMapper showMapper;

    @Autowired
    private ShowPerformerMapper showPerformerMapper;

    @GetMapping("/exhibition")
    public PageInfo<Exhibition> exhibition(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Exhibition> exhibitions = exhibitionMapper.selectList(null);
        PageInfo<Exhibition> pageInfo = new PageInfo<>(exhibitions);
        System.out.println(pageInfo);
        return pageInfo;

    }

    @Transactional
    @PostMapping("/exhibition/delete")
    public String deleteExhibition(@RequestBody Exhibition exhibition) {
        System.out.println("delete sponsor id: " + exhibition.getExhibitionId().longValue());
        System.out.println("delete sponsor name: " + exhibition.getExhibitionName());
        stallMapper.setStallsExhibitionIdToNull(exhibition.getExhibitionId().longValue());
        contractMapper.deleteByExhibitionId(exhibition.getExhibitionId().longValue());
        List<Show> shows = showMapper.findByExhibitionId(exhibition.getExhibitionId().longValue());
        for(Show show: shows){
            showPerformerMapper.deleteByShowId(show.getShowId().longValue());
        }
        showMapper.deleteByExhibitionId(exhibition.getExhibitionId().longValue());
        exhibitionMapper.deleteById(exhibition.getExhibitionId());
        return "delete success";
    }

    @PostMapping("/exhibition/update")
    public String updateExhibition(@RequestBody Exhibition exhibition) {
        System.out.println("update sponsor id: " + exhibition.getExhibitionId());
        System.out.println("update sponsor name: " + exhibition.getExhibitionName());
        exhibitionMapper.updateById(exhibition);
        return "update success";
    }

    @PostMapping("/exhibition/insert")
    public String insertSExhibition(@RequestBody Exhibition exhibition) {
        System.out.println("insert sponsor id: " + exhibition.getExhibitionId());
        System.out.println("insert sponsor name: " + exhibition.getExhibitionName());
        System.out.println("insert sponsor address: " + exhibition.getDescription());
        exhibitionMapper.insertWithId(exhibition);
        return "insert success";
    }
}
