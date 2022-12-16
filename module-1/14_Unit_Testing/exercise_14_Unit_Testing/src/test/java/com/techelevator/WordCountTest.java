package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordCountTest {

    private WordCount stringCountInArray = new WordCount();

     @Test
    public void testGetCount() {
         Map<String, Integer> expected1 = new HashMap<>();
         Map<String, Integer> actual1 = new HashMap<>();

         actual1 = stringCountInArray.getCount(new String[]{"ba", "zuhaha", "zuhaha", "ca"});
         expected1.put("ca",1);
         expected1.put("ba", 1);
         expected1.put("zuhaha",2);

         assertThat(actual1, is(expected1));



         Map<String, Integer> expected2 = new HashMap<>();
         Map<String, Integer> actual2 = new HashMap<>();

         actual2 = stringCountInArray.getCount(new String[]{"joy", "sad", "joy", "", "", "alliswell"});
         expected2.put("",2);
         expected2.put("joy", 2);
         expected2.put("sad",1);
         expected2.put("alliswell", 1);

         assertThat(actual2, is(expected2));


         Map<String, Integer> expected3 = new HashMap<>();
         Map<String, Integer> actual3 = new HashMap<>();

         actual3 = stringCountInArray.getCount(new String[]{"Ohio", "TX", "TX", "IN", "", "TX"});
         expected3.put("",1);
         expected3.put("IN", 1);
         expected3.put("Ohio",1);
         expected3.put("TX", 3);

         assertThat(actual3, is(expected3));


     }

}
