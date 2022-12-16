package com.techelevator;

public class HomeworkAssignment {


    private int earnedMarks;
    private int possibleMarks = getPossibleMarks();
    private String submitterName = getSubmitterName();



    public String getLetterGrade() {

        String letterGrade;
        double percentage = 100 * earnedMarks / possibleMarks ;

        if(percentage >= 90 && percentage <= 100){letterGrade = "A";}

        else if(percentage >= 80 && percentage < 90){letterGrade = "B";}

        else if(percentage >= 70 && percentage < 80) {letterGrade = "C";}

        else if(percentage >= 60 && percentage < 70) {letterGrade = "D";}

        else {letterGrade = "F";}

        return (letterGrade);
    }


    public int getEarnedMarks() {return earnedMarks;}

    public void setEarnedMarks(int earnedMarks)
    {this.earnedMarks = earnedMarks;}

    public int getPossibleMarks() {return possibleMarks;}

    public String getSubmitterName() {return submitterName;}



    public HomeworkAssignment (int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

//    private String getLetterGrade (int possibleMarks, int earnedMarks) {
//
//        double percentage = 100 * earnedMarks / possibleMarks ;
//
//        if(percentage >= 90 && percentage <= 100){letterGrade = "A";}
//
//        else if(percentage >= 80 && percentage < 90){letterGrade = "B";}
//
//        else if(percentage >= 70 && percentage < 80) {letterGrade = "C";}
//
//        else if(percentage >= 60 && percentage < 70) {letterGrade = "D";}
//
//        else {letterGrade = "F";}
//
//        return letterGrade;
//    }



//
//
//    public static void main(String[] args) {
//
//        HomeworkAssignment jack = new HomeworkAssignment(110, "Jack Dominguez");
//        HomeworkAssignment jill = new HomeworkAssignment(110, "Jill Stevenson");
//
//        jack.setEarnedMarks(99);
//        jill.setEarnedMarks(85);
//
//
//        System.out.println( "Student " + jack.submitterName + " earned a total of " + jack.getEarnedMarks() + " out of " + jack.possibleMarks);
//        System.out.println( "Student Jack Dominguez got a letter grade of " + jack.getLetterGrade(110,99));
//        System.out.println();
//
//        System.out.println( "Student " + jill.submitterName + " earned a total of " + jill.getEarnedMarks() + " out of " + jill.possibleMarks);
//        System.out.println( "Student Jill Stevenson got a letter grade of " + jill.getLetterGrade(110,85));
//    }

}
