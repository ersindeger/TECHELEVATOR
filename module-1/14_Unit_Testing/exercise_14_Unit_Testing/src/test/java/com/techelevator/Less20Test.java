package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    private Less20 numberMod40 = new Less20();

    @Test
    public void testIsLessThanMultipleOf20 (){
        Assert.assertTrue(numberMod40.isLessThanMultipleOf20(59));
        Assert.assertTrue(numberMod40.isLessThanMultipleOf20(58));
        Assert.assertTrue(numberMod40.isLessThanMultipleOf20(99));
        Assert.assertTrue(numberMod40.isLessThanMultipleOf20(98));

        Assert.assertFalse(numberMod40.isLessThanMultipleOf20(60));
        Assert.assertFalse(numberMod40.isLessThanMultipleOf20(57));
        Assert.assertFalse(numberMod40.isLessThanMultipleOf20(72));
        Assert.assertFalse(numberMod40.isLessThanMultipleOf20(101));

        Assert.assertFalse(numberMod40.isLessThanMultipleOf20(111));






    }


}
