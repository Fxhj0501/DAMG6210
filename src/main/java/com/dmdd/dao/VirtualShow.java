package com.dmdd.dao;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class VirtualShow {
    @TableId
    private Integer performerId;
    private String virtualPlatform;
    private String internetNeeds;
}