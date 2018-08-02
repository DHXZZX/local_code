package com.dhxz.lock_sample.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@Entity
public class Customer extends AbstractEntity {

    String firstname,lastname;
    protected Customer(){
        this.firstname = null;
        this.lastname = null;
    }

}
