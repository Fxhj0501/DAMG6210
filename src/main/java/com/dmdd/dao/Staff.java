package com.dmdd.dao;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Staff {
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffId;

    private String staffName;

    private String phoneNo;

    private LocalDate joiningDate;

    private String shiftSchedule;

    private BigDecimal salary;

    private String emergencyContact;

    private String position;
}