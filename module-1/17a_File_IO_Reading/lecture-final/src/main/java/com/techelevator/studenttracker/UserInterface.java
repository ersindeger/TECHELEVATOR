package com.techelevator.studenttracker;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner inputScanner = new Scanner(System.in);


    public String askUserForFileName() {

        System.out.println("Please enter the name of the student file");
        return inputScanner.nextLine();

    }


    public void displayStudents(List<Student> students) {

        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getAge() + " " + student.getGpa());
        }

    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
