package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

	/**1
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
	 array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
	 array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
	 */
	public List<String> array2List(String[] stringArray) {

		List<String> values = new ArrayList<>();


			for (int i = 0; i < stringArray.length; i++) {
				values.add(stringArray[i]);
			}

//			System.out.print(values);

			return values;
	}

	/** 2
	 Given a list of Strings, return an array containing the same Strings in the same order
	 list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
	 list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
	 list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
	 */
	public String[] list2Array(List<String> stringList) {

		String [] values = new String [stringList.size()];

		for (int i = 0; i < stringList.size(); i++) {
			values[i]= stringList.get(i);
		}
		// GENERATES the LIST of Strings as an ARRAY of Strings

		return values;
	}



	/** 3
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
	public List<String> no4LetterWords(String[] stringArray) {

		List<String> myList = new ArrayList<>();


		for (int i = 0; i < stringArray.length; i++) {
			if ( stringArray[i].length() != 4 ) {  // IF i-th element in stringArray NOT of length 4,
				myList.add(stringArray[i]);   //  THEN add it to the LIST called VALUES.
			}
		}

		return myList;
	}




	/*
	 Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
	 arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
	 arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
	 arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
	 */
	public List<Double> arrayInt2ListDouble(int[] intArray) {

		List <Double> halfOfAllGivens_List = new ArrayList<>();
		// Declare a LIST called HALF_OF_GIVENS_LIST, the data type of which is Double.

		double [] doublesArray = new double[intArray.length];
		// DECLARE an Array of doubles.

		for (int i = 0; i < intArray.length; i++) {
			doublesArray[i] = intArray[i];
		}
		// Set it equal to the Array of Integers.


		for (int i = 0; i < intArray.length; i++) {

				halfOfAllGivens_List.add( (doublesArray[i] / 2));

				//  THEN use it to add to the LIST called HALF_OF_GIVENS_LIST.
		}

		return halfOfAllGivens_List;

	}

	/*
	 Given a List of Integers, return the largest value.
	 findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
	 findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
	 findLargest( [34070, 1380, 81238, 7782, 234, 64362, 627] ) -> 81238
	 */
	public Integer findLargest(List<Integer> integerList) {

		Integer [] values = new Integer [integerList.size()];

		for (int i = 0; i < integerList.size(); i++) {
			values[i]= integerList.get(i);
		}


		int maximum_ = values[0]; ;

		for (int i = 0; i < values.length; i++) {
			if (values[i] >= maximum_){
				maximum_ = values[i];
			}
		}


		return maximum_;
	}



	/*
	 Given an array of Integers, return a List of Integers containing just the odd values.
	 oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
	 oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
	 oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
	 */
	public List<Integer> oddOnly(Integer[] integerArray) {

		List<Integer> myListJustOdds = new ArrayList<>();

		for (int i = 0; i < integerArray.length; i++) {
			if ( integerArray[i] % 2 != 0 ) {  // IF i-th element in stringArray NOT EVEN,
				myListJustOdds.add(integerArray[i]);   //  THEN add it to the LIST called MY_LIST_JUST_ODDS.
			}
		}

		return myListJustOdds;

	}

	/*
	 Given a List of Integers, and an int value, return true if the int value appears two or more times in
	 the list.
	 foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
	 foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
	 foundIntTwice( [9, 9, 44, 2, 88, 9], 9) -> true
	 */
	public boolean foundIntTwice(List<Integer> integerList, int intToFind) {

		int count = 0;

		for (int i = 0; i < integerList.size() ; i++) {
			if( intToFind == integerList.get(i) ){
				count = count + 1;
			}
		}

		if(count <= 1){
			return false;
		}

		else
			return true;
	}

	/*
	 Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
	must be replaced by the String "Fizz", any multiple of 5 must be replaced by the String "Buzz",
	and any multiple of both 3 and 5 must be replaced by the String "FizzBuzz."
	** INTERVIEW QUESTION **

	fizzBuzzList( {1, 2, 3} )  ->  ["1", "2", "Fizz"]
	fizzBuzzList( {4, 5, 6} )  ->  ["4", "Buzz", "Fizz"]
	fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  ["7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]

	HINT: To convert an Integer x to a String, you can use x.toString() in your code. For example, if x = 1, then x.toString() returns "1."
	 */
	public List<String> fizzBuzzList(Integer[] integerArray) {

		List <String> values = new ArrayList<>();

		for (Integer i : integerArray){

			if (i.intValue()  % 15 == 0){
				values.add("FizzBuzz");
			}

			else if (i.intValue() % 3 == 0){
				values.add("Fizz");
			}

			else if (i.intValue() % 5 == 0){
				values.add("Buzz");
			}
			else
				values.add(i.toString());

		}

		return values;
	}

	/*
	 Given two lists of Integers, interleave them beginning with the first element in the first list followed
	 by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
	 Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
	 list to the new list before returning it.
	 interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
	 */
	public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {

		List<Integer> interwovenList = new ArrayList<>();

		int z1 = listOne.size() - listTwo.size();
		int z2 = listTwo.size() - listOne.size();


		if ( listOne.size() == listTwo.size() ){
			for (int i = 0; i < listOne.size(); i++) {
				interwovenList.add(listOne.get(i));
				interwovenList.add(listTwo.get(i));
			}
		}

		else if ( listOne.size() > listTwo.size() ){
			for (int i = 0; i < listTwo.size(); i++) {
				interwovenList.add(listOne.get(i));
				interwovenList.add(listTwo.get(i));
			}
			for (int i = 0 ; i < z1 ; i++) {
				interwovenList.add(listOne.get( listTwo.size()+ i ) );
			}
		}

		else
			//if ( listTwo.size() > listOne.size() )
			{
			for (int i = 0; i < listOne.size(); i++) {
				interwovenList.add(listOne.get(i));
				interwovenList.add(listTwo.get(i));
			}
			for (int i = 0; i < z2 ; i++) {
				interwovenList.add(listTwo.get( listOne.size()+ i ) );
			}
		}


		// start looping the smaller sized list and interweave them until you reach the end of the
		// smaller one,


		// then use the index value of the starting point
		// to append the remaining from the largest.


		return interwovenList;
	}

}
