package com.dmdd.controller;

import com.dmdd.dao.Exhibition;
import com.dmdd.dao.Stall;
import com.dmdd.mapper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/exhibition")
    public PageInfo<Exhibition> exhibition(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Exhibition> exhibitions = exhibitionMapper.selectList(null);
        PageInfo<Exhibition> pageInfo = new PageInfo<>(exhibitions);
        System.out.println(pageInfo);
        return pageInfo;

    }

    @PostMapping("/exhibition/delete")
    public String deleteExhibition(@RequestBody Exhibition exhibition) {
        System.out.println("delete sponsor id: " + exhibition.getExhibitionId());
        System.out.println("delete sponsor name: " + exhibition.getExhibitionName());
        List<Stall> stalls =  stallMapper.findByExhibitionId(exhibition.getExhibitionId().longValue());
        //Set exhibition id to null in all relative stalls
        for(Stall stall: stalls){
            stall.setExhibitionId(null);
            stallMapper.updateById(stall);
        }
        contractMapper.deleteByExhibitionId(exhibition.getExhibitionId().longValue());
        showMapper.deleteByExhibitionId(exhibition.getExhibitionId().longValue());
        exhibitionMapper.deleteById(exhibition.getExhibitionId().longValue());
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
