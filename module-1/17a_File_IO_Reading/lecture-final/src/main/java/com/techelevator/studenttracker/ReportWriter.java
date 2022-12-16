package com.techelevator.studenttracker;

import java.io.*;

public class ReportWriter {

    private File reportFile;

    public ReportWriter(String fileName) {
        reportFile = new File(fileName);
    }

    public void writeStudentDataToFile(Student student) throws FileNotFoundException {

        try (PrintWriter writer = new PrintWriter(reportFile)) {
            writer.println(student.getFirstName() + " has a gpa of " + student.getGpa());
        }

    }

    public void writeStudentDataToFileAppending(Student student, String outFile) throws IOException {

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outFile, true )))) {
            writer.println(student.getFirstName() + " has a gpa of " + student.getGpa());
        }
    }


}
