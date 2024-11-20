package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.ShowPerformer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShowPerformerMapper extends BaseMapper<ShowPerformer> {
    @Delete("DELETE FROM Show_Performer WHERE performer_id = #{performerId}")
    int deleteByPerformerId(Long performerId);

    @Delete("DELETE FROM Show_Performer WHERE show_id = #{showId}")
    int deleteByShowId(Long showId);

    @Delete("DELETE FROM Show_Performer WHERE performer_id = #{performerId} AND show_id = #{showId}")
    int deleteByPerformerIdAndShowId(Long performerId, Long showId);
}
