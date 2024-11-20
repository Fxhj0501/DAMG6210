package com.dmdd.controller;

import com.dmdd.dao.Contract;
import com.dmdd.mapper.ContractMapper;
import com.dmdd.mapper.ExhibitionMapper;
import com.dmdd.mapper.SponsorMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractController {
    @Autowired
    private SponsorMapper sponsorMapper;

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private ExhibitionMapper exhibitionMapper;

    @GetMapping("/contract")
    public PageInfo<Contract> contract(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Contract> contracts = contractMapper.selectList(null);
        PageInfo<Contract> pageInfo = new PageInfo<>(contracts);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/contract/delete")
    public String deleteContract(@RequestBody Contract contract) {
        System.out.println("delete contract id: " + contract.getExhibitionId());
        System.out.println("delete contract name: " + contract.getSponsorId());
        contractMapper.deleteBySponsorIdAndExhibitionId(contract.getSponsorId().longValue(), contract.getExhibitionId().longValue());
        return "delete success";
    }

    @PostMapping("/contract/insert")
    public String insertContract(@RequestBody Contract contract) {
        System.out.println("insert contract id: " + contract.getExhibitionId());
        System.out.println("insert contract name: " + contract.getSponsorId());
        contractMapper.insert(contract);
        return "insert success";
    }

}
