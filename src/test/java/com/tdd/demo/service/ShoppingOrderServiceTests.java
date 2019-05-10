package com.tdd.demo.service;

import com.tdd.demo.dao.AddressDao;
import com.tdd.demo.dao.ItemDao;
import com.tdd.demo.dao.ShoppingOrderDao;
import com.tdd.demo.dao.UserDao;
import com.tdd.demo.entity.Address;
import com.tdd.demo.entity.ShoppingOrder;
import com.tdd.demo.stub.StubAddress;
import com.tdd.demo.stub.StubItem;
import com.tdd.demo.stub.StubShoppingOrder;
import com.tdd.demo.stub.StubUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingOrderServiceTests {

    @Autowired
    private ShoppingOrderService shoppingOrderService;

    @Autowired
    private UserDao userDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private StubUser stubUser;
    @Autowired
    private StubAddress stubAddress;
    @Autowired
    private StubItem stubItem;
    @Autowired
    private StubShoppingOrder stubShoppingOrder;


    @Test
    public void test_saveShoppingOrder() {
        userDao.save(stubUser.stub(1));
        addressDao.save(stubAddress.stub(1));
        itemDao.save(stubItem.stub(1));
        itemDao.save(stubItem.stub(2));
        itemDao.save(stubItem.stub(3));

        ShoppingOrder shoppingOrder = shoppingOrderService.save(stubShoppingOrder.stub(1));

        ShoppingOrder expectedShoppingOrder = stubShoppingOrder.stub(1);
        expectedShoppingOrder.setId(shoppingOrder.getId());

        assertEquals(expectedShoppingOrder, shoppingOrder);
    }
}
