package com.dmdd.dao;

import javax.persistence.*;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.dmdd.dao.ContractId;
import lombok.Data;

@Entity
@Table(name = "Contract")
@IdClass(ContractId.class)
@Data
public class Contract {

    @Id
    private Integer sponsorId;

    @Id
    private Integer exhibitionId;

    @Temporal(TemporalType.DATE)
    private Date contractStartDate;

    @Temporal(TemporalType.DATE)
    private Date contractEndDate;

    // Getters and Setters
}

