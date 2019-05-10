package com.tdd.demo.service;

import com.tdd.demo.dao.ShoppingOrderDao;
import com.tdd.demo.entity.ShoppingOrder;
import com.tdd.demo.stub.StubShoppingOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("in-memory-database")
public class ShoppingOrderServiceInMemoryTests {

    @Autowired
    private ShoppingOrderService shoppingOrderService;

    @Autowired
    private StubShoppingOrder stubShoppingOrder;

    @Autowired
    private ShoppingOrderDao shoppingOrderDao;

    @Test
    public void test_saveShoppingOrder() {
        ShoppingOrder shoppingOrder = shoppingOrderService.save(stubShoppingOrder.stub(1));

        assertEquals(stubShoppingOrder.stub(10), shoppingOrder);
    }
}
