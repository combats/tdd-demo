package com.tdd.demo.controller;

import com.tdd.demo.entity.ShoppingOrder;
import com.tdd.demo.service.ShoppingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ShoppingOrderController {

    @Autowired
    private ShoppingOrderService shoppingOrderService;

    @RequestMapping(method = POST, value = "/order")
    public ShoppingOrder create(@RequestBody ShoppingOrder shoppingOrder) {
        return shoppingOrderService.save(shoppingOrder);
    }
}
