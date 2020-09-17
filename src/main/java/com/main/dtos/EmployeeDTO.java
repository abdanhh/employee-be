package com.main.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
@Data
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    private String nik;

    private String name;

    private long divisionId;

    private long positionId;

    private String type;

    private long lastPosition;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssXXX")
    private Date createdDate;

}
