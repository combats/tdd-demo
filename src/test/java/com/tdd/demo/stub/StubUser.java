package com.tdd.demo.stub;

import com.tdd.demo.entity.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StubUser {

    public User stub(int id) {
        User user = new User();
        user.setId(UUID.fromString("00000000-0000-0000-0000-00000000000" + id));
        user.setName("Test user name #" + id);
        return user;
    }

}
