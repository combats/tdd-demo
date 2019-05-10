package com.tdd.demo.dao;

import com.tdd.demo.entity.ShoppingOrder;
import com.tdd.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShoppingOrderDao {

    ShoppingOrder save(ShoppingOrder shoppingOrder);
}