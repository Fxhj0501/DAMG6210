package com.dmdd.dao;

import lombok.Data;

import java.util.Date;

@Data
public class StallStaff {
    private Integer stallId;
    private Integer staffId;
    private Date assignmentStartDate;
    private Date assignmentEndDate;
}
