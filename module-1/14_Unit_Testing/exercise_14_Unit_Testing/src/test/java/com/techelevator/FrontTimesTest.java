package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    private FrontTimes frontThreeLettersRepeated = new FrontTimes();

    @Test
    public void testGenerateString (){
        Assert.assertEquals("GeoGeoGeoGeo", frontThreeLettersRepeated.generateString("Georgie", 4));
        Assert.assertEquals("muhmuhmuh", frontThreeLettersRepeated.generateString("muhaha", 3));
        Assert.assertEquals("xavxav", frontThreeLettersRepeated.generateString("xavier", 2));
        Assert.assertEquals("ers", frontThreeLettersRepeated.generateString("ersoygil", 1));
        Assert.assertEquals("", frontThreeLettersRepeated.generateString("TechElevator", 0));
    }

}
