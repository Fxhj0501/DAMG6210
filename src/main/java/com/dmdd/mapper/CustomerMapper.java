package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    @Insert({
            "SET IDENTITY_INSERT Customer ON;",
            "INSERT INTO Customer (customer_email, registration_date, customer_name, customer_age, selected_genres) ",
            "VALUES (#{customerEmail}, #{registrationDate}, #{customerName}, #{customerAge}, #{selectedGenres})",
            "SET IDENTITY_INSERT Customer OFF;"
    })
    int insert(Customer customer);
}
