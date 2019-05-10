package com.tdd.demo.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hibernate.annotations.CascadeType.ALL;

@Entity
@Data
public class ShoppingOrder {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    private User user;

    @OneToMany
    private List<Item> itemList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "address_id", unique = true, nullable = false)
    @Cascade(ALL)
    private Address address;

    private String comment;
}
