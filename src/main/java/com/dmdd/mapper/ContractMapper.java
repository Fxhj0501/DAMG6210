package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.Contract;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContractMapper extends BaseMapper<Contract> {
    @Delete("DELETE FROM Contract WHERE sponsor_id = #{sponsorId}")
    int deleteBySponsorId(@Param("sponsorId") Long sponsorId);

    @Delete("DELETE FROM Contract WHERE exhibition_id = #{exhibitionId}")
    int deleteByExhibitionId(@Param("exhibitionId") Long exhibitionId);

    @Delete("DELETE FROM Contract WHERE sponsor_id = #{sponsorId} AND exhibition_id = #{exhibitionId}")
    int deleteBySponsorIdAndExhibitionId(@Param("sponsorId") Long sponsorId, @Param("exhibitionId") Long exhibitionId);

    @Insert("INSERT INTO Contract (sponsor_id, exhibition_id, contract_start_date, contract_end_date) VALUES (#{sponsorId}, #{exhibitionId}, #{contractStartDate}, #{contractEndDate})")
    int insert(Contract contract);
}
