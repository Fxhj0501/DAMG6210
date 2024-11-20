package com.dmdd.dao;

import lombok.Data;

import lombok.Data;

import javax.persistence.IdClass;
import java.time.LocalDateTime;

@Data
@IdClass(ShowPerformerID.class)
public class ShowPerformer {
    private Integer showId;
    private Integer performerId;
    private LocalDateTime performanceTime;
    private String performanceRole;
}


