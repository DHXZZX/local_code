package com.dhxz.lock_sample.lock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MysqlLock {
    @Id
    @Column(name = "mysql_lock")
    private String lock;
}
