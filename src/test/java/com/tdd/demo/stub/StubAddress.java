package com.tdd.demo.stub;

import com.tdd.demo.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StubAddress {

    @Autowired
    private StubUser stubUser;

    public Address stub(int id) {
        Address address = new Address();
        address.setId(UUID.fromString("00000000-0000-0000-0000-00000000000" + id));
        address.setUser(stubUser.stub(id));
        address.setCity("Kiev");
        address.setStreet("Heroiv Dnipra");
        address.setBuilding(id);
        return address;
    }
}
