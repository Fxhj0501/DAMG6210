package com.dmdd.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Orders {
    private Integer orderId;
    private Integer customerId;
    private BigDecimal orderAmount;
    private String billingAddress;
    private LocalDate orderDate;
    private String orderStatus;
    private BigDecimal discountApplied;
}
