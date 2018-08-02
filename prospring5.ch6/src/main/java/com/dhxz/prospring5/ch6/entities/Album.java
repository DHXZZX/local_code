package com.dhxz.prospring5.ch6.entities;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@Accessors(fluent = true,chain = true)
public class Album implements Serializable{
    private static final long serialVersionUID = -3011992159018065600L;
    private Long id;
    private Long singerId;
    private String title;
    private Date releaseDate;
}
