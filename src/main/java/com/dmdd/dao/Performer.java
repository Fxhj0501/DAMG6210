package com.dmdd.dao;
import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "Performer")
@Data
public class Performer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer performerId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 15)
    private String contactInfoPhoneNo;

    @Column(length = 100)
    private String contactInfoEmail;

    @Column(length = 50)
    private String performanceType;

    private Integer duration;

    @Column(length = 255)
    private String socialMediaHandles;

    // Getters and Setters
}