package com.main.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "division", schema = "public")
@Data
@NoArgsConstructor
public class Division implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

}
