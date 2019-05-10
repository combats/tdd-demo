package com.tdd.demo.stub;

import com.tdd.demo.entity.Address;
import com.tdd.demo.entity.Item;
import com.tdd.demo.entity.ShoppingOrder;
import com.tdd.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class StubShoppingOrder {

    @Autowired
    private StubUser stubUser;
    @Autowired
    private StubAddress stubAddress;
    @Autowired
    private StubItem stubItem;

    public ShoppingOrder stub(int id) {
        ShoppingOrder shoppingOrder = new ShoppingOrder();
        shoppingOrder.setUser(stubUser.stub(id));
        shoppingOrder.setAddress(stubAddress.stub(id));
        shoppingOrder.setItemList(stubItem.stubList(id, id + 3));
        shoppingOrder.setComment("Test shopping order comment #" + id);
        return shoppingOrder;
    }
}
