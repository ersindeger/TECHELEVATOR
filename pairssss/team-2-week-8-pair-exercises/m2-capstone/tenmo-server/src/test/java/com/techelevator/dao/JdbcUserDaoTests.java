package com.techelevator.dao;

import com.techelevator.tenmo.dao.JdbcTransferDao;
import com.techelevator.tenmo.dao.JdbcUserDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDaoTests extends BaseDaoTests {
    protected static final User USER_1 = new User(1001, "user1", "user1", "USER");
    protected static final User USER_2 = new User(1002, "user2", "user2", "USER");
    private static final User USER_3 = new User(1003, "user3", "user3", "USER");

    private JdbcUserDao sut;
    private JdbcTransferDao transSut;


    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcUserDao(jdbcTemplate);
        transSut = new JdbcTransferDao(jdbcTemplate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findIdByUsername_given_null_throws_exception() {
        sut.findIdByUsername(null);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void findIdByUsername_given_invalid_username_throws_exception() {
        sut.findIdByUsername("invalid");
    }

    @Test
    public void findIdByUsername_given_valid_user_returns_user_id() {
        int actualUserId = sut.findIdByUsername(USER_1.getUsername());

        Assert.assertEquals(USER_1.getId(), actualUserId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByUsername_given_null_throws_exception() {
        sut.findByUsername(null);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void findByUsername_given_invalid_username_throws_exception() {
        sut.findByUsername("invalid");
    }

    @Test
    public void findByUsername_given_valid_user_returns_user() {
        User actualUser = sut.findByUsername(USER_1.getUsername());

        Assert.assertEquals(USER_1, actualUser);
    }

    @Test
    public void getUserById_given_invalid_user_id_returns_null() {
        User actualUser = sut.getUserById(-1);

        Assert.assertNull(actualUser);
    }

    @Test
    public void getUserById_given_valid_user_id_returns_user() {
        User actualUser = sut.getUserById(USER_1.getId());

        Assert.assertEquals(USER_1, actualUser);
    }

//    @Test
//    public void findAll_returns_all_users() {
//        List<User> users = sut.findAll();
//
//        Assert.assertNotNull(users);
//        Assert.assertEquals(3, users.size());
//        Assert.assertEquals(USER_1, users.get(0));
//        Assert.assertEquals(USER_2, users.get(1));
//        Assert.assertEquals(USER_3, users.get(2));
//    }

    @Test(expected = DataIntegrityViolationException.class)
    public void create_user_with_null_username() {
        sut.create(null, USER_3.getPassword());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void create_user_with_existing_username() {
        sut.create(USER_1.getUsername(), USER_3.getPassword());
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_user_with_null_password() {
        sut.create(USER_3.getUsername(), null);
    }

    @Test
    public void create_user_creates_a_user() {
        User newUser = new User(-1, "new", "user", "USER");

        boolean userWasCreated = sut.create(newUser.getUsername(), newUser.getPassword());

        Assert.assertTrue(userWasCreated);

        User actualUser = sut.findByUsername(newUser.getUsername());
        newUser.setId(actualUser.getId());

        actualUser.setPassword(newUser.getPassword()); // reset password back to unhashed password for testing
        Assert.assertEquals(newUser, actualUser);
    }

    @Test
    public void create_a_transfer(){



    }

    @Test
    public void create_a_transfers() {
        Transfer transferTry = new Transfer();
        List<Transfer> transfers = new ArrayList<>();
        BigDecimal preBalance = transSut.getBalance("user1");
        transSut.createTransfer(1001, 1002, BigDecimal.valueOf(79.95));
        transSut.createTransfer(1001, 1002, BigDecimal.valueOf(60));
        BigDecimal balance = transSut.getBalance("user1");


        transfers = transSut.retrieveListOfAllTransfers(1001);


        Assert.assertEquals(balance, preBalance);


    }



    }
