package com.tdd.demo.stub;

import com.tdd.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class StubItem {

    public Item stub(int id) {
        Item item = new Item();
        item.setId(UUID.fromString("00000000-0000-0000-0000-00000000000" + id));
        item.setName("Item name #" + id);
        return item;
    }

    public List<Item> stubList(int idFrom, int idTo) {
        List<Item> itemList = new ArrayList<>();
        for(int i = idFrom; i <= idTo; i++) {
            itemList.add(stub(i));
        }
        return itemList;
    }
}
