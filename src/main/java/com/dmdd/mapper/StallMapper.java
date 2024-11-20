package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.Stall;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Mapper
public interface StallMapper extends BaseMapper<Stall> {
    @Insert({
            "SET IDENTITY_INSERT Stall ON;",
            "INSERT INTO Stall (stall_id, exhibition_id, game_id, section_number, stall_description, no_of_employees, size_sqft, stall_location, rental_cost, equipment_provided) ",
            "VALUES (#{stallId}, #{exhibitionId}, #{gameId}, #{sectionNumber}, #{stallDescription}, #{noOfEmployees}, #{sizeSqft}, #{stallLocation}, #{rentalCost}, #{equipmentProvided});",
            "SET IDENTITY_INSERT Stall OFF;"
    })
    int insert(Stall stall);

    @Delete("DELETE FROM Sponsor WHERE stall_id = #{stallId}")
    int deleteById(@Param("stallId") Long stallId);

    @Query("SELECT * FROM Stall WHERE exhibition_id = #{exhibitionId}")
    List<Stall> findByExhibitionId(@Param("exhibitionId") Long exhibitionId);

    @Query("SELECT * FROM Stall WHERE game_id = #{gameId}")
    List<Stall> findByGameId(@Param("gameId") Long gameId);

}
