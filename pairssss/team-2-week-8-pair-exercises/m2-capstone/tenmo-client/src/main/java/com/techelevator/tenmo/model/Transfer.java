package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private int transferId;
    private int transferType;
    private int transferStatus;
    private int accountFrom;
    private int accountTo;
    private BigDecimal amount;
    private int userIdFrom;
    private int userIdTo;
    private String transferTypeMessage;
    private String transferStatusMessage;

    private String userTo;
    private String userFrom;

    public Transfer(){}


    public String getTransferTypeMessage() {
        return transferTypeMessage;
    }

    public void setTransferTypeMessage(String transferTypeMessage) {
        this.transferTypeMessage = transferTypeMessage;
    }

    public String getTransferStatusMessage() {
        return transferStatusMessage;
    }

    public void setTransferStatusMessage(String transferStatusMessage) {
        this.transferStatusMessage = transferStatusMessage;
    }

    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public int getUserIdFrom() {return userIdFrom;}

    public void setUserIdFrom(int userIdFrom) {this.userIdFrom = userIdFrom;}

    public int getUserIdTo() {return userIdTo;}

    public void setUserIdTo(int userIdTo) {
        this.userIdTo = userIdTo;
    }

    public int getTransferId() {return transferId;}

    public void setTransferId(int transferId) {this.transferId = transferId;}

    public int getTransferType() {
        return transferType;
    }

    public void setTransferType(int transferType) {
        this.transferType = transferType;
    }

    public int getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(int transferStatus) {
        this.transferStatus = transferStatus;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}





