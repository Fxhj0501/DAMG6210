package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.Performer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PerformerMapper extends BaseMapper<Performer> {
    @Insert({
            "INSERT INTO Performer (performer_id, performer_name, performer_type, performer_description) ",
            "VALUES (#{performerId}, #{performerName}, #{performerType}, #{performerDescription});"
    })
    void insertWithId(Performer performer);
}
