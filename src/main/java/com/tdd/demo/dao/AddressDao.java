package com.tdd.demo.dao;

import com.tdd.demo.entity.Address;
import com.tdd.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressDao extends JpaRepository<Address, UUID> {
}
