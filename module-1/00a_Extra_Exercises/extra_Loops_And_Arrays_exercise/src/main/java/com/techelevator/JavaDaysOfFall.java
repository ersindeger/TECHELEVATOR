package com.techelevator;

public class JavaDaysOfFall {

//    You will be surprised at how quickly you will start to lose your coding skills as we dive into databases and the web. We will post a challenge here in this channel daily (aka Days of Code) as a reminder to you to keep practicing those skills.  These are similar to white-boarding questions that will be thrown at you in the very near future. These are things that you should know how to do, perhaps with some effort. We encourage you to pretend you are whiteboarding for each one of these.
//    Jot down the problem (on paper), what they want returned and what you have to work with.
//            2. (still on paper) Write out a method signature and method block that returns the expected data type.
//            3.  talk while you write the pseudo code that would solve the problem.
//            4. write in some code that should compile.
//5. Pass in some dummy data to 'test' your code (again, all on paper, all talking out loud to your rubber duck or pet).
//            6. Correct any mistakes you happen to find if necessary.
//            You do not need to submit these to us. If you would like someone to take a look at your solution, feel free to send an instructor a message. Happy coding!
//    We've also put together a couple of decks of these exercises on repl.it (which is an  in-browser IDE.)
//    Here are a couple of ways you might make use of them:
//            1) Pick an exercise and work on the problem to practice your problem-solving skills. Talk about the problems and its solution as you solve the problem. Each access creates a copy for you to use and might save if you wish to create a free repl.it account. Already solved that problem? Fine, solve it again. You are likely to do it better and faster.
//            2) Create a copy(fork) of the exercise for yourself and then "Share" with a fellow student or with an instructor while on a video chat. Talk through the problem as you solve it. You and the other person can do the equivalent of white-boarding, both seeing and accessing the same exercise.
//    Here is the first exercise:
//
//      Exercise 1: SwapEnds
//        Create an integer array method called SwapEnds that takes in an integer array "nums".
//   Given an array of ints, swap the first and last elements in the array. Return the modified array.
//   The array length will be at least 1.
//        For example:
//        swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
//        swapEnds([1, 2, 3]) → [3, 2, 1]
//        swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
//
// The one below does the array BACKWARDS....
        public int[] swapEnds(int [] nums){

            int [] b = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
               b[i] = nums[nums.length-1-i];
            }

            return b;
        }

//    Exercise 2:   Has12
//    Create a boolean method called Has12 that takes in an integer array "nums". Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array.
//    For example:
//    has12([1, 3, 2]) → true
//    has12([3, 1, 2]) → true
//    has12([3, 1, 4, 5, 2]) → true
//


//    Exercise 3:    GreenTicket
//    Create an integer method called GreenTicket that takes in three integers, "a". "b", and "c"
//    You have a green lottery ticket, with ints a, b, and c on it. If the numbers are all different from each other,  the result is 0. If all of the numbers are the same, the result is 20. If two of the numbers are the same, the  result is 10.
//    greenTicket(1, 2, 3) → 0
//    greenTicket(2, 2, 2) → 20
//    greenTicket(1, 1, 2) → 10
//


}
