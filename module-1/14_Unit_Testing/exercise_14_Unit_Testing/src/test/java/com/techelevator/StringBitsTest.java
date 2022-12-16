package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {

    private StringBits everyOtherString = new StringBits();

    @Test
    public void testGetBits (){
        Assert.assertEquals("Hlohr", everyOtherString.getBits("HelloThere"));
        Assert.assertEquals("", everyOtherString.getBits(""));
        Assert.assertEquals("wowza", everyOtherString.getBits("wwa"));
        Assert.assertEquals("o", everyOtherString.getBits("oy"));
        Assert.assertEquals("Lfcce", everyOtherString.getBits("Lifecycle"));
        Assert.assertEquals("FLeEUt", everyOtherString.getBits("FALseRESUlt"));
    }

}
