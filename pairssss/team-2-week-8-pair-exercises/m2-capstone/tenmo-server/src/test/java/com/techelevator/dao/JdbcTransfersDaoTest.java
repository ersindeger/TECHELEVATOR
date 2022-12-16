package com.techelevator.dao;

import com.techelevator.tenmo.dao.JdbcTransferDao;
import com.techelevator.tenmo.dao.JdbcUserDao;
import com.techelevator.tenmo.exceptions.TransferNotFoundException;
import com.techelevator.tenmo.model.Transfer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
//INSERT INTO tenmo_user (username,password_hash,role) VALUES ('joel','user6','ROLE_USER');
//        INSERT INTO tenmo_user (username,password_hash,role) VALUES ('ersin','user4','ROLE_USER');
//        INSERT INTO tenmo_user (username,password_hash,role) VALUES ('ian','user5','ROLE_USER');

public class JdbcTransfersDaoTest extends BaseDaoTests {
//    public Transfer(int transferId, BigDecimal amount, int userIdFrom, int userIdTo, String userFrom, String userTo);

    private final Transfer TRANSFER1 = new Transfer(3030, BigDecimal.valueOf(70.00), 1004, 10, "juan", "ersin"  );
    private final Transfer TRANSFER2 = new Transfer(3031, BigDecimal.valueOf(90.00), 1004, 1098, "erin ", ""  );
    private final Transfer TRANSFER3 = new Transfer(3033, BigDecimal.valueOf(97.00), 1005, 1097, "lust", "sin"  );

    private final Transfer TRANSFER4 = new Transfer(1090, 1087, BigDecimal.valueOf(79.55));

    private JdbcTransferDao sut;



    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcTransferDao(jdbcTemplate);
    }

    @Test
    public void create_a_transfers(){

        double afterBalance = sut.getBalance("user1").doubleValue();
        afterBalance -= 80.00;
        sut.createTransfer(1001,1002, BigDecimal.valueOf(80.0));
        double newbalance =  sut.getBalance("user1").doubleValue();
        Assert.assertEquals(newbalance,afterBalance,0.0);



    }


    @Test
    public void get_balanced(){
        double user2Balance = 1500.00;

        double testBalance = sut.getBalance("user2").doubleValue();

        Assert.assertEquals(user2Balance,testBalance,0.0);

    }


    @Test
    public void get_list_of_all_transfers(){

        List<Transfer> transfers = null;
        sut.createTransfer(1001,1002, BigDecimal.valueOf(98));


        transfers = sut.retrieveListOfAllTransfers(1001);

        Assert.assertEquals(3,transfers.size());


    }



    private void assertEquals(Transfer expected, Transfer actual){
        Assert.assertEquals(expected.getAmount(), actual.getAmount());
        Assert.assertEquals(expected.getTransferId(), actual.getTransferId());
        Assert.assertEquals(expected.getUserIdTo(), actual.getUserIdTo());
        Assert.assertEquals(expected.getUserIdFrom(), actual.getUserIdFrom());
        Assert.assertEquals(expected.getUserFrom(), actual.getUserFrom());
        Assert.assertEquals(expected.getUserTo(), actual.getUserTo());
    }



    private void assertEqualCreateMethod(Transfer expected, Transfer actual){
        Assert.assertEquals(expected.getAmount(), actual.getAmount());
        Assert.assertEquals(expected.getUserFrom(), actual.getUserFrom());
        Assert.assertEquals(expected.getUserTo(), actual.getUserTo());
    }


}
