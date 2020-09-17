package com.main.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PositionDTO {

    private long id;
    private String name;
    private long level;
}
