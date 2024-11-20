package com.dmdd.controller;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TableController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/{tableName}/fields")
    public List<String> getTableFields(@PathVariable String tableName) {
        String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?";
        return jdbcTemplate.query(sql, new Object[]{tableName}, (rs, rowNum) -> rs.getString("COLUMN_NAME"));
    }

    @GetMapping("/getTables")
    public List<String> getAllTableNames() {
        String sql = "SELECT TABLE_NAME " +
                "FROM INFORMATION_SCHEMA.TABLES " +
                "WHERE TABLE_SCHEMA = 'DDMDProject'";

        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("TABLE_NAME"));
    }
}

