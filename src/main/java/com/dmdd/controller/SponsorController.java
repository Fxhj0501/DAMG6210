package com.dmdd.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmdd.dao.Exhibition;
import com.dmdd.dao.Sponsor;
import com.dmdd.mapper.ContractMapper;
import com.dmdd.mapper.SponsorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
public class SponsorController {

    @Autowired
    private SponsorMapper sponsorMapper;

    @Autowired
    private ContractMapper contractMapper;

    @GetMapping("/sponsor")
    public PageInfo<Sponsor> sponsor(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Sponsor> sponsors = sponsorMapper.selectList(null);
        PageInfo<Sponsor> pageInfo = new PageInfo<>(sponsors);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/sponsor/delete")
    public String deleteSponsor(@RequestBody Sponsor sponsor) {
        System.out.println("delete sponsor id: " + sponsor.getSponsorId());
        System.out.println("delete sponsor name: " + sponsor.getSponsorName());
        contractMapper.deleteBySponsorId(sponsor.getSponsorId().longValue());
        sponsorMapper.deleteById(sponsor.getSponsorId().longValue());
        return "delete success";
    }

    @PostMapping("/sponsor/update")
    public String updateSponsor(@RequestBody Sponsor sponsor) {
        System.out.println("update sponsor id: " + sponsor.getSponsorId());
        System.out.println("update sponsor name: " + sponsor.getSponsorName());
        sponsorMapper.updateById(sponsor);
        return "update success";
    }

    @PostMapping("/sponsor/insert")
    public String insertSponsor(@RequestBody Sponsor sponsor) {
        System.out.println("insert sponsor id: " + sponsor.getSponsorId());
        System.out.println("insert sponsor name: " + sponsor.getSponsorName());
        System.out.println("insert sponsor address: " + sponsor.getDescription());
        sponsorMapper.insert(sponsor);
        return "insert success";
    }

}
