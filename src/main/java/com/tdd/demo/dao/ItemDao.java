package com.tdd.demo.dao;

import com.tdd.demo.entity.Item;
import com.tdd.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemDao extends JpaRepository<Item, UUID> {
}
