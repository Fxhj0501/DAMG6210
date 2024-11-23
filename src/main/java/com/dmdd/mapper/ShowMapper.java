package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.Show;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShowMapper extends BaseMapper<Show>  {
    @Insert({
            "SET IDENTITY_INSERT Show ON;",
            "INSERT INTO Show (exhibition_id, schedule, show_description, duration, age_restriction, capacity) ",
            "VALUES (#{exhibitionId}, #{schedule}, #{showDescription}, #{duration}, #{ageRestriction}, #{capacity})",
            "SET IDENTITY_INSERT Show OFF;"
    })
    int insertShow(Show show);

    @Select("SELECT * FROM Show WHERE exhibition_id = #{exhibitionId}")
    List<Show> findByExhibitionId(@Param("exhibitionId") Long exhibitionId);

    @Delete("DELETE FROM Show WHERE exhibition_id = #{exhibitionId}")
    int deleteByExhibitionId(@Param("exhibitionId") Long exhibitionId);

    @Select("SELECT show_id, exhibition_id, schedule, show_description, duration, age_restriction, capacity " +
            "FROM [show]")
    List<Show> selectAllShows();

    @Select("SELECT show_id, exhibition_id, schedule, show_description, duration, age_restriction, capacity " +
            "FROM [show] " +
            "ORDER BY show_id " +
            "OFFSET #{offset} ROWS FETCH NEXT #{size} ROWS ONLY")
    List<Show> selectPagedShows(@Param("offset") int offset, @Param("size") int size);


}
