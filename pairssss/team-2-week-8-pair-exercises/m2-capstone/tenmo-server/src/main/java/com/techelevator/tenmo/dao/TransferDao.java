package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exceptions.TransferNotFoundException;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface TransferDao {

    BigDecimal getBalance(String username);
    Transfer createTransfer(int userIdFrom, int userIdTo, BigDecimal amount);
    List<Transfer> retrieveListOfAllTransfers (int currentUserId);
    Transfer retrieveTransferByTransferId (int transferId) throws TransferNotFoundException;


}
