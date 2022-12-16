package com.techelevator.studenttracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentFileReader {

    public List<Student> readStudentFile(String fileName) {

        List<Student> students = new ArrayList<>();

        File studentFile = new File(fileName);

        try {
            Scanner fileScanner = new Scanner(studentFile);

            while(fileScanner.hasNextLine()) {

                String record = fileScanner.nextLine();

                //break the record into its individual fields
                String[] fields = record.split(",");

                Student student = new Student();
                student.setFirstName(fields[0]);
                student.setLastName(fields[1]);
                student.setAge(Integer.parseInt(fields[2]));
                student.setGpa(Double.parseDouble(fields[3]));

                 students.add(student);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return students;

    }
}
