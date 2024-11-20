package com.dmdd.controller;

import com.dmdd.dao.ExhibitionGame;
import com.dmdd.dao.Stall;
import com.dmdd.mapper.ExhibitionGameMapper;
import com.dmdd.mapper.StallMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExhibitionGameController {
    @Autowired
    private ExhibitionGameMapper exhibitionGameMapper;
    @Autowired
    private StallMapper stallMapper;

    @GetMapping("/exhibitionGame")
    public PageInfo<ExhibitionGame> exhibitionGame(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<ExhibitionGame> exhibitionGames = exhibitionGameMapper.selectList(null);
        PageInfo<ExhibitionGame> pageInfo = new PageInfo<>(exhibitionGames);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/exhibitionGame/delete")
    public String deleteExhibitionGame(@RequestBody ExhibitionGame exhibitionGame) {
        System.out.println("delete exhibitionGame id: " + exhibitionGame.getGameId());
        List<Stall> stalls = stallMapper.findByGameId(exhibitionGame.getGameId().longValue());
        //Set game id to null in all relative stalls
        for(Stall stall: stalls){
            stall.setGameId(null);
            stallMapper.updateById(stall);
        }
        exhibitionGameMapper.deleteById(exhibitionGame.getGameId().longValue());
        return "delete success";
    }

    @PostMapping("/exhibitionGame/update")
    public String updateExhibitionGame(@RequestBody ExhibitionGame exhibitionGame){
        System.out.println("update exhibitionGame id: " + exhibitionGame.getGameId());
        exhibitionGameMapper.updateById(exhibitionGame);
        return "update success";
    }

    @PostMapping("/exhibitionGame/insert")
    public String insertExhibitionGame(@RequestBody ExhibitionGame exhibitionGame){
        System.out.println("insert exhibitionGame id: " + exhibitionGame.getGameId());
        exhibitionGameMapper.insert(exhibitionGame);
        return "insert success";
    }
}
