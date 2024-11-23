package com.dmdd.dao;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Show")
@Data
public class Show {

    @TableId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private Integer exhibitionId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date schedule;

    @Column(length = 255)
    private String showDescription;

    private Integer duration;

    @Column(length = 10)
    private String ageRestriction;

    private Integer capacity;

    // Getters and Setters
}