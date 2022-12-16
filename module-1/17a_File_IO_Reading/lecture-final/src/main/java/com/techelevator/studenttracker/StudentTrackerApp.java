package com.techelevator.studenttracker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class StudentTrackerApp {

    public static void main(String[] args) {

        String studentReport = "student_gpa_report.txt";

        //create only one
        UserInterface ui = new UserInterface();
        StudentFileReader reader = new StudentFileReader();
        ReportWriter reportWriter = new ReportWriter(studentReport);


        //main logic

        //ask the user for a filename
        String fileName = ui.askUserForFileName();
        System.out.println(fileName);


        //call the filereader to get list of students
        List<Student> students = reader.readStudentFile(fileName);

        //send students to ui to print
        ui.displayStudents(students);



        //create a final gpa report
        for (Student student : students) {
            try {
                if (student.getGpa() < 2 ) {
                    reportWriter.writeStudentDataToFileAppending(student, studentReport);
                }
            } catch (IOException e) {
                ui.printMessage("Java Green has left you high and dry you would be better off going to Brian's class");
            }
        }




    }

}
