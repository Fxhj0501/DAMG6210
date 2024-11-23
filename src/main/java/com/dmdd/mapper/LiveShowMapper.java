package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.LiveShow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LiveShowMapper extends BaseMapper<LiveShow> {
    @Insert({
            "INSERT INTO Live_Show (performer_id, equipment_needs) ",
            "VALUES (#{performerId}, #{equipmentNeeds})"
    })
    int insertLiveShow(LiveShow liveShow);


    @Delete("DELETE FROM Live_Show WHERE performer_id = #{performerId}")
    int deleteById(Long performerId);

}
