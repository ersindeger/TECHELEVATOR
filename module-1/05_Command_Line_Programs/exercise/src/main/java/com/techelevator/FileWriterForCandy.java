package com.techelevator;

import java.io.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterForCandy {

    File auditFile = new File("C:\\Users\\Student\\repos\\individual\\ersin-deger-student-code\\module-1\\05_Command_Line_Programs\\exercise\\Log.txt");
    List<String> auditList = new ArrayList<>();


    public void logMoneyReceived(double initialBalance, double moneyReceived) {

        LocalDateTime myObj = LocalDateTime.now();
        LocalDateTime myObject = myObj.truncatedTo(ChronoUnit.SECONDS);
        auditList.add(0, myObject + " ");
        auditList.add(1, "MONEY RECEIVED: ");
        auditList.add(2, "$" + String.format("%.2f",initialBalance));
        auditList.add(3, "$" + String.format("%.2f",initialBalance + moneyReceived)+"\n");
    }

    public void logChangeGiven(double currentBalance) {
        LocalDateTime myObj = LocalDateTime.now();
        LocalDateTime myObject = myObj.truncatedTo(ChronoUnit.SECONDS);

        auditList.add(0, String.valueOf(myObject));
        auditList.add(1, "CHANGE GIVEN: ");
        auditList.add(2, "$" + String.format("%.2f",currentBalance));
        auditList.add(3, "$0.00"+"\n");
    }

    public void logItemsOrdered(Candy candy, double currentBalance) {
        LocalDateTime myObj = LocalDateTime.now();
        LocalDateTime myObject = myObj.truncatedTo(ChronoUnit.SECONDS);

        auditList.add(0, String.valueOf(myObject));
        auditList.add(1, candy.getQty() + " " + candy.getName()
                + " " + candy.getProductId() + " " );
        auditList.add(2, "$" + String.format("%.2f",candy.getPrice()));
        auditList.add(3, "$" + String.format("%.2f",currentBalance - candy.getPrice()) +"\n");
    }

    public void writeToLog() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(auditFile, true)))) {
            writer.println(auditList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
