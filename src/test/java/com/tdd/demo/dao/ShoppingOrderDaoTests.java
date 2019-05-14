package com.tdd.demo.dao;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import com.tdd.demo.entity.Address;
import com.tdd.demo.entity.Item;
import com.tdd.demo.entity.ShoppingOrder;
import com.tdd.demo.entity.User;
import com.tdd.demo.stub.StubItem;
import com.tdd.demo.stub.StubShoppingOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DBRider
public class ShoppingOrderDaoTests {

    @Autowired
    private ShoppingOrderDao shoppingOrderDao;

    @Test
    @DataSet({
            "db-rider/user-1.xml",
            "db-rider/address-1.xml",
            "db-rider/item-1.xml",
            "db-rider/item-2.xml",
            "db-rider/item-3.xml",
    })
    @ExpectedDataSet("db-rider/expected-shoppingOrder-1.xml")
    public void test_saveShoppingOrder_simpleWay() {
        ShoppingOrder shoppingOrder = new ShoppingOrder();
        User user = new User();
        user.setId(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        user.setName("Test user name #1");
        Address address = new Address();
        address.setId(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        address.setUser(user);
        address.setCity("Kiev");
        address.setStreet("Heroiv Dnipra");
        address.setBuilding(15);
        Item item_1 = new Item();
        item_1.setId(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        item_1.setName("Item name #1");
        Item item_2 = new Item();
        item_2.setId(UUID.fromString("00000000-0000-0000-0000-000000000002"));
        item_2.setName("Item name #2");
        Item item_3 = new Item();
        item_3.setId(UUID.fromString("00000000-0000-0000-0000-000000000003"));
        item_3.setName("Item name #3");

        List<Item> itemList = new ArrayList<>();
        itemList.add(item_1);
        itemList.add(item_2);
        itemList.add(item_3);
        shoppingOrder.setUser(user);
        shoppingOrder.setAddress(address);
        shoppingOrder.setItemList(itemList);
        shoppingOrder.setComment("Test shopping order comment #1");

        ShoppingOrder savedOrder = shoppingOrderDao.save(shoppingOrder);
    }


    //It was half of the pain, now - imagine - you need partial update


    @Test
    @DataSet({
            "db-rider/shoppingOrder-1.xml",
            "db-rider/user-1.xml",
            "db-rider/address-1.xml",
            "db-rider/item-1.xml",
            "db-rider/item-2.xml",
            "db-rider/item-3.xml",
            "db-rider/item-4.xml"
    })
    public void test_updateShoppingOrder_simpleWay() {
        ShoppingOrder shoppingOrder = new ShoppingOrder();
        Item additional_item_4 = new Item();
        additional_item_4.setId(UUID.fromString("00000000-0000-0000-0000-000000000004"));
        additional_item_4.setName("Item name #4");

        List<Item> itemList = new ArrayList<>();
        itemList.add(additional_item_4);
        shoppingOrder.setId(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        shoppingOrder.setItemList(itemList);
        shoppingOrder.setComment("Updated Test shopping order comment #1");

        ShoppingOrder updatedOrder = shoppingOrderDao.save(shoppingOrder);


        ShoppingOrder expectedShoppingOrder = new ShoppingOrder();
        User user = new User();
        user.setId(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        user.setName("Test user name #1");
        Address address = new Address();
        address.setId(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        address.setUser(user);
        address.setCity("Kiev");
        address.setStreet("Heroiv Dnipra");
        address.setBuilding(15);
        Item item_1 = new Item();
        item_1.setId(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        item_1.setName("Item name #1");
        Item item_2 = new Item();
        item_2.setId(UUID.fromString("00000000-0000-0000-0000-000000000002"));
        item_2.setName("Item name #2");
        Item item_3 = new Item();
        item_3.setId(UUID.fromString("00000000-0000-0000-0000-000000000003"));
        item_3.setName("Item name #3");
        Item item_4 = new Item();
        item_4.setId(UUID.fromString("00000000-0000-0000-0000-000000000004"));
        item_4.setName("Item name #4");

        List<Item> updatedItemList = new ArrayList<>();
        updatedItemList.add(item_1);
        updatedItemList.add(item_2);
        updatedItemList.add(item_4);
        expectedShoppingOrder.setUser(user);
        expectedShoppingOrder.setAddress(address);
        expectedShoppingOrder.setItemList(updatedItemList);
        expectedShoppingOrder.setComment("Updated Test shopping order comment #1");


        assertEquals(expectedShoppingOrder, updatedOrder);
    }




    //I have some stubs for you

    @Autowired
    private StubShoppingOrder stubShoppingOrder;
    @Autowired
    private StubItem stubItem;


    @Test
    @DataSet({
            "db-rider/user-1.xml",
            "db-rider/address-1.xml",
            "db-rider/item-1.xml",
            "db-rider/item-2.xml",
            "db-rider/item-3.xml",
    })
    @ExpectedDataSet("db-rider/expected-shoppingOrder-1.xml")
    public void test_saveShoppingOrder_stubWay() {
        ShoppingOrder savedOrder = shoppingOrderDao.save(stubShoppingOrder.stub(1));
    }


    //It was half of the pain, now - imagine - you need parial update


    @Test
    @DataSet({
            "db-rider/shoppingOrder-1.xml",
            "db-rider/user-1.xml",
            "db-rider/address-1.xml",
            "db-rider/item-1.xml",
            "db-rider/item-2.xml",
            "db-rider/item-3.xml",
            "db-rider/item-4.xml"
    })
    public void test_updateShoppingOrder_stubWay() {
        ShoppingOrder shoppingOrder = new ShoppingOrder();

        List<Item> itemList = new ArrayList<>();
        itemList.add(stubItem.stub(4));
        shoppingOrder.setId(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        shoppingOrder.setItemList(itemList);
        shoppingOrder.setComment("Updated Test shopping order comment #1");


        ShoppingOrder updatedOrder = shoppingOrderDao.save(shoppingOrder);


        ShoppingOrder expectedShoppingOrder = stubShoppingOrder.stub(1);
        expectedShoppingOrder.setItemList(stubItem.stubList(1, 4));
        expectedShoppingOrder.setComment("Updated Test shopping order comment #1");

        assertEquals(expectedShoppingOrder, updatedOrder);
    }


}