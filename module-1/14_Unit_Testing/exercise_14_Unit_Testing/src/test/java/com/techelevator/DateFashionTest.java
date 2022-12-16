package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

    private DateFashion dateTable = new DateFashion();

    @Test
    public void testGetATable (){
        Assert.assertEquals(2, dateTable.getATable(3,8));
        Assert.assertEquals(2, dateTable.getATable(9,4));
        Assert.assertEquals(2, dateTable.getATable(8,10));



        Assert.assertEquals(1, dateTable.getATable(4,7));
        Assert.assertEquals(1, dateTable.getATable(7,3));
        Assert.assertEquals(1, dateTable.getATable(3,3));

        Assert.assertEquals(0, dateTable.getATable(2,9));
        Assert.assertEquals(0, dateTable.getATable(10,2));
        Assert.assertEquals(0, dateTable.getATable(0,2));







    }


}
