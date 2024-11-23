package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.Exhibition;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ExhibitionMapper extends BaseMapper<Exhibition> {

    // 插入指定主键
    @Insert({
            "SET IDENTITY_INSERT Exhibition ON;",
            "INSERT INTO Exhibition (exhibition_id, exhibition_name, location_name, start_time, end_time, description,max_capacity,registration_deadline) ",
            "VALUES (#{exhibitionId}, #{exhibitionName}, #{locationName}, #{startTime}, #{endTime}, #{description},#{maxCapacity},#{registrationDeadline});",
            "SET IDENTITY_INSERT Exhibition OFF;"
    })
    void insertWithId(Exhibition exhibition);

    // 插入自动生成主键
    @Insert({
            "INSERT INTO Exhibition (exhibition_name, location_name, start_time, end_time, description) ",
            "VALUES (#{exhibitionName}, #{locationName}, #{startTime}, #{endTime}, #{description});"
    })
    void insertWithoutId(Exhibition exhibition);

    @Delete("DELETE FROM Exhibition WHERE exhibition_id = #{exhibitionId}")
    void deleteById(@Param("exhibitionId") Integer exhibitionId);

    @Select("SELECT * FROM Exhibition WHERE exhibition_id = #{exhibitionId}")
    Exhibition selectById(@Param("exhibitionId") Integer exhibitionId);
}
