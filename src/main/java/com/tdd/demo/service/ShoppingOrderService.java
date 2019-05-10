package com.tdd.demo.service;

import com.tdd.demo.dao.ShoppingOrderDao;
import com.tdd.demo.entity.ShoppingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingOrderService {

    @Autowired
    private ShoppingOrderDao shoppingOrderDao;

    public ShoppingOrder save(ShoppingOrder shoppingOrder) {
        return shoppingOrderDao.save(shoppingOrder);
    }
}
