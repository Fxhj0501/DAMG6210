package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.ExhibitionGame;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExhibitionGameMapper extends BaseMapper<ExhibitionGame> {
    @Insert({
            "SET IDENTITY_INSERT Exhibition_Game ON;",
            "INSERT INTO Exhibition_Game (game_id, game_name, game_publisher, game_type, description, age_rating, booth_location) ",
            "VALUES (#{gameId}, #{gameName}, #{gamePublisher}, #{gameType}, #{description}, #{ageRating}, #{boothLocation});",
            "SET IDENTITY_INSERT Exhibition_Game OFF;"
    })
    int insert(ExhibitionGame exhibitionGame);

    @Delete("DELETE FROM Exhibition_Game WHERE game_id = #{gameId}")
    int deleteById(Long gameId);
}
