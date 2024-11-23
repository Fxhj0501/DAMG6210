package com.dmdd.dao;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Exhibition")
@Data
public class Exhibition {

    @TableId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exhibitionId;

    @Column(nullable = false, length = 100)
    private String exhibitionName;

    @Column(nullable = false, length = 100)
    private String locationName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(length = 255)
    private String description;

    private Integer maxCapacity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDeadline;

}

