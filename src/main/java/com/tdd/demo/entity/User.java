package com.tdd.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
}