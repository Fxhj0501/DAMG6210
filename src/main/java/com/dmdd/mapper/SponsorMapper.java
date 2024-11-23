package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.Exhibition;
import com.dmdd.dao.Sponsor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SponsorMapper extends BaseMapper<Sponsor>{
    @Delete("DELETE FROM Sponsor WHERE sponsor_id = #{sponsorId}")
    int deleteById(@Param("sponsorId") Long sponsorId);

    @Insert({
            "SET IDENTITY_INSERT Sponsor ON;",
            "INSERT INTO Sponsor (sponsor_id, sponsor_name, description, contact_person, sponsorship_level, logo_url, contract_start_date, contract_end_date) ",
            "VALUES (#{sponsorId}, #{sponsorName}, #{description}, #{contactPerson}, #{sponsorshipLevel}, #{logoUrl}, #{contractStartDate}, #{contractEndDate});",
            "SET IDENTITY_INSERT Sponsor OFF;"
    })
    int insert(Sponsor sponsor);
}
