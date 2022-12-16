package com.techelevator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class Exercises {

	/*******   Exercise 1  ********
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"   //
	 * animalGroupName("rhino") -> "Crash"  // .lowercase so you can have one KEY.
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		//need to create, populate, search the map

		Map <String,String> animal_Group = new HashMap <String, String> ();

		animal_Group.put("rhino", "Crash");
		animal_Group.put("giraffe", "Tower");
		animal_Group.put("elephant", "Herd");
		animal_Group.put("lion", "Pride");
		animal_Group.put("crow", "Murder");
		animal_Group.put("pigeon", "Kit");
		animal_Group.put("flamingo", "Pat");
		animal_Group.put("deer", "Herd");
		animal_Group.put("dog", "Pack");
		animal_Group.put("crocodile", "Float");


		if ( animalName == "" || animalName == null ) {
			return "unknown";
		}

		else {

			animalName = animalName.toLowerCase();

			if ((!animal_Group.containsKey(animalName))) {
				return "unknown";
			} else {
				return animal_Group.get(animalName);
			}
		}


	}

	/*******   Exercise 2 ********
	 * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.  //check this condition and above condition FIRST.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {

		if ( itemNumber == "" || itemNumber == null ) {
			return 0.0;
		}

		else{
			itemNumber = itemNumber.toUpperCase();
		}


		Map <String,Double> houseItemsSale = new HashMap <String, Double> ();

		houseItemsSale.put("KITCHEN4001", 0.20);
		houseItemsSale.put("GARAGE1070", 0.15);
		houseItemsSale.put("LIVINGROOM", 0.10);
		houseItemsSale.put("KITCHEN6073", 0.40);
		houseItemsSale.put("BEDROOM3434", 0.60);
		houseItemsSale.put("BATH0073", 0.15);


			if ((!houseItemsSale.containsKey(itemNumber))) {
				return 0.0;
			}
			else {
				return houseItemsSale.get(itemNumber);
			}


	}

	/**********   Exercise 3   ************
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer
	 * half of it to "Paul", but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		// Given a MAP <String, Integer> named PETERPAUL, return the
		// answer as a MAP <String, Integer> that we will call PETER_PAUL_MONEY_TRANSFER

		Map <String,Integer> peter_Paul_Money_Transfer = new HashMap <String, Integer> ();

		if ( peterPaul.get("Paul") < 1000 ){
			peter_Paul_Money_Transfer.put("Peter", peterPaul.get("Peter") - (peterPaul.get("Peter") / 2) );
			peter_Paul_Money_Transfer.put("Paul", peterPaul.get("Peter") / 2 + peterPaul.get("Paul"));
		}

		else {
			peter_Paul_Money_Transfer.put("Peter", peterPaul.get("Peter") );
			peter_Paul_Money_Transfer.put("Paul", peterPaul.get("Paul") );
		}

		return peter_Paul_Money_Transfer;

		//updating values in the map basically... so use IFs depending on values.
	}


	/********* Exercise 4 *************
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {

		// Given a MAP <String, Integer> named PETERPAUL, return the
		// answer as a MAP <String, Integer> that we will call PETER_PAUL_PARTNERSHIP

		Map <String,Integer> peterPaul_partnership = new HashMap <String, Integer> ();

		if ( peterPaul.get("Paul") >= 10000 && peterPaul.get("Peter") >= 5000 ){
			peterPaul_partnership.put("Peter", peterPaul.get("Peter") * 3/4  );
			peterPaul_partnership.put("Paul", peterPaul.get("Paul") * 3/4);
			peterPaul_partnership.put("PeterPaulPartnership", ( peterPaul.get("Paul") + peterPaul.get("Peter") )/4);

		}

		else {
			peterPaul_partnership.put("Peter", peterPaul.get("Peter") );
			peterPaul_partnership.put("Paul", peterPaul.get("Paul") );
		}

		return peterPaul_partnership;

	}
		// the first sentence is IF statement, then create a new entry by .put assigning 1/4 of each value
		// from Peter and Paul


	/************ Exercise 5 ***************
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {

		//in the previous one and the previous second one, you ARE given a map that you manipulate.
		//you are not given a map here in this question.... but the return type is MAP.
		// charAt(0) gives first char, charAt(last index) gives last char

		Map <String, String> wordsFirstLastMap = new HashMap<>();


		for (int i = 0; i < words.length; i++) {
				wordsFirstLastMap.put(String.valueOf(words[i].charAt(0)), String.valueOf(words[i].charAt(words[i].length()-1))) ;
		}

		return wordsFirstLastMap;
	}

	/********************* Exercise 6 **************************
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		// given parameter STRING array, return the answer as a MAP < String, Integer>
		// classic problem of counting words...
		// .containskey in the map should be useful.

		Map<String, Integer> wordCountMap = new HashMap<String,Integer>();

		if ( words.length == 0 ){
			return wordCountMap;
		}


		for (int i = 0; i < words.length; i++) {
			if (!(wordCountMap.containsKey(words[i]))) {
				wordCountMap.put(words[i], 1);
			} else
				wordCountMap.put(words[i], wordCountMap.get(words[i]) + 1 );
		}

		return wordCountMap;
	}

	/******* Exercise 7 *********
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {


		Map<Integer, Integer> integerCountMap = new HashMap<Integer,Integer>();

		if (ints.length == 0 ){
			return integerCountMap;
		}


		for (int i = 0; i < ints.length; i++) {
			if (!(integerCountMap.containsKey(ints[i]))) {
				integerCountMap.put(ints[i], 1);
			} else
				integerCountMap.put(ints[i], integerCountMap.get(ints[i]) + 1 );
		}

		return integerCountMap;
	}

	/******       Exercise 8      ******
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {

		Map<String, Boolean> output = new HashMap<>();

		if (words != null) {
			for (String word : words) {
				if (!output.containsKey(word)) {
					output.put(word, false);
				}
				else {
					output.put(word, true);
				}
			}
		}

		return output;

	}


	/* ---------------------------EXERCISE 9--------------------------
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {

		// Merge second map with first map
		remoteWarehouse.forEach((key, value) ->
				mainWarehouse.merge(key, value, (v1, v2) -> v1 + v2) );


		return mainWarehouse;
	}

	/******* EXERCISE #10 **********
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {

		int [] count = new int [words.length];

		for (int i = 0; i < words.length; i++) {

			if (words[i].length() <= 1) {
				count[i] = 0; }

			else {
				count[i] = 0;

				char [] charString = new char [2* words.length];

				charString [2*i] = words[i].charAt(words[i].length() - 2);
				charString [2*i +1] = words[i].charAt(words[i].length() - 1);


				for (int j = 0; j < words[j].length() - 2; j++) {
					if ((words[j].charAt(j) == charString [2*j]) && (words[j].charAt(j + 1) == charString [2*j])) {
						count[j] = count[j] + 1;
					}
				}
			}

		}


		Map<String,Integer> last2SubstringCount = new HashMap<>();
		//Construct the MAP using the pairs (KEY, VALUE) = ( words[i], count[i] ) for each i below

		for (int i = 0; i < words.length; i++) {
			last2SubstringCount.put(words[i],count[i]);
		}

		return last2SubstringCount;


	}

}
