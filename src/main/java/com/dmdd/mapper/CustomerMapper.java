package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    @Insert({
            "SET IDENTITY_INSERT Customer ON;",
            "INSERT INTO Customer (customer_id,customer_email, registration_date, customer_name, customer_age, selected_genres) ",
            "VALUES (#{customerId}, #{customerEmail}, #{registrationDate}, #{customerName}, #{customerAge}, #{selectedGenres})",
            "SET IDENTITY_INSERT Customer OFF;"
    })
    int insert(Customer customer);

    @Select("SELECT customer_id, " +
            "       CAST(DecryptByKey(customer_email) AS NVARCHAR(MAX)) AS customer_email, " +
            "       registration_date, " +
            "       customer_name, " +
            "       customer_age, " +
            "       selected_genres " +
            "FROM Customer")
    List<Customer> selectDecryptedCustomerList();




}
