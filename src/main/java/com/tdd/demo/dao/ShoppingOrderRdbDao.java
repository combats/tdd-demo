package com.tdd.demo.dao;

import com.tdd.demo.entity.ShoppingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ShoppingOrderRdbDao implements ShoppingOrderDao {

    @Autowired
    private ShoppingOrderJpaDao shoppingOrderJpaDao;

    public ShoppingOrder save(ShoppingOrder shoppingOrder) {
        return shoppingOrderJpaDao.save(shoppingOrder);
    }

    public interface ShoppingOrderJpaDao extends JpaRepository<ShoppingOrder, UUID> {
    }

}
