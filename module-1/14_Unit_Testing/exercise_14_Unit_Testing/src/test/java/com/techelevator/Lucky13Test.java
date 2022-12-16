package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Test {

    private Lucky13 numberSeq = new Lucky13();

    @Before
    public void setup() {
        System.out.println("Before");
    }


    @Test
    public void testGetLucky (){
        Assert.assertEquals(true, numberSeq.getLucky(null));



        Assert.assertTrue(false == numberSeq.getLucky(new int[]{1, 6, 7, 9, 23}));
        Assert.assertTrue(false == numberSeq.getLucky(new int[]{3, 1, 7, 9, 2,4,6}));
        Assert.assertTrue(false == numberSeq.getLucky(new int[]{7, 3, 2}));
        Assert.assertTrue(true == numberSeq.getLucky(new int[]{4, 8, 7, 9, 2}));
        Assert.assertTrue(true == numberSeq.getLucky(new int[]{0, 2}));






    }


}
