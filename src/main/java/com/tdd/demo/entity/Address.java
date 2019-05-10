package com.tdd.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    private User user;

    private String city;
    private String street;
    private int building;

}
