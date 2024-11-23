package com.dmdd.controller;

import com.dmdd.dao.Tickets;
import com.dmdd.mapper.TicketsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketsController {
    @Autowired
    private TicketsMapper ticketMapper;

    @GetMapping("/tickets")
    public PageInfo<Tickets> tickets(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        List<Tickets> tickets = ticketMapper.selectList(null);
        PageInfo<Tickets> pageInfo = new PageInfo<>(tickets);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/tickets/delete")
    public String deleteTickets(@RequestBody Tickets tickets) {
        ticketMapper.deleteById(tickets.getTicketId().longValue());
        return "delete success";
    }

    @PostMapping("/tickets/update")
    public String updateTickets(@RequestBody Tickets tickets) {
        ticketMapper.updateById(tickets);
        return "update success";
    }

    @PostMapping("/tickets/insert")
    public String insertTickets(@RequestBody Tickets tickets) {
        ticketMapper.insert(tickets);
        return "insert success";
    }
}
