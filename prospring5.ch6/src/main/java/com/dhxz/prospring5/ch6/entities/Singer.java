package com.dhxz.prospring5.ch6.entities;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Builder
@Accessors(fluent = true,chain = true)
public class Singer implements Serializable{
    private static final long serialVersionUID = 3131103050116804567L;
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<Album> albums;
}
