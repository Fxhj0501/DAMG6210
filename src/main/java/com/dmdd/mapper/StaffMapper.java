package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.Staff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StaffMapper extends BaseMapper<Staff> {
    @Insert({
            "SET IDENTITY_INSERT Staff ON;",
            "INSERT INTO Staff (staff_id, staff_name, phone_no, joining_date, shift_schedule, salary, emergency_contact, position) ",
            "VALUES (#{staffId}, #{staffName}, #{phoneNo}, #{joiningDate}, #{shiftSchedule}, #{salary}, #{emergencyContact}, #{position});",
            "SET IDENTITY_INSERT Staff OFF;"
    })
    int insert(Staff staff);

    @Delete("DELETE FROM Sponsor WHERE staff_id = #{staffId}")
    int deleteById(@Param("staffId") Long staffId);
}
