package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.StallStaff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StallStaffMapper extends BaseMapper<StallStaff> {
    @Delete("DELETE FROM StallStaff WHERE staff_id = #{staffId}")
    int deleteByStaffId(Long staffId);

    @Delete("DELETE FROM StallStaff WHERE stall_id = #{stallId}")
    int deleteByStallId(Long stallId);

    @Delete("DELETE FROM StallStaff WHERE staff_id = #{staffId} AND stall_id = #{stallId}")
    int deleteByStaffIdAndStallId(Long staffId, Long stallId);
}
