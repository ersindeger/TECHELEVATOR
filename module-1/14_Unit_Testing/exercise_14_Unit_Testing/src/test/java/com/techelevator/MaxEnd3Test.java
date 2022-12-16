package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    private MaxEnd3 intArray = new MaxEnd3();

    @Test
    public void testMakeArray (){
        Assert.assertArrayEquals(new int[]{4,4,4}, intArray.makeArray(new int[]{1,3,4}));
        Assert.assertArrayEquals(new int[]{2,2,2}, intArray.makeArray(new int[]{2,1,0}));
        Assert.assertArrayEquals(new int[]{5,5,5}, intArray.makeArray(new int[]{2,100,5}));
        Assert.assertArrayEquals(new int[]{3,3,3}, intArray.makeArray(new int[]{-5,-100,3}));
        Assert.assertArrayEquals(new int[]{0,0,0}, intArray.makeArray(new int[]{-9,-1,0}));
        Assert.assertArrayEquals(new int[]{7,7,7}, intArray.makeArray(new int[]{2,98,7}));



    }

}
