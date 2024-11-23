package com.dmdd.dao;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Customer")
@Data
public class Customer {
    @TableId
    private Integer customerId;
    private String customerEmail;
    private LocalDate registrationDate;
    private String customerName;
    private Integer customerAge;
    private String selectedGenres;
}