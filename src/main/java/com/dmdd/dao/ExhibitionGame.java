package com.dmdd.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Generated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class ExhibitionGame {
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;
    private String gameName;
    private String gamePublisher;
    private String gameType;
    private String description;
    private String ageRating;
    private String boothLocation;
}
