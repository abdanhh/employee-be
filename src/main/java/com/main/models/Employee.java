package com.main.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employee", schema = "public")
@Data
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @SequenceGenerator(name="employeeSeq", sequenceName="employee_seq", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSeq")
    @Column(name = "id", nullable=false, updatable=false)
    private long id;

    @Column(name = "nik")
    private String nik;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "division_id")
    private long divisionId;

    @Column(name = "position_id")
    private long positionId;

    @Column(name = "last_position")
    private long lastPosition;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;
}
