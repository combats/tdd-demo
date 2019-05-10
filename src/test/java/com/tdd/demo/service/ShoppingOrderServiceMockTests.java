package com.tdd.demo.service;

import com.tdd.demo.dao.AddressDao;
import com.tdd.demo.dao.ItemDao;
import com.tdd.demo.dao.ShoppingOrderDao;
import com.tdd.demo.dao.UserDao;
import com.tdd.demo.entity.ShoppingOrder;
import com.tdd.demo.stub.StubAddress;
import com.tdd.demo.stub.StubItem;
import com.tdd.demo.stub.StubShoppingOrder;
import com.tdd.demo.stub.StubUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingOrderServiceMockTests {

    @Autowired
    private ShoppingOrderService shoppingOrderService;

    @Autowired
    private StubShoppingOrder stubShoppingOrder;

    @MockBean
    private ShoppingOrderDao shoppingOrderDao;

    @Test
    public void test_saveShoppingOrder() {
        when(shoppingOrderDao.save(stubShoppingOrder.stub(1))).thenReturn(stubShoppingOrder.stub(10));

        ShoppingOrder shoppingOrder = shoppingOrderService.save(stubShoppingOrder.stub(1));

        assertEquals(stubShoppingOrder.stub(10), shoppingOrder);
    }
}
