package com.techelevator;

import java.util.Locale;

public class StringExamples {

    public static void main(String[] args) {


        String title = "The big book of Java";
        System.out.println(title);

//        String titleUpper = title.toUpperCase();
//        System.out.println(titleUpper);

        title = title.toUpperCase();
        System.out.println(title);

        String title2 = new String("The big book of Java");

        title2 = title; // IMPORTANT : if you DELETE this line, the statement BELOW will NOT print!!
                        // as title2 and title would represent two different objects .


        if(title == title2) {
            System.out.println("They are equal!!!");
        }



        // Example of String concatenation

        String a = "Hello ";

        String b = "John" ;

        System.out.println( a+b );
        System.out.println("Hello " + b);

        a.concat(b); // same as the previous line of code above!!

        System.out.println(a);



        // ******************** SUBSTRING Example *********************

        String subTitle = title.substring(5); //substring with single value starting at this index
                                                // and ending where "title" ends
        System.out.println(subTitle);

        String subTitle2 = title.substring(8,11);
        System.out.println(subTitle2);






    }




}
