package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.JdbcUserDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.exceptions.TransferNotFoundException;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;


@PreAuthorize("isAuthenticated()")
@RestController
public class UsersController {


    @Autowired
    private UserDao userDao;
    @Autowired
    private TransferDao transferDao;


    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> list(Principal principal){

        return userDao.findAll(principal.getName());
    }

    @RequestMapping(path = "/account", method = RequestMethod.GET)
    public BigDecimal getUserBalance (Principal principal) {

        BigDecimal balanceUser = transferDao.getBalance(principal.getName());
        return balanceUser;
    }

    @RequestMapping(path = "/transfers", method = RequestMethod.POST)
    public void transferRequest (@RequestBody Transfer transfer)  {

         transferDao.createTransfer(transfer.getUserIdFrom(),transfer.getUserIdTo(),transfer.getAmount());
    }

    @RequestMapping(path = "/transfers/user", method = RequestMethod.GET)
    public List<Transfer> getAllTransfers(Principal principal){
        return transferDao.retrieveListOfAllTransfers(userDao.findIdByUsername(principal.getName()));

    }

    @RequestMapping(path = "/transfers/{transferId}", method = RequestMethod.GET )
    public Transfer retrieveTransferByTransferId(@PathVariable int transferId ) throws TransferNotFoundException{
        return transferDao.retrieveTransferByTransferId(transferId);
    }

}
