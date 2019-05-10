package com.tdd.demo.in_memory_dao;

import com.tdd.demo.dao.ShoppingOrderDao;
import com.tdd.demo.entity.ShoppingOrder;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("in-memory-database")
@Primary
public class ShoppingOrderInMemoryDao implements ShoppingOrderDao {

    List<ShoppingOrder> storage = new ArrayList<>();

    @Override
    public ShoppingOrder save(ShoppingOrder shoppingOrder) {
        storage.add(shoppingOrder);
        return shoppingOrder;
    }
}
