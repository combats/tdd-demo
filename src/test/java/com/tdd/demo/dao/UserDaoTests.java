package com.tdd.demo.dao;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import com.tdd.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DBRider
public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    @Test
    @ExpectedDataSet("db-rider/expected-user-1.xml")
    public void test_saveUser() {
        User user = new User();
        user.setName("Test user name #1");
        userDao.save(user);
    }

    @Test
    @DataSet("db-rider/user-1.xml")
    public void test_updateUser() {
        User user = new User();
        user.setId(UUID.fromString("00000000-0000-0000-0000-000000000001"));
        user.setName("updated user Name");
        User updatedUser = userDao.save(user);
        assertEquals("updated user Name", updatedUser.getName());
    }
}