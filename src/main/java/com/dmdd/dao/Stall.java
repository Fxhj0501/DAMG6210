package com.dmdd.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class Stall {
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stallId;
    private Integer exhibitionId;
    private Integer gameId;
    private Integer sectionNumber;
    private String stallDescription;
    private Integer noOfEmployees;
    private Double sizeSqft;
    private String stallLocation;
    private Double rentalCost;
    private String equipmentProvided;
}

