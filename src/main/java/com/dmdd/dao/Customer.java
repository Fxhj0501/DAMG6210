package com.dmdd.dao;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(nullable = false, length = 100)
    private String customerName;

    @Column(length = 15)
    private String phoneNo;

    @Column(length = 100)
    private String email;

    @Column(length = 255)
    private String address;

    private Integer age;

    @Column(length = 20)
    private String gender;

    // Getters and Setters
}