package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {

    private NonStart comboWords = new NonStart();

    @Test
    public void testGetPartialString (){

        Assert.assertEquals("hehouts", comboWords.getPartialString("she", "shouts"));
        Assert.assertEquals("aybeater", comboWords.getPartialString("maybe", "later"));
        Assert.assertEquals("ontcare", comboWords.getPartialString("i", "dontcare"));
        Assert.assertEquals("uhahaha", comboWords.getPartialString("muhahaha", "?"));
        Assert.assertEquals("ALURada", comboWords.getPartialString("KAL", "BURada"));


    }

}
