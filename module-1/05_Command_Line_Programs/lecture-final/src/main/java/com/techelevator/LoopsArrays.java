package com.techelevator;

public class LoopsArrays {

    public static void main(String[] args) {

        int[] nums = new int[] { 1, 2,3,4,5,6,7,8,9,10} ;


//        for (int i=0; i<nums.length; i++) {
//
//            if (nums[i] % 2 == 0 && nums[i] % 3 == 0 ) {
//                System.out.println(nums[i] + " is even and divisible by 3");
//            }
//            else if (nums[i] % 2 == 0 ) {
//                System.out.println( nums[i] + " is even");
//            }
//            else {
//                System.out.println( nums[i] + " is odd");
//            }
//
//
//        }

        int[] oddNumbers = new int[nums.length];

        //loop through original array and check each element to see if odd
        for (int i = 0; i< nums.length; i++) {

            // if odd, add to new array
            if (nums[i] % 2 != 0) {
                oddNumbers[i] = nums[i];
                System.out.println(oddNumbers[i]);
            }



        }

        int count = 0;
        while (true) {
            count ++;
            if (count > 100) {
                break;
            }
        }





    }


}
