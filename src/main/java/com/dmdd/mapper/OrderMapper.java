package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
    @Insert({
            "SET IDENTITY_INSERT Order ON;",
            "INSERT INTO Orders (customer_id, order_amount, billing_address, order_date, order_status, discount_applied) ",
            "VALUES (#{customerId}, #{orderAmount}, #{billingAddress}, #{orderDate}, #{orderStatus}, #{discountApplied})",
            "SET IDENTITY_INSERT Order OFF;"
    })
    int insertOrder(Orders order);

    @Delete("DELETE FROM Orders WHERE order_id = #{orderId}")
    int deleteById(Long orderId);

}
