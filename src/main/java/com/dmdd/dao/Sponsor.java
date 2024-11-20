package com.dmdd.dao;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sponsor {

    @TableId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonAlias("sponsorId")
    private Integer sponsorId;

    @Column(nullable = false, length = 100)
    private String sponsorName;

    @Column(length = 255)
    private String description;

    @Column(length = 100)
    private String contactPerson;

    @Column(length = 50)
    private String sponsorshipLevel;

    @Column(length = 255)
    private String logoUrl;

    @Temporal(TemporalType.DATE)
    private Date contractStartDate;

    @Temporal(TemporalType.DATE)
    private Date contractEndDate;
}
