package com.main.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RequestDTO {

    private long id;

    private String nik;

    private String name;

    private long divisionId;

    private long positionId;

    private String type;

    private String lastPosition;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date createdDate;

}
