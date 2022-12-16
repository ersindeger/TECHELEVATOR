package com.techelevator.tenmo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class Transfer {


    private int transferId;

    private int transferType;
    private int transferStatus;

    @Min(value = 1, message = "Cannot not send less than 1 to other users")
    private BigDecimal amount;
    @Min(value = 1000, message = "'UserId' Starts at 1000")
    @Max(value = 2000, message = "'UserId' doesn't go past 1999")
    private int userIdFrom;
    @Min(value = 1000, message = "'UserId' Starts at 1000")
    @Max(value = 2000, message = "'UserId' doesn't go past 1999")
    private int userIdTo;
    @NotBlank(message = "The field 'useFrom' is required")
    private String userFrom;
    @NotBlank(message = "The field 'useTo' is required")
    private String userTo;


    public Transfer(){}

    public Transfer(int transferId, BigDecimal amount, int userIdFrom, int userIdTo, String userFrom, String userTo) {
        this.transferId = transferId;
        this.amount = amount;
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
        this.userFrom = userFrom;
        this.userTo = userTo;
    }

    public Transfer(int userIdFrom, int userIdTo, BigDecimal amount) {
    }




    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
