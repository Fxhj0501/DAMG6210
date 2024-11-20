package com.dmdd.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Data
public class Tickets {
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private Integer exhibitionId;
    private Integer orderId;
    private String ticketType;
    private Double ticketPrice;
    private Date saleStartDate;
    private Date saleEndDate;
    private String qrCode;
    private Integer maxTicketsPerOrder;
    private String refundPolicy;
}
