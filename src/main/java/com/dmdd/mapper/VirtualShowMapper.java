package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.VirtualShow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VirtualShowMapper extends BaseMapper<VirtualShow> {
    @Insert({"SET IDENTITY_INSERT Exhibition_Game ON;",
            "INSERT INTO Virtual_Show (performer_id, virtual_platform, internet_needs) ",
            "VALUES (#{performerId}, #{virtualPlatform}, #{internetNeeds})",
            "SET IDENTITY_INSERT Exhibition_Game OFF;"
    })
    int insertVirtualShow(VirtualShow virtualShow);

    @Delete("DELETE FROM Virtual_Show WHERE performer_id = #{performerId}")
    int deleteById(Long performerId);

}
