package com.dmdd.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Live_Show")
@Data
public class LiveShow {

    @Id
    private Integer performerId;

    @Column(length = 255)
    private String equipmentNeeds;

    // Getters and Setters
}
